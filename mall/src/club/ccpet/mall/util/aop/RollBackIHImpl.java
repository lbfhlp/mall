package club.ccpet.mall.util.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import club.ccpet.mall.util.JDBCUtil;
import club.ccpet.mall.util.annotation.Transaction;

/**
 * 动态代理的切面,
 * 用于实现事务控制
 * 所有需要应用改切面的类都需要添加@AOP注解,方法上添加@Transaction注解.
 */
public class RollBackIHImpl implements InvocationHandler {

    private Object target;

    public RollBackIHImpl() {

    }

    public RollBackIHImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        Object returnValue = null;

        //方法是否开启事务注解 且name为RollBackIHImpl;
        boolean isTransaction = method.isAnnotationPresent(Transaction.class);
        if (!isTransaction) {
            //如果未开启了事务
            System.out.println("未开启事务");
            System.out.println(method.getName());
            returnValue = method.invoke(target, args);  
            return returnValue;  
        } 
    	   //如果开启了事务
           System.out.println("开启了回滚事务");
           System.out.println(method.getName());
           try {
           	//开启事务
               JDBCUtil.beginTransaction();
               //执行方法
               returnValue = method.invoke(target, args);  
               //提交
               JDBCUtil.commitTransaction();
           } catch (Exception e) {
           	//出错则回滚
           	System.out.println("我滚了");
           	JDBCUtil.rollbackTransaction();
               throw e;
           } finally {
           	//释放
           	JDBCUtil.releaseConnection();
           }

           return returnValue;  
       
       
    }

}
