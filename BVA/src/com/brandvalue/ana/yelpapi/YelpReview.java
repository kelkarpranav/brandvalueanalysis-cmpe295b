package com.brandvalue.ana.yelpapi;
import yelp.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.omg.CORBA.Request;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import yelp.Yelp;
import yelp.YelpApi2;
import yelp.YelpBusinesss;
import yelp.YelpData;
import yelp.YelpPython;

import com.alchemyapi.api.AlchemyAPI;
import com.google.gson.Gson;

public class YelpReview {
	  OAuthService service;
	  Token accessToken;
	
	//@SuppressWarnings("static-access")
	public static String getYelpSentiment (String s) throws IOException, InterruptedException, XPathExpressionException, SAXException, ParserConfigurationException {

		
		String consumerKey = "";
		String consumerSecret = "";
		String token = "";
		String tokenSecret = "";
		Yelp yelp = new Yelp(consumerKey, consumerSecret, token, tokenSecret);
		String response = yelp.search(s, "San Jose");
		System.out.println(response);

		Gson gson = new Gson();
		// System.out.println("reading JSON..");
		YelpData yelpdata = gson.fromJson(response, YelpData.class);
		System.out.println("Getting Total:" + yelpdata.getTotal());

		YelpBusinesss[] business2 = yelpdata.getBusiness();
		System.out.println("Length of business2 Object >>  "
				+ yelpdata.getBusiness());

		ArrayList<String> test = new ArrayList<String>();
		for (YelpBusinesss business : business2) {
			//System.out.println(business.getId());
			test.add(business.getId());
		}
		YelpPython obj = new YelpPython();
		//System.out.println(obj.pythonrun(test.get(0)));
		//System.out.println(obj.pythonrun("tandoori-oven-san-jose-2"));

	    String[] reviewset0 = obj.pythonrun(test.get(0)).split("\n");
	    List<String> reviewlist0 = Arrays.asList(reviewset0);
for(String e: reviewlist0)
	    System.out.println(e);

	    String[] reviewset1 = obj.pythonrun(test.get(1)).split("\n");
	    List<String> reviewlist1 = Arrays.asList(reviewset1); 

	    String[] reviewset2 = obj.pythonrun(test.get(2)).split("\n");
	    List<String> reviewlist2 = Arrays.asList(reviewset2);
	    for(String e: reviewlist0)
		    System.out.println(e);
		    for(String e: reviewlist1)
			    System.out.println(e);
			    for(String e: reviewlist2)
				    System.out.println(e);

	    AlchemyAPI alchemyObj = AlchemyAPI.GetInstanceFromString("89935b37f460d48132793b1f4d07afa34939bd9c");
	    List<String> finalset = new ArrayList<String>();	
	    List  l1 = new LinkedList();
	    List  l2 = new LinkedList();
	    List  l3 = new LinkedList();

	 	Document doc;

	     for (String e : reviewlist0)  
	     {  
	     	Map map1 = new HashMap();
	     	doc = alchemyObj.TextGetTextSentiment(e);
	     	String sentiment = doc.getElementsByTagName("type").item(0).getTextContent();
	     	String score = "0.214";
	    	try{
	    		score = doc.getElementsByTagName("score").item(0).getTextContent();
	    	}
	    	catch (Exception f) {
	    		f.printStackTrace();
	    		 score = "0.214";
	    	}	  	    map1.put("review", e);
	  	    map1.put("sentiment", sentiment);
	  	    map1.put("score", score);
	  	    l1.add(map1);
	     }  
	 
	     for (String e : reviewlist1)  
	     {  
	     	Map map1 = new HashMap();

	     	doc = alchemyObj.TextGetTextSentiment(e);
	     	String sentiment = doc.getElementsByTagName("type").item(0).getTextContent();
	     	String score = "0.214";
	    	try{
	    		score = doc.getElementsByTagName("score").item(0).getTextContent();
	    	}
	    	catch (Exception g) {
	    		g.printStackTrace();
	    		 score = "0.414";
	    	}	  	    map1.put("review", e);
	  	    map1.put("sentiment", sentiment);
	  	    map1.put("score", score);
	  	    l2.add(map1);
	     }  
	     
	     for (String e : reviewlist2)  
	     {  
	     	Map map1 = new HashMap();

	     	doc = alchemyObj.TextGetTextSentiment(e);
	     	String sentiment = doc.getElementsByTagName("type").item(0).getTextContent();
	     	String score = "-0.714";
	    	try{
	    		score = doc.getElementsByTagName("score").item(0).getTextContent();
	    	}
	    	catch (Exception h) {
	    		h.printStackTrace();
	    		 score = "0.214";
	    	}	  	    map1.put("review", e);
	  	    map1.put("sentiment", sentiment);
	  	    map1.put("score", score);
	  	    l3.add(map1);
	     }  
	    
	     
	     String s1 = l1.toString();
	     Pattern p1 = Pattern.compile("=positive");
	     Matcher m1 = p1.matcher(s1);
	     Integer count11 = 0;
	     while (m1.find()){
	     	count11 +=1;
	     }
	   // System.out.println(count11);
	     p1 = Pattern.compile("=negative");
	      m1 = p1.matcher(s1);
	     Integer count12 = 0;
	     while (m1.find()){
	     	count12 +=1;
	     }
	   //  System.out.println(count12);

	     p1 = Pattern.compile("=neutral");
	     m1 = p1.matcher(s1);
	     Integer count13 = 0;
	     while (m1.find()){
	     	count13 +=1;
	     }
	   //  System.out.println(count13);

	     
	     
	     Map map11 = new HashMap();
	 	map11.put("positive", count11.toString());
	 	map11.put("negative", count12.toString());
	 	map11.put("neutral", count13.toString());
	  //   System.out.println(map11.toString());

	 	List  l4 = new LinkedList();
		l4.add(map11);
	  //   System.out.println(l1.toString());

	 	
	 	 String s2 = l2.toString();
	 	 
	 	 Pattern p2 = Pattern.compile("=positive");
	 	    Matcher m2 = p2.matcher(s2);
	 	    Integer count21 = 0;
	 	    while (m2.find()){
	 	    	count21 +=1;
	 	    }
	 	 
	 	 p2 = Pattern.compile("=negative");
	 	    m2 = p2.matcher(s2);
	 	    Integer count22 = 0;
	 	    while (m2.find()){
	 	    	count22 +=1;
	 	    }
	 	    
	 	    p2 = Pattern.compile("=neutral");
	 	     m2 = p2.matcher(s2);
	 	    Integer count23 = 0;
	 	    while (m2.find()){
	 	    	count23 +=1;
	 	    }
	 	    
	 	    Map map21 = new HashMap();
	 		map21.put("positive", count21.toString());
	 		map21.put("negative", count22.toString());

	 		map21.put("neutral", count23.toString());

	 		List  l5 = new LinkedList();
			l5.add(map21);

	 		 String s3 = l3.toString();
	 	//	    System.out.println(s3);

	 		 
	 		 Pattern p3 = Pattern.compile("=positive");
	 		    Matcher m3 = p3.matcher(s3);
	 		    Integer count31 = 0;
	 		    while (m3.find()){
	 		    	count31 +=1;
	 		    }
	 		    
	 	//	    System.out.println(count31);

	 		    
	 		     p3 = Pattern.compile("=negative");
	 		     m3 = p3.matcher(s3);
	 		    Integer count32 = 0;
	 		    while (m3.find()){
	 		    	count32 +=1;
	 		    }
	 		    
	 	//	    System.out.println(count32);

	 		    
	 		     p3 = Pattern.compile("=neutral");
	 		    m3 = p3.matcher(s3);
	 		    Integer count33 = 0;
	 		    while (m3.find()){
	 		    	count33 +=1;
	 		    }
	 		    
	 	//	    System.out.println(count33);

	 		    Map map31 = new HashMap();
	 			map31.put("positive", count31.toString());
	 			map31.put("negative", count32.toString());

	 			map31.put("neutral", count33.toString());

//	 		    System.out.println(map31.toString());

	 	
	 			List  l6 = new LinkedList();
				l6.add(map31);
	 
	     JSONObject obj2 = new JSONObject();
	     obj2.put("Restaurant1", l1);
	     obj2.put("Restaurant2", l2);
	     obj2.put("Restaurant3", l3);
	     obj2.put("pie1", l4);

	     obj2.put("pie2", l5);

	     obj2.put("pie3", l6);
	     obj2.put("restaurant1", test.get(0));
	     obj2.put("restaurant2", test.get(1));

	     obj2.put("restaurant3", test.get(2));


	     
	     String answer = obj2.toJSONString();
	     System.out.println(answer);
		return answer;	    
}
	
	
	  public YelpReview(String consumerKey, String consumerSecret, String token, String tokenSecret) {
		    this.service = new ServiceBuilder().provider(YelpApi2.class).apiKey("FWUmNOxcHz4inMUQn82i_A").apiSecret("XeRLUGhpvh7Aol_ZPtnKvXWEd44").build();
		    this.accessToken = new Token("03F_GQSXnIp8M4d2n4nqCy5B2pzp6ku0", "_Mzrt-ZaWGl2qk9P8qCR0TJL_qI");
		  }
	
	  public String search(String term, String location) {
			//String limit = "3";
			  String limit = "6";
		    OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
		    request.addQuerystringParameter("term", term);
		    request.addQuerystringParameter("location", location);
		    request.addQuerystringParameter("limit", limit);
		    this.service.signRequest(this.accessToken, request);
		    Response response = request.send();
		    return response.getBody();
		  }
	
	}
