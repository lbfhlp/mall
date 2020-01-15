package club.ccpet.mall.daoImpl.goods_spu_sku;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;

import club.ccpet.mall.dao.BaseDao;
import club.ccpet.mall.dao.goods_spu_sku.SpuDao;
import club.ccpet.mall.domain.goods_spu_sku.Spu;

public class SpuDaoImpl extends BaseDao<Spu> implements SpuDao{
	/*
	 * private static Connection conn; private static ResultSet rs; private static
	 * PreparedStatement ps;
	 * 
	 * static { conn=DbConnection.getConnection(); }
	 */
	@Override
	public int insertASpu(Long spu_no, String goods_name, int parent_category_id, int sub_category_id, int sex,
			BigDecimal lowest_price) throws SQLException {
		
		
		String sql ="INSERT INTO spu (spu_no,goods_name,parent_category_id,sub_category_id,sex,lowest_price) "
				+ "VALUES(?,?,?,?,?,?)";
		return update(sql,spu_no,goods_name,parent_category_id,sub_category_id,sex,lowest_price);
	}

	@Override
	public Spu selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectIDBySpu_no(Long spu_no) throws SQLException {
		String sql ="SELECT id FROM	 spu WHERE spu_no=?";
		//查询一个字段,返回的是object对象.
		Object  id = getForValue(sql,spu_no);
		if(id==null||id=="") {
			return 0;
		}
		
		return (Integer)id;
	}

	@Override
	public int deleteBySpu_no(Long spu_no) throws SQLException {
		String sql = "DELETE FROM spu WHERE spu_no=?";
		return update(sql, spu_no);
	}

	@Override
	public int updateSpu(BigDecimal lowestPrice,Long spu_no) throws SQLException {
		String sql = "UPDATE spu SET lowest_price = ? WHERE spu_no = ?; ";
		return update(sql, lowestPrice,spu_no);
	}
	@Override
	public Spu selectSpuBySpu_no(Long spu_no) throws SQLException {
		String sql = "SELECT * FROM spu WHERE spu_no=?";
		return get(sql, spu_no);
	}

}
