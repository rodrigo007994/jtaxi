package com.zencherry.jtaxi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class SetTie {

	public static String Tie(String email, int id){
		Connection conn=null;
		Statement stmt=null;
		conn=null;
        stmt=null;
        int rows=0;
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/rodrigov_zendb","rodrigov_zen", "4DZ856pn1pTu");
			stmt = conn.createStatement();
			rows = stmt.executeUpdate("UPDATE jtaxi_rides SET status='EN CAMINO AL DESTINO', driver ='"+email+"' WHERE jtaxi_rides.id="+id+" AND status='ESPERANDO TAXI';");
			stmt.close();
	        conn.close();
			if(rows==1){
			return "Servicio asignado";
			}else{
				return "Ya fue asignado a otro Taxi.";
			}
			
        }catch(ClassNotFoundException e1){
            System.out.println( e1.getClass().getName()+": "+ e1.getMessage() );
            return "No se encuentra el driver";
        }catch(SQLException e2){
            System.out.println( e2.getClass().getName()+": "+ e2.getMessage() );
            return "Error en la consulta a la BD.";
        }
}
	
}
