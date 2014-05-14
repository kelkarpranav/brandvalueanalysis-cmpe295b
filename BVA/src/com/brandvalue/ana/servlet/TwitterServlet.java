package com.brandvalue.ana.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.brandvalue.ana.twitterapi.TwitterSentiment;
import com.brandvalue.ana.yelpapi.YelpReview;

/**
 * Servlet implementation class TwitterServlet
 */
public class TwitterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwitterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String twitterobject2;
		String twitterobjectget = "";
		if (request.getParameter("twitterBrand") != null
				|| !"".equals(request.getParameter("twitterBrand"))) {
			twitterobjectget = request.getParameter("twitterBrand");
			System.out.println(twitterobjectget);
		}

		try {
			twitterobject2 = TwitterSentiment.getTwitterSentiment(twitterobjectget);
			session.setAttribute("TwitterResult", twitterobject2);
			response.sendRedirect("pages/twitterResult.jsp#anchor4");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
