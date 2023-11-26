package com.user.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	final String USER_INSERT = "insert into users(user_id, user_password, user_nickname, user_name, user_email, user_introduce, joinday)" + "values(?, ?, ?, ?, ?, ?, ?)";
	final String USER_LIST = "select * from users;";
	final String USER_DELETE = "delete from users where user_id=?";
	final String ADMIN_ACT = "select * from users where user_id=?;";
	final static String CHCEK_ID = "select user_id from users where user_id = ?";
	final String LOGIN_CHECK = "select user_id, user_password from users where user_id = ? and user_password = ?";
	
	public void insertMember(UserDTO mem) throws SQLException {
		conn = JDBCutil.getConnection();
		pstmt = conn.prepareStatement(USER_INSERT);
		pstmt.setString(1, mem.getUser_id());
		pstmt.setString(2, mem.getUser_password());
		pstmt.setString(3, mem.getUser_nickname());
		pstmt.setString(4, mem.getUser_name());
		pstmt.setString(5, mem.getUser_email());
		pstmt.setString(6, mem.getUser_introduce());
		pstmt.setString(7, mem.getJoinday());
		pstmt.executeUpdate();
		JDBCutil.close(pstmt, conn);
}
	
	public static boolean checkId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        boolean checkCon = false;
        try {
            conn = JDBCutil.getConnection();
            pstmt = conn.prepareStatement(CHCEK_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            checkCon = rs.next();

        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        } finally {
        	JDBCutil.close(pstmt, conn);
        }
        return checkCon;
    }
	
	public ArrayList<UserDTO> selectMemberList() throws SQLException{
		conn = JDBCutil.getConnection();
		pstmt = conn.prepareStatement(USER_LIST);
		rs = pstmt.executeQuery();
		
		ArrayList<UserDTO> aList = new ArrayList<UserDTO>();
		while(rs.next()) {
			UserDTO rd = new UserDTO();
			rd.setUser_id(rs.getString("user_id"));
			rd.setUser_password(rs.getString("user_password"));
			rd.setUser_nickname(rs.getString("user_nickname"));
			rd.setUser_email(rs.getString("user_email"));
			rd.setUser_name(rs.getString("user_name"));
			rd.setUser_introduce(rs.getString("user_introduce"));
			rd.setJoinday(rs.getString("joinday"));
			aList.add(rd);
		}
		JDBCutil.close(pstmt, conn);
		return aList;
	}
	
	public String deleteMember(String member_id) throws SQLException {
		conn = JDBCutil.getConnection();
		pstmt = conn.prepareStatement(USER_DELETE);
		pstmt.setString(1, member_id);
		pstmt.executeUpdate();
		JDBCutil.close(pstmt, conn);
		return "User Delete Success";
	}
	
	
	
	public int adminLoginChk(String admin_id, String admin_pw) throws SQLException{
		conn = JDBCutil.getConnection();
		pstmt = conn.prepareStatement(ADMIN_ACT);
		pstmt.setString(1, "admin");
		rs = pstmt.executeQuery();
		
		String adid = null;
		String adpw = null;
		
		while(rs.next()) {
			adid = rs.getString("user_id");
			adpw = rs.getString("user_password");
		}
		
		if(admin_id.equals(adid) && 
				admin_pw.equals(adpw)) {
			JDBCutil.close(pstmt, conn);
			return 1;
		}
		else{
			JDBCutil.close(pstmt, conn);
			return 0;
		}
	}
	
	public boolean loginCheck(String user_id, String user_password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean loginCon = false;
        try {
            conn = JDBCutil.getConnection();
            pstmt = conn.prepareStatement(LOGIN_CHECK);
            pstmt.setString(1, user_id);
            pstmt.setString(2, user_password);
            rs = pstmt.executeQuery();
            loginCon = rs.next();
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        } finally {
        	JDBCutil.close(pstmt, conn);
        }
        return loginCon;
    }
	
}
