package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

import dao.Modelo_dao_compras;
import dao.Control_datos_productos;
import dao.Modelo_dao_proveedor;
import dao.Control_datos_venta;
import modelo.Compra;
import modelo.Fechas;
import modelo.Ventas;
import vistas_pc2.InterfazCVentas;
import vistas_pc2.InterfazDCompras;

public class Fcontrol_datos_interfaz_venta implements ItemListener,ActionListener{
	Econtrol_obtener_datos_interfaz_venta codiv;
	Fechas f;
	Ventas v=new Ventas();
	Control_datos_venta cdv;
	public Fcontrol_datos_interfaz_venta(Econtrol_obtener_datos_interfaz_venta cdoiv){
		this.codiv=cdoiv;
		codiv.iv.getComboBox_meses().addItemListener(this);
		codiv.iv.getComboBox_años().addItemListener(this);
		codiv.iv.getComboBox_dias().addItemListener(this);
		codiv.iv.getComboBox_productos().addItemListener(this);
		codiv.iv.getBtnIngresar().addActionListener(this);
		codiv.iv.getBtnSalir().addActionListener(this);
		codiv.mostrar();
		cdv=new Control_datos_venta();
/*
		v.setMesVenta((String)codiv.iv.getComboBox_meses().getSelectedItem());
		v.setDiaVenta((String)codiv.iv.getComboBox_dias().getSelectedItem());
		v.setAñoVenta((String)codiv.iv.getComboBox_años().getSelectedItem());
		v.setProducto((String)codiv.iv.getComboBox_productos().getSelectedItem());
*/
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==codiv.iv.getComboBox_meses()){
			v.setMesVenta(""+codiv.iv.getComboBox_meses().getSelectedIndex());
			f=new Fechas();
		    int nDias=f.numeroDeDiasMes(Integer.parseInt(v.getMesVenta())+1);
		    String[] cdias=new String[nDias];
			f.asignarDias(cdias,nDias);
			codiv.iv.getComboBox_dias().setModel(new DefaultComboBoxModel(cdias));
		}
		if(e.getSource()==codiv.iv.getComboBox_dias()) {
			v.setDiaVenta((String)codiv.iv.getComboBox_dias().getSelectedItem());
		}
		if(e.getSource()==codiv.iv.getComboBox_años()) {
			v.setAñoVenta((String)codiv.iv.getComboBox_años().getSelectedItem());
		}
		if(e.getSource()==codiv.iv.getComboBox_productos()) {
			v.setProducto((String)codiv.iv.getComboBox_productos().getSelectedItem());
			codiv.iv.getTextFieldPrecio().setText((codiv.cdp.obtenerPrecio(v.getProducto())));
			codiv.iv.getSpinner().setModel(new SpinnerNumberModel(new Integer(1),new Integer(1),new Integer(codiv.cdp.buscarCantidad(v.getProducto())),new Integer(1)));
			
		}
	}
	public void actionPerformed(ActionEvent eb) {
		// TODO Auto-generated method stub
		if(eb.getSource()==codiv.iv.getBtnIngresar()) {
			v.setCantidad(""+codiv.iv.getSpinner().getValue());
			v.setPrecio((String)codiv.iv.getTextFieldPrecio().getText());
			v.setComprador((String)codiv.iv.getTextField_comprador().getText());
			if(codiv.iv.mostrarMensasjeConfirmacion(v)) {
				System.out.println("si");
				String id_prod=codiv.cdp.buscarIdProd(v.getProducto());
				System.out.println(v.getComprador()+" "+v.getCantidad()+" "+v.getDiaVenta()+"-"+v.getMesVenta()+"-"+v.getAñoVenta());
				cdv.registrarVenta(v,id_prod);
			}else {
				codiv.iv.mostrarMensaje("Ingrese nuevo datos y intente nuevamente");
			}
		}
		if(eb.getSource()==codiv.iv.getBtnSalir()) {
			codiv.iv.dispose();
			codiv.obtenerControlMenuPrincipal();
		}
	}
}
