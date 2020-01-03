package modelo;

import javax.swing.JOptionPane;

public class Compra {
	private String id_prod;
	private String idProv;
	private int cantidad;
	private double costo;
	private String dia;
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}


	private String mes;
	private String año;
	public String getProducto() {
		return id_prod;
	}
	public void setProducto(String producto) {
		this.id_prod = producto;
	}
	public String getProveedor() {
		return idProv;
	}
	public void setProveedor(String proveedor) {
		this.idProv = proveedor;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public static boolean verificaDatosValidos(String productos, String proveedores, String cantidad, String costo,String fecha) {
		boolean acierto=true;
		try {
			int cantidadI=Integer.parseInt(cantidad);
			if(cantidadI<0) {
				acierto=false;
			}
		}catch(Exception e) {
			acierto=false;
			JOptionPane.showMessageDialog(null, "Cantidad no valida");
		}
		try {
			double costoD=Double.parseDouble(costo);
			if(costoD<0) {
				acierto=false;
			}
		}catch(Exception e) {
			acierto=false;
			JOptionPane.showMessageDialog(null,"Costo no valido");
		}
		return acierto;
	}


	public boolean confirmarRegistro() {
		boolean acierto=false;
		int selec=JOptionPane.showConfirmDialog(null, "Desea registrar la compra con los siguientes de datos:\nNombre del producto: "+id_prod+"\n"
				+ "Nombre del proveedor: "+idProv+"\n"
				+ "Cantidad comprada: "+cantidad+"\n"
				+ "Costo total de la compra: "+costo+"\n"
				+ "Fecha: "+año+"-"+mes+"-"+dia+"\n", "Confirmar registro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(selec==0) {
			acierto=true;
		}else {
			JOptionPane.showMessageDialog(null,"Ingrese datos nuevos y presione registrar nuevamente");
		}
		return acierto;
	}
}
