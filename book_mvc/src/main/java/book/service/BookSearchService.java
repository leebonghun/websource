package book.service;

import java.sql.Connection;
import java.util.List;

import book.domain.BookDTO;
import book.persistence.BookDAO;

import static book.persistence.jdbcUtil.*;
public class BookSearchService {
	public List<BookDTO> bookSearch(String criteria,String keyword){
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		List<BookDTO> list = dao.search(criteria, keyword);
		
		close(con);
		
		return list;
		
		
	}
}
