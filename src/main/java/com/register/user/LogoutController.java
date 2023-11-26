package com.register.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter script = response.getWriter();
		
		request.getSession().removeAttribute("success");
		request.getSession().removeAttribute("idkey");
		script.println("<script  charset='UTF-8'>");
		script.println("alert('로그아웃 되었습니다.');");
		script.println("location.href='jsp/index.jsp'"); 
		script.println("</script>");
		script.close();
	}

}
