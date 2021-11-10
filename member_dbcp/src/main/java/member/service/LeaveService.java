package member.service;
//여기가 원래 하던 db작업 여기서 leaveAction으로 넘어감
import java.sql.Connection;
import java.sql.PreparedStatement;

import member.domain.MemberDTO;
import member.persistence.MemberDAO;

import static member.persistence.jdbcUtil.*;
public class LeaveService {
	public boolean leave(String userid, String password) {
		Connection con = getConnection();
		
		MemberDAO dao = new MemberDAO(con);
		
		boolean deleteFlag = dao.delete(userid, password);
		
		if(deleteFlag) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return deleteFlag;
	}
}
