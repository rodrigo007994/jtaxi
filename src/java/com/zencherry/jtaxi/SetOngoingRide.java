package com.zencherry.jtaxi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class SetOngoingRide {

	public static String CancelRide(String email){
		Connection conn=null;
		Statement stmt=null;
		conn=null;
        stmt=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/rodrigov_zendb","rodrigov_zen", "4DZ856pn1pTu");
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE jtaxi_rides SET status='CANCELADO' WHERE client='"+email+"' AND (status='ESPERANDO TAXI' OR status='EN CAMINO AL DESTINO');");
			stmt.close();
	        conn.close();
			return "Servicio cancelado exitosamente";
        }catch(ClassNotFoundException e1){
            System.out.println( e1.getClass().getName()+": "+ e1.getMessage() );
            return "No se encuentra el driver";
        }catch(SQLException e2){
            System.out.println( e2.getClass().getName()+": "+ e2.getMessage() );
            return "Error en la consulta a la BD.";
        }
}
	
	public static String DriverCancelRide(String email){
		Connection conn=null;
		Statement stmt=null;
		conn=null;
        stmt=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/rodrigov_zendb","rodrigov_zen", "4DZ856pn1pTu");
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE jtaxi_rides SET status='CANCELADO POR CONDUCTOR' WHERE driver='"+email+"' AND (status='ESPERANDO TAXI' OR status='EN CAMINO AL DESTINO');");
			stmt.close();
	        conn.close();
			return "Servicio cancelado exitosamente";
        }catch(ClassNotFoundException e1){
            System.out.println( e1.getClass().getName()+": "+ e1.getMessage() );
            return "No se encuentra el driver";
        }catch(SQLException e2){
            System.out.println( e2.getClass().getName()+": "+ e2.getMessage() );
            return "Error en la consulta a la BD.";
        }
}
	
}
