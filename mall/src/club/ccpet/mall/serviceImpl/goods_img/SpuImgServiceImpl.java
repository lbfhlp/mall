package club.ccpet.mall.serviceImpl.goods_img;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import club.ccpet.mall.dao.BaseDao;
import club.ccpet.mall.daoImpl.goods_img.SpuImgDaoImpl;
import club.ccpet.mall.domain.goods_img.SpuImg;
import club.ccpet.mall.service.BaseService;
import club.ccpet.mall.service.goods_img.SpuImgService;

public class SpuImgServiceImpl extends BaseService<SpuImg> implements SpuImgService{
	BaseDao<SpuImg> bs = new SpuImgDaoImpl();
	
	@Override
	public void insertSpuImg(int spu_id, int img_id) throws SQLException {
		String sql  = "INSERT INTO spu_img (img_id,spu_id) VALUES(?,?)";
		update(sql,img_id,spu_id);
	}
	//根据spu_id,查询这个spu所有的图片id;
	public   List<Integer> selectIdArr(int spu_id) throws SQLException {
		String sql = "SELECT img_id FROM spu_img WHERE spu_id=?";
		 List<Object[]> list=getForList(sql,spu_id);
		 List<Integer> idArr = new ArrayList<Integer>();
		 for(Object[] objArr: list) {
			 idArr.add((Integer) objArr[0]);
		 }
		return idArr;
	}
	//根据spu_id,查询这个spu的一个最新的图片id;
	public Integer selectAId(int spu_id) throws SQLException {
		String sql = "SELECT img_id FROM spu_img WHERE spu_id=?  ORDER BY id  LIMIT 1";
		return getForValue(sql, spu_id);
	}
}
