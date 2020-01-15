package club.ccpet.mall.domain.goods_img;

public class SpuImg {
	int id;
	int img_id;
	int spu_id;
	public SpuImg(int id, int img_id, int spu_id) {
		super();
		this.id = id;
		this.img_id = img_id;
		this.spu_id = spu_id;
	}
	public SpuImg() {
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
	public int getSpu_id() {
		return spu_id;
	}
	public void setSpu_id(int spu_id) {
		this.spu_id = spu_id;
	}
	
	
}
