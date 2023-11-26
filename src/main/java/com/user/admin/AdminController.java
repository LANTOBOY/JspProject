package com.user.admin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.beans.UserDAO;
import com.user.beans.UserDTO;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		response.getWriter().append("This is admin.do");
		String Todo = request.getParameter("todo");

		response.getWriter().append("Todo is ").append(Todo);
		if(Todo.equals("show")) {
			showUsers(request,response);
		}
		if(Todo.equals("drop")) {
			String drop_id = request.getParameter("drop_user");
			try {
				dropUsers(request,response, drop_id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(Todo.equals("adlogin")) {
			try {
				adminLogin(request,response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void showUsers(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		res.getWriter().append("Served at: ").append(req.getContextPath());
		res.setContentType("text/html; charset=UTF-8");
		UserDAO userdao = new UserDAO();
		ArrayList<UserDTO> userlist = new ArrayList<UserDTO>();
		
		
		
		try {
			userlist = userdao.selectMemberList();
			HttpSession session = req.getSession();
			session.setAttribute("ulist",userlist);
			req.getRequestDispatcher("jsp/adminMainPage.jsp").forward(req, res);
//			response.sendRedirect("jsp/adminManageUsers.jsp");
//			userlist = (ArrayList<UserDTO>) session.getAttribute("ulist");
//			String id = userlist.get(0).getUser_id();
//			res.getWriter().append("id : ").append(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void dropUsers(HttpServletRequest req, HttpServletResponse res , String drop_id) throws SQLException, ServletException, IOException{
		UserDAO userdao = new UserDAO();
		String success = userdao.deleteMember(drop_id);
		res.getWriter().append(success);
		showUsers(req,res);
	}
	
	public void adminLogin(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
		UserDAO userdao = new UserDAO();
		String admin_id = req.getParameter("admin_id");
		String admin_pw = req.getParameter("admin_pw");
		int Success = userdao.adminLoginChk(admin_id,admin_pw);
		
		if(Success == 1) {
			req.getRequestDispatcher("jsp/adminMainPage.jsp").forward(req, res);
		}
		else {
			req.getRequestDispatcher("jsp/logintoadmin").forward(req, res);
		}
	}

}
