package com.zencherry.jtaxi;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
public class XhrLogin extends HttpServlet {
    /**
	 * 
	 */

    @Override
    public void init() throws ServletException{
        
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String  email, password;
    	String[] content;
    	response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
    	
    	

    	email=request.getParameter("email");
    	password=request.getParameter("password");
    	content=Login.NewLogin(email, password);
    	if(content[0].equals("Inicio de session exitosa.")){
    		HttpSession session = request.getSession(true);
    		session.setAttribute("email", email);
    		session.setAttribute("tipo", content[1]);
    		
    	}
    	
        request.setAttribute("zcontent", content[0]);

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/xhr.jsp");
        view.forward(request, response);
    }
    @Override
    public void destroy(){
  
    }
}