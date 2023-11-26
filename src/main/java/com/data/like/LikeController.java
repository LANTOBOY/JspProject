package com.data.like;

import com.data.like.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/likectl.do")
public class LikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LikeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		likeBtnClick(request,response);
	}
	
	public void likeBtnClick(HttpServletRequest req, HttpServletResponse res){
		try {
			

			String movieid = req.getParameter("movieId");
			String userid = req.getParameter("userId");
			HttpSession session = req.getSession();
			LikeDTO likeDto = new LikeDTO();
			LikeDAO likeDao = new LikeDAO();
			
			
			res.getWriter().append("/ movieid : "+movieid).append("/ userid : "+userid);
			
			likeDto = likeDao.selectLike(userid , movieid);
			session.setAttribute("islike", likeDto.getIsLike());
			if(likeDto.getMovieId() == null) {
				likeDao.insertLike(userid, movieid, 1);
			}
			// 좋아요 -> 싫어요
			else if(likeDto.getIsLike() == 1) {
				likeDao.updateLike(userid, movieid, 0);
			}
			// 싫어요 -> 좋아요
			else if(likeDto.getIsLike() != 1) {
				likeDao.updateLike(userid, movieid, 1);
			}
			PrintWriter script = res.getWriter();
			// 
			script.println("<script>");
    		script.println("history.go(-1);"); 
    		script.println("</script>");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
