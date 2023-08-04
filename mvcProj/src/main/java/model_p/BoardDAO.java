package model_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	
	// 데이터베이스에 접속
	Connection con;
	
	// 매개변수화된 SQL 쿼리 준비
	PreparedStatement ptmt;
	
	// 데이터베이스 쿼리의 결과를 저장
	ResultSet rs;
	String sql;
	
	public BoardDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mvc322");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDTO> list(){
		
		sql = "select * from board order by id desc";
		ArrayList<BoardDTO> res = new ArrayList<>();
		
		try {
			ptmt = con.prepareStatement(sql);
			// 결과 반환
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setId(rs.getInt("id"));
				dto.setGid(rs.getInt("gid"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setSeq(rs.getInt("seq"));
				dto.setLev(rs.getInt("lev"));
				dto.setTitle(rs.getString("title"));
				dto.setPname(rs.getString("pname"));
				dto.setPw(rs.getString("pw"));
				dto.setUpfile(rs.getString("upfile"));
				dto.setContent(rs.getString("content"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				
				res.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	// 글 상세보기
	public BoardDTO detail(int id){
		
		sql = "select * from board where id = ?";
		BoardDTO dto = null;
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setId(rs.getInt("id"));
				dto.setGid(rs.getInt("gid"));
				dto.setCnt(rs.getInt("cnt"));
				dto.setSeq(rs.getInt("seq"));
				dto.setLev(rs.getInt("lev"));
				dto.setTitle(rs.getString("title"));
				dto.setPname(rs.getString("pname"));
				dto.setPw(rs.getString("pw"));
				dto.setUpfile(rs.getString("upfile"));
				dto.setContent(rs.getString("content"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	// 조회수
	public void addCount(int id){
		
		sql = "update board set cnt = cnt + 1 where id =?";
				
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, id);
			ptmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

	}
	
	// 글작성
	public void write(BoardDTO dto){
		
		// cnt = -1 ==> 작성하자마자 상세보기로 넘어가면 조회수 1증가하기 때문에 -1로 설정
		sql = "insert into board (title, pname, pw, upfile, content, seq, lev, gid, cnt, reg_date)"
				+ "values (?, ?, ?, ?, ?, 0, 0, 0, -1, sysdate() )";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getTitle());
			ptmt.setString(2, dto.getPname());
			ptmt.setString(3, dto.getPw());
			ptmt.setString(4, dto.getUpfile());
			ptmt.setString(5, dto.getContent());
			ptmt.executeUpdate();
			
			ptmt.close();
			
			// 글 작성 후 작성한 글 보기 (최신 글 찾기) - id의 최댓값
			sql = "select max(id) from board";
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			rs.next();
			dto.setId(rs.getInt(1));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	// 글삭제
	public int delete(BoardDTO dto){
		
		sql = "delete from board where id = ? and pw = ?";
		int res = 0;
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getPw());
			
			res = ptmt.executeUpdate();
			// 결과값이 0일 경우 id != pw ==> 삭제 실패
			// 결과값이 1일 경우 id = pw  ==> 삭제
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	// 
	public BoardDTO idPwChk (BoardDTO dto){
		
		sql = "select * from board where id = ? and pw = ?";
		// 
		BoardDTO res = null;
		try {
			ptmt = con.prepareStatement(sql);
			
			ptmt.setInt(1, dto.getId());
			ptmt.setString(2, dto.getPw());
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				res = new BoardDTO();
				res.setId(rs.getInt("id"));
				// 내용이 있으면 삭제, ""이라면 유지
				res.setUpfile(rs.getString("upfile"));				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	// 수정
	public int modify(BoardDTO dto){
		
		int res = 0; 
		
		// cnt = -1 ==> 작성하자마자 상세보기로 넘어가면 조회수 1증가하기 때문에 -1로 설정
		sql = "update board set title = ?, pname=?, upfile=?, content=?  "
				+ "where id = ? and pw = ?";
		
		try {
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, dto.getTitle());
			ptmt.setString(2, dto.getPname());
			ptmt.setString(3, dto.getUpfile());
			ptmt.setString(4, dto.getContent());
			ptmt.setInt(5, dto.getId());			
			ptmt.setString(6, dto.getPw());
			
			res = ptmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	public void close() {
		if(rs!=null) try { rs.close();	} catch (Exception e) {}
		if(ptmt!=null) try { ptmt.close();	} catch (Exception e) {}
		if(con!=null) try { con.close();	} catch (Exception e) {}
	}
}