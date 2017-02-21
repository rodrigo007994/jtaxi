package com.zencherry.jtaxi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class SetRequest {
//email, latitude, longitude, calle, numext, cruzamientos, colonia, referencia
	public static String NewRequest(String email, Double latitude, Double longitude, String calle, String numext, String cruzamientos, String colonia, String referencia){
		String content=null;
		Connection conn=null;
		Statement stmt=null;
		conn=null;
        stmt=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/rodrigov_zendb","rodrigov_zen", "4DZ856pn1pTu");
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO jtaxi_rides(client, latitude, longitude, calle, numext, cruzamientos, colonia, referencia) VALUES ('"+email+"','"+latitude+"', '"+longitude+"','"+calle+"','"+numext+"','"+cruzamientos+"','"+colonia+"','"+referencia+"');");
			content="Solicitud enviada";
			stmt.close();
	        conn.close();
			return content;
        }catch(ClassNotFoundException e1){
            System.out.println( e1.getClass().getName()+": "+ e1.getMessage() );
            return "Error en el driver.";
        }catch(SQLException e2){
            System.out.println( e2.getClass().getName()+": "+ e2.getMessage() );
            return "Error en los datos capturados.";
        }
}
	
}
