package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Empleado;
import modelo.Gastos;

public class Control_datos_empleado {
	private Connection conexion=null;
	private Statement st;
	private ResultSet rs;
	private String _usuario="root";
	 private String _pwd= "";
	 private static String _bd="sistema_contable";
	 static String _url = "jdbc:mysql://localhost/"+_bd;
	 private Connection conn = null;
	 static String sDriver="com.mysql.jdbc.Driver";

	 
	 public Control_datos_empleado() {
	  
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
	 /*
	
	public DAOEmpleado() {
		try{
		     Class.forName("com.mysql.jdbc.Connection");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sistema_contable","root","");
		     if(conexion != null)
		     {
		       System.out.println("Conexion a base de datos jdbc:mysql://localhost/sistema_contable . . . Ok");
		     }
		   }
		   catch(SQLException ex)
		   {
		      System.out.println("Hubo un problema al intentar conecarse a la base de datos jdbc:mysql://localhost/sistema_contable");
		   }
		   catch(ClassNotFoundException ex)
		   {
		      System.out.println(ex);
		   }  
	}
	Statement state = null;
    ResultSet resultado = null;
    */
	public boolean existeUsuario(Empleado v) {
		String sql="select * from empleado where usuario='"+v.getNombre()+"' and contraseña='"+v.getContraseña()+"'";
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
	}/*
	public ResultSet getQuery(String _query)
	 {
	    Statement state = null;
	    ResultSet resultado = null;
	    try{
	      state = (Statement) conn.createStatement();
	      resultado = state.executeQuery(_query);
	    }
	    catch(SQLException e)
	    {
	      e.printStackTrace();
	    }x
	    return resultado;
	 }*/
	public boolean verificaPropietario(Empleado usuario) {
		String sql="select tipo_usuario_id_tipo_usu from empleado where usuario='"+usuario.getNombre()+"' and contraseña='"+usuario.getContraseña()+"'";
		Statement state = null;
	    ResultSet resultado = null;
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			String tipo="";
			while(resultado.next()) {
				tipo=resultado.getString("tipo_usuario_id_tipo_usu");
			}
			System.out.println(tipo);
			if(Integer.parseInt(tipo)==1) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
		return false;
	}
	public void registraNuevoVendedor(Empleado ne) {
		try {
			Class.forName(sDriver).newInstance();
			String query="INSERT INTO empleado VALUES  (null,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,ne.getNombre());
			stmt.setString(2,ne.getApelido());
			stmt.setString(3,ne.getUsuario());
			stmt.setString(4,ne.getContraseña());
			stmt.setInt(5,Integer.parseInt(ne.getTelefono()));
			stmt.setInt(6,Integer.parseInt(ne.getTipo()));
			stmt.executeUpdate();
	
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}
