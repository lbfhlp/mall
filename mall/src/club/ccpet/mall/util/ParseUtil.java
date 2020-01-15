package club.ccpet.mall.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 
 * @author lbf
 *
 */
public class ParseUtil {
	//常量,避免每次返回-1都产生一个对象.
	private static final BigInteger bInt = new BigInteger("-1");
	private static final BigDecimal bdec = new BigDecimal("-1");
	/**
	 * 非null及非空的字符串转换成Int;
	 * @param str
	 * @return
	 */
	public static int parseStr2Int(String str) {
		int i;
		if(str!=null&&!"".equals(str)) {
			
				i=Integer.parseInt(str);
				return i;
			
			
		}
		return -1;
	}
	
	/**
	 * 根据时间转换成毫秒数,不成功返回-1;
	 * @param date
	 * @return
	 */
	public static long parseDate2Long(Date date) {
		 if (null == date) {
	            return 0;
	        }
	        String timestamp = String.valueOf(date.getTime());
	       
	        int length = timestamp.length();
	        if (length > 3) {
	        	
	            return Long.valueOf(timestamp.substring(0,length-3));
	           
	        } else {
	            return 0;
	        }
	}
	
	/**
	 * 转换string成biginteger.成功返回;不成功返回-1;
	 * @param str
	 * @return
	 */
	public  static BigInteger str2BigInteger(String str) {
		BigInteger b ;
		//判断后赋值,避免产生不必要的对象.
		if(str!=null||"".equals(str)!=true) {
			
				b = new BigInteger(str);
				return bInt;
			
		}
		return bInt;
	}
	public  static BigDecimal str2BigDecimal(String str) {
		BigDecimal b ;
		//判断后赋值,避免产生不必要的对象.
		if(str!=null||"".equals(str)!=true) {
			
				b = new BigDecimal(str);
				return b;
			
		}
		return bdec;
	}
	
}
