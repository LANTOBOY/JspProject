package com.register.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.beans.UserDAO;

/**
 * Servlet implementation class loginCheckcontroller
 */
@WebServlet("/loginCheck.do")
public class LogincheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter script = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_password = request.getParameter("user_password");
		
		UserDAO rd = new UserDAO();
		boolean loginCheck = rd.loginCheck(user_id, user_password);
		
		if(loginCheck){
			    request.getSession().setAttribute("idKey",user_id);
			    request.getSession().setAttribute("success","success");
			    script.println("<script  charset='UTF-8'>");
	    		script.println("alert('로그인을 성공하셨습니다..');");
	    		script.println("location.href='jsp/index.jsp'"); 
	    		script.println("</script>");
	    		script.close();
		   }else{
		        script.println("<script  charset='UTF-8'>");
	    		script.println("alert('아이디 혹은 비밀번호가 틀렸습니다.');");
	    		script.println("history.back();"); 
	    		script.println("</script>");
	    		script.close();
		   }
	}

}
