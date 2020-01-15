package club.ccpet.mall.domain.goods_img;

public class ImgSpecValue {
	int id;
	int img_id;
	String spec_value;
	public ImgSpecValue(int id, int img_id, String spec_value) {
		super();
		this.id = id;
		this.img_id = img_id;
		this.spec_value = spec_value;
	}
	public ImgSpecValue() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getImg_id() {
		return img_id;
	}
	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}
	public String getSpec_value() {
		return spec_value;
	}
	public void setSpec_value(String spec_value) {
		this.spec_value = spec_value;
	}

	
}
