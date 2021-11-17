package board.action;

import javax.servlet.http.HttpServletRequest;

import board.domain.boardDTO;
import board.service.BoardReplyService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class BoardReplyAction implements BoardAction {
	private String path;
	@Override
	public BoardActionForward execute(HttpServletRequest request) throws Exception {
		boardDTO dto = new boardDTO();
		//원본글에 대한 정보
		dto.setRe_ref(Integer.parseInt(request.getParameter("re_ref")));
		dto.setRe_lev(Integer.parseInt(request.getParameter("re_lev")));
		dto.setRe_seq(Integer.parseInt(request.getParameter("re_seq")));
		//댓글에 대한 정보
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		BoardReplyService service = new BoardReplyService();
		boolean replyFlag = service.reply(dto);
		
		if(!replyFlag) {
			path = "/read.do?bno="+request.getParameter("bno");
		}
		
		return new BoardActionForward(path,true);
	}

}
