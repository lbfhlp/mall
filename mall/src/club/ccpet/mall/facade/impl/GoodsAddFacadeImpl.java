package club.ccpet.mall.facade.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;

import club.ccpet.mall.domain.goods_img.SpuImg;
import club.ccpet.mall.facade.GoodsAddFacade;
import club.ccpet.mall.myException.ImgException;
import club.ccpet.mall.service.BaseService;
import club.ccpet.mall.service.goods_img.ImgService;
import club.ccpet.mall.service.goods_img.SpuImgService;
import club.ccpet.mall.service.goods_spu_sku.SkuService;
import club.ccpet.mall.service.goods_spu_sku.Spec_valueService;
import club.ccpet.mall.service.goods_spu_sku.SpuService;
import club.ccpet.mall.service.goods_spu_sku.Spu_specService;
import club.ccpet.mall.serviceImpl.goods_img.ImgServiceImpl;
import club.ccpet.mall.serviceImpl.goods_img.SpuImgServiceImpl;
import club.ccpet.mall.serviceImpl.goods_spu_sku.SkuServiceImpl;
import club.ccpet.mall.serviceImpl.goods_spu_sku.Spec_valueServiceImpl;
import club.ccpet.mall.serviceImpl.goods_spu_sku.SpuServiceImpl;
import club.ccpet.mall.serviceImpl.goods_spu_sku.Spu_specServiceImpl;
import club.ccpet.mall.util.ParseUtil;
import club.ccpet.mall.util.annotation.AOP;
import club.ccpet.mall.util.annotation.Transaction;
@AOP
public class GoodsAddFacadeImpl implements GoodsAddFacade{
	 
	Spec_valueService spec_valueService = new Spec_valueServiceImpl();
	Spu_specService spu_specService = new Spu_specServiceImpl();
	SkuService skuService = new SkuServiceImpl();
	SpuService spuService = new SpuServiceImpl();
	//String转int等有可能异常的代码,一定不能trycatch处理,否则不会触发回滚操作.
	@Transaction
	public void  addGoods(List<FileItem> items,String basePath) throws UnsupportedEncodingException, SQLException   {
		//商品信息
		Map<String,String> formMap = new LinkedHashMap<String,String>();
		//商品图片信息
		LinkedHashMap<String, FileItem> imgMap= new LinkedHashMap<String, FileItem>();
		
		Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            // 若是上传组件返回false. 
            if (item.isFormField()) {
           	// 返回input标签name属性的值
                String fieldName = item.getFieldName();
               // 将FileItem对象中保存的数据流内容以一个字符串返回
                //获取非文件的内容,相当于getParameter.
                String value = item.getString("utf-8");
                
                if(formMap.get(fieldName)==null) {
               	 formMap.put(fieldName, value);
                }else {
               	 String string=formMap.get(fieldName)+","+value;
               	 formMap.put(fieldName, string);
                }
                // 信息为文件格式
            }else {
            	//如果上传的不是图片,抛出异常.
            	if(!item.getContentType().contains("image/")) {
            		throw	new ImgException("上传的不是图片文件!!!!!") ;
            	}
            	//item.getsize得到的是字节大小.1kb=1024字节,1m=1024kb;
            	//单张图片超过0.5m则报错;
            	Long long1 = (long) (1024*1024/2);
            	if(item.getSize()>long1) {
            		throw	new ImgException("上传的图片超出限制!!!!!") ;
            	}
            	//得到上传文件的名称.
                String fileName = item.getName();
                int index = fileName.lastIndexOf("\\");
                fileName = fileName.substring(index + 1);
                System.out.println("文件名"+fileName);
                //获取上传文件的后缀
				String extName = fileName.substring(fileName.lastIndexOf("."));
				//生成图片名称
				String uuid = UUID.randomUUID().toString().replace("-", "");
				//组成新的名称
				String newName = uuid+extName;
				//先把图片的信息存到formMap,添加商品信息成功后才上传
				System.out.println(newName+"xinxixnxnxn");
                imgMap.put(newName, item);
            }
        }
        Long spu_no=null;
       
