package club.ccpet.mall.dao.goods_spu_sku;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;

import club.ccpet.mall.domain.goods_spu_sku.Spu;

public interface SpuDao {
	public int insertASpu(Long spu_no,String goods_name,int parent_category_id, int sub_category_id,int sex,BigDecimal lowest_price) throws SQLException;
	public Spu selectById(int id);
	public int selectIDBySpu_no(Long spu_no) throws SQLException;
	public int deleteBySpu_no(Long spu_no) throws SQLException;
	public int updateSpu(BigDecimal lowestPrice,Long spu_no) throws SQLException;
	public Spu selectSpuBySpu_no(Long spu_no) throws SQLException;
}
