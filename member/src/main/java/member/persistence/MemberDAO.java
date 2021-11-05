package member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.domain.MemberDTO;
import static member.persistence.jdbcUtil.*;
public class MemberDAO {
	private Connection con;
	
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	//login => (select)
	
	public MemberDTO select(String userid,String password) {
		
		MemberDTO loginDto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select userid,name from member where userid=? and password=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				loginDto = new MemberDTO();
				loginDto.setUserid(rs.getString("userid"));
				loginDto.setName(rs.getString("name"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return loginDto;
	}
	public boolean delete(String userid,String password) {
		boolean deleteFlag = false;
		PreparedStatement pstmt=null;
		
		String sql = "delete from member where userid =? and password=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				deleteFlag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteFlag;
	}
	
	public boolean update(MemberDTO dto) {
		boolean updateFlag = false;
		PreparedStatement pstmt = null;
		String sql = "update MEMBER set password=? where userid=? and password=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getChagnePassword());
			pstmt.setString(2, dto.getUserid());
			pstmt.setString(3, dto.getPassword());
			int result = pstmt.executeUpdate();
			
			if(result>0) updateFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateFlag;
	}
	
}
