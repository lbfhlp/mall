package club.ccpet.mall.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import club.ccpet.mall.dao.SPDao;
import club.ccpet.mall.domain.SP;
import club.ccpet.mall.util.DbConnection;

public class SPDaoImpl implements SPDao{
	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement ps;
	
	static {
		conn=DbConnection.getConnection();
	}
	@Override
	public SP selectASP(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> selectImgBySortId(int sort_parent_id, int sort_sub_id) {
		ArrayList<String> imgArr = new ArrayList<String>();
		String sql ="SELECT img_name,img_path FROM SP WHERE  sort_parent_id="+sort_parent_id+" and "+"sort_sub_id="+sort_sub_id+";";
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String img = rs.getString(2)+rs.getString(1);
				imgArr.add(img);
			}
			return imgArr;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return imgArr;
	}
	
	/**
	 * 商品名称,售价,颜色,图片名字,路径.
	 */
	@Override
	public ArrayList<SP> selectSPBySortId(int sort_parent_id, int sort_sub_id) {
		ArrayList<SP> spArr = new ArrayList<SP>();
		String sql ="SELECT name,salePrice,color,img_name,img_path,id FROM SP WHERE  sort_parent_id="+sort_parent_id+" and "+"sort_sub_id="+sort_sub_id+";";
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				SP sp = new SP();
				sp.setName(rs.getString(1));
				sp.setSalePrice(rs.getDouble(2));
				sp.setColor(rs.getString(3));
				sp.setImg_name(rs.getString(4));
				sp.setImg_path(rs.getString(5));
				sp.setId(rs.getInt(6));
				spArr.add(sp);
			}
			return spArr;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return spArr;
		
	}
	/**
	 * 根据商品id获取商品信息
	 * @param id 商品id;
	 * @return
	 */
	public SP selectSPById(int id) {
		SP sp=null;
		String sql ="SELECT * FROM SP WHERE  id="+id+";";
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				sp=new SP();
				sp.setId(rs.getInt(1));
				sp.setSex(rs.getInt(2));
				sp.setName(rs.getString(3));
				sp.setSort_parent_id(rs.getInt(4));
				sp.setSort_sub_id(rs.getInt(5));
				sp.setSalePrice(rs.getDouble(6));
				sp.setCost(rs.getDouble(7));
				sp.setStock(rs.getInt(8));
				sp.setSalesVolume(rs.getInt(9));
				sp.setImg_name(rs.getString(10));
				sp.setImg_path(rs.getString(11));
				sp.setColor(rs.getString(12));
				sp.setSize(rs.getString(13));
				sp.setDisc(rs.getString(14));
				
			}
			return sp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sp;
	}

}
