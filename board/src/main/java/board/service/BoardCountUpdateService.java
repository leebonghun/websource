package board.service;
import static board.persistence.jdbcUtil.*;

import java.sql.Connection;

import board.persistence.boardDAO;
public class BoardCountUpdateService {
	public boolean update(int bno) {
		Connection con = getConnection();
		boardDAO dao = new boardDAO(con);
		
		boolean updateFlag = dao.update(bno);
		
		if(updateFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return updateFlag;
	}
}
