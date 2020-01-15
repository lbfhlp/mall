package club.ccpet.mall.dao;

import java.util.ArrayList;

import club.ccpet.mall.domain.SP_type.SP_type_parent;
import club.ccpet.mall.domain.SP_type.SP_type_sub;
import club.ccpet.mall.service.SP_typeService;

public interface SP_typeDao {
	public ArrayList<SP_type_parent> selectParent(String  sql);
	public ArrayList<SP_type_sub> selectSub(String sql) ;
	public ArrayList<String> selectSubType(String sql);
}
