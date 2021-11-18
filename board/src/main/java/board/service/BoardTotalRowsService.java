package board.service;
import static board.persistence.jdbcUtil.*;

import java.sql.Connection;

import board.domain.SearchDTO;
import board.persistence.boardDAO;
public class BoardTotalRowsService {
	public int totalRows(SearchDTO searchDto) {
		Connection con = getConnection();
		boardDAO dao = new boardDAO(con);
		
		int total = dao.totalRows(searchDto);
		
		close(con);
		return total;
		
		
	}
}
