package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Gastos;

public class Modelo_datos_gasto {
	private String _usuario="root";
	private String _pwd= "";
	private static String _bd="sistema_contable";
	static String _url = "jdbc:mysql://localhost/"+_bd;
	private Connection conn = null;
	static String sDriver="com.mysql.jdbc.Driver";
	 public Modelo_datos_gasto(){
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
	public void registrarGasto(Gastos g) {
		try {
			Class.forName(sDriver).newInstance();
			String query="INSERT INTO gastos VALUES  (null,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			System.out.println(g.getTipo()+" "+g.getMotivo()+" "+g.getAñoGasto()+"-"+g.getMesGasto()+"-"+g.getDiaGasto()+" "+g.getPrecio());
			stmt.setString(1,g.getTipo());
			stmt.setString(2,g.getMotivo());
			stmt.setString(3,g.getAñoGasto()+"-"+g.getMesGasto()+"-"+g.getDiaGasto());
			stmt.setDouble(4,Double.parseDouble(g.getPrecio()));
			stmt.setInt(5,1);
			stmt.executeUpdate();
	
	
	}catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Error");
		e.printStackTrace();
	}
		
	}
	 
}
