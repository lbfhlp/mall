package club.ccpet.mall.serviceImpl.goods_cate;

import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.domain.goods_category.ParentCate;
import club.ccpet.mall.service.BaseService;
import club.ccpet.mall.service.goods_category.ParentCateService;

public class ParentCateServiceImpl extends BaseService<ParentCate> implements ParentCateService{
	

	@Override
	public int selectParentId(String parent_type) throws SQLException {
		String sql = "SELECT id FROM parent_category WHERE parent_type=?;";
		return getForValue(sql, parent_type);
	}

	@Override
	public String getDesc(int parent_category_id) throws SQLException {
		String sql = "SELECT full_name FROM parent_category WHERE id=?;";
		return getForValue(sql,parent_category_id);
	}
	
}
