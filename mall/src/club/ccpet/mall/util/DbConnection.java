
package club.ccpet.mall.util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DbConnection {
	
	private static Connection conn=null;  
	private String driver="com.mysql.cj.jdbc.Driver";  
	private String url="jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Hongkong";  
	private String user="root";  
	private String password="123456";  
	//恶汉单例模式. 
	private DbConnection(){  
	  try {  
	   Class.forName(driver);  
	   conn=DriverManager.getConnection(url, user, password);  
	  } catch (ClassNotFoundException e) {  
	   e.printStackTrace();  
	  } catch (SQLException e) {  
	   e.printStackTrace();  
	  }  
	 }  
	   
	 public static Connection getConnection() {  
		  //首次访问时,给conn赋值.
		  if(conn==null){  
			  new DbConnection();  
		  }  
		  return conn;  
	 }
	
	 public static void close() {
			if(conn != null) {
				try {
					conn.close();  //关闭数据库链接
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


}
