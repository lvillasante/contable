package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.Control_datos_empleado;
import modelo.Empleado;
import vistas_pc2.InterfazQCrearVendedor;

public class Icontrol_registro_vendedor implements ActionListener{
	InterfazQCrearVendedor icv;
	Empleado nuevo_empleado;
	Control_datos_empleado cde;
	private Hcontrol_verifica_propietario cvprop;
	public Hcontrol_verifica_propietario getCvprop() {
		return cvprop;
	}
	public void setCvprop(Hcontrol_verifica_propietario cvprop) {
		this.cvprop = cvprop;
	}
	public Icontrol_registro_vendedor() {
		icv=new InterfazQCrearVendedor();
		icv.getBtnIngresar().addActionListener(this);
		icv.getBtnSalir().addActionListener(this);
		nuevo_empleado=new Empleado();
		cde=new Control_datos_empleado();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==icv.getBtnIngresar() ) {
			if(new String(icv.getPasswordField_confirmacion_nueva().getPassword()).equals(new String(icv.getPasswordField_nueva_contraseña().getPassword()))){
				nuevo_empleado.setNombre(icv.getTextField_nombre().getText());
				nuevo_empleado.setApelido(icv.getTextField_apellido().getText());
				nuevo_empleado.setTelefono(icv.getTextField_telefono().getText());
				nuevo_empleado.setTipo("2");
				nuevo_empleado.setUsuario(icv.getTextField_nombre_usuario().getText());
				nuevo_empleado.setContraseña(new String(icv.getPasswordField_confirmacion_nueva().getPassword()));
				cde.registraNuevoVendedor(nuevo_empleado);
			}else {
				icv.mostrarMensaje("Las contraseñas no coninciden");
			}
		}
		if(e.getSource()==icv.getBtnSalir()) {
			icv.dispose();
			cvprop.mostrarInterfazMenuPrincipal();
			
		}
	}
	public void mostrar() {
		// TODO Auto-generated method stub
		icv.setVisible(true);
		icv.setLocationRelativeTo(null);
	}
}
