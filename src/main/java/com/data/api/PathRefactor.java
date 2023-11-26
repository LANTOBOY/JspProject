package com.data.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PathRefactor {
	public String ImagePath(String requestString) {
		return "https://image.tmdb.org/t/p/original" + requestString;
	}
	
	public String FindHomepage(String movieid, JSONObject detailMovie) {
		StreamingLogoPath logopath = new StreamingLogoPath();
		String homepageStr = String.valueOf(detailMovie.get("homepage"));
		if(homepageStr.contains("netflix")) {
			return logopath.getNetflixPath();
		}
		else if(homepageStr.contains("wavve")) {
			return logopath.getWavvePath();
		}
		else if(homepageStr.contains("disneyplus")) {
			return logopath.getDisneyPath();
		}
		else if(homepageStr.contains("watcha")) {
			return logopath.getWatchaPath();
		}
		else {
			return "";
		}
	}
	
}
