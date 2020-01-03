package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import dao.Modelo_dao_compras;
import modelo.Compra;

public class Dcontrol_interfaz_compra implements ActionListener,ItemListener{
	Ccontrol_obtener_datos_interfaz_compra codip;
	Compra c;
	Modelo_dao_compras mdc;
	JControl_interfaz_registra_proveedor cirp;
	KControl_interfaz_registra_producto cirprod;
	public Dcontrol_interfaz_compra(Ccontrol_obtener_datos_interfaz_compra codip) {
		this.codip=codip;
		codip.ic.getComboBox_años().addItemListener(this);
		codip.ic.getComboBox_Dias().addItemListener(this);
		codip.ic.getComboBox_Meses().addItemListener(this);
		codip.ic.getComboBox_productos().addItemListener(this);
		codip.ic.getComboBox_proveedores().addItemListener(this);
		codip.ic.getBtnRegistrarProducto().addActionListener(this);
		codip.ic.getBtnRegistrarProveedor().addActionListener(this);
		codip.ic.getBtnRegistrar().addActionListener(this);
		codip.ic.getBtnSalir().addActionListener(this);
		c=new Compra();
		mdc=new Modelo_dao_compras();
	}
	@Override
	public void itemStateChanged(ItemEvent ei) {
		if(ei.getSource()==codip.ic.getComboBox_años()) {
			c.setAño(""+codip.ic.getComboBox_años().getSelectedItem());
		}
		if(ei.getSource()==codip.ic.getComboBox_Dias()) {
			c.setDia(""+codip.ic.getComboBox_Dias().getSelectedItem());
		}if(ei.getSource()==codip.ic.getComboBox_Meses()) {
			c.setMes(""+(codip.ic.getComboBox_Meses().getSelectedIndex()+1));

		}if(ei.getSource()==codip.ic.getComboBox_productos()) {
			c.setProducto(""+codip.ic.getComboBox_productos().getSelectedItem());
			codip.ic.getTextField_costo().setText(codip.cmp.cdp.obtenerPrecio(c.getProducto()));
			
		}if(ei.getSource()==codip.ic.getComboBox_proveedores()) {
			c.setProveedor(""+codip.ic.getComboBox_proveedores().getSelectedItem());
		}
	}
	@Override
	public void actionPerformed(ActionEvent eb) {
		if(eb.getSource()==codip.ic.getBtnRegistrarProducto()) {
			codip.ic.dispose();
			cirprod=new KControl_interfaz_registra_producto(this);
			cirprod.mostrarInterfazRegistraProducto();
		}
		if(eb.getSource()==codip.ic.getBtnRegistrarProveedor()) {
			codip.ic.dispose();
			cirp=new JControl_interfaz_registra_proveedor(this);
			cirp.mostrarINterfazRegistraProveedor();
		}
		if(eb.getSource()==codip.ic.getBtnRegistrar()) {
			mdc.registrarCompra(c,codip.cmp.cdp.buscarIdProd(c.getProducto()),"1",codip.cmp.cdprov.buscarIdProv(c.getProveedor()));
			codip.cmp.cdp.actualizarStock();
		}if(eb.getSource()==codip.ic.getBtnSalir()) {
			codip.ic.dispose();
			codip.cmp.mostrarInterfazMenu();
		}
		
	}

}
