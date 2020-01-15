package club.ccpet.mall.domain.goods_img;

public class ImgSpec {
	int id;
	int img_spec_id;
	public ImgSpec(int id, int img_spec_id) {
		super();
		this.id = id;
		this.img_spec_id = img_spec_id;
	}
	public ImgSpec() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getImg_spec_id() {
		return img_spec_id;
	}
	public void setImg_spec_id(int img_spec_id) {
		this.img_spec_id = img_spec_id;
	}
	
	
	
	
}
