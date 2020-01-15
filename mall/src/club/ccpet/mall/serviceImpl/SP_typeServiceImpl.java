package club.ccpet.mall.serviceImpl;

import java.util.ArrayList;

import club.ccpet.mall.dao.SP_typeDao;
import club.ccpet.mall.daoImpl.SP_typeDaoImpl;
import club.ccpet.mall.domain.SP_type.SP_type_parent;
import club.ccpet.mall.domain.SP_type.SP_type_sub;
import club.ccpet.mall.service.SP_typeService;

public class SP_typeServiceImpl implements SP_typeService{
	
	@Override
	public ArrayList<SP_type_parent> getAllSP_type_parent() {
		SP_typeDao sptd = new SP_typeDaoImpl();
		String sql = "SELECT * FROM sp_type_parent ORDER BY parent_id;";
		ArrayList<SP_type_parent> sptpArray =sptd.selectParent(sql);
		return sptpArray;
	}

	@Override
	public ArrayList<SP_type_sub> getAllSP_type_sub() {
		SP_typeDao sptd = new SP_typeDaoImpl();
		String sql = "SELECT * FROM sp_type_sub ORDER BY parent_id,sub_id;";
		ArrayList<SP_type_sub> sptsArray =sptd.selectSub(sql);
		return sptsArray;
	}

	/**
	 * 根据父级分类id获取子级分类的sub_type
	 */
	@Override
	public ArrayList<String> getSubTypeByParent(int parent_id) {
		SP_typeDao sptd = new SP_typeDaoImpl();
		String sql = "SELECT sub_type FROM sp_type_sub where parent_id="+parent_id+" ORDER BY sub_id;";
		ArrayList<String> subTypeArr =sptd.selectSubType(sql);
		return subTypeArr;
	}

	/**
	 * 根据父级分类的id,获取子级分类
	 */
	@Override
	public ArrayList<SP_type_sub> getSubByParent(int parent_id) {
		SP_typeDao sptd = new SP_typeDaoImpl();
		String sql = "SELECT * FROM sp_type_sub where parent_id="+parent_id+" ORDER BY sub_id;" ;
		ArrayList<SP_type_sub> sptsArray =sptd.selectSub(sql);
		return sptsArray;
		
	}

	

}
