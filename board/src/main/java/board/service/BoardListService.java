package board.service;

import java.sql.Connection;
import java.util.List;
import static board.persistence.jdbcUtil.*;
import board.domain.boardDTO;
import board.persistence.boardDAO;

public class BoardListService {
	public List<boardDTO> list(){
		Connection con = getConnection();
		boardDAO dao = new boardDAO(con);
		
		List<boardDTO> list = dao.list();
		
		close(con);
		return list;
		
	}
}
