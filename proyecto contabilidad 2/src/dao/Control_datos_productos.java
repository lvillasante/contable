package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

import modelo.Producto;

public class Control_datos_productos {
	private String _usuario="root";
	private String _pwd= "";
	private static String _bd="sistema_contable";
	static String _url = "jdbc:mysql://localhost/"+_bd;
	private Connection conn = null;
	static String sDriver="com.mysql.jdbc.Driver";
	public Control_datos_productos() {
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
	public <T> void buscarDatosProductos(ArrayList<T> nombres) {
		String sql="select nomb_prod from productos p";
		Statement state = null;
	    ResultSet resultado = null;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			while(resultado.next()) {
				nombres.add((T) resultado.getString("nomb_prod"));
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
	}
	public <T> void buscarPreciosProductos(ArrayList<T> precios) {
		String sql="select precio_prod from productos p";
		Statement state = null;
	    ResultSet resultado = null;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			while(resultado.next()) {
				precios.add((T) resultado.getString("precio_prod"));
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
		
	}
	public String buscarIdProd(String nombre) {
		String sql="select id_prod from productos p where p.nomb_prod='"+nombre+"'",id_prod="";
		Statement state = null;
	    ResultSet resultado = null;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			while(resultado.next()) {
				id_prod=resultado.getString("id_prod");
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
		System.out.println(id_prod);
		return id_prod;
	}
	public String obtenerPrecio(String nombre) {
		String sql="select precio_prod from productos p where p.nomb_prod='"+nombre+"'";
		Statement state = null;
	    ResultSet resultado = null;
		String precio="";

		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			while(resultado.next()) {
				precio=resultado.getString("precio_prod");
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
		return precio;
	}
	public String buscarCantidad(String nombre) {
		// TODO Auto-generated method stub
		String sql="select stock from productos p where p.nomb_prod='"+nombre+"'";
		Statement state = null;
	    ResultSet resultado = null;
		String stock="";

		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			while(resultado.next()) {
				stock=resultado.getString("stock");
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
		return stock;	}
	public void actualizarStock() {
		
	}
	public void registrarProducto(Producto prod, String id) {
		try {
			Class.forName(sDriver).newInstance();
			String query="INSERT INTO productos VALUES  (null,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,prod.getNombre());
			stmt.setInt(2,Integer.parseInt(id));
			stmt.setDouble(3,Double.parseDouble(prod.getPrecio()));
			stmt.setInt(4,Integer.parseInt(prod.getStock()));
			stmt.executeUpdate();
	
	
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	public boolean confirmarExistencia(String id) {
		String sql="select id_prod from productos where id_prod="+id;
		Statement state = null;
	    ResultSet resultado = null;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			return resultado.first();
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
		return false;
	}
	public void buscarDatosProductos(String id, Producto prod) {
		String sql="select nomb_prod,tipo_prod_idtipo_prod,precio_prod,stock from productos p where p.id_prod="+id;
		Statement state = null;
	    ResultSet resultado = null;
	    String nombre = null;
	    int tipo = 0,stock = 0;
	    double precio = 0;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			System.out.println("funciona");
			while(resultado.next()) {
				nombre=(resultado.getString("nomb_prod"));
				tipo=(resultado.getInt("tipo_prod_idtipo_prod"));
				precio=(resultado.getDouble("precio_prod"));
				stock=(resultado.getInt("stock"));
			}
			
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
		prod.setNombre(nombre);
		prod.setTipo(tipo+"");
		prod.setPrecio(precio+"");
		prod.setStock(stock+"");
	}
	public void actualizarDatosProducto(String id_prod, Producto prod) {
	    try {
	    	 Statement state = null;
	 		state=(Statement) conn.createStatement();
			state.execute("update productos set nomb_prod=\""+prod.getNombre()+"\" where id_prod="+id_prod);
			 state.execute("update productos set precio_prod="+prod.getPrecio()+" where id_prod="+id_prod);
		     state.execute("update productos set stock="+prod.getStock()+" where id_prod="+id_prod);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
