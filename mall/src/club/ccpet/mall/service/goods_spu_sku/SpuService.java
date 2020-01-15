package club.ccpet.mall.service.goods_spu_sku;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import club.ccpet.mall.domain.goods_spu_sku.Spu;
import club.ccpet.mall.util.ParseUtil;

public interface SpuService {
	public Long creatSpu( String goods_name, int parent_category_id, int sub_category_id, int sex,
			BigDecimal lowest_price) throws SQLException;
	public int deleteSpu(Long spu_no) throws SQLException;
	public int updateSpu(BigDecimal lowestPrice,Long spu_no) throws SQLException;
	public int selectIDBySpu_no(Long spu_no) throws SQLException;
	public List<Spu> selectSpusByParentId(int paretn_cate_id) throws SQLException;
	public List<Spu> selectSpusBySortId(int parent_category_id,int sub_category_id) throws SQLException;
	public Spu selectSpuBySpu_no(Long spu_no) throws SQLException;
	public default Long createSpu_no(int parent_category_id, int sub_category_id,int sex) {
		Long	 date = ParseUtil.parseDate2Long(new Date());
		
		
		return new Long(""+sex+parent_category_id+sub_category_id+date);
	}
}
