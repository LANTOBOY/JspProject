package com.data.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiRequester {
	
	public JSONObject discoverMovies(String pageNum, String orderby) {
		try {
			String serviceKey = "65829c74555ef199f3912160bbd86656";
			String language = "as-KR";
			String region = "KR";
			String sort = orderby;
			String page = pageNum;
			
		    String urlStr = "https://api.themoviedb.org/3/discover/movie";
			
			urlStr += "?"+ URLEncoder.encode("api_key","UTF-8") +"=" + serviceKey;
			urlStr += "&"+ URLEncoder.encode("language","UTF-8") + "="+ language;
		    urlStr += "&"+ URLEncoder.encode("region","UTF-8") +"="+ region;
		    urlStr += "&"+ URLEncoder.encode("sort_by","UTF-8") +"="+ sort;
		    urlStr += "&"+ URLEncoder.encode("page","UTF-8") +"="+ page;
		    
		    URL url = new URL(urlStr);
		    
		    String line = "";
		    String result = "";
		    
		    BufferedReader br;
		    br = new BufferedReader(new InputStreamReader(url.openStream()));
		    while ((line = br.readLine()) != null) {
		        result = result.concat(line);
		        //System.out.println(line);                
		    }            
		    
		    JSONParser parser = new JSONParser();
		    JSONObject obj = (JSONObject)parser.parse(result);
		    
		    br.close();
		    return obj;
        }catch(Exception e) {
        	e.printStackTrace();
        }
		return null;
	}
	
	public JSONObject detailMovieInfo(String movieid) {
		// 영화상세정보 api 요청
		try {
			String serviceKey = "65829c74555ef199f3912160bbd86656";
			String urlStr = "https://api.themoviedb.org/3/movie/";
			urlStr += movieid;
			urlStr += "?" + URLEncoder.encode("api_key","UTF-8") +"="+ serviceKey;
			
			URL url = new URL(urlStr);
			String line = "";
		    String result = "";
			
			BufferedReader br;
		    br = new BufferedReader(new InputStreamReader(url.openStream()));
		    while ((line = br.readLine()) != null) {
		        result = result.concat(line);
		        //System.out.println(line);                
		    }            
		    
		    JSONParser parser = new JSONParser();
		    JSONObject obj = (JSONObject)parser.parse(result);
		    
		    br.close();
		    
		    return obj;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
