package board.persistence;

import java.lang.module.ModuleDescriptor.Builder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static board.persistence.jdbcUtil.*;

import board.domain.PageDTO;
import board.domain.SearchDTO;
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
	
	//전체 목록 : page 나누기 전
//	public List<boardDTO> list(){
//		List<boardDTO> list = new ArrayList<boardDTO>();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			//댓글과 게시글 위치 변경
//			String sql = "select bno,title,name,regdate,readcount,re_lev from board order by re_ref desc,re_sequence asc";
//																//re_lev : 댓글 부분 띄워주기위해
//			pstmt =con.prepareStatement(sql);
//			rs=pstmt.executeQuery();
//			
//			while(rs.next()) {
//			boardDTO dto = new boardDTO();
//			dto.setBno(rs.getInt("bno"));
//			dto.setTitle(rs.getString("title"));
//			dto.setName(rs.getString("name"));
//			dto.setRegdate(rs.getDate("regdate"));
//			dto.setReadcount(rs.getInt("readcount"));
//			dto.setRe_lev(rs.getInt("re_lev"));
//			
//			list.add(dto);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//		return list;
//	}
	
	//페이지 나누기 개념 + searchList 개념
	public List<boardDTO> list(PageDTO pageDtO){
		List<boardDTO> list = new ArrayList<boardDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			StringBuilder bulider = new StringBuilder();
			//공통 부분
			bulider.append("select bno,title,name,regdate,readcount,re_lev ");
			bulider.append("from (select rownum rnum,A.* ");
			bulider.append("from ");
			bulider.append("(select bno,title,name,regdate,readcount,re_lev from board ");
			bulider.append("where bno>0 ");
			
			int start = pageDtO.getPage()*pageDtO.getAmount();
			int end = (pageDtO.getPage()-1)*pageDtO.getAmount();
			
			if(!pageDtO.getSearchDto().getCriteria().isEmpty()) {
				bulider.append("and "+pageDtO.getSearchDto().getCriteria()+" like ? ");
				bulider.append("order by re_ref desc, re_sequence asc) A ");
				bulider.append("where rownum <= ?) ");
				bulider.append("where rnum > ?");
				
				pstmt =con.prepareStatement(bulider.toString());
				pstmt.setString(1, "%"+pageDtO.getSearchDto().getKeyword()+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}else {
				bulider.append("order by re_ref desc, re_sequence asc) A ");
				bulider.append("where rownum <= ?) ");
				bulider.append("where rnum > ?");
				
				pstmt =con.prepareStatement(bulider.toString());
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
			}
			
		
			//댓글과 게시글 위치 변경
		    //re_lev : 댓글 부분 띄워주기위해
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			boardDTO dto = new boardDTO();
			dto.setBno(rs.getInt("bno"));
			dto.setTitle(rs.getString("title"));
			dto.setName(rs.getString("name"));
			dto.setRegdate(rs.getDate("regdate"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setRe_lev(rs.getInt("re_lev"));
			
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
	
	//전체 게시물 수
	public int totalRows(SearchDTO searchDto) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int total = 0;
		try {
			String sql = "";
			
			if(!searchDto.getCriteria().isEmpty()) {
				sql = "select count(*) from board where "+searchDto.getCriteria()+" like ?";
				pstmt= con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchDto.getKeyword()+"%");
			}else {
				 sql = "select count(*) from board ";
				 pstmt= con.prepareStatement(sql);
				
				
			}
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return total;//게시물개수가담김
	}
	public boardDTO read(int bno) {
		boardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select bno,name,title,content,attach,re_ref,re_sequence,re_lev from board where bno = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new boardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
				
				//댓글 작업 때문에 추가
				dto.setRe_ref(rs.getInt("re_ref"));
				dto.setRe_seq(rs.getInt("re_sequence"));
				dto.setRe_lev(rs.getInt("re_lev"));
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
	//비밀번호 맞으면 게시물 삭제
	//delete from board where bno=? and password=?
	// drop 
	
	public boolean delete(int bno,String password) {
		boolean deleteFlag = false;
		PreparedStatement pstmt = null;
		String sql = "delete from board where bno=? and password=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, password);
			
			int result = pstmt.executeUpdate();
			if(result>0) deleteFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return deleteFlag;
	}
	//update board set title=?, content=? ,attach=? where bno =? and password?
	public boolean getUpdate(boardDTO dto) {
		boolean updateFlag1 = false;
		PreparedStatement pstmt = null;
		String sql = "";
		try {
			if(dto.getAttach()!=null) {
			sql = "update board set title=?, content=? ,attach=? where bno =? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getAttach());
			pstmt.setInt(4, dto.getBno());
			pstmt.setString(5, dto.getPassword());
			}else {
				sql = "update board set title=?, content=? where bno =? and password=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getContent());
				pstmt.setInt(3, dto.getBno());
				pstmt.setString(4, dto.getPassword());
			}
			int result= pstmt.executeUpdate();
			if(result>0) updateFlag1=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateFlag1;
	}
	//댓글 삽입 전 이전 댓글에 대한 정보 업데이트
	public boolean replyUpdate(boardDTO dto) {
		boolean replyFlag = false;
		PreparedStatement pstmt = null;
		try {
			//원본글에 대한 정보 가져오기
			int re_ref = dto.getRe_ref();
			int re_seq = dto.getRe_seq();
			
			//원본글에 달려있는 기존 댓글의 re_sequence값을 수정하는 것(댓글을 최신순으로 정렬하기 위함)
			String sql = "update board set re_sequence = re_sequence+1 where re_ref=? and re_sequence>?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int result = pstmt.executeUpdate();
			
			if(result>0) replyFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return replyFlag;
	}
	
	//댓글 삽입
	public boolean replyInsert(boardDTO dto) {
		boolean insertFlag = false;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into board (bno,title,content,password,attach,name,re_ref,re_sequence,re_lev)values(board_seq.nextval,?,?,?,null,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getName());
			pstmt.setInt(5, dto.getRe_ref());
			pstmt.setInt(6, dto.getRe_seq()+1); //db에서 1넣었던것 *
			pstmt.setInt(7, dto.getRe_lev()+1); //db에서 1넣었던것 *
			
			int result = pstmt.executeUpdate();
			if(result>0) insertFlag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertFlag;
		
	}
	public List<boardDTO> searchList(SearchDTO searchDTO){
		List<boardDTO> list = new ArrayList<boardDTO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select bno,title,name,regdate,readcount,re_lev from board where "+searchDTO.getCriteria()+" like ? order by re_ref desc,re_sequence asc";
//		             "select bno,title,name,regdate,readcount,re_lev from board order by re_ref desc,re_sequence asc";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+searchDTO.getKeyword()+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				boardDTO dto = new boardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRe_lev(rs.getInt("re_lev"));
				
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
	
}
