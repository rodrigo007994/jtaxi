package com.zencherry.jtaxi;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class Rides extends HttpServlet {
    /**
	 * 
	 */

    @Override
    public void init() throws ServletException{
        
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String content="";
    	response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        content=GetRides.PendingDriver();
		
        request.setAttribute("zcontent", content);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/rides.jsp");
        view.forward(request, response);
    }
    @Override
    public void destroy(){
  
    }
}