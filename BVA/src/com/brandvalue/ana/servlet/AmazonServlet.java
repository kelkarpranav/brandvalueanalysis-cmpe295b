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

import com.brandvalue.ana.amazonapi.AmazonReview;
import com.brandvalue.ana.yelpapi.YelpReview;

/**
 * Servlet implementation class AmazonServlet
 */
public class AmazonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AmazonServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String amazonobject2;
		String amazonobjectget = "";
		if (request.getParameter("amazonBrand") != null
				|| !"".equals(request.getParameter("amazonBrand"))) {
			amazonobjectget = request.getParameter("amazonBrand");
			System.out.println(amazonobjectget);
		}
		
		try {
			amazonobject2 = AmazonReview.getAmazonReview(amazonobjectget);
			session.setAttribute("AmazonResult", amazonobject2);
			response.sendRedirect("pages/amazonResult.jsp#anchor4");
			
		}catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
