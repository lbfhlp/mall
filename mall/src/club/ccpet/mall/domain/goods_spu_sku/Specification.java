package club.ccpet.mall.domain.goods_spu_sku;

import java.sql.Timestamp;

public class Specification {
	private int id;
	private String spec_no;
	private String spec_name;
	private Timestamp gmt_create;
	private Timestamp gmt_update;
	public Specification() {
		super();
	}

	public Specification(int id, String spec_no, String spec_name, Timestamp gmt_create, Timestamp gmt_update) {
		super();
		this.id = id;
		this.spec_no = spec_no;
		this.spec_name = spec_name;
		this.gmt_create = gmt_create;
		this.gmt_update = gmt_update;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpec_no() {
		return spec_no;
	}

	public void setSpec_no(String spec_no) {
		this.spec_no = spec_no;
	}

	public String getSpec_name() {
		return spec_name;
	}

	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
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
