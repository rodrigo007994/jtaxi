package com.zencherry.jtaxi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class AddRegistration {

	public static String NewRegistration(String name, String lastname, String email, String password, Double phone){
		if(
		name!=null&&
		lastname!=null&&
		email!=null&&
		password!=null&&
		phone!=null&&
		name.length()>1&&
		lastname.length()>1&&
		email.length()>1&&
		password.length()>1
		){
			Connection conn=null;
			Statement stmt=null;
			conn=null;
	        stmt=null;
	        try{
	            Class.forName("org.postgresql.Driver");//name lastname email pass phone regdate status 
	            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/rodrigov_zendb","rodrigov_zen", "4DZ856pn1pTu");
				stmt = conn.createStatement();
				stmt.executeUpdate("INSERT INTO jtaxi_users (name, lastname, email, password, phone) VALUES ('"+name+"', '"+lastname+"', '"+email+"', '"+password+"', "+phone+");");
				System.out.println("REGISTRO EXITOSO");
		        stmt.close();
		        conn.close();
				return "Registrado exitosamente";
	        }catch(ClassNotFoundException e1){
	            System.out.println( e1.getClass().getName()+": "+ e1.getMessage() );
	            return "Error, no se encontro el controlador JDBC.";
	        }catch(SQLException e2){
	            System.out.println( e2.getClass().getName()+": "+ e2.getMessage() );
	            return "Error, error en los datos capturados o el email ya existe.";
	        }
		}else{
			System.out.println("Error, los campos no estan correctamente llenados");
        	return "Error, los campos no estan correctamente llenados";
        }
        }
}
	

