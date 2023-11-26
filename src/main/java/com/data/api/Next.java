package com.data.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class FilterMovie
 */
@WebServlet("/Next.do")
public class Next extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 try {
	        	
	        	int a = 1;
	        	
	        	a=a+1;
	        	
		        HttpSession session = req.getSession();
		        session.setAttribute("next", a);
		        session.removeAttribute("prev");
	            req.getRequestDispatcher("/datactl.do?func=movielist&page="+ a +"&sort=popularity.desc").forward(req, res);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}