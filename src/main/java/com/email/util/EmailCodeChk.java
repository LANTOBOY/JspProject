package com.email.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmailCodeChk
 */
@WebServlet("/codechk.do")
public class EmailCodeChk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmailCodeChk() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession ClientSession = request.getSession();
		int inputCode = Integer.parseInt(request.getParameter("code")); 
		int verifyCode = Integer.parseInt(String.valueOf( ClientSession.getAttribute("verifycode")));
		PrintWriter script = response.getWriter();
		
		if(inputCode == verifyCode) {
			
//			
    		script.println("<script>");
    		script.println("alert('Confirmed');");
    		script.println("location.href='jsp/registerIntegrate.jsp';"); 
    		script.println("</script>");
    		script.close();
		}
		else {
    		script.println("<script  charset='UTF-8'>");
    		script.println("alert('Code is Wrong');");
    		//script.println("alert('input code : "+inputCode+", verifyCode : "+verifyCode+".');");  // 입력코드와 발급코드 확인
    		script.println("history.back();"); 
    		script.println("</script>");
    		script.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
