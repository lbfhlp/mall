package club.ccpet.mall.service;

import java.util.ArrayList;

import club.ccpet.mall.domain.SP_type.SP_type_parent;
import club.ccpet.mall.domain.SP_type.SP_type_sub;

public interface SP_typeService {
	/**
	 * 所有父级商品分类
	 * @return
	 */
	public  ArrayList<SP_type_parent> getAllSP_type_parent() ;
	/**
	 * 所有子级商品分类
	 * @return
	 */
	public 	ArrayList<SP_type_sub> getAllSP_type_sub();
	/**
	 * 根据父级分类id,获取其所有子级分类的sub_type;
	 * @param parent_id
	 * @return
	 */
	public 	ArrayList<String> getSubTypeByParent(int parent_id);
	/**
	 * 根据父级分类id,获取其所有子级分类
	 * @param parent_id
	 * @return
	 */
	public 	ArrayList<SP_type_sub> getSubByParent(int parent_id);
}