        	//上传商品信息成功才处理图片;
        spu_no = insertGoods2DB( formMap,imgMap,basePath);
        
	}
	
	public Long insertGoods2DB(Map<String,String> formMap,LinkedHashMap<String, FileItem> imgMap,String basePath) throws SQLException   {
		BigDecimal lowestPri = new BigDecimal("-1");
     	int pcid = ParseUtil.parseStr2Int(formMap.get("parent_category_id"));
		int scid = ParseUtil.parseStr2Int(formMap.get("sub_category_id"));
		//获取分类id;
		
		int sex = ParseUtil.parseStr2Int(formMap.get("sex"));
		Long spu_no = spuService.creatSpu(formMap.get("goods_name"), pcid, 
				scid,sex , new BigDecimal("0"));
		int spu_id = spuService.selectIDBySpu_no(spu_no);
		//颜色
		String[] specsArr1 = formMap.get("spec1").split(",");
	    //尺码
		String[] specsArr2 = formMap.get("spec2").split(",");
		//价格
		String[] priceArr = formMap.get("price").split(",");
		//库存
		String[] stockArr = formMap.get("stock").split(",");
		
		//根据颜色处理图片
			//图片路径
		basePath = "D:\\Mall-Img";
		String path ="\\"+pcid+"\\"+scid+"\\";
				
		//处理图片相关表
//		for(String img_name:imgMap.keySet()) {	
//			
//			String img_spec_value = imgMap.get(img_name).getFieldName();
//			if("details_img".equals(img_spec_value)) {
//				addGoodsImg(spu_id, img_spec_value, img_name, path);
//			}else {
//				
//				for(String img_spec_value1:specsArr1) {
//					addGoodsImg(spu_id, img_spec_value1, img_name, path);
//				}
//			}
//		
//		}
		int specsArr1Length = specsArr1.length;
		int temp = specsArr1Length;
		for(String img_spec_value1:specsArr1) {
			for(String img_name:imgMap.keySet()) {
				//input的name如果为details_img,即为商品详情图片.
				String img_spec_value = imgMap.get(img_name).getFieldName();
				 if(("sku_img"+(specsArr1Length-temp)).equals(img_spec_value)){
					
						addGoodsImg(spu_id, img_spec_value1, img_name, path);
				}
			}
			temp--;
		}
		for(String img_name:imgMap.keySet()) {
			String img_spec_value = imgMap.get(img_name).getFieldName();
			if("details_img".equals(img_spec_value)) {
				addGoodsImg(spu_id, img_spec_value, img_name, path);
			}
		}
		//处理sku,spu相关表.
		for (int i = 0; i < specsArr1.length; i++) {
			//外层循环规格一,即颜色;
			int spec1_value_id = spec_valueService.creatSpec_value(specsArr1[i], 1);	//规格1即颜色
			spu_specService.insert(spu_id, 1, spec1_value_id);	// 把规格值添加到spu_spec表中
				for (int j = 0; j < specsArr2.length; j++) {
					int  spec2_value_id= spec_valueService.creatSpec_value(specsArr2[j], 2);	//规格2,即尺码;
					//内层循环规格2即尺码;
					if(i==0) {
						spu_specService.insert(spu_id, 2, spec2_value_id);
					}
					String sku_spec_value = skuService.createSku_spec_value(spec1_value_id, spec2_value_id);		
					//一个sku对应的价格
					String priceStr =priceArr[j+i*specsArr2.length];
					BigDecimal price = ParseUtil.str2BigDecimal(priceStr);
					//一个sku对应的库存
					String stockStr = stockArr[j+i*specsArr2.length];
					int stock = ParseUtil.parseStr2Int(stockStr);
					//设置最低价格
					if(i==0&&j==0) {	//第一次循环时赋值;
						lowestPri = price;
					}else if (lowestPri.compareTo(price)==1) {	//-1小于 ,0等于  ,,1大于
						lowestPri = price;
					}
					skuService.addSku(spu_no, sku_spec_value, price, stock,i+1,j+1);
				}
		}
		//设置最低价格
		spuService.updateSpu(lowestPri, spu_no);
		//上传图片
		uploadGoodsImg(imgMap, (basePath+path));
         return spu_no;
	}
	//添加图片相关表.
	public void addGoodsImg(int spu_id, String img_spec_value,String img_name,String img_path) throws SQLException {
			ImgService is= new ImgServiceImpl();
			int img_id = is.addImg( img_name,img_spec_value,img_path);
			SpuImgService bs = new SpuImgServiceImpl();
			bs.insertSpuImg(spu_id, img_id);
	}
	//上传图片
	public void uploadGoodsImg(LinkedHashMap<String, FileItem> imgMap,String basePath)  {
		for(String imgName:imgMap.keySet()) {
			 File f = new File(basePath);
		        if(!f.exists()){
		            f.mkdirs();        
		        }
    		 File file = new File(basePath, imgName );
    		 FileItem item =  imgMap.get(imgName);
    		 try {
    			
				item.write(file);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ImgException("图片上传中出错,请重新上传!");
			}
             item.delete();
    	}
	}
	
}
