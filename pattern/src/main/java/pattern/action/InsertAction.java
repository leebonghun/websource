package pattern.action;

import javax.servlet.http.HttpServletRequest;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request) throws Exception {
		
		return new ActionForward("insert.jsp",false);
	}

}
