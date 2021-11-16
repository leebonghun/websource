package board.action;

import javax.servlet.http.HttpServletRequest;


import board.domain.boardDTO;
import board.service.BoardCountUpdateService;
import board.service.BoardReadService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BoardReadAction implements BoardAction {
	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		//Integer.parseInt 썼을때 뜨는 오류가 NumberFormatException: null
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		
		
		BoardReadService service = new BoardReadService();
		boardDTO dto = service.getRead(bno);
		
		
		
		request.setAttribute("dto", dto);
		
	
		return new BoardActionForward(path,false);
	}

}
