package club.ccpet.mall.dao;


import java.util.ArrayList;

import club.ccpet.mall.domain.SP;

public interface SPDao {
	public SP selectASP(String  sql);
	public ArrayList<String> selectImgBySortId(int parent_id,int sub_id);
	public ArrayList<SP> selectSPBySortId(int sort_parent_id, int sort_sub_id);
	public SP selectSPById(int id);
}
