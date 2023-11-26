package com.data.api;

import com.data.api.PathRefactor;
import com.data.api.ApiRequester;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class DataController
 */
@WebServlet("/datactl.do")
public class DataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DataController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		response.getWriter().append("datactl.do have arrived").append("page : " + request.getParameter("page"));
		
		String func = request.getParameter("func");
		if(func.equals("movielist")) {
			movieList(request, response);
		}
		else if(func.equals("movieinfo")) {
			movieInfo(request,response);
		}
		else {
			response.getWriter().append("No Parameter to 'func'");
		}
	
	}
	
	public void movieList(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException, ServletException{
		
        try {
        	ApiRequester doApi = new ApiRequester(); 
        	HttpSession session = req.getSession();
        	String pageNumber = req.getParameter("page");
        	String sortWay = req.getParameter("sort");
            session.setAttribute("pageNum", pageNumber);
            session.setAttribute("sortWay", sortWay);
            PrintWriter script = res.getWriter();
        	
    		JSONObject obj = doApi.discoverMovies(pageNumber,sortWay);
    		session.setAttribute("pageSize", obj);
	        if(obj != null) {
	        	JSONArray parse_listArr = (JSONArray)obj.get("results");
		        ArrayList<MovieDTO> movieList = new ArrayList<MovieDTO>();
		        for(int i=0; i < parse_listArr.size(); i++) {
		        	JSONObject movie = (JSONObject) parse_listArr.get(i);
		        	MovieDTO mvDTO = new MovieDTO();
		        	mvDTO.setMovie_id(String.valueOf(movie.get("id")));
		        	
		        	
	                mvDTO.setMovie_origin_title(String.valueOf(movie.get("original_title")));
	                mvDTO.setMovie_title(String.valueOf(movie.get("title")));
	                
	                // Genre ����
	                ArrayList<String> genreArray = new ArrayList<String>();
	                JSONArray genreList = (JSONArray)movie.get("genre_ids");
	                for(int j=0; j<genreList.size(); j++) {
	                	genreArray.add(String.valueOf(genreList.get(j)));
	                }
	                mvDTO.setGenre_ids(genreArray);
	                PathRefactor pr = new PathRefactor();
	                
	                // logoPath ����
	                JSONObject getLogoPath = doApi.detailMovieInfo( mvDTO.getMovie_id());
	                mvDTO.setLogo_path(pr.FindHomepage( mvDTO.getMovie_id(),getLogoPath));
	                
	                mvDTO.setMovie_posterPath(pr.ImagePath(String.valueOf(movie.get("poster_path"))));
	                mvDTO.setMovie_backdropPath(pr.ImagePath(String.valueOf(movie.get("backdrop_path"))));
	                mvDTO.setMove_release_date(String.valueOf(movie.get("release_date")));
	                mvDTO.setMovie_overview(String.valueOf(movie.get("overview")));
	                
	                movieList.add(mvDTO);
		        }
		        
		        
	            session.setAttribute("movielist", movieList);
	            req.getRequestDispatcher("jsp/movieTheater.jsp").forward(req, res);
	        	
	        }
	        else {
	        	script.println("<script>");
	        	script.println("alert('업데이트중입니다.');");
	        	script.println("history.back()");
	    		script.println("</script>");
	    		script.close();
	        }
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}
	
	public void movieInfo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String requested_id = req.getParameter("mvid");
		
		MovieDTO mvDTO = new MovieDTO();
		
		PathRefactor pr = new PathRefactor();
		ApiRequester ar = new ApiRequester();
		JSONObject foundMovieRoot = ar.detailMovieInfo(requested_id); 
		
		mvDTO.setMovie_title(String.valueOf(foundMovieRoot.get("title")));
		mvDTO.setTagline(String.valueOf(foundMovieRoot.get("tagline")));
		mvDTO.setMovie_posterPath(pr.ImagePath(String.valueOf(foundMovieRoot.get("poster_path"))));
		mvDTO.setMovie_backdropPath(pr.ImagePath(String.valueOf(foundMovieRoot.get("backdrop_path"))));
		mvDTO.setLogo_path(pr.FindHomepage( mvDTO.getMovie_id(),foundMovieRoot));
		mvDTO.setMovie_overview(String.valueOf(foundMovieRoot.get("overview")));
		mvDTO.setHomepage(String.valueOf(foundMovieRoot.get("homepage")));
		mvDTO.setMove_release_date(String.valueOf(foundMovieRoot.get("release_date")));
		mvDTO.setMovie_id(String.valueOf(foundMovieRoot.get("id")));
		
		ServletContext application = getServletContext();
		application.setAttribute("movieInfoInApplication", mvDTO);
		req.getRequestDispatcher("jsp/movieInfo.jsp").forward(req,res);
	}
}
