package club.ccpet.mall.dao.goods_img;

import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.domain.goods_img.Img;

public interface ImgDao {
	public List<Img> selectBeanListById(Integer...arg) throws SQLException;
}
