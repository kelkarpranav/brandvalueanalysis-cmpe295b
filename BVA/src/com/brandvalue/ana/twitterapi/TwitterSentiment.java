package com.brandvalue.ana.twitterapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.*;


public class TwitterSentiment {
public static String getTwitterSentiment (String s) throws IOException, InterruptedException
{
	String brand = s;	
	StringBuffer output1 = new StringBuffer();

	try{
	Process p1 = Runtime.getRuntime().exec("python analyze.py " + brand + " 30");
	//p1.waitFor();

	BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
	String line = "";			
	while ((line = reader.readLine())!= null) {
		output1.append(line + "\n");
	}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
    	

	
	String str1 = output1.toString();
	//System.out.print(str1);
	
    String[] tweetset = str1.split("\n");
    List<String> tweetlist = Arrays.asList(tweetset); 
    for (String e : tweetlist) 
    {
    	System.out.println(e);
    	
    } 
	Map map = new LinkedHashMap();

	int i,a,b,c;
	int j=1;
    for(i=0;i<(tweetlist.size()/2);i++)  
    {  
      a=i;
      b=i+1;
      c=i+2; 
      map.put("tweet"+j, tweetlist.get(a));
 	  map.put("sentiment"+j, tweetlist.get(b));
 	  map.put("confidence"+j, tweetlist.get(c));
 	  j++;
 	  i=i+2;
 	  
    }  
    
   String temp = map.toString();
   Pattern p1 = Pattern.compile("positive");
   Matcher m1 = p1.matcher(temp);
   Integer count1 = 0;
   while (m1.find()){
   	count1 +=1;
   }
   
   Pattern p2 = Pattern.compile("negative");
   Matcher m2 = p2.matcher(temp);
   Integer count2 = 0;
   while (m2.find()){
	   count2 +=1;
   }

   Pattern p3 = Pattern.compile("neutral");
   Matcher m3 = p3.matcher(temp);
   Integer count3 = 0;
   while (m3.find()){
	   count3 +=1;
   }
   

 
   //System.out.println(count1);
   //System.out.println(count2);
   //System.out.println(count3);
	map.put("positive", count1.toString());
	map.put("negative", count2.toString());

	map.put("neutral", count3.toString());


   String jsonText = JSONValue.toJSONString(map);

   //System.out.print(jsonText);	
   
    return jsonText;
    
	
}
}