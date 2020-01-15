package club.ccpet.mall.serviceImpl.goods_spu_sku;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import club.ccpet.mall.dao.goods_spu_sku.SkuDao;
import club.ccpet.mall.daoImpl.goods_spu_sku.SkuDaoImpl;
import club.ccpet.mall.domain.goods_spu_sku.Sku;
import club.ccpet.mall.service.BaseService;
import club.ccpet.mall.service.goods_spu_sku.SkuService;
import club.ccpet.mall.service.goods_spu_sku.Spec_valueService;
import club.ccpet.mall.service.goods_spu_sku.SpuService;
import club.ccpet.mall.service.goods_spu_sku.Spu_specService;
import club.ccpet.mall.util.ParseUtil;

public class SkuServiceImpl extends BaseService<Sku> implements SkuService{
	SkuDao skuDao = new SkuDaoImpl();
	/**
	 * 添加一个spu下的所有sku,并且返回最低价格,添加sku出错时返回-1;
	 * @throws SQLException 
	 */
	@Override
	public int addSku( Long spu_no, String sku_spec_value, BigDecimal price, int stock,int i,int j) throws SQLException {
		
		
		Long sku_no = createSku_no(spu_no,i,j);
		return skuDao.addASku(sku_no, spu_no, sku_spec_value, price, stock);
	}

	@Override
	public List<Sku> getBySpu_no(Long spu_no) throws SQLException {
		
		
		return skuDao.getBySpu_no(spu_no);
	}
	
	
	

	
}
