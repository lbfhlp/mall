package club.ccpet.mall.service.goods_img;

import java.sql.SQLException;
import java.util.List;

public interface SpuImgService {
	public void insertSpuImg(int spu_id,int img_id ) throws SQLException;
	public Integer selectAId(int spu_id) throws SQLException;
	public   List<Integer> selectIdArr(int spu_id) throws SQLException;
}
