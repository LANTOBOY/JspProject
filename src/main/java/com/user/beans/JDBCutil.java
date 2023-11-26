package com.user.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCutil {
	
	final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final static String JDBC_URL= "jdbc:mysql://localhost:3306/moviegroup?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf-8";
	final static String JDBC_PASS = "root";
	final static String JDBC_USER = "root";
	
	
	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	
	
	
	// ResultSet , pstmt, conn close하는 오버로딩
	public static void close(PreparedStatement pstmt, Connection conn) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
