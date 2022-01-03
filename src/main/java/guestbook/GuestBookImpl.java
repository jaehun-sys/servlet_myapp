package guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import emailList.DBConnectionMgr;


public class GuestBookImpl implements GuestBookDao{
	private DBConnectionMgr pool;

	public GuestBookImpl() {
		try{
			pool = DBConnectionMgr.getInstance();
	    }catch(Exception e){
	    	System.out.println("Error : 커넥션 연결 실패");      
	    }
	}

	@Override
	public ArrayList<GuestBookVo> select() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GuestBookVo> guestbookList = new ArrayList<>();
		
		try {
			con = pool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT	BOOKNO									, ");
			sql.append("		NAME									, ");
			sql.append("		PASSWORD								, ");
			sql.append("		TO_CHAR (REGDATE, 'YYYY-MM-DD') REGDATE	, ");
			sql.append("		CONTENT		 							  ");
			sql.append("FROM	GUESTBOOK ");

			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery(sql.toString());
			
			while (rs.next()) {
				GuestBookVo vo = new GuestBookVo();
				vo.setBookno(rs.getInt("bookno"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setContent(rs.getString("content"));
    		    guestbookList.add(vo);
    		 }
		}catch(Exception ex) {
			System.out.println("Exception" + ex);
		}finally{
			pool.freeConnection(con,pstmt,rs);
		}
		return guestbookList;
	}

	@Override
	public boolean insert(GuestBookVo vo) {
		boolean success = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = pool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO GUESTBOOK(BOOKNO, NAME, PASSWORD, CONTENT, REGDATE) ");
			sql.append("VALUES	(SEQ_GUESTBOOK_NO.NEXTVAL, ?, ?, ?, SYSDATE) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setString(index++, vo.getName());
			pstmt.setString(index++, vo.getPassword());
			pstmt.setString(index++, vo.getContent());
			
			System.out.println("-------------------------");
//			System.out.println(vo.getName());
//			System.out.println("패스워드 : " +vo.getPassword());
//			System.out.println(vo.getContent());
			
			//실행 결과 리턴. sql 문장 실행 후, 변경된 row 수 int 타입으로 리턴
			int r = pstmt.executeUpdate();
			//pstmt.executeQuery() : select
			//pstmt.executeUpdate() : insert, update, delete
			System.out.println(r + "건 입력 처리");
			
			success = true;
			
		}catch(Exception e){
			System.err.println("SQL 에러: " + e.getMessage());
		}finally{
			pool.freeConnection(conn, pstmt);
		}
		
		return success;
	}

	@Override
	public boolean update(GuestBookVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int num, String pwd) {
		boolean success = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = pool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE 	");
			sql.append("FROM 	GUESTBOOK ");
			sql.append("WHERE 	BOOKNO = ? ");
			sql.append("AND 	PASSWORD = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setInt(index++, num);
			pstmt.setString(index++, pwd);
			
			System.out.println("-------------------------");
//			System.out.println(vo.getName());
//			System.out.println("패스워드 : " +vo.getPassword());
//			System.out.println(vo.getContent());
			
			//실행 결과 리턴. sql 문장 실행 후, 변경된 row 수 int 타입으로 리턴
			int r = pstmt.executeUpdate();
			//pstmt.executeQuery() : select
			//pstmt.executeUpdate() : insert, update, delete
			System.out.println(r + "건 삭제 처리");
			
			success = true;
			
		}catch(Exception e){
			System.err.println("SQL 에러: " + e.getMessage());
		}finally{
			pool.freeConnection(conn, pstmt);
		}
		
		return success;
	}

}
