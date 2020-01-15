package club.ccpet.mall.service.goods_spu_sku;

import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.domain.goods_spu_sku.SpuSpecification;

public interface Spu_specService {
	public int insert(int spu_id, int spec_id, int spec_value_id) throws SQLException;
	public int delete(int spu_id) throws SQLException;
	public List<SpuSpecification> getSpecBySpu_id(int spu_id) throws SQLException ;
	
}
