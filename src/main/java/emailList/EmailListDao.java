package emailList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class EmailListDao {

	private DBConnectionMgr pool;
	
	public EmailListDao() {
		try{
			pool = DBConnectionMgr.getInstance();
	    }catch(Exception e){
	    	System.out.println("Error : 커넥션 연결 실패");      
	    }
	}
	
	public ArrayList<EmailListVo> viewEmailList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmailListVo> emaillist = new ArrayList<>();
		
		try {
			con = pool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT	LAST_NAME	, ");
			sql.append("		FIRST_NAME	, ");
			sql.append("		EMAIL ");
			sql.append("FROM	EMAILLIST ");

			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery(sql.toString());
			
			while (rs.next()) {
    		    EmailListVo vo = new EmailListVo();
    		    vo.setLast_name(rs.getString("last_name"));
    		    vo.setFirst_name(rs.getString("first_name"));
    		    vo.setEmail(rs.getString("email"));
    		    emaillist.add(vo);
    		 }
		}catch(Exception ex) {
			System.out.println("Exception" + ex);
		}finally{
			pool.freeConnection(con,pstmt,rs);
		}
		return emaillist;
	}
	
	public boolean insert(EmailListVo vo) {
		// TODO Auto-generated method stub
		boolean success = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = pool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO EMAILLIST(EMAILNO, LAST_NAME, FIRST_NAME, EMAIL) ");
			sql.append("VALUES (SEQUENCE_EMAILLIST_NO.NEXTVAL, ?, ?, ?) ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setString(index++, vo.getLast_name());
			pstmt.setString(index++, vo.getFirst_name());
			pstmt.setString(index++, vo.getEmail());
			
			//실행 결과 리턴. sql 문장 실행 후, 변경된 row 수 int 타입으로 리턴
			int r = pstmt.executeUpdate();
			//pstmt.executeQuery() : select
			//pstmt.executeUpdate() : insert, update, delete
			System.out.println(r + "건 처리");
			
			success = true;
			
		}catch(Exception e){
			System.err.println("SQL 에러: " + e.getMessage());
		}finally{
			pool.freeConnection(conn, pstmt);
		}
		
		return success;
	}
	
}
