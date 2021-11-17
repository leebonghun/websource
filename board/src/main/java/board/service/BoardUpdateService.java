package board.service;
import static board.persistence.jdbcUtil.*;

import java.sql.Connection;

import board.domain.boardDTO;
import board.persistence.boardDAO;
public class BoardUpdateService {
	public boolean update1(boardDTO dto) {
		Connection con = getConnection();
		boardDAO dao = new boardDAO(con);
		
		boolean updateFlag1 = dao.getUpdate(dto);
		if(updateFlag1) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return updateFlag1;
		
	}
}
