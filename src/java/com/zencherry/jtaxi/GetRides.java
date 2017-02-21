package com.zencherry.jtaxi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class GetRides {

	public static String PendingDriver(){
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
			rs = stmt.executeQuery("SELECT Jtaxi_rides.id, "
					+ "calle, "
					+ "numext, "
					+ "cruzamientos, "
					+ "colonia, "
					+ "referencia, "
					+ "CONCAT(Jtaxi_users.name, ', ', Jtaxi_users.lastname) AS fullname, Jtaxi_users.phone, Jtaxi_rides.latitude, Jtaxi_rides.longitude, round(EXTRACT(EPOCH FROM (now() - Jtaxi_rides.stamp))/60) AS stamp2, Jtaxi_rides.status FROM Jtaxi_rides INNER JOIN jtaxi_users ON Jtaxi_rides.client=Jtaxi_users.email WHERE Jtaxi_rides.status='ESPERANDO TAXI' ORDER BY Jtaxi_rides.stamp DESC LIMIT 500;");
			content+="<table class='table-bordered'>";
			while(rs.next())
			{	
				
				content+="<tr>";
				content+="<td>";
				content+="Acciones";
				content+="</td>";
				content+="<td>";
				content+="<button onclick='xhrTie(this)' value='"+rs.getString("id")+"' class='btn btn-primary'>Asignar</button>";
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
				content+="N&oacute;mero";
				content+="</td>";
				content+="<td>";
				content+=rs.getString("phone");
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
				
				
				
				
			}
			content+="</table>";
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
	
}
