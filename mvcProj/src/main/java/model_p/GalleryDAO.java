package model_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GalleryDAO {
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public GalleryDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mvc322");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	// 갤러리 출력
	public List<GalleryDTO> list() {
		sql = "select * from gallery order by gid desc";
	    List<GalleryDTO> galleryList = new ArrayList<>(); // 리스트 생성
	    
	    
		try {
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				GalleryDTO gto = new GalleryDTO();
				gto.setId(rs.getInt("id"));
	            gto.setGid(rs.getInt("gid"));
	            gto.setCnt(rs.getInt("cnt"));
	            gto.setTitle(rs.getString("title"));
	            gto.setPname(rs.getString("pname"));
	            gto.setPw(rs.getString("pw"));
	            gto.setUpfile(rs.getString("upfile"));
	            gto.setContent(rs.getString("content"));
	            gto.setReg_date(rs.getTimestamp("reg_date"));
	            
	            
	            galleryList.add(gto);
				}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}
		return galleryList;
	}
	
	// 글작성
		public void write(BoardDTO dto){
			
			// cnt = -1 ==> 작성하자마자 상세보기로 넘어가면 조회수 1증가하기 때문에 -1로 설정
			
			
			try {
				// 글 작성 후 작성한 글 보기 (최신 글 찾기) - id의 최댓값
				sql = "select max(id)+1 from board";
				ptmt = con.prepareStatement(sql);
				rs = ptmt.executeQuery();
				rs.next();
				dto.setId(rs.getInt(1));
				
				ptmt.close();
				
				sql = "insert into board "
						+ "(id, title, pname, pw, upfile, content, seq, lev, gid, cnt, reg_date)"
						+ "values (?, ?, ?, ?, ?, ?, 0, 0, ?, -1, sysdate() )";
				
				ptmt = con.prepareStatement(sql);
				ptmt.setInt(1, dto.getId());
				ptmt.setString(2, dto.getTitle());
				ptmt.setString(3, dto.getPname());
				ptmt.setString(4, dto.getPw());
				ptmt.setString(5, dto.getUpfile());
				ptmt.setString(6, dto.getContent());
				ptmt.setInt(7, dto.getId());
				ptmt.executeUpdate();
				
				
				

				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close();
			}
			
		}
	private void close() {
		if(rs!=null) try { rs.close();} catch (Exception e) {}
		if(ptmt!=null) try { ptmt.close();} catch (Exception e) {}
		if(con!=null) try { con.close();} catch (Exception e) {}
	}
}
