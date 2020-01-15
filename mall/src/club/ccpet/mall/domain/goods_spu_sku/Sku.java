package club.ccpet.mall.domain.goods_spu_sku;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class Sku {
	private int id;
	private Long sku_no;
	private Long spu_no;
	private String sku_spec_value;
	private BigDecimal price;
	private int stock;
	private int sku_sales;
	private String sku_img;
	private Timestamp gmt_create;
	private Timestamp gmt_update;
	public Sku() {
		super();
	}
	public Sku(int id, Long sku_no, Long spu_no, String sku_spec_value, BigDecimal price, int stock,
			int sku_sales, String sku_img, Timestamp gmt_create, Timestamp gmt_update) {
		super();
		this.id = id;
		this.sku_no = sku_no;
		this.spu_no = spu_no;
		this.sku_spec_value = sku_spec_value;
		this.price = price;
		this.stock = stock;
		this.sku_sales = sku_sales;
		this.sku_img = sku_img;
		this.gmt_create = gmt_create;
		this.gmt_update = gmt_update;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getSku_no() {
		return sku_no;
	}
	public void setSku_no(Long sku_no) {
		this.sku_no = sku_no;
	}
	public Long getSpu_no() {
		return spu_no;
	}
	public void setSpu_no(Long spu_no) {
		this.spu_no = spu_no;
	}
	public String getSku_spec_value() {
		return sku_spec_value;
	}
	public void setSku_spec_value(String sku_spec_value) {
		this.sku_spec_value = sku_spec_value;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSku_sales() {
		return sku_sales;
	}
	public void setSku_sales(int sku_sales) {
		this.sku_sales = sku_sales;
	}
	public String getsku_img() {
		return sku_img;
	}
	public void setsku_img(String sku_img) {
		this.sku_img = sku_img;
	}
	public Timestamp getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(Timestamp gmt_create) {
		this.gmt_create = gmt_create;
	}
	public Timestamp getGmt_update() {
		return gmt_update;
	}
	public void setGmt_update(Timestamp gmt_update) {
		this.gmt_update = gmt_update;
	}
	
	

}
