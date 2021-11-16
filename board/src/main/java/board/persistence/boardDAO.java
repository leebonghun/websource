package board.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static board.persistence.jdbcUtil.*;
import board.domain.boardDTO;

public class boardDAO {

	private Connection con;
	
	public boardDAO(Connection con) {
		this.con = con;
	}
	public boolean insert(boardDTO dto) {
		boolean insertFlag = false;
		PreparedStatement pstmt = null;				
		try {
			String sql = "insert into board (bno,title,content,password,attach,name,re_ref,re_lev,re_sequence)values(board_seq.nextval,?,?,?,?,?,board_seq.currval,0,0)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getAttach());
			pstmt.setString(5, dto.getName());
		
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				insertFlag=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertFlag;
	}
	public List<boardDTO> list(){
		List<boardDTO> list = new ArrayList<boardDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select bno,title,name,regdate,readcount from board order by bno desc";
			pstmt =con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			boardDTO dto = new boardDTO();
			dto.setBno(rs.getInt("bno"));
			dto.setTitle(rs.getString("title"));
			dto.setName(rs.getString("name"));
			dto.setRegdate(rs.getDate("regdate"));
			dto.setReadcount(rs.getInt("readcount"));
			
			list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public boardDTO read(int bno) {
		boardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select bno,name,title,content,attach from board where bno = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new boardDTO();
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return dto;
	}
	//조회수 업데이트
	public boolean update(int bno) {
		boolean updateFlag = false;
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update board set readcount = readcount+1 where bno=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				updateFlag = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return updateFlag;
		
	}
}
