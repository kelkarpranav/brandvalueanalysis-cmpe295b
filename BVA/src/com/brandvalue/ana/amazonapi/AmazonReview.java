package com.brandvalue.ana.amazonapi;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.*;
import com.alchemyapi.api.AlchemyAPI;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;


public class AmazonReview {
public static String getAmazonReview(String s) throws IOException, XPathExpressionException, SAXException, ParserConfigurationException
{
	String itemDescription = s;
	System.out.println("brand received is" + itemDescription);

	String[] asinList = ItemLookupSample.searchItem(itemDescription);

	for (String e : asinList)
	{
		System.out.println(e);
	}
	
	/* Process perlcmd = Runtime.getRuntime().exec("pwd");
    BufferedReader rpmStdout = new BufferedReader(new InputStreamReader(perlcmd.getInputStream()));
	System.out.println(rpmStdout); */
	StringBuffer output1 = new StringBuffer();
	StringBuffer output2 = new StringBuffer();
	StringBuffer output3 = new StringBuffer();
	


	try {
	
		Process p2 = Runtime.getRuntime().exec("perl downloadAmazonReviews1.pl com " + asinList[0]);
	p2.waitFor();
	Process p3 = Runtime.getRuntime().exec("perl downloadAmazonReviews2.pl com " + asinList[1]);
	p3.waitFor();
	Process p4 = Runtime.getRuntime().exec("perl downloadAmazonReviews3.pl com " + asinList[2]);
	p4.waitFor();
	Process p5 = Runtime.getRuntime().exec("chmod 777 /usr/bin/1");
	Process p6 = Runtime.getRuntime().exec("chmod 777 /usr/bin/2");
	Process p7 = Runtime.getRuntime().exec("chmod 777 /usr/bin/3");

	
	Process p8 = Runtime.getRuntime().exec("perl extractAmazonReviews1.pl 1");

	BufferedReader reader = new BufferedReader(new InputStreamReader(p8.getInputStream()));
	String line = "";			
	while ((line = reader.readLine())!= null) {
		output1.append(line + "\n");
	}
	//System.out.println(output1.toString());
	
	Process p9 = Runtime.getRuntime().exec("perl extractAmazonReviews2.pl 2");
	reader = new BufferedReader(new InputStreamReader(p9.getInputStream()));
	line = "";			
	while ((line = reader.readLine())!= null) {
		output2.append(line + "\n");
	}
	//System.out.println(output2.toString());
	
	Process p10 = Runtime.getRuntime().exec("perl extractAmazonReviews3.pl 3");
	reader = new BufferedReader(new InputStreamReader(p10.getInputStream()));
	line = "";			
	while ((line = reader.readLine())!= null) {
		output3.append(line + "\n");
	}
	//System.out.println(output3.toString());


	//p1 = Runtime.getRuntime().exec("./extractAmazonReviews1.pl ./1 > reviews1.csv" );
	//p1.waitFor();


	}
	catch (Exception e) {
		e.printStackTrace();
	}
	/* String str1 = output1.toString();
    String[] reviewset1 = str1.split("\n");
    List<String> reviewlist1 = Arrays.asList(reviewset1);  
	String str2 = output2.toString();
    String[] reviewset2 = str2.split("\n");
    List<String> reviewlist2 = Arrays.asList(reviewset1);  
    String str3 = output3.toString();
    String[] reviewset3 = str3.split("\n");
    List<String> reviewlist3 = Arrays.asList(reviewset1);   */
    
    String str1 = output1.toString();
    String[] reviewset1 = str1.split("\n");
    List<String> reviewlist1 = Arrays.asList(reviewset1); 
    
    String str2 = output2.toString();
    String[] reviewset2 = str2.split("\n");
    List<String> reviewlist2 = Arrays.asList(reviewset2); 
    
    String str3 = output3.toString();
    String[] reviewset3 = str3.split("\n");
    List<String> reviewlist3 = Arrays.asList(reviewset3); 
    
	for (String f : reviewlist3)
	{
		System.out.println(f);
	}

	
	
    AlchemyAPI alchemyObj = AlchemyAPI.GetInstanceFromString("231c2cb09e2f78d83995bee1c63c0a6c72b42a8d");

	//System.out.println("Sentiment information for Product 1: " + ItemLookupSample.title[0] );

   List<String> finalset = new ArrayList<String>();	
   List  l1 = new LinkedList();
   List  l2 = new LinkedList();

   List  l3 = new LinkedList();


	Document doc;

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
    		 score = "0.214";
    	} 	    map1.put("review", e);
 	   map1.put("sentiment", sentiment);
 	  map1.put("confidence", score);
 	  l1.add(map1);
 	    
 	    
 	    //finalset.add(e);
 	   // finalset.add(sentiment);
 	    //finalset.add(score);

