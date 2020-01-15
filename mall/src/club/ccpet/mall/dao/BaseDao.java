package club.ccpet.mall.dao;



import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import club.ccpet.mall.domain.goods_category.Sub_category;
import club.ccpet.mall.util.JDBCUtil;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 * 封装了基本的增删改查的方法，以供子类继承使用。
 * 当前DAO 直接在方法中获取数据库连接。
 * 整个DAO 采取DBUtils 解决方案。
 * @author User
 *
 * @param <T> 当前 DAO 处理的实体类的类型是什么
 */
public class BaseDao<T> {

    private QueryRunner queryRunner = new QueryRunner();
    
    private Class<T> clazz;
    
    
    /**
     * 需要确定 clazz
     */
    public BaseDao(){
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
                    clazz = (Class<T>) typeArgs[0];
                }
            }
        }
    }
    //baseservice层调用basedao时,由于没有任何类继承了basedao,则上面的构造方法无法获取到有用的Class对象.
    public BaseDao(Class clazz) {
    	this.clazz = clazz;
    }
    
    /**
     * 将结果集第一行的某一列放到某个对象中
     * @return 
     * @throws SQLException 
     */
    public <E> E getForValue(String sql, Object...args) throws SQLException{
        Connection connection = null;
        
            connection = JDBCUtil.getConnection();
            return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
    }
    
    /**
     * 将结果集的所有行存到一个Object[],并把这个数组存到list中
     * @param sql
     * @param args
     * @return 
     * @throws SQLException
     */
    public  List<Object[]>  getForList(String sql, Object...args) throws SQLException {
    	Connection connection = null;
        connection = JDBCUtil.getConnection();
    	return queryRunner.query(connection,sql, new ArrayListHandler(),args);
    }
    /**
     * 查询，返回T 所对应的 List
     * @throws SQLException 
     */
    public List<T> getForBeanList(String sql, Object...args) throws SQLException {
    	System.out.println("dfjkdjfkdjf"+clazz);
    		Connection connection = null;
            connection = JDBCUtil.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
       
        
    }
    
    /**
     * 查询,返回一个T 的实体类对象
     * BeanHandler--将结果集中的第一行数据封装到一个对应的JavaBean实例中（把每条记录封装成对象，适合取一条记录）
     * @throws SQLException 
     */
    public T get(String sql, Object...args) throws SQLException{
        Connection connection = null;
        
        
            connection = JDBCUtil.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
       
       
    }
    
    
    /**
     * 通用的 insert 、delete、update 方法;返回增删改成功的行数;失败则返回0;
     * @param sql sql语句;
     * @param args 可变参数,即Object[];参数名字需要和表的字段名对应;
     * @return
     * @throws SQLException 
     */
    public int update(String sql, Object...args) throws SQLException{
    	 	Connection connection  = JDBCUtil.getConnection();
    	 	
            return queryRunner.update(connection, sql, args);
    }
    /**
     * 用于插入一条记录时,返回这条记录的id(int类型).
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    @SuppressWarnings("unchecked")
	public int insert(String sql, Object...args) throws SQLException {
    	Connection connection  = JDBCUtil.getConnection();
    	Long long1 = (Long)queryRunner.insert(connection, sql, new ScalarHandler(), args);
        return long1.intValue();

    }
}
