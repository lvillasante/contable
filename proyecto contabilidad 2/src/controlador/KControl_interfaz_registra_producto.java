package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import dao.Modelo_dao_tipoProducto;
import modelo.Producto;
import vistas_pc2.InterfazGRegistroProductos;

public class KControl_interfaz_registra_producto implements ItemListener,ActionListener{
	InterfazGRegistroProductos irp;
	Modelo_dao_tipoProducto mdtp;
	Producto prod;
	Dcontrol_interfaz_compra cdic;
	public KControl_interfaz_registra_producto(Dcontrol_interfaz_compra cdic) {
		this.cdic=cdic;
		// TODO Auto-generated constructor stub
		mdtp=new Modelo_dao_tipoProducto();
		irp=new InterfazGRegistroProductos(mdtp.obtenerNombreTipos());
		irp.getComboBox_nombre_tipo().addItemListener(this);
		prod=new Producto();
		irp.getBtnActualizarProducto().addActionListener(this);
		irp.getBtnSalir().addActionListener(this);
		irp.getBtnRegistrar().addActionListener(this);
		irp.getComboBox_nombre_tipo().addItemListener(this);
	}

	public void mostrarInterfazRegistraProducto() {
		irp.setVisible(true);
		irp.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent eb) {
		if(eb.getSource()==irp.getBtnActualizarProducto()) {
			LControl_interfaz_actualizacion_producto ciap=new LControl_interfaz_actualizacion_producto(this);
			ciap.mostrar();
			irp.dispose();
		}
		if(eb.getSource()==irp.getBtnSalir()) {
			cdic.codip.mostrar();
			irp.dispose();
		}
		if(eb.getSource()==irp.getBtnRegistrar()) {
			prod.setNombre(irp.getTextField_nombre().getText());
			prod.setPrecio(irp.getTextField_precio().getText());
			prod.setStock(irp.getTextField_cantidad().getText());
			cdic.codip.cmp.cdp.registrarProducto(prod,mdtp.buscarId(prod.getTipo()));
		}
	}

	@Override
	public void itemStateChanged(ItemEvent ec) {
		if(ec.getSource()==irp.getComboBox_nombre_tipo()) {
			prod.setTipo(""+irp.getComboBox_nombre_tipo().getSelectedItem());
		}
	}

}
