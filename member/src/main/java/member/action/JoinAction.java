package member.action;

import javax.servlet.http.HttpServletRequest;


import lombok.AllArgsConstructor;
import member.domain.MemberDTO;
import member.service.JoinService;
@AllArgsConstructor
public class JoinAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		
		MemberDTO dto = new MemberDTO();
		dto.setUserid(request.getParameter("userid"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setGender(request.getParameter("gender"));
		dto.setEmail(request.getParameter("email"));
		
		JoinService service = new JoinService();
		boolean insertFlag = service.register(dto);
		
		if(!insertFlag) {
			path ="/view/joinForm.jsp?tab=join";
		}
		return new ActionForward(path,true);
	}

}
