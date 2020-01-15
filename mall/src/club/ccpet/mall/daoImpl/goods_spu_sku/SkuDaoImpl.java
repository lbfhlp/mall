package club.ccpet.mall.daoImpl.goods_spu_sku;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.dao.BaseDao;
import club.ccpet.mall.dao.goods_spu_sku.SkuDao;
import club.ccpet.mall.domain.goods_spu_sku.Sku;

public class SkuDaoImpl extends BaseDao<Sku> implements SkuDao{
	@Override
	public int addASku( Long sku_no, Long spu_no, String sku_spec_value, BigDecimal price, int stock) throws SQLException {
		String sql ="INSERT  INTO sku (sku_no,spu_no,sku_spec_value,price,stock) VALUES(?,?,?,?,?)";
		return update(sql,sku_no,spu_no,sku_spec_value,price,stock);
	}

	@Override
	public List<Sku> getBySpu_no(Long spu_no) throws SQLException {
		String sql = "SELECT * FROM sku WHERE spu_no=?;";
		return getForBeanList(sql,spu_no);
	}

	@Override
	public int deleteBySpu_no(Long spu_no) throws SQLException {
		String sql = "DELETE FROM sku where spu_no=?;";
		return update(sql, spu_no);
	}

	

}
