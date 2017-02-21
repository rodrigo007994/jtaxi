package com.zencherry.jtaxi;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
public class Home extends HttpServlet {
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
        request.setAttribute("ztitle", "Inicio");
        HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null){
			String gravatar=MD5Util.md5Hex(session.getAttribute("email").toString());
			request.setAttribute("gravatar", gravatar);
			RequestDispatcher view;
			if(session.getAttribute("tipo").toString().equals("chofer")){
				view = request.getRequestDispatcher("WEB-INF/jsp/driverhome.jsp");
		        
			}else{
				view = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
			}
			
	        view.forward(request, response);
		}
        
    }
    @Override
    public void destroy(){
  
    }
}