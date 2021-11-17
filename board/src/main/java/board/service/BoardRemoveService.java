package board.service;
import static board.persistence.jdbcUtil.*;

import java.sql.Connection;

import board.persistence.boardDAO;
public class BoardRemoveService {
	public boolean delete(int bno,String password) {

		
		Connection con  = getConnection();
		boardDAO dao = new boardDAO(con);
		
		boolean deleteFlag = dao.delete(bno, password);
		
		if(deleteFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		return deleteFlag;
	}
}
