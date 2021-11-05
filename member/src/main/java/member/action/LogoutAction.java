package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogoutAction implements Action {
	private String path; //index.jsp가 들어가있는 상황
	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		
		//세션 해제
		
		HttpSession session = request.getSession();
		session.removeAttribute("loginDto");
//		session.invalidate();
		
		
		
		return new ActionForward(path,true) ;
	}

}
