package com.zencherry.jtaxi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class GetClientHistoric {

	public static String getRides(String email){
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
			rs = stmt.executeQuery("SELECT jtaxi_rides.id, CONCAT(jtaxi_users.name, ', ', jtaxi_users.lastname) AS fullname, jtaxi_rides.latitude, jtaxi_rides.longitude, DATE(jtaxi_rides.stamp) AS stamp2, jtaxi_rides.status FROM jtaxi_rides LEFT JOIN jtaxi_users ON jtaxi_rides.driver=jtaxi_users.email WHERE jtaxi_rides.client='"+email+"' AND jtaxi_rides.status!='ESPERANDO TAXI' AND jtaxi_rides.status!='EN CAMINO AL DESTINO' LIMIT 100;");
			content+="<table class='table-bordered'>";
			while(rs.next())
			{	
				
				content+="<tr>";
				content+="<td>";
				content+="Conductor";
				content+="</td>";
				content+="<td>";
				content+=rs.getString("fullname");
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
				content+="Fecha";
				content+="</td>";
				content+="<td>";
				content+=rs.getString("stamp2");
				content+="</td>";
				content+="</tr>";
				
				content+="<tr>";
				content+="<td colspan='2'>";
				content+="<img width='300' src='http://image.maps.cit.api.here.com/mia/1.6/mapview?app_id=FepdAwq3sSVy5iSz8ofh&app_code=xZn2tPu48VdAKO1wS1X_NA&c="+
				rs.getString("latitude")+","+
				rs.getString("longitude")+
				"&h=300&w=300&z=17&f=0&style=alps' alt='pick up location'>";
				content+="</td>";
				content+="</tr>";
				
				
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
