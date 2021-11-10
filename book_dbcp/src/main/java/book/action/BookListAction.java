package book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import book.domain.BookDTO;
import book.service.BookListService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BookListAction implements BookAction {
	private String path;

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		
		BookListService service = new BookListService();
		List<BookDTO> list=service.getList();
		
		request.setAttribute("list", list);
		
		// TODO Auto-generated method stub
		return new BookActionForward(path,false); //request.setAttribute로 하면 무조거 false;
	}

}
