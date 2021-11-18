package board.service;


import java.sql.Connection;
import java.util.List;

import board.domain.SearchDTO;
import board.domain.boardDTO;
import board.persistence.boardDAO;

import static board.persistence.jdbcUtil.*;

public class BoardSearchService {
	public List<boardDTO> search(SearchDTO searchDTO){
		Connection con = getConnection();
		boardDAO dao = new boardDAO(con);
		
		List<boardDTO> list = dao.searchList(searchDTO);
		
		close(con);
		
		return list;
		
		
		
	}
}
