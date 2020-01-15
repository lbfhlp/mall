package club.ccpet.mall.serviceImpl;

import java.util.ArrayList;

import club.ccpet.mall.dao.SPDao;
import club.ccpet.mall.daoImpl.SPDaoImpl;
import club.ccpet.mall.domain.SP;
import club.ccpet.mall.service.SPService;

public class SPServiceImpl implements SPService{

	@Override
	public ArrayList<String> getImgBySortId(int sort_parent_id, int sort_sub_id) {
		SPDao spd = new SPDaoImpl();	
		ArrayList<String> imgArr = spd.selectImgBySortId(sort_parent_id, sort_sub_id);
		return imgArr;
	}

	@Override
	public ArrayList<SP> getSPBySortId(int sort_parent_id, int sort_sub_id) {
		SPDao spd = new SPDaoImpl();
		ArrayList<SP> spArr = spd.selectSPBySortId(sort_parent_id, sort_sub_id);
		
		return spArr;
	}
	
	/**
	 * 根据商品的id获取所有信息
	 */
	@Override
	public SP getSPById(int id) {
		SPDao spd = new SPDaoImpl();
		SP sp = spd.selectSPById(id);
		return sp;
	}

}
