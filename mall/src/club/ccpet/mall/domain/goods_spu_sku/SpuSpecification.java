package club.ccpet.mall.domain.goods_spu_sku;

import java.math.BigInteger;
import java.sql.Timestamp;

public class SpuSpecification {
	private int id;
	private int spu_id;
	private int spec_id;
	private int spec_value_id;
	public SpuSpecification() {
		super();
	}
	public SpuSpecification(int id, int spu_id, int spec_id, int spec_value_id) {
		super();
		this.id = id;
		this.spu_id = spu_id;
		this.spec_id = spec_id;
		this.spec_value_id = spec_value_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSpu_id() {
		return spu_id;
	}
	public void setSpu_id(int spu_id) {
		this.spu_id = spu_id;
	}
	public int getSpec_id() {
		return spec_id;
	}
	public void setSpec_id(int spec_id) {
		this.spec_id = spec_id;
	}
	public int getSpec_value_id() {
		return spec_value_id;
	}
	public void setSpec_value_id(int spec_value_id) {
		this.spec_value_id = spec_value_id;
	}
	
	
}
