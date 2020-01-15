package club.ccpet.mall.domain.goods_category;

public class Sub_category {
	private int id;
	private int parent_id;
	private int sub_id;
	private String  sub_type;
	private String full_name;
	public Sub_category() {
		super();
	}

	public Sub_category(int id, int parent_id, int sub_id, String sub_type, String full_name) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.sub_id = sub_id;
		this.sub_type = sub_type;
		this.full_name = full_name;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
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




	public String getFull_name() {
		return full_name;
	}




	public void setFull_name(String desc) {
		this.full_name = desc;
	}





	

	
	
}
