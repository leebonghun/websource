package member.service;

import java.sql.Connection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import member.domain.MemberDTO;
import member.domain.UpdateDTO;
import member.persistence.MemberDAO;
import member.persistence.jdbcUtil;

import static member.persistence.jdbcUtil.*;
@Getter
@Setter

public class ModifyService {
	public boolean modify(UpdateDTO updateDTO) {

		Connection con = getConnection();

		
		MemberDAO dao = new MemberDAO(con);

		boolean updateFlag = dao.update(updateDTO);

		if (updateFlag) {
			commit(con);
		} else {
			rollback(con);
		}

		close(con);

		return updateFlag;

	}
}
