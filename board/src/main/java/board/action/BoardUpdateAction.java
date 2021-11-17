package board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.domain.boardDTO;
import board.service.BoardUpdateService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BoardUpdateAction implements BoardAction {
	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		
		UploadUtil uploadUtil = new UploadUtil();
		Map<String, String> map=uploadUtil.requestParse(request);
		
		
		boardDTO dto = new boardDTO();
		
		dto.setTitle(map.get("title"));
		dto.setContent(map.get("content"));
		dto.setPassword(map.get("password"));
		dto.setAttach(map.get("attach"));
		dto.setName(map.get("name"));
		dto.setBno(Integer.parseInt(map.get("bno")));

		
		BoardUpdateService service = new BoardUpdateService();
		boolean updateFlag1 = service.update1(dto);
		if(updateFlag1) {
			path += "?bno="+dto.getBno();
		}else {
			path = "/modify.do?bno="+dto.getBno();
		}
		
		
		return new BoardActionForward(path,true);
	}

}
