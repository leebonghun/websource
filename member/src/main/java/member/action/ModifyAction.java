package member.action;

import javax.servlet.http.HttpServletRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModifyAction implements Action {
	private String path;
	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		//modifyForm.jsp 에서 사용자 입력값 가져오기
		
		String current_password = request.getParameter("current_password"); // 현재 비밀번호
		String new_password = request.getParameter("new_password");// 새 비밀번호
		String confirm_password = request.getParameter("confirm_password");// 새 비밀번호
		
		
		
		return null;
	}

}
