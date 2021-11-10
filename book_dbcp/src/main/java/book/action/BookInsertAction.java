package book.action;

import javax.servlet.http.HttpServletRequest;

import book.domain.BookDTO;
import book.service.BookInsertService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BookInsertAction implements BookAction{
	private String path;

	@Override
	public BookActionForward execute(HttpServletRequest request) throws Exception {
		
		BookDTO insertDto = new BookDTO();
		
		insertDto.setCode(request.getParameter("code"));
		insertDto.setTitle(request.getParameter("title"));
		insertDto.setWriter(request.getParameter("writer"));
		insertDto.setPrice(Integer.parseInt(request.getParameter("price")));
		
		BookInsertService service = new BookInsertService();
		boolean insertFlag = service.bookInsert(insertDto);
		
		
		if(!insertFlag) {
			path ="/index.jsp?tab=insert";
		}
		// TODO Auto-generated method stub
		return new BookActionForward(path,true);
	}

}
