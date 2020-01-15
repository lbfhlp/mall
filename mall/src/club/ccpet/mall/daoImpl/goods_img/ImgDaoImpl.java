package club.ccpet.mall.daoImpl.goods_img;

import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.dao.BaseDao;
import club.ccpet.mall.dao.goods_img.ImgDao;
import club.ccpet.mall.domain.goods_img.Img;
public class ImgDaoImpl extends BaseDao<Img> implements ImgDao{
	public void insertAImg(String img_name,String img_spec_value,String img_path) throws SQLException {
		
		
	}

	@Override
	public List<Img> selectBeanListById(Integer... arg) throws SQLException {
		int num = arg.length;
		StringBuffer stringBuffer = new StringBuffer();
		while(num>0) {
			if(num==1) {
				stringBuffer.append("?");
			}else {
				stringBuffer.append("?,");
			}
			num--;
		}
		String sql = "SELECT * FROM img WHERE id IN("+stringBuffer.toString()+")";
		return getForBeanList(sql,arg);
	}
}
