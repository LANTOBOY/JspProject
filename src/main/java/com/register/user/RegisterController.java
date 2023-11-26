package com.register.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.beans.UserDAO;
import com.user.beans.UserDTO;


@WebServlet("/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter script = response.getWriter();
		
	    Timestamp timestamp =new Timestamp(System.currentTimeMillis());
	    SimpleDateFormat sdf = new SimpleDateFormat( "yy-MM-dd" , Locale.KOREA );
	    String str = sdf.format( new Date( timestamp.getTime() ) );
		String i=request.getParameter("user_id");
		String p=request.getParameter("user_password");
		String nick=request.getParameter("user_nickname");
		String n=request.getParameter("user_name");
		String em=request.getParameter("user_email");
		String iu=request.getParameter("user_introduce");
		String ti=(str);
		UserDTO	rt=new UserDTO();
		rt.setUser_id(i);
		rt.setUser_password(p);
		rt.setUser_nickname(nick);
		rt.setUser_name(n);
		rt.setUser_email(em);
		rt.setUser_introduce(iu);
		rt.setJoinday(ti);
		UserDAO rd = new UserDAO();
		try {
			rd.insertMember(rt);
			response.sendRedirect("jsp/Sucess.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			script.println("<script  charset='UTF-8'>");
    		script.println("alert('회원가입을 다시 작성 하시오.');");
    		script.println("history.back();"); 
    		script.println("</script>");
    		script.close();
		}
	}

}
