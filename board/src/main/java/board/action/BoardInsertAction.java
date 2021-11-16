package board.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import board.domain.boardDTO;
import board.service.BoardInsertService;
import board.util.UploadUtil;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BoardInsertAction implements BoardAction {
	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {

		//request를 UploadUtil 넘기기
		UploadUtil uploadUtil = new UploadUtil();
		Map<String, String> map=uploadUtil.requestParse(request);
		
		  boardDTO dto = new boardDTO(); //qna_board_write.jsp에서 넘긴 값 가져오기
		  dto.setTitle(map.get("title"));
		  dto.setContent(map.get("content"));
		  dto.setPassword(map.get("password"));
		  dto.setAttach(map.get("attach"));
		  dto.setName(map.get("name"));
		 
		
		
		
		 BoardInsertService service = new BoardInsertService(); 
		 boolean insertFlag = service.boardInsert(dto);
		  
		  
		  if(!insertFlag) { path ="/view/qna_board_write.jsp"; }
		 
		// TODO Auto-generated method stub
		return new BoardActionForward(path,true);
	}

}
