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
	public String getAñoVenta() {
		return añoVenta;
	}
	public void setAñoVenta(String añoVenta) {
		this.añoVenta = añoVenta;
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
	String añoVenta="";
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
