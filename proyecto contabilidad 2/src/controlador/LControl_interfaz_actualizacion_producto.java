package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Producto;
import vistas_pc2.InterfazGActualizarProducto;

public class LControl_interfaz_actualizacion_producto implements ActionListener {
	InterfazGActualizarProducto iap;
	Producto prod;
	KControl_interfaz_registra_producto cirp;
	public LControl_interfaz_actualizacion_producto(KControl_interfaz_registra_producto cirp) {
		this.cirp=cirp;
		// TODO Auto-generated constructor stub
		iap=new InterfazGActualizarProducto();
		iap.getBotonBuscar().addActionListener(this);
		prod=new Producto();
		iap.getBtnActualizar().addActionListener(this);
		iap.getBtnSalir().addActionListener(this);
	}

	public void mostrar() {
		iap.setVisible(true);
		iap.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==iap.getBotonBuscar()) {
			if(cirp.cdic.codip.cmp.cdp.confirmarExistencia(iap.getTextFieldID().getText())) {
				cirp.cdic.codip.cmp.cdp.buscarDatosProductos(iap.getTextFieldID().getText(),prod);
				System.out.println(prod.getNombre());
				iap.establecerDatosEncontrados(prod);
			}else {
				iap.mostrarMensaje("El producto buscado no existe\n registre este producto");
			}
		
		}
		if(e.getSource()==iap.getBtnActualizar()) {
			if(cirp.cdic.codip.cmp.cdp.confirmarExistencia(iap.getTextFieldID().getText())) {
				prod.setNombre(iap.getTextField_nombre().getText());
				prod.setPrecio(iap.getTextField_precio().getText());
				prod.setStock(iap.getTextField_cantidad().getText());
				cirp.cdic.codip.cmp.cdp.actualizarDatosProducto(iap.getTextFieldID().getText(),prod);
			}
		}
		if(e.getSource()==iap.getBtnSalir()) {
			//volver a menu de opciones
			cirp.cdic.codip.mostrar();
			iap.dispose();
		}
	}

}