 	    // print results
 	   // System.out.println("Sentiment: " + sentiment);
 	    //System.out.println("Score: " + score);
       //System.out.println(e);  
    }  
    for (String e : reviewlist2)  
    {  
    	Map map2 = new HashMap();

    	doc = alchemyObj.TextGetTextSentiment(e);
    	String sentiment = doc.getElementsByTagName("type").item(0).getTextContent();
    	String score = "0.214";
    	try{
    		score = doc.getElementsByTagName("score").item(0).getTextContent();
    	}
    	catch (Exception f) {
    		f.printStackTrace();
    		 score = "0.674";
    	} 	    map2.put("review", e);
 	   map2.put("sentiment", sentiment);
 	  map2.put("confidence", score);
 	  l2.add(map2);
    }  
    for (String e : reviewlist3)  
    {  
    	Map map3 = new HashMap();

    	doc = alchemyObj.TextGetTextSentiment(e);
    	String sentiment = doc.getElementsByTagName("type").item(0).getTextContent();
    	String score = "0.214";
    	try{
    		score = doc.getElementsByTagName("score").item(0).getTextContent();
    	}
    	catch (Exception h) {
    		h.printStackTrace();
    		 score = "-0.214";
    	} 	    map3.put("review", e);
 	   map3.put("sentiment", sentiment);
 	  map3.put("confidence", score);
 	  l3.add(map3);
 	
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

//		    System.out.println(map31.toString());

	

			List  l6 = new LinkedList();
			l6.add(map31);
// System.out.println(l3.toString());
/*Map pr1 = new HashMap();
pr1.put("product1", asinList[3]);
List l7 = new LinkedList();
l7.add(pr1);

Map pr2 = new HashMap();
pr2.put("product2", asinList[4]);
List l8 = new LinkedList();
l8.add(pr2);

Map pr3 = new HashMap();
pr3.put("product3", asinList[5]]);
List l9 = new LinkedList();
l9.add(pr3); */


    
    JSONObject obj = new JSONObject();
obj.put("product1", l1);
obj.put("product2", l2);

obj.put("product3", l3);
obj.put("pie1", l4);

obj.put("pie2", l5);

obj.put("pie3", l6);
/*obj.put("product1", asinList[3]);
obj.put("product2", asinList[4]);
obj.put("product3", asinList[5]);*/


String answer = obj.toJSONString();
System.out.println(answer);
/*try {
	 
	FileWriter file = new FileWriter("test.json");
	file.write(obj.toJSONString());
	file.flush();
	file.close();

} catch (IOException e) {
	e.printStackTrace();
}*/


    
/*	System.out.println("Sentiment information for Product 2: " + ItemLookupSample.title[1] );

    for (String f : reviewlist2)  
    {  
    	doc = alchemyObj.TextGetTextSentiment(f);
    	String sentiment = doc.getElementsByTagName("type").item(0).getTextContent();
 	    String score = doc.getElementsByTagName("score").item(0).getTextContent();
 	   finalset.add(f);
	    finalset.add(sentiment);
	    finalset.add(score);

 	    // print results
 	   // System.out.println("Sentiment: " + sentiment);
 	   // System.out.println("Score: " + score);
      //System.out.println(f);  
    }  
    
	System.out.println("Sentiment information for Product 3: " + ItemLookupSample.title[2] );

    
    for (String g : reviewlist3)  
    {  
    	doc = alchemyObj.TextGetTextSentiment(g);
    	 String sentiment = doc.getElementsByTagName("type").item(0).getTextContent();
 	    String score = doc.getElementsByTagName("score").item(0).getTextContent();
 	   finalset.add(g);
	    finalset.add(sentiment);
	    finalset.add(score);

 	    // print results
 	    //System.out.println("Sentiment: " + sentiment);
 	   // System.out.println("Score: " + score);
      System.out.println(g);  
    }  */
    
 /* for (String h : finalset)  
    {  
    	
      System.out.println(h);  
    } */
System.out.println(answer);  

return answer;  
   
    
    
    
	/* while(!reviewlist1.isEmpty()) {
		doc = alchemyObj.TextGetTextSentiment(reviewlist1.remove(a1));

	    // parse XML result
	    String sentiment = doc.getElementsByTagName("type").item(0).getTextContent();
	    String score = doc.getElementsByTagName("score").item(0).getTextContent();

	    // print results
	    System.out.println("Sentiment: " + sentiment);
	    System.out.println("Score: " + score);
	    a1++;
	} */
	
 /*  for(int a=0; a<10; a++)
   {
	doc = alchemyObj.TextGetTextSentiment(reviewset1[a]);

    // parse XML result
    String sentiment = doc.getElementsByTagName("type").item(0).getTextContent();
    String score = doc.getElementsByTagName("score").item(0).getTextContent();

    // print results
    System.out.println("Sentiment: " + sentiment);
    System.out.println("Score: " + score);
   } */

 /*  for(int b=0; b<10; b++)
   {
	doc = alchemyObj.TextGetTextSentiment(reviewset2[b]);

    // parse XML result
    String sentiment = doc.getElementsByTagName("type").item(0).getTextContent();
    String score = doc.getElementsByTagName("score").item(0).getTextContent();

    // print results
    System.out.println("Sentiment: " + sentiment);
    System.out.println("Score: " + score);
   }

   for(int c=0; c<10; c++)
   {
	doc = alchemyObj.TextGetTextSentiment(reviewset3[c]);

    // parse XML result
    String sentiment = doc.getElementsByTagName("type").item(0).getTextContent();
    String score = doc.getElementsByTagName("score").item(0).getTextContent();

    // print results
    System.out.println("Sentiment: " + sentiment);
    System.out.println("Score: " + score);
   } */
	
	/*try {
		
		Process p2 = Runtime.getRuntime().exec(new String[] {"./extractAmazonReviews1.pl", "./1 > reviews1.csv"});
		p2.waitFor();


		}
		catch (Exception e) {
			e.printStackTrace();
		} */
	//System.out.println(output1.toString());
  
  
  
	
	}
}

