package board.service;

import board.domain.boardDTO;
import board.persistence.boardDAO;

import static board.persistence.jdbcUtil.*;

import java.sql.Connection;
public class BoardInsertService {
	public boolean boardInsert(boardDTO dto) {
		Connection con = getConnection();
		boardDAO dao = new boardDAO(con);
		
		boolean insertFlag = dao.insert(dto);
		
		
		if(insertFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return insertFlag;
		
		
	}
}
