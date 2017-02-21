package com.zencherry.jtaxi;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
public class XhrSetRide extends HttpServlet {
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
        if(GetOngoingRide.test(email)){
        	content="Ya solicitaste un taxi con anterioridad.";
        }else{
        Double latitude=Double.parseDouble(request.getParameter("latitude"));
        Double longitude=Double.parseDouble(request.getParameter("longitude"));
        String calle=request.getParameter("calle");
        String numext=request.getParameter("numext");
        String cruzamientos=request.getParameter("cruzamientos");
        String colonia=request.getParameter("colonia");
        String referencia=request.getParameter("referencia");
        content = SetRequest.NewRequest(email, latitude, longitude, calle, numext, cruzamientos, colonia, referencia);
        }
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