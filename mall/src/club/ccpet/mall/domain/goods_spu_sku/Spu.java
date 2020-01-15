package club.ccpet.mall.domain.goods_spu_sku;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class Spu {
	private int id;
	private Long spu_no;
	private String goods_name;
	private int parent_category_id;
	private int sub_category_id;
	private int sex;
	private BigDecimal lowest_price;
	private int spu_sales;
	private int spu_reviews;
	private  String detail_img;
	
	public Spu() {
		super();
	}
	public Spu(int id, Long spu_no, String goods_name, int parent_category_id, int sub_category_id,
			int sex, BigDecimal lowest_price, int spu_sales, int spu_reviews,String detail_img) {
		super();
		this.id = id;
		this.spu_no = spu_no;
		this.goods_name = goods_name;
		this.parent_category_id = parent_category_id;
		this.sub_category_id = sub_category_id;
		this.sex = sex;
		this.lowest_price = lowest_price;
		this.spu_sales = spu_sales;
		this.spu_reviews = spu_reviews;
		this.detail_img=detail_img;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getSpu_no() {
		return spu_no;
	}
	public void setSpu_no(Long spu_no) {
		this.spu_no = spu_no;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getParent_category_id() {
		return parent_category_id;
	}
	public void setParent_category_id(int parent_category_id) {
		this.parent_category_id = parent_category_id;
	}
	public int getSub_category_id() {
		return sub_category_id;
	}
	public void setSub_category_id(int sub_category_id) {
		this.sub_category_id = sub_category_id;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public BigDecimal getLowest_price() {
		return lowest_price;
	}
	public void setLowest_price(BigDecimal lowest_price) {
		this.lowest_price = lowest_price;
	}
	public int getSpu_sales() {
		return spu_sales;
	}
	public void setSpu_sales(int spu_sales) {
		this.spu_sales = spu_sales;
	}
	public int getSpu_reviews() {
		return spu_reviews;
	}
	public void setSpu_reviews(int spu_reviews) {
		this.spu_reviews = spu_reviews;
	}
	public String getDetail_img() {
		return detail_img;
	}
	public void setDetail_img(String detail_img) {
		this.detail_img = detail_img;
	}
	
	

}
