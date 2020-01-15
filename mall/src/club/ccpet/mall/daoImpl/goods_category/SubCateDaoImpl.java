package club.ccpet.mall.daoImpl.goods_category;

import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.dao.BaseDao;
import club.ccpet.mall.dao.goods_category.SubCateDao;
import club.ccpet.mall.domain.goods_category.Sub_category;

public class SubCateDaoImpl extends BaseDao<Sub_category> implements SubCateDao{

	@Override
	public List<Sub_category> selectSubId(int parent_id) throws SQLException {
		String sql = "SELECT * FROM sub_category WHERE parent_id=?;";
		return getForBeanList(sql,parent_id);
	}

	@Override
	public String getDesc(int parent_category_id, int sub_category_id) throws SQLException {
		String sql = "SELECT full_name FROM sub_category WHERE parent_id=? AND sub_id=?;";
		return getForValue(sql,parent_category_id,sub_category_id);
	}
	
}
