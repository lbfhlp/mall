package club.ccpet.mall.domain.goods_spu_sku;

import java.sql.Timestamp;

public class SpecificationValue {
	private int id;
	private int spec_id;
	private String spec_value;
	private Timestamp gmt_create;
	private Timestamp gmt_update;
	public SpecificationValue() {
		super();
	}

	public SpecificationValue(int id, int spec_id, String spec_value, Timestamp gmt_create,
			Timestamp gmt_update) {
		super();
		this.id = id;
		this.spec_id = spec_id;
		this.spec_value = spec_value;
		this.gmt_create = gmt_create;
		this.gmt_update = gmt_update;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpec_id() {
		return spec_id;
	}

	public void setSpec_id(int spec_id) {
		this.spec_id = spec_id;
	}

	public String getSpec_value() {
		return spec_value;
	}

	public void setSpec_value(String spec_value) {
		this.spec_value = spec_value;
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
