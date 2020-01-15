package club.ccpet.mall.service.goods_spu_sku;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import club.ccpet.mall.domain.goods_spu_sku.Sku;

public interface SkuService {
	public int addSku(Long spu_no, String sku_spec_value, BigDecimal price, int stock,int i,int j) throws SQLException;
	
	/**
	 * 根据spu_no查询,返回一个sku类型的集合.
	 * @return
	 * @throws SQLException 
	 */
	public List<Sku> getBySpu_no(Long spu_no) throws SQLException;
	/**
	 * sku_no生成规则:   spu_no+i+j;存在数值溢出的可能.
	 * 	如果spu_no不为空,则返回""+spu_no+i+j,否则返回-1;
	 * @param spu_no
	 * @param i
	 * @param j
	 * @return
	 */
	public default  Long createSku_no(Long spu_no,int i,int j) {
		return  (spu_no!=null)?new Long(""+spu_no+i+j):new Long(-1);
	}
	/**
	 * 根据规格的id,创建sku的规格字段,即颜色id-尺码id;
	 * @param spec1_value_id
	 * @param spec2_value_id
	 * @return
	 */
	public default  String createSku_spec_value(int spec1_value_id,int spec2_value_id) {
		return new String(spec1_value_id+"-"+spec2_value_id);
	}
}
