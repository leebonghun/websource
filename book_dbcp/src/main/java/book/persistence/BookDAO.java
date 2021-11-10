package book.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

import static book.persistence.jdbcUtil.*;


import book.domain.BookDTO;

public class BookDAO {
	private Connection con;
	
	public BookDAO(Connection con) {
		
		this.con = con;
	}
	
	//insert
	public boolean insert(BookDTO insertDto) {
		String sql = "insert into bookTBL values(?,?,?,?)";
		PreparedStatement pstmt =null;
		boolean insertFlag = false;
		
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, insertDto.getCode());
			pstmt.setString(2, insertDto.getTitle());
			pstmt.setString(3, insertDto.getWriter());
			pstmt.setInt(4, insertDto.getPrice());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				insertFlag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return insertFlag;
		
		
	}
	
	//delete
	public boolean delete(String code) {
		String sql = "delete from bookTBL where code =?";
		PreparedStatement pstmt = null;
		boolean deleteFlag = false;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, code);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) deleteFlag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return deleteFlag;
		
	}
	public boolean update(String code,int price) {
		String sql = "update bookTBL set price = ? where code =? ";
		PreparedStatement pstmt = null;
		boolean updateFlag=false;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setString(2, code);
			int result = pstmt.executeUpdate();
			
			if(result>0) updateFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateFlag;
	}
	//update
	
	public List<BookDTO> select(){
		List<BookDTO> bookList = new ArrayList<BookDTO>(); 
		String sql = "select* from bookTBL";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
			BookDTO dto = new BookDTO();
			dto.setCode(rs.getString("code"));
			dto.setTitle(rs.getString("title"));
			dto.setWriter(rs.getString("writer"));
			dto.setPrice(rs.getInt("price"));
			
			bookList.add(dto);
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(rs);
			close(pstmt);
		}
		return bookList;
	}
	public List<BookDTO> search(String criteria,String keyword) {
		List<BookDTO> list = new ArrayList<BookDTO>();
		String sql = "select * from bookTBL where "+criteria+"=?";	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getString("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				
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
