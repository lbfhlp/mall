package club.ccpet.mall.domain.goods_category;

public class ParentCate {
	int id;
	String parent_type;
	String full_name;
	public ParentCate(int id, String parent_type, String full_name) {
		super();
		this.id = id;
		this.parent_type = parent_type;
		this.full_name = full_name;
	}
	public ParentCate() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParent_type() {
		return parent_type;
	}
	public void setParent_type(String parent_type) {
		this.parent_type = parent_type;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String disc) {
		this.full_name = disc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((full_name == null) ? 0 : full_name.hashCode());
		result = prime * result + id;
		result = prime * result + ((parent_type == null) ? 0 : parent_type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParentCate other = (ParentCate) obj;
		if (full_name == null) {
			if (other.full_name != null)
				return false;
		} else if (!full_name.equals(other.full_name))
			return false;
		if (id != other.id)
			return false;
		if (parent_type == null) {
			if (other.parent_type != null)
				return false;
		} else if (!parent_type.equals(other.parent_type))
			return false;
		return true;
	}

	
}
