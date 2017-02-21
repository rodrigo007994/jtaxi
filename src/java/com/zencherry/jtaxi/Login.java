package com.zencherry.jtaxi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Login {

	public static String[] NewLogin(String email, String password){
		String[] salida=new String[2];
		salida[1]="cliente";
		if(
		email!=null&&
		password!=null&&
		email.length()>1&&
		password.length()>1
		){
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			conn=null;
	        stmt=null;
	        rs=null;
	        try{
	            Class.forName("org.postgresql.Driver");
	            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/rodrigov_zendb","rodrigov_zen", "4DZ856pn1pTu");
				stmt = conn.createStatement();
				rs=stmt.executeQuery("SELECT tipo FROM jtaxi_users WHERE email='"+email+"' AND password='"+password+"';");
				if(rs.next()){
					salida[1]=rs.getString("tipo");
					salida[0]="Inicio de session exitosa.";
				}else{
					salida[0]="Email o contraseña no validos.";
				}
				rs.close();
				stmt.close();
		        conn.close();
	        }catch(ClassNotFoundException e1){
	            System.out.println( e1.getClass().getName()+": "+ e1.getMessage() );
	            salida[0]="No se encontro el driver";
	            return salida;
	        }catch(SQLException e2){
	            System.out.println( e2.getClass().getName()+": "+ e2.getMessage() );
	            salida[0]="datos mal capturados.";
	            return salida;
	        }
	        return salida;
		}else{
			System.out.println("Error, los campos no estan correctamente llenados");
        	salida[0]="Error, los campos no estan correctamente llenados";
        	return salida;
        }
        }
}
	

