package book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import book.domain.BookDTO;
import book.service.BookSearchService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BookSearchAction implements BookAction {
	private String path;
	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");
		
		BookSearchService service = new BookSearchService();
		List<BookDTO> list=service.bookSearch(criteria, keyword);
		
		request.setAttribute("list", list);
		
		return new BookActionForward(path,false);
	}

}
