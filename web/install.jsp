<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%!
		public static void install(){
		String htmlout=null;
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
			stmt.executeUpdate("DROP TABLE IF EXISTS jtaxi_rides CASCADE;");
			stmt.executeUpdate("DROP TABLE IF EXISTS jtaxi_users CASCADE;");
			stmt.executeUpdate("CREATE TABLE jtaxi_rides (id serial PRIMARY KEY, client varchar(250), driver varchar(250), latitude float8 NOT NULL, longitude float8 NOT NULL, "+
			"calle varchar(250), "+
			"numext varchar(250), "+
			"cruzamientos varchar(250), "+
			"colonia varchar(250), "+
			"referencia varchar(250), "+
			"stamp timestamp DEFAULT NOW(), status varchar(50) DEFAULT 'ESPERANDO TAXI');");
			stmt.executeUpdate("CREATE TABLE jtaxi_users (id serial PRIMARY KEY, name varchar(250), lastname varchar(250), email varchar(250) UNIQUE, password varchar(50), phone bigint, tipo varchar(50) DEFAULT 'cliente', regdate timestamp DEFAULT NOW(), status varchar(50));");
			System.out.println("INSTALACION EXITOSA.");
        }catch(ClassNotFoundException e1){
            System.out.println( e1.getClass().getName()+": "+ e1.getMessage() );
        }catch(SQLException e2){
            System.out.println( e2.getClass().getName()+": "+ e2.getMessage() );
        }
}
%>
<% 
install();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head></head>
<body>
<p>INSTALACION CONCLUIDA</p>
</body>
</html>
