package club.ccpet.mall.service.goods_spu_sku;

import java.sql.SQLException;

public interface Spec_valueService {
	/**
	 * 查询spec_value是否存在,存在则直接返回id,否则新建,并返回id;
	 * @throws SQLException 
	 */
	public int creatSpec_value(String spec_value,int spec_id) throws SQLException;
	public String getSpecValue(int id ) throws SQLException;
}
