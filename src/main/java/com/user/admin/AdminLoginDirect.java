package com.user.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginDirect
 */
@WebServlet("/jsp/logintoadmin")
public class AdminLoginDirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
    public AdminLoginDirect() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		doPost(request, response);
		response.getWriter().append("This is admin Login Direct java");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("This is admin Login Direct java");
		request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
	}

}
