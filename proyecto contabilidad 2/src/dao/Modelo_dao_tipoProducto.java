package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelo_dao_tipoProducto {
	private String _usuario="root";
	private String _pwd= "";
	private static String _bd="sistema_contable";
	static String _url = "jdbc:mysql://localhost/"+_bd;
	private Connection conn = null;
	static String sDriver="com.mysql.jdbc.Driver";
	public Modelo_dao_tipoProducto() {
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
	public String[] obtenerNombreTipos() {
		String sql="select nombre from tipo_prod tp";
		Statement state = null;
	    ResultSet resultado = null;
	    ArrayList<String>listaNombre=new ArrayList();
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			while(resultado.next()) {
				listaNombre.add( resultado.getString("nombre"));
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
		return convierteStatico(listaNombre);
	}
	private String[] convierteStatico(ArrayList<String> listaNombre) {
		String[] nombreEstatico=new String[listaNombre.size()];
		int i=0;
		for(String nombre:listaNombre) {
			nombreEstatico[i]=nombre;
			System.out.println(nombreEstatico[i]);
			i++;
		}
		return nombreEstatico;
	}
	public String buscarId(String tipo) {
		String id="";
		String sql="select idtipo_prod from tipo_prod tp where tp.nombre='"+tipo+"'";
		Statement state = null;
	    ResultSet resultado = null;
	    ArrayList<String>listaNombre=new ArrayList();
		try {
			state = (Statement) conn.createStatement();
			resultado = state.executeQuery(sql);
			while(resultado.next()) {
				id=( resultado.getString("idtipo_prod"));
			}
		}catch(Exception e) {
			System.out.println("Error");
			e.getStackTrace();
		}
		return id;
	}
	
}
