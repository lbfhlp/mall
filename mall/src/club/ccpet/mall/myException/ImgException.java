package club.ccpet.mall.myException;
/**
 * 自定义异常,图片上传时异常
 * @author lbf
 *
 */
public class ImgException extends RuntimeException {
	/**
	 * 
	 */
	 //无参构造方法
    public ImgException(){
    	super();
    	
    }

    //有参的构造方法
    public ImgException(String message){
    	super(message);
    }

    
}
