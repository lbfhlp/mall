package club.ccpet.mall.serviceImpl.goods_spu_sku;

import java.sql.SQLException;

import club.ccpet.mall.dao.goods_spu_sku.Spec_valueDao;
import club.ccpet.mall.daoImpl.goods_spu_sku.Spec_valueDaoImpl;
import club.ccpet.mall.service.goods_spu_sku.Spec_valueService;

public class Spec_valueServiceImpl implements Spec_valueService{
	Spec_valueDao sd = new Spec_valueDaoImpl();
	/**
	 * 查询spec_value是否存在,存在则直接返回id,否则新建,并返回id;
	 * @throws SQLException 
	 */
	@Override
	public int creatSpec_value(String spec_value,int spec_id) throws SQLException {
		
		
		//如果有记录则返回id,否则返回-1;
		int spec_value_id = sd.selectSpec_value_id(spec_value, spec_id);
		//存在直接返回id
		if(spec_value_id>-1) {
			return spec_value_id;
		}else {
			//否则插入.并且返回id
			sd.insert(spec_id, spec_value);
			//该方法查不到id会返回-1;
			return sd.selectSpec_value_id(spec_value, spec_id);
		}
		
		
	}

	@Override
	public String getSpecValue(int id) throws SQLException {
		return sd.selectSpecValue(id);
	}

}
