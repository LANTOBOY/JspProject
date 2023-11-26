package com.data.like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.user.beans.JDBCutil;

public class LikeDAO {
	Connection conn;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	final String LIKE_INSERT = "insert into likes(userid, movieid, islike)" + "values(?, ?, ?);";
	final String LIKE_SELECT_USERID = "SELECT * FROM likes WHERE userid = ? and movieid = ?;";
	final String LIKE_UPDATE = "update likes set userid = ? , movieid = ? , islike = ? ;";
	
	public void insertLike(String userid, String movieid, int islike) {
		try {
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(LIKE_INSERT);
			pstmt.setString(1, userid);
			pstmt.setString(2, movieid);
			pstmt.setInt(3, islike);
			pstmt.executeUpdate();
			
			JDBCutil.close(pstmt, conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateLike(String userid, String movieid, int islike) {
		try {
			
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(LIKE_UPDATE);
			pstmt.setString(1, userid);
			pstmt.setString(2, movieid);
			pstmt.setInt(3, islike);
			pstmt.executeUpdate();
			JDBCutil.close(pstmt, conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public LikeDTO selectLike(String userid, String movieid) throws SQLException {
		conn = JDBCutil.getConnection();
		pstmt = conn.prepareStatement(LIKE_SELECT_USERID);
		pstmt.setString(1, userid);
		pstmt.setString(2, movieid);
		rs = pstmt.executeQuery();
		
		LikeDTO likeDto = new LikeDTO();
		while(rs.next()) {
			likeDto.setIsLike(rs.getInt("islike"));
			likeDto.setMovieId(rs.getString("movieid"));
			likeDto.setUserId(rs.getString("userid"));
		}
		
		JDBCutil.close(rs, pstmt, conn);
		return likeDto;
		
		
	}
	
	
}
