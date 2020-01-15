package club.ccpet.mall.service.goods_category;

import java.sql.SQLException;

import club.ccpet.mall.domain.goods_category.ParentCate;

public interface ParentCateService {
	public int selectParentId(String parent_type) throws SQLException ;

	public String getDesc(int parent_category_id) throws SQLException;
}
