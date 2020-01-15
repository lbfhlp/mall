package club.ccpet.mall.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import club.ccpet.mall.dao.BaseDao;
import club.ccpet.mall.domain.goods_category.Sub_category;
import club.ccpet.mall.util.JDBCUtil;

public class BaseService<T> {
	private Class<T> clazz;
	
	BaseDao<T>	baseDao;
	 public BaseService(Class clazz) {
		 baseDao=new BaseDao<T>(clazz);
	}
	 public BaseService(){
	        //由得到子类的 Class得到父类 带泛型的那个类型。
	        Type superClass = getClass().getGenericSuperclass();
	        //先判断是不是那个类型
	        if(superClass instanceof ParameterizedType){
	            //是的话，强转一下
	            ParameterizedType parameterizedType = (ParameterizedType) superClass;
	            //获取真正的泛型的参数
	            Type[] typeArgs = parameterizedType.getActualTypeArguments();
	            if(typeArgs != null && typeArgs.length >0){
	                if(typeArgs[0] instanceof Class){
	                	//子类继承Dao<User>,则clazz=User.getClass().用于保存bean;
	                    clazz = (Class<T>)typeArgs[0];
	                }
	            }
	        }
	        System.out.println(clazz);
	        //basedao 需要一个class对象用于处理结果集保存到哪个bean.
	        baseDao=new BaseDao<T>(clazz);
	    }
	 /**
	  * 封装通用的insert,delete,update,
	  * @param sql
	  * @param args
	  * @return
	  * @throws SQLException
	  */
	 public int update(String sql, Object...args) throws SQLException {
		
		return baseDao.update(sql, args);
	}
	 /**
	  * 将结果集第一行的某一列放到某个对象中
	  * @param <E>
	  * @param sql
	  * @param args
	  * @return
	  * @throws SQLException
	  */
	 public <E> E getForValue(String sql, Object...args) throws SQLException{
		 return baseDao.getForValue(sql, args);
	 }
	
	 
	 /**
	     * 将结果集的所有行存到一个Object[],并把这个数组存到list中
	     * @param sql
	     * @param args
	     * @return 
	     * @throws SQLException
	     */
	    public  List<Object[]>  getForList(String sql, Object...args) throws SQLException {
	    	
	    	return baseDao.getForList(sql, args);
	    }
	 
	 /**
	    * 查询，返回T 所对应的 List
	 * @throws SQLException 
	 */
    public List<T> getForBeanList(String sql, Object...args) throws SQLException {
    	return baseDao.getForBeanList(sql, args);
    }
    /**
             * 查询,返回一个T 的实体类对象
     * BeanHandler--将结果集中的第一行数据封装到一个对应的JavaBean实例中（把每条记录封装成对象，适合取一条记录）
     * @throws SQLException 
     */
    public T get(String sql, Object...args) throws SQLException{
       
    	return baseDao.get(sql, args);
    }
    /**
     * 插入一条数据,并返回id;
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    public int insert(String sql, Object...args) throws SQLException {
    	return baseDao.insert(sql, args);
    }
}
