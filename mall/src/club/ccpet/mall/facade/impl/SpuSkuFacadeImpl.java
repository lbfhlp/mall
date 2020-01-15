package club.ccpet.mall.facade.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import club.ccpet.mall.dao.goods_img.ImgDao;
import club.ccpet.mall.dao.goods_spu_sku.Spec_valueDao;
import club.ccpet.mall.daoImpl.goods_img.ImgDaoImpl;
import club.ccpet.mall.daoImpl.goods_spu_sku.Spec_valueDaoImpl;
import club.ccpet.mall.domain.goods_category.Sub_category;
import club.ccpet.mall.domain.goods_img.Img;
import club.ccpet.mall.domain.goods_spu_sku.Sku;
import club.ccpet.mall.domain.goods_spu_sku.SpecificationValue;
import club.ccpet.mall.domain.goods_spu_sku.Spu;
import club.ccpet.mall.domain.goods_spu_sku.SpuSpecification;
import club.ccpet.mall.service.goods_category.ParentCateService;
import club.ccpet.mall.service.goods_category.SubCateService;
import club.ccpet.mall.service.goods_img.ImgService;
import club.ccpet.mall.service.goods_img.SpuImgService;
import club.ccpet.mall.service.goods_spu_sku.SkuService;
import club.ccpet.mall.service.goods_spu_sku.Spec_valueService;
import club.ccpet.mall.service.goods_spu_sku.SpuService;
import club.ccpet.mall.service.goods_spu_sku.Spu_specService;
import club.ccpet.mall.serviceImpl.goods_cate.ParentCateServiceImpl;
import club.ccpet.mall.serviceImpl.goods_cate.SubCateServiceImpl;
import club.ccpet.mall.serviceImpl.goods_img.ImgServiceImpl;
import club.ccpet.mall.serviceImpl.goods_img.SpuImgServiceImpl;
import club.ccpet.mall.serviceImpl.goods_spu_sku.SkuServiceImpl;
import club.ccpet.mall.serviceImpl.goods_spu_sku.Spec_valueServiceImpl;
import club.ccpet.mall.serviceImpl.goods_spu_sku.SpuServiceImpl;
import club.ccpet.mall.serviceImpl.goods_spu_sku.Spu_specServiceImpl;
/**
 * 该类用于处理spu,sku相关.
 * @author lbf
 *
 */
public class SpuSkuFacadeImpl {
	ParentCateService gcs = new ParentCateServiceImpl();
	SubCateService scs = new SubCateServiceImpl();
	SpuService ss = new SpuServiceImpl();
	Spu_specService spu_specService = new Spu_specServiceImpl();
	SpuImgService spuImgservice = new SpuImgServiceImpl();
	ImgService imgService = new ImgServiceImpl();
	SkuService skuservice = new SkuServiceImpl();
	Spec_valueService spec_valueService = new Spec_valueServiceImpl();
	ImgDao imgDao  = new ImgDaoImpl();
	Spec_valueDao spec_valueDao = new Spec_valueDaoImpl();
	public List CreateParentPage(String type) throws SQLException {
		
//		//父级分类id
		int parent_cate_id = gcs.selectParentId(type);
//		//子级分类数组
		List<Sub_category> subArr = scs.selectSubId(parent_cate_id);
		//key:子级分类的sub_id,value:该分类下的spu类型的list
		Map<Integer, List<Spu>> subSpuMap = new HashMap<Integer, List<Spu>>();
		List<Spu> list=null;
		for(Sub_category s:subArr) {
			System.out.println(s.getSub_id());
			list=ss.selectSpusBySortId(parent_cate_id, s.getSub_id());
			if(list!=null||!list.isEmpty()) {
				//根据sub_id,取到数据才添加.
				subSpuMap.put(s.getSub_id(), list);
			}
		}
		//key为spuid,value为
		Map<Integer, Img> spuImgMap = new HashMap<Integer,Img>();
		for(int i:subSpuMap.keySet()) {
			List<Spu> list1=subSpuMap.get(i);
			for(Spu s:list1) {
				//根据spu的id,取到img 的id;
				int spu_id = s.getId();
				int img_id = spuImgservice.selectAId(spu_id);
				Img img = imgService.selectAImg(img_id);
				spuImgMap.put(spu_id, img);
			}
		}
		List<Object> goodsList = new ArrayList<Object>();
		goodsList.add(subArr);
		goodsList.add(subSpuMap);
		goodsList.add(spuImgMap);
		return goodsList;
	}

	public Map<String,?> getSkusOfSpu(Long spu_no) throws SQLException {
		Map<String,Object> goodsMap= new HashMap<String,Object>();
		List<Sku> skuArr = skuservice.getBySpu_no(spu_no);
		Spu spu = ss.selectSpuBySpu_no(spu_no);
		int parent_category_id = spu.getParent_category_id();
		int sub_category_id = spu.getSub_category_id();
		String  parent_full_name= gcs.getDesc(parent_category_id);
		String  sub_full_name = scs.getDesc(parent_category_id,sub_category_id);
		List<SpuSpecification> spuSpecArr = spu_specService.getSpecBySpu_id(spu.getId());
		List<SpecificationValue> spec_valueArr = new ArrayList<SpecificationValue>();
		for(SpuSpecification s:spuSpecArr) {
			int spec_id = s.getSpec_id();
			int spec_value_id = s.getSpec_value_id();
			SpecificationValue spec_value = spec_valueDao.selectBean(spec_value_id);
				spec_valueArr.add(spec_value);
			
		}
		List<Integer> img_idArr = spuImgservice.selectIdArr(spu.getId());
		//list转integer数组
		List<Img> imgArr = imgDao.selectBeanListById(img_idArr.toArray(new Integer[img_idArr.size()]));
		goodsMap.put("skuArr", skuArr);
		goodsMap.put("spu", spu);
		goodsMap.put("parent_full_name", parent_full_name);
		goodsMap.put("sub_full_name", sub_full_name);
		goodsMap.put("spec_valueArr", spec_valueArr);
		goodsMap.put("imgArr", imgArr);
		return goodsMap;
	}

}
