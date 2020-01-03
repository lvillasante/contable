package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Proveedor;

public class Modelo_dao_proveedor {
	private String _usuario="root";
	private String _pwd= "";
	private static String _bd="sistema_contable";
	static String _url = "jdbc:mysql://localhost/"+_bd;
	private Connection conn = null;
	static String sDriver="com.mysql.jdbc.Driver";
	public Modelo_dao_proveedor() {
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
	public <T> void buscarNombreProveedores(ArrayList<T> nombres) {
		String sql="select nombreProv from proveedor p";
		Statement state = null;
	    ResultSet resultado = null;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			while(resultado.next()) {
				nombres.add((T) resultado.getString("nombreProv"));
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
	}
	public void buscarDatosConId(String id, Proveedor prov) {
		String sql="select id_prov,nombreProv,nombreEmpresa,direccion,telefono from proveedor prov where prov.id_prov="+id;
		Statement state = null;
	    ResultSet resultado = null;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			while(resultado.next()) {
				prov.setNombreProv(resultado.getString("nombreProv"));
				prov.setNombreEmpresa(resultado.getString("nombreEmpresa"));
				prov.setDireccion(resultado.getString("direccion"));
				prov.setTelefono(""+resultado.getInt("telefono"));
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
	}
	public boolean confirmarExistencia(String id) {
		String sql="select id_prov from proveedor where id_prov="+id;
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
	public void actualizarProveedor(String id_prov, Proveedor prov) {
		// TODO Auto-generated method stub
		
	     try {
	    	 Statement state = null;
	 		state=(Statement) conn.createStatement();
			state.execute("update proveedor set nombreProv=\""+prov.getNombreProv()+"\" where id_prov="+id_prov);
			 state.execute("update proveedor set nombreEmpresa=\""+prov.getNombreEmpresa()+"\" where id_prov="+id_prov);
		     state.execute("update proveedor set direccion=\""+prov.getDireccion()+"\" where id_prov="+id_prov);
		     state.execute("update proveedor set telefono=\""+prov.getTelefono()+"\" where id_prov="+id_prov);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void registrarProveedor(Proveedor prov) {
		try {
			Class.forName(sDriver).newInstance();
			String query="INSERT INTO proveedor VALUES  (null,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,prov.getNombreProv());
			stmt.setString(2,prov.getNombreEmpresa());
			stmt.setString(3,prov.getDireccion());
			stmt.setInt(4,Integer.parseInt(prov.getTelefono()));
			stmt.executeUpdate();
	
	
	}catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Error");
		e.printStackTrace();
	}
		
	}
	public String buscarIdProv(String nombre) {
		String sql="select id_prov from proveedor where nombreProv='"+nombre+"'",id_prov="";
		Statement state = null;
	    ResultSet resultado = null;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			while(resultado.next()) {
				id_prov=(resultado.getString("id_prov"));
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
		return id_prov;
	}

}
