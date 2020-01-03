package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.Modelo_dao_proveedor;
import modelo.Proveedor;
import vistas_pc2.InterfazFRegistroProveedor;

public class JControl_interfaz_registra_proveedor implements ActionListener{
	InterfazFRegistroProveedor irprov;
	Proveedor prov;
	Modelo_dao_proveedor mcdp;
	Dcontrol_interfaz_compra cic;
	public JControl_interfaz_registra_proveedor(Dcontrol_interfaz_compra cic) {
		this.cic=cic;
		irprov=new InterfazFRegistroProveedor();
		prov=new Proveedor();
		mcdp=new Modelo_dao_proveedor();
		irprov.getBtnRegistrar().addActionListener(this);
		irprov.getBotonBuscar().addActionListener(this);
		irprov.getBtnSalir().addActionListener(this);
	}

	public void mostrarINterfazRegistraProveedor() {
		// TODO Auto-generated method stub
		irprov.setVisible(true);
		irprov.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==irprov.getBotonBuscar()) {
			if(mcdp.confirmarExistencia(irprov.getTextFieldID().getText())) {
				mcdp.buscarDatosConId(irprov.getTextFieldID().getText(),prov);
				irprov.asignarDatosInterfaz(prov);
			}else {
				irprov.mostrarMensaje("el proveedor que desea buscar no existe");
				
			}
		}
		if(e.getSource()==irprov.getBtnRegistrar()) {
			prov.establecerDatosARegistrar(irprov.getTextField_direccion().getText(),irprov.getTextField_nombre_empresa().getText(),irprov.getTextField_nombre().getText(),irprov.getTextFieldTelefono().getText());
			if(mcdp.confirmarExistencia(irprov.getTextFieldID().getText())) {
				mcdp.actualizarProveedor(irprov.getTextFieldID().getText(),prov);
				
			}else {
				mcdp.registrarProveedor(prov);
			}
		}
		if(e.getSource()==irprov.getBtnSalir()) {
			irprov.dispose();
			cic.codip.mostrar();
			
		}
	}


	
}
