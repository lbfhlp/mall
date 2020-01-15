package club.ccpet.mall.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import club.ccpet.mall.dao.SP_typeDao;
import club.ccpet.mall.domain.SP_type.SP_type_parent;
import club.ccpet.mall.domain.SP_type.SP_type_sub;
import club.ccpet.mall.util.DbConnection;

public class SP_typeDaoImpl implements SP_typeDao {
	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement ps;
	
	static {
		conn=DbConnection.getConnection();
	}
	/**
	 * 所有父级分类
	 */
	@Override
	public ArrayList<SP_type_parent> selectParent(String sql) {
		
		ArrayList<SP_type_parent> SP_type_parent_s = new ArrayList<SP_type_parent>();
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				SP_type_parent sptp = new SP_type_parent();
				sptp.setParent_id(rs.getInt(1));
				sptp.setParent_type(rs.getString(2));
				sptp.setDisc(rs.getString(3));
				SP_type_parent_s.add(sptp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return SP_type_parent_s;
	}
	/**
	 * 子级分类的sub_type
	 */
	@Override
	public ArrayList<String> selectSubType(String sql) {
		ArrayList<String> subTypeArray = new ArrayList<String>();
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				subTypeArray.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return subTypeArray;
	}
	
	/**
	 * 获取子级分类
	 */
	@Override
	public ArrayList<SP_type_sub> selectSub(String sql) {
		ArrayList<SP_type_sub> SP_type_subs = new ArrayList<SP_type_sub>();
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				SP_type_sub spts = new SP_type_sub();
				spts.setParent_id(rs.getInt(1));
				spts.setSub_id(rs.getInt(2));
				spts.setSub_type(rs.getString(3));
				spts.setDisc(rs.getString(4));
				SP_type_subs.add(spts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return SP_type_subs;
	}
	
	

}
