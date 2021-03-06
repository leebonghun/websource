package board.action;

import javax.servlet.http.HttpServletRequest;

import board.service.BoardCountUpdateService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BoardCountUpdateAction implements BoardAction {
	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardCountUpdateService updateService = new BoardCountUpdateService();
		updateService.update(bno);
		
		path += "?bno="+bno; //bno값을 다시 받아줌 여기서는 애초에 bno를 받았음.
		
		return new BoardActionForward(path, true) ;
	}

}
