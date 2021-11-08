package member.action;

import java.nio.file.ClosedWatchServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import member.domain.MemberDTO;
import member.domain.UpdateDTO;
import member.persistence.MemberDAO;
import member.persistence.jdbcUtil;
import member.service.ModifyService;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModifyAction implements Action {
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		// modifyForm.jsp 에서 사용자 입력값 가져오기
		String current_password = request.getParameter("current_password"); // 현재 비밀번호
		String new_password = request.getParameter("new_password");// 새 비밀번호
		String confirm_password = request.getParameter("confirm_password");// 새 비밀번호
		MemberDTO loginDto = (MemberDTO) session.getAttribute("loginDto");
		String userid = loginDto.getUserid();
		UpdateDTO updateDto = new UpdateDTO(userid, current_password, new_password, confirm_password);

		if (updateDto.passwordEqualTo(new_password)) {
			// db작업
			ModifyService service = new ModifyService();
			boolean updateFlag = service.modify(updateDto);

			if (updateFlag) {
				session.invalidate();
//				path = "/view/loginForm.jsp";
			} else {
				path = "/view/modifyForm.jsp";
			}
		} else {
			path = "/view/modifyForm.jsp";
		}

		return new ActionForward(path, true);
	}

}
