package member.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.compiler.NewlineReductionServletWriter;

import lombok.AllArgsConstructor;
import member.service.DupService;
@AllArgsConstructor
public class DupAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");
		
		DupService service = new DupService();
		boolean dupid = service.dupId(userid);
		
		request.setAttribute("dupId", dupid);
		
		
		
		
		return new ActionForward(path,false);
	}

}
