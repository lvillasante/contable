package modelo;

public class Proveedor {
	String nombreProv="";
	String nombreEmpresa="";
	String direccion="";
	String telefono="";
	public String getNombreProv() {
		return nombreProv;
	}
	public void setNombreProv(String nombreProv) {
		this.nombreProv = nombreProv;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public Proveedor() {
		
	}
	public void establecerDatosARegistrar(String direccion,String empresa,String nombre,String telefono) {
		// TODO Auto-generated method stub
		setDireccion(direccion);
		setNombreEmpresa(empresa);
		setNombreProv(nombre);
		setTelefono(telefono);
	}
}
