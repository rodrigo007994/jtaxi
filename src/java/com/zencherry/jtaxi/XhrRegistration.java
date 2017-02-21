package com.zencherry.jtaxi;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class XhrRegistration extends HttpServlet {
    /**
	 * 
	 */

    @Override
    public void init() throws ServletException{
        
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String name, lastname, email, password;
    	Double phone;
    	String content="";
    	response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
    	
    	
    	name=request.getParameter("name");
    	lastname=request.getParameter("lastname");
    	email=request.getParameter("email");
    	password=request.getParameter("password");
    	if(request.getParameter("phone").length()==10){
    		try{
    	    	phone=Double.parseDouble(request.getParameter("phone"));
    	    	content=AddRegistration.NewRegistration(name, lastname, email, password, phone);
    	    	System.out.println("Validando datos");
    	    	}catch(Exception e2){
    	    	System.out.println("Error, ingresar unicamente numeros al campo de telefono");
    	    	content="Error, ingresar unicamente numeros al campo de telefono";
    	    	}
    	}else{
    		content="Error, ingresar unicamente 10 numeros al campo de telefono";
    		System.out.println("Error, ingresar unicamente 10 numeros al campo de telefono");
    	}
    	
        
        request.setAttribute("zcontent", content);

        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/xhr.jsp");
        view.forward(request, response);
    }
    @Override
    public void destroy(){
  
    }
}