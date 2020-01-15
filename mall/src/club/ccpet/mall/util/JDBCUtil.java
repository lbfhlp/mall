package club.ccpet.mall.util;




import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;




/**
 * JDBC 操作的工具类
 * @author User
 *
 */
public class JDBCUtil {
	//ThreadLocal是为当前线程创建一个单独的变量副本
	 private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
   
	 /**
	     * 数据源的初始化一定要放在静态代码块中，数据源被创建一次就够了
	     */
	    private static DataSource dataSource = null;
	    static{
	    	//使用c3p0连接池.
	        dataSource = new ComboPooledDataSource("mall"); //传入的是 configName
	    }
	    /**
	     * 获取连接.返回数据源的一个 Connection 对象,并且把这个连接保存到threadLocal,便于事务操作.
	     * @throws SQLException 
	     */
	    public static Connection getConnection() throws SQLException{
	    	//保证了一个事务中,取到的都是同一个connection.
	        Connection conn = threadLocal.get();
	        if (conn==null) {
				conn = dataSource.getConnection();
				//把conn存储到当前线程.
				threadLocal.set(conn);
			}
	        return conn;
	       

	    }
	 
	 /**
     * 释放 Connection 的连接
	 * @throws SQLException 
     */
    public static void releaseConnection() throws SQLException{
    	Connection conn = threadLocal.get();
        
            if(conn != null){
            	//释放连接之前,先设为自动提交.
            	conn.setAutoCommit(true);
                conn.close();
                //从当前线程删除保存的变量.
                threadLocal.remove();
            }
    }
    
    /*
     * 开启事务
     */
    public static void beginTransaction() throws SQLException {
        Connection connnection = getConnection();
        connnection.setAutoCommit(false);
    }
    //提交事务
    public static void commitTransaction() throws SQLException {
        Connection connnection = getConnection();
        connnection.commit();
    }

    //回滚
    public static void rollbackTransaction() throws SQLException {
        Connection connnection = getConnection();
        connnection.rollback();
    }

   
  
}
