package club.ccpet.mall.domain.SP_type;
/**
 * 主页二级菜单实体类;
 * @author lbf
 *
 */
public class SP_type_sub {
	public int parent_id;
	public int sub_id;
	public String sub_type;
	public String disc;
	public SP_type_sub() {
	}
	public SP_type_sub(int parent_id, int sub_id, String sub_type, String disc) {
		super();
		this.parent_id = parent_id;
		this.sub_id = sub_id;
		this.sub_type = sub_type;
		this.disc = disc;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_type() {
		return sub_type;
	}
	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
	
	

}
