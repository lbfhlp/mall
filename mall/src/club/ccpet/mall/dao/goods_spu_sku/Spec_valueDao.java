package club.ccpet.mall.dao.goods_spu_sku;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import club.ccpet.mall.domain.goods_spu_sku.SpecificationValue;

public interface Spec_valueDao {
	/**
	 * 插入失败返回-1;
	 * @throws SQLException 
	 */
	public int insert(int spec_id,String spec_value) throws SQLException;
	public SpecificationValue selectById(BigInteger id);
	public int selectSpec_value_id(String spec_value,int spec_id) throws SQLException;
	public String selectSpecValue(int id) throws SQLException ;
	public SpecificationValue selectBean(int id) throws SQLException;
}
