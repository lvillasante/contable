package modelo;

public class Ventas {
	public String getMesVenta() {
		return mesVenta;
	}
	public void setMesVenta(String mesVenta) {
		this.mesVenta = mesVenta;
	}
	public String getDiaVenta() {
		return diaVenta;
	}
	public void setDiaVenta(String diaVenta) {
		this.diaVenta = diaVenta;
	}
	public String getA�oVenta() {
		return a�oVenta;
	}
	public void setA�oVenta(String a�oVenta) {
		this.a�oVenta = a�oVenta;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	String diaVenta="";
	String a�oVenta="";
	String producto="";
	String vendedor="";
	String mesVenta="";
	String cantidad="";
	String precio="";
	String comprador="";
	public String getComprador() {
		return comprador;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public void setComprador(String comprador) {
		this.comprador=comprador;
	}

}
