package book.service;
import static book.persistence.jdbcUtil.*;

import java.sql.Connection;


import book.persistence.BookDAO;
public class BookModifyService {
	public boolean bookupdate(String code,int price) {
		
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		boolean updateFlag=dao.update(code, price);
		
		if(updateFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return updateFlag;
	}
}
