package com.email.util;

import java.io.IOException;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/emailTest.do")
public class EmailTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EmailTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("cleangun8274@gmail.com", "famkutifvsvszkfx");
			}
		});
		String receiver = String.valueOf(request.getParameter("email"));	
		String title = "테스트 메일입니다.";
		String content = "<h2 style='color:blue'>안녕하세요</h2>";
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("cleangun8274@gmail.com", "관리자", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
