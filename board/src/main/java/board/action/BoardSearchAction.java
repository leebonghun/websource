package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import board.domain.SearchDTO;
import board.domain.boardDTO;
import board.service.BoardSearchService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BoardSearchAction implements BoardAction {
	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		SearchDTO searchDto = new SearchDTO();
		
		searchDto.setCriteria(request.getParameter("criteria"));
		searchDto.setKeyword(request.getParameter("keyword"));
		
		BoardSearchService service = new BoardSearchService();
		List<boardDTO> list=service.search(searchDto);
		
		request.setAttribute("list", list);
		request.setAttribute("searchDto", searchDto);
		
		return new BoardActionForward(path,false);
	}

	
	}


