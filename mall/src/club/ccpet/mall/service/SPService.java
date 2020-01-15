package club.ccpet.mall.service;

import java.util.ArrayList;

import club.ccpet.mall.domain.SP;

public interface SPService {
	public ArrayList<String> getImgBySortId(int sort_parent_id, int sort_sub_id );
	public ArrayList<SP> getSPBySortId(int sort_parent_id, int sort_sub_id );
	public SP getSPById(int id);
}
