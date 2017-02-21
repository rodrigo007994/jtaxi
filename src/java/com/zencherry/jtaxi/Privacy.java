package com.zencherry.jtaxi;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class Privacy extends HttpServlet {
    /**
	 * 
	 */

    @Override
    public void init() throws ServletException{
        
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("ztitle", "Aviso de privacidad");
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/privacy.jsp");
        view.forward(request, response);
    }
    @Override
    public void destroy(){
  
    }
}