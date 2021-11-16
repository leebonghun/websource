package board.service;

import board.domain.boardDTO;
import board.persistence.boardDAO;

import static board.persistence.jdbcUtil.*;

import java.sql.Connection;
public class BoardReadService {
	public boardDTO getRead(int bno) {
		Connection con = getConnection();
		boardDAO dao = new boardDAO(con);
		
		
		boardDTO dto = dao.read(bno);
		
		close(con);
		
		return dto;
	}
}
