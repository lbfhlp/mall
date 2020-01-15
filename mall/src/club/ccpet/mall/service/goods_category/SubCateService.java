package club.ccpet.mall.service.goods_category;

import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.domain.goods_category.Sub_category;

public interface SubCateService {
	public List<Sub_category> selectSubId(int parent_id ) throws SQLException;

	public String getDesc(int parent_category_id, int sub_category_id) throws SQLException;
}
