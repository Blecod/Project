package lt.ktu.project.client;

import java.util.ArrayList;

public class FormSearch {
	
	String generateURL(String q, ArrayList<String> tags, String sort, int limit,
			int skip, String order, String author, Boolean allowAnon, Boolean finished){
		String URL = "?";
		//if()
		URL = "?author="+ author +"&q="+ q +"&sort="+ sort +"&order="+ order;
		
		if(limit != 0){
			URL += "&limit="+limit;
		} else {
			URL += "&limit=20";
		}
		
		URL += "&allowAnon=" + allowAnon + "&finished" + finished;
		
		if(skip != 0){
			URL += "&skip=" + skip;
		}
		
		if(order.length() != 0){
			URL += "&order=" + order;
		}
		
		return URL;
	}
}
