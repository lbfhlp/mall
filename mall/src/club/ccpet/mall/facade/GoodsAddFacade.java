package club.ccpet.mall.facade;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import club.ccpet.mall.util.annotation.AOP;
import club.ccpet.mall.util.annotation.Transaction;

@AOP
public interface GoodsAddFacade {
	@Transaction
	public void  addGoods(List<FileItem> items,String basePath) throws SQLException, Exception;
}
