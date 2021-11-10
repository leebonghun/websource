package member.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.ToString;
import member.domain.MemberDTO;
import member.persistence.MemberDAO;
import member.service.LeaveService;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import static member.persistence.jdbcUtil.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LeaveAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		String userid = request.getParameter("userid");
		String current_password = request.getParameter("current_password");
		
		
		
		//db작업;
		LeaveService service = new LeaveService();
		boolean deleteFlag = service.leave(userid, current_password);
		
		if(deleteFlag) {
			//현재 가지고 있는 session 해제
			HttpSession session = request.getSession();
			session.removeAttribute("loginDto");
		}else {
			path = "/view/leaveForm.jsp";
		}
		
		return new ActionForward(path,true);
	}

}
