package com.email.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailSendAction
 */
@WebServlet("/sendEmail.do")
public class EmailSendAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HttpServletRequest Rs;
	private static HttpServletResponse Rp;
	
	int random = 0;
	static String verifyCode;
	static String host;
	static String from;
	static String to;
	static String subject;
	static String content;
	
	
       
    public EmailSendAction() {
        super();
    }
   
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
	      response.setCharacterEncoding("utf-8");
	      request.setCharacterEncoding("utf-8");
		random = new Random().nextInt(10000) + 1000;
    	verifyCode = String.valueOf(random);
    	host = "http://localhost:8080/GUN/";
    	from = "khs6410108274@naver.com";
    	to = request.getParameter("email");
    	subject = "MovieGroup 이메일 인증코드";
    	content = "MOVIE GROUP <br> 인증코드 : " + verifyCode;
    	EmailSendStart(request, response);
    	request.getSession().setAttribute("requestedEmail", to);
	}
	
	// 이메일 인증코드 전송 
	 public void EmailSendStart(HttpServletRequest request, HttpServletResponse response ) throws IOException {
		 	PrintWriter script = response.getWriter();
		 	Properties p = new Properties();
	    	p.put("mail.smtp.user", from);
	    	p.put("mail.smtp.host", "smtp.gmail.com"); // google SMTP 주소
	    	p.put("mail.smtp.port", "587");
	    	p.put("mail.smtp.starttls.enable", "true");
	    	p.put("mail.smtp.auth", "true");
	    	p.put("mail.smtp.ssl.trust",true);
	    	
	    	
	    	try {

	        	request.getSession().setAttribute("verifycode", verifyCode);
	    		Authenticator auth = new Gmail();
	    		Session ses = Session.getInstance(p, auth);
	    		ses.setDebug(true);
	    		
	    		Address fromAddr = new InternetAddress(from , "MovieGroup EmailSender", "utf-8");
	    		Address toAddr = new InternetAddress(to);
	    		MimeMessage msg = new MimeMessage(ses);
	    		msg.setSubject(subject);
	    		msg.setFrom(fromAddr);
	    		msg.addRecipient(Message.RecipientType.TO, toAddr);
	    		msg.setContent(content,"text/html; charset=UTF-8");
	    		Transport.send(msg);
	    		
	    		script.println("<script>");
	    		script.println("history.back();"); 
	    		script.println("</script>");
	    		
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		script.println("<script>");
	    		script.println("alert('please put email in box');");
	    		script.println("history.back();"); 
	    		script.println("</script>");
	    		script.close();
	    	}
	
	 }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
	

}
