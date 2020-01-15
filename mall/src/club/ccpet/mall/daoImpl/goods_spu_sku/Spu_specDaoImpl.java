package club.ccpet.mall.daoImpl.goods_spu_sku;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.dao.BaseDao;
import club.ccpet.mall.dao.goods_spu_sku.Spu_specDao;
import club.ccpet.mall.domain.goods_spu_sku.SpuSpecification;
import club.ccpet.mall.util.DbConnection;

public class Spu_specDaoImpl extends BaseDao<SpuSpecification> implements Spu_specDao{
	@Override
	public int insert(int spu_id, int spec_id, int spec_value_id) throws SQLException {
		String sql = "INSERT INTO spu_specification (spu_id,spec_id,spec_value_id) VALUES(?,?,?);";
		return update(sql, spu_id,spec_id,spec_value_id);
	}

	public int delete(int spu_id) throws SQLException {
		String sql = "DELETE FROM spu_specification WHERE spu_id=?;";
		return update(sql, spu_id);
	}

	@Override
	public List<SpuSpecification> selectSpecBySpu_id(int spu_id) throws SQLException {
		String sql = "SELECT * FROM spu_specification WHERE spu_id=?";
		return getForBeanList(sql, spu_id);
	}
}
