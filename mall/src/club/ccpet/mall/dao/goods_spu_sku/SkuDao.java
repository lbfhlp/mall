package club.ccpet.mall.dao.goods_spu_sku;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.domain.goods_spu_sku.Sku;

public interface SkuDao {
	public int addASku(Long sku_no,Long spu_no,String sku_spec_value,BigDecimal price,int stock) throws SQLException;
	/**
	 * 根据spu_no,查询sku,每个sku存到Sku对象中,sku对象存到list中.
	 * @param spu_no
	 * @return
	 * @throws SQLException
	 */
	public List<Sku> getBySpu_no(Long spu_no) throws SQLException;
	public int deleteBySpu_no(Long spu_no) throws SQLException;
}
