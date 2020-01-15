package club.ccpet.mall.serviceImpl.goods_img;

import java.sql.SQLException;

import club.ccpet.mall.domain.goods_img.Img;
import club.ccpet.mall.service.BaseService;
import club.ccpet.mall.service.goods_img.ImgService;

public class ImgServiceImpl extends BaseService<Img> implements ImgService{
	@Override
	public int  addImg(String img_name,String img_spec_value,String img_path) throws SQLException {
		String sql = "INSERT INTO img (img_name,img_spec_value,img_path) "
				+ "VALUES(?,?,?)";
		return insert(sql, img_name,img_spec_value,img_path);
	}
	
	@Override
	public Img selectAImg(int img_id) throws SQLException {
		String sql = "SELECT img_name,img_spec_value,img_path FROM img WHERE id=?";
		return get(sql,img_id);
	}
}
