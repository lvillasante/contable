package modelo;

public class Empleado {
	private static String usuario;
	private static String contraseña;
	private String nombre;
	private String apelido;
	private String telefono;
	private String tipo;
	public Empleado(String usuario,String contraseña,String nombre,String apellido,String telefono,String tipo) {
		this.usuario=usuario;
		this.contraseña=contraseña;
		this.nombre=nombre;
		this.apelido=apellido;
		this.telefono=telefono;
		this.tipo=tipo;
	}
	public static String getUsuario() {
		return usuario;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Empleado(String usuario,String contraseña) {
		this.setUsuario(usuario);
		this.setContraseña(contraseña);
	}
	public Empleado() {
		this("","");
	}
	public  static  String getNombre() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public  static String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}
