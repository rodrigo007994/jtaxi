package com.zencherry.jtaxi;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
public class XhrTie extends HttpServlet {
    /**
	 * 
	 */

    @Override
    public void init() throws ServletException{
        
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	int id;
    	String content="";
    	response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
    	
    	

        HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null){
			if(GetDriverOngoingRide.test(session.getAttribute("email").toString())){
	        	content="Ya tienes un viaje asociado.";
	        }else{
	        	id=Integer.parseInt(request.getParameter("id"));
		    	content=SetTie.Tie(session.getAttribute("email").toString(), id);
	        }
			
		}
    	
    	
    	
        request.setAttribute("zcontent", content);

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/xhr.jsp");
        view.forward(request, response);
    }
    @Override
    public void destroy(){
  
    }
}