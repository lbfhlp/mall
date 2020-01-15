package club.ccpet.mall.serviceImpl.goods_spu_sku;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import club.ccpet.mall.dao.goods_spu_sku.SpuDao;
import club.ccpet.mall.daoImpl.goods_spu_sku.SpuDaoImpl;
import club.ccpet.mall.domain.goods_spu_sku.Spu;
import club.ccpet.mall.service.BaseService;
import club.ccpet.mall.service.goods_spu_sku.SpuService;
import club.ccpet.mall.util.ParseUtil;

public class SpuServiceImpl extends BaseService<Spu> implements SpuService{
	SpuDao  spuDao = new SpuDaoImpl();
	/**
	 * 生成一个spu,并且返回它的sku_no;
	 * @throws SQLException 
	 * @throws Exception 
	 */
	@Override
	public Long creatSpu(String goods_name, int parent_category_id, int sub_category_id, int sex,
			BigDecimal lowest_price) throws SQLException  {
		
		//spu_no:商品编号,自动生成规则---1/0+父级分类id+子级分类id+当前时间毫秒数
		Long spu_no = null ;
			spu_no = new Long(""+sex+parent_category_id+sub_category_id+ParseUtil.parseDate2Long(new Date()));
		
	
		
		 spuDao.insertASpu(spu_no, goods_name, parent_category_id, sub_category_id, sex, lowest_price);
		
		
		return  spu_no;
	}
	@Override
	public List<Spu> selectSpusByParentId(int paretn_cate_id) throws SQLException {
		String sql = "SELECT * FROM spu WHERE parent_category_id=? ;";
		//父类分类下所有spu;
		
		return getForBeanList(sql,paretn_cate_id);
	}
	/**
	 * 根据父子级分类id获取spu,降序排序,从第一条到第十条;
	 */
	@Override
	public List<Spu> selectSpusBySortId(int parent_category_id,int sub_category_id) throws SQLException {
		
		String sql = "SELECT * FROM spu where parent_category_id=? and sub_category_id=?";
		//父类分类下所有spu;
		 
		return getForBeanList(sql ,parent_category_id,sub_category_id);
	}
	@Override
	public int deleteSpu(Long spu_no) throws SQLException {
		 
		
		return spuDao.deleteBySpu_no(spu_no);
	}
	@Override
	public int updateSpu(BigDecimal lowestPrice,Long spu_no) throws SQLException {
		
		
		return spuDao.updateSpu(lowestPrice, spu_no);
	}
	@Override
	public int selectIDBySpu_no(Long spu_no) throws SQLException {
		
		return spuDao.selectIDBySpu_no(spu_no);
	}
	@Override
	public Spu selectSpuBySpu_no(Long spu_no) throws SQLException {
		return spuDao.selectSpuBySpu_no(spu_no);
	}
}
