package com.zencherry.jtaxi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class GetDriverOngoingRide {

	public static String getRide(String email){
		String content="";
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
			rs = stmt.executeQuery("SELECT Jtaxi_rides.id, Jtaxi_rides.client, "
					+ "calle, "
					+ "numext, "
					+ "cruzamientos, "
					+ "colonia, "
					+ "referencia, "
					+ "CONCAT(jtaxi_users.name, ', ', jtaxi_users.lastname) AS fullname, jtaxi_users.phone, Jtaxi_rides.latitude, Jtaxi_rides.longitude, round(EXTRACT(EPOCH FROM (now() - Jtaxi_rides.stamp))/60) AS stamp2, Jtaxi_rides.status FROM Jtaxi_rides INNER JOIN jtaxi_users ON jtaxi_users.email=Jtaxi_rides.client WHERE Jtaxi_rides.driver='"+email+"' AND (Jtaxi_rides.status='ESPERANDO TAXI' OR Jtaxi_rides.status='EN CAMINO AL DESTINO') ORDER BY jtaxi_rides.id DESC LIMIT 1;");
			if(rs.next())
			{	
				content+="<table class='table-bordered'>";
				
				content+="<tr>";
				content+="<td>";
				content+="Acciones";
				content+="</td>";
				content+="<td>";
				content+="<button onclick='xhrDriverCancelTaxi()' class='btn btn-primary'>Cancelar Servicio</button>";
				content+="</td>";
				content+="</tr>";
				
				
				content+="<tr>";
				content+="<td>";
				content+="Cliente";
				content+="</td>";
				content+="<td>";
				content+=rs.getString("fullname");
				content+="</td>";
				content+="</tr>";
				
				
				
				content+="<tr>";
				content+="<td>";
				content+="Imagen";
				content+="</td>";
				content+="<td>";
				content+="<img src='https://www.gravatar.com/avatar/"+MD5Util.md5Hex(rs.getString("client"))+"?s=200' />";
				content+="</td>";
				content+="</tr>";
				
				
				
				
				content+="<tr>";
				content+="<td>";
				content+="Telefono";
				content+="</td>";
				content+="<td>";
				content+=rs.getString("phone");
				content+="</td>";
				content+="</tr>";
				
				content+="<tr>";
				content+="<td>";
				content+="Estado";
				content+="</td>";
				content+="<td>";
				content+=rs.getString("status");
				content+="</td>";
				content+="</tr>";
				
				content+="<tr>";
				content+="<td>";
				content+="Minutos transcurridos";
				content+="</td>";
				content+="<td>";
				content+=rs.getString("stamp2");
				content+="</td>";
				content+="</tr>";
				
				
if(rs.getString("calle").length()>0){
					
					content+="<tr>";
					content+="<td>";
					content+="Calle";
					content+="</td>";
					content+="<td>";
					content+=rs.getString("calle");
					content+="</td>";
					content+="</tr>";
					
					
					content+="<tr>";
					content+="<td>";
					content+="N&uacute;mero exterior";
					content+="</td>";
					content+="<td>";
					content+=rs.getString("numext");
					content+="</td>";
					content+="</tr>";
					
					
					content+="<tr>";
					content+="<td>";
					content+="Cruzamientos";
					content+="</td>";
					content+="<td>";
					content+=rs.getString("cruzamientos");
					content+="</td>";
					content+="</tr>";


					content+="<tr>";
					content+="<td>";
					content+="Colonia";
					content+="</td>";
					content+="<td>";
					content+=rs.getString("colonia");
					content+="</td>";
					content+="</tr>";
					
					
					content+="<tr>";
					content+="<td>";
					content+="Referencia";
					content+="</td>";
					content+="<td>";
					content+=rs.getString("referencia");
					content+="</td>";
					content+="</tr>";
					
					
				}else{
					content+="<tr>";
					content+="<td colspan='2'>";
					content+="<img width='320' zsize='14' onclick='zoom(this,\""+rs.getString("latitude")+"\",\""+rs.getString("longitude")+"\");' src='http://image.maps.cit.api.here.com/mia/1.6/mapview?app_id=FepdAwq3sSVy5iSz8ofh&app_code=xZn2tPu48VdAKO1wS1X_NA&c="+
					rs.getString("latitude")+","+
					rs.getString("longitude")+
					"&h=320&w=320&z=14&f=0&style=alps' alt='pick up location'>";
					content+="</td>";
					content+="</tr>";
				}
				
				
				content+="</table>";
			}
			rs.close();
			stmt.close();
	        conn.close();

			return content;
        }catch(ClassNotFoundException e1){
            System.out.println( e1.getClass().getName()+": "+ e1.getMessage() );
            return null;
        }catch(SQLException e2){
            System.out.println( e2.getClass().getName()+": "+ e2.getMessage() );
            return null;
        }
}
	
	public static Boolean test(String email){
		Boolean resultado=true;
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
			rs = stmt.executeQuery("SELECT jtaxi_rides.id FROM jtaxi_rides WHERE Jtaxi_rides.driver='"+email+"' AND Jtaxi_rides.status='EN CAMINO AL DESTINO' LIMIT 1;");
			if(!rs.next())
			{	
				resultado=false;		
			}
			rs.close();
			stmt.close();
	        conn.close();
			return resultado;
        }catch(ClassNotFoundException e1){
            System.out.println( e1.getClass().getName()+": "+ e1.getMessage() );
            return true;
        }catch(SQLException e2){
            System.out.println( e2.getClass().getName()+": "+ e2.getMessage() );
            return true;
        }
}
	
}
