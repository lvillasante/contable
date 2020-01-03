package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Compra;

public class Modelo_dao_compras {
	Control_datos_productos cdp=new Control_datos_productos();
	Modelo_dao_proveedor cdprov=new Modelo_dao_proveedor();
	
	private Connection conexion=null;
	private Statement st;
	private ResultSet rs;
	private String _usuario="root";
	 private String _pwd= "";
	 private static String _bd="sistema_contable";
	 static String _url = "jdbc:mysql://localhost/"+_bd;
	 private Connection conn = null;
	 static String sDriver="com.mysql.jdbc.Driver";

	 
	 public Modelo_dao_compras() {
	  
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
	      System.out.println(ex);
	   }  
	 }
	public void registrarCompra(Compra c, String id_prod,String id_prop,String id_prov) {
		System.out.println(id_prod+" "+id_prop+" "+id_prov);
		 try {
			Class.forName(sDriver).newInstance();
				String query="INSERT INTO compras (id_comp,cantidad_Comprada,precioTotal,fecha,productos_id_prod,proveedor_id_prov,propietario_id_prop) values(null,?,?,?,?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setInt(1,c.getCantidad());
				stmt.setDouble(2,c.getCosto());
				stmt.setString(3,c.getAño()+"-"+c.getMes()+"-"+c.getDia());
				stmt.setInt(4,Integer.parseInt(id_prod));
				stmt.setInt(5,Integer.parseInt(id_prov));
				stmt.setInt(6,Integer.parseInt(id_prop));
				stmt.executeUpdate();
		
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
