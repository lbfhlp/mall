package club.ccpet.mall.util.ioc;
/**
* bean工厂接口
*/
public interface BeanFactory {
   Object getBean(String id);
}