package member.service;
import static member.persistence.jdbcUtil.*;

import java.sql.Connection;

import member.domain.MemberDTO;
import member.persistence.MemberDAO;
public class JoinService {
	public boolean register(MemberDTO dto) {
			Connection con = getConnection();
			MemberDAO dao = new MemberDAO(con);
			
			boolean insertFlag = dao.insert(dto);
			
			if(insertFlag) {
				commit(con);
			}else {
				rollback(con);
			}
			close(con);
			
			return insertFlag;
		
	}
}
