package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Empleado;
import vistas_pc2.InterfazPAutorizarNuevoVendedor;

public class Hcontrol_verifica_propietario implements ActionListener{
	AcontroladorIniciarSesion cis;
	InterfazPAutorizarNuevoVendedor ianv;
	private Empleado emp;
	int intentos=0;
	public Hcontrol_verifica_propietario(AcontroladorIniciarSesion cis){
		this.cis=cis;
		ianv=new InterfazPAutorizarNuevoVendedor();
		emp=new Empleado();
		ianv.getBtnIngresar().addActionListener(this);
		ianv.getBtnSalir().addActionListener(this);
	}
	public void mostrarInterfazValidacionPropietario() {
		ianv.setVisible(true);
		ianv.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ianv.getBtnIngresar()) {
			emp.setUsuario(ianv.getTextField_nombre().getText());
			emp.setContraseña(new String(ianv.getPasswordField_contraseña().getPassword()));
			if(cis.daoE.verificaPropietario(emp)) {
				Icontrol_registro_vendedor crv=new Icontrol_registro_vendedor();
				crv.setCvprop(this);
				crv.mostrar();
				ianv.dispose();
			}else {
				ianv.mostrarMensaje("Usted es vendedor no tiene autorizacion de registrar datos de otro vendedor\n o ingreso datos incorrectos");
			}
			intentos++;
			if(intentos>3) {
				cis.iniciar();
				ianv.dispose();
			}
		}
		if(e.getSource()==ianv.getBtnSalir()) {
			cis.iniciar();
			ianv.dispose();
		}
	}
	public void mostrarInterfazMenuPrincipal() {
		cis.iniciar();
	}

}
