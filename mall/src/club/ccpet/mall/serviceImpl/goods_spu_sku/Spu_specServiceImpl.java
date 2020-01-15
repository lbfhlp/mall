package club.ccpet.mall.serviceImpl.goods_spu_sku;


import java.sql.SQLException;
import java.util.List;

import club.ccpet.mall.dao.goods_spu_sku.Spu_specDao;
import club.ccpet.mall.daoImpl.goods_spu_sku.Spu_specDaoImpl;
import club.ccpet.mall.domain.goods_spu_sku.SpuSpecification;
import club.ccpet.mall.service.goods_spu_sku.Spu_specService;

public class Spu_specServiceImpl implements Spu_specService{
	Spu_specDao  spu_specDao = new Spu_specDaoImpl(); 

	@Override
	public int insert(int spu_id, int spec_id, int spec_value_id) throws SQLException {
		
	
		return 	spu_specDao.insert(spu_id, spec_id, spec_value_id);
	}
	@Override
	public  int  delete(int spu_id) throws SQLException {
		 
		return spu_specDao.delete(spu_id);
	}
	
	public List<SpuSpecification> getSpecBySpu_id(int spu_id) throws SQLException {
		return spu_specDao.selectSpecBySpu_id(spu_id);
	}
	
}
