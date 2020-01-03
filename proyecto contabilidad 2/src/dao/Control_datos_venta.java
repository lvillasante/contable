package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Ventas;

public class Control_datos_venta {
	private String _usuario="root";
	private String _pwd= "";
	private static String _bd="sistema_contable";
	static String _url = "jdbc:mysql://localhost/"+_bd;
	private Connection conn = null;
	static String sDriver="com.mysql.jdbc.Driver";
	 public Control_datos_venta(){
		 try{
		     Class.forName("com.mysql.jdbc.Connection");
		     conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
		     if(conn != null)
		     {
		       System.out.println("Conexion a base de datos "+_url+" . . . Ok");
		     }
		   }
		   catch(SQLException ex)
		   {
		      System.out.println("Hubo un problema al intentar conecarse a la base de datos"+_url);
		   }
		   catch(ClassNotFoundException ex)
		   {
			   System.out.println("error");
		   }  
	 }
	public void registrarVenta(Ventas v, String id_prod) {
		System.out.println(v.getComprador()+" "+v.getCantidad()+" "+v.getDiaVenta()+"-"+v.getMesVenta()+"-"+v.getAñoVenta());
		try {
			Class.forName(sDriver).newInstance();
			String query="INSERT INTO venta VALUES  (null,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,v.getComprador());
			stmt.setInt(2,Integer.parseInt(v.getCantidad()));
			stmt.setString(3,v.getAñoVenta()+"-"+v.getMesVenta()+"-"+v.getDiaVenta());
			stmt.setInt(4,Integer.parseInt(id_prod));
			stmt.setInt(5,1);
			stmt.executeUpdate();
	
	
	}catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Error");
		e.printStackTrace();
	}
		
	}

}
