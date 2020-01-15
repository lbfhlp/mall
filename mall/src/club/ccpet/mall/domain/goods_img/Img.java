package club.ccpet.mall.domain.goods_img;

public class Img {
	int id;
	String img_name;
	String img_spec_value;
	String img_path;
	public Img(int id, String img_name, String img_spec_value, String img_path) {
		super();
		this.id = id;
		this.img_name = img_name;
		this.img_spec_value = img_spec_value;
		this.img_path = img_path;
	}
	public Img() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public String getImg_spec_value() {
		return img_spec_value;
	}
	public void setImg_spec_value(String img_spec_value) {
		this.img_spec_value = img_spec_value;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	
	
	
	
}
