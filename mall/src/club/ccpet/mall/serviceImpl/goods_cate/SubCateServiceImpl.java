package club.ccpet.mall.serviceImpl.goods_cate;

import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.dao.goods_category.SubCateDao;
import club.ccpet.mall.daoImpl.goods_category.SubCateDaoImpl;
import club.ccpet.mall.domain.goods_category.Sub_category;
import club.ccpet.mall.service.BaseService;
import club.ccpet.mall.service.goods_category.SubCateService;

public class SubCateServiceImpl extends BaseService<Sub_category> implements SubCateService{
	SubCateDao subcateDao = new SubCateDaoImpl();

	@Override
	public List<Sub_category> selectSubId(int parent_id) throws SQLException {
		
		return subcateDao.selectSubId(parent_id);
	}

	@Override
	public String getDesc(int parent_category_id, int sub_category_id) throws SQLException {
		
		return subcateDao.getDesc(parent_category_id, sub_category_id);
	}
	
}
