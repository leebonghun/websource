package member.service;

import member.domain.MemberDTO;
import member.persistence.MemberDAO;

import static member.persistence.jdbcUtil.*;

import java.sql.Connection;
public class LoginService {
	public MemberDTO loginService(String userid,String password){
		
		
		Connection con =getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		MemberDTO loginDto = dao.select(userid,password);
		
		close(con);
		
		return loginDto;
	}
}
