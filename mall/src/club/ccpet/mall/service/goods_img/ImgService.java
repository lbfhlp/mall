package club.ccpet.mall.service.goods_img;

import java.sql.SQLException;

import club.ccpet.mall.domain.goods_img.Img;

public interface ImgService  {
	public int  addImg(String img_name,String img_spec_value,String img_path) throws SQLException;
	/**
	 * 根据id,获取图片的其他信息,保存到imgbean中.
	 * @param img_id
	 * @return
	 * @throws SQLException
	 */
	public Img selectAImg(int img_id) throws SQLException ;
}
