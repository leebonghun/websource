package board.service;
import static board.persistence.jdbcUtil.*;

import java.sql.Connection;

import board.domain.boardDTO;
import board.persistence.boardDAO;
public class BoardReplyService {
	public boolean reply(boardDTO dto) {
		Connection con = getConnection();
		boardDAO dao = new boardDAO(con);
		
		dao.replyUpdate(dto);
		commit(con);
		
		boolean insertFlag = dao.replyInsert(dto);
		if(insertFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return insertFlag;
		

		
		
	}
	
}
