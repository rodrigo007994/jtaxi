package com.zencherry.jtaxi;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
public class XhrDriverCancelTaxi extends HttpServlet {
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
        HttpSession session = request.getSession(false);
        if(session.getAttribute("email")!=null){
        
        String email=session.getAttribute("email").toString();
        
        content = SetOngoingRide.DriverCancelRide(email);
        }else{
        	content="Necesitas volver a iniciar session.";
        }
        request.setAttribute("zcontent", content);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/xhr.jsp");
        view.forward(request, response);
    }
    @Override
    public void destroy(){
  
    }
}