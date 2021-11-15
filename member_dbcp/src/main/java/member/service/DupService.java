package member.service;
import static member.persistence.jdbcUtil.*;

import java.sql.Connection;

import member.persistence.MemberDAO;
public class DupService {
	public boolean dupId(String userid) {
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		boolean dupId = dao.dupid(userid);
		
		close(con);
		return dupId;
	}
}
