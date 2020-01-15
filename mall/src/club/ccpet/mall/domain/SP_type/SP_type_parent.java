package club.ccpet.mall.domain.SP_type;

public class SP_type_parent {
	public int parent_id;
	public String parent_type;
	public String disc;
	public SP_type_parent() {
	}
	public SP_type_parent(int parent_id, String parent_type, String disc) {
		super();
		this.parent_id = parent_id;
		this.parent_type = parent_type;
		this.disc = disc;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_type() {
		return parent_type;
	}
	public void setParent_type(String parent_type) {
		this.parent_type = parent_type;
	}
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}

	
	
	
}
