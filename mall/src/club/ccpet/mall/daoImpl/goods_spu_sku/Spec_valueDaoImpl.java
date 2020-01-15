package club.ccpet.mall.daoImpl.goods_spu_sku;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.dao.BaseDao;
import club.ccpet.mall.dao.goods_spu_sku.Spec_valueDao;
import club.ccpet.mall.domain.goods_spu_sku.SpecificationValue;
import club.ccpet.mall.util.DbConnection;

public class Spec_valueDaoImpl extends BaseDao<SpecificationValue>implements Spec_valueDao{
	
	@Override
	public int insert(int spec_id, String spec_value) throws SQLException {
		String sql = "INSERT INTO specification_value (spec_id,spec_value) VALUES(?,?)";
		return update(sql, spec_id,spec_value);
	}

	@Override
	public SpecificationValue selectById(BigInteger id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据规格的id 和规格值获取  该规格值的id,仅一个;没有则返回0
	 * @throws SQLException 
	 */
	@Override
	public int selectSpec_value_id(String spec_value, int spec_id) throws SQLException {
		String sql = "SELECT id FROM specification_value WHERE spec_id=? AND spec_value=? ";
		Object id = getForValue(sql,spec_id,spec_value);
		if(id==null ) {
			return -1;
		}
		return (int)id;
	}

	@Override
	public String selectSpecValue(int id) throws SQLException {
		String sql = "SELECT spec_value FROM specification_value WHERE id=?";
		return getForValue(sql,id);
	}

	@Override
	public SpecificationValue selectBean(int id) throws SQLException {
		String sql = "SELECT * FROM specification_value WHERE id=? ";
		return get(sql,id);
	}
	
	
}
