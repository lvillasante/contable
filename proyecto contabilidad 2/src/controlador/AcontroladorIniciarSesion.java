package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.Control_datos_empleado;
import modelo.Empleado;
import vistas_pc2.InterfazBiniciar_sesion;

public class AcontroladorIniciarSesion implements ActionListener{
	InterfazBiniciar_sesion frame;
	Empleado usuario;
	Control_datos_empleado daoE;
	Bcontrol_menu_principal cmp;
	Hcontrol_verifica_propietario cvprop;
	public AcontroladorIniciarSesion() {
		frame = new InterfazBiniciar_sesion();
		usuario=new Empleado();
		cvprop=new Hcontrol_verifica_propietario(this);
		this.frame.btnIngresar.addActionListener(this);
		this.frame.btnSalir.addActionListener(this);
		this.frame.btnNuevoUsuario.addActionListener(this);
		daoE=new Control_datos_empleado();
	}
	public void iniciar() {
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==frame.btnNuevoUsuario) {
			this.frame.dispose();
			cvprop.mostrarInterfazValidacionPropietario();
			
		}
		if(e.getSource()==frame.btnSalir) {
			frame.dispose();
		}
		if(e.getSource()==frame.btnIngresar) {
			this.usuario.setUsuario(frame.textField.getText());
			this.usuario.setContraseña((new String(frame.passwordField.getPassword())));
			if(daoE.existeUsuario(usuario)) {
				cmp=new Bcontrol_menu_principal(usuario);
				cmp.mostrarInterfazMenu();
				this.frame.dispose();
			}
			else {
				JOptionPane.showMessageDialog(null,"Contraseña y/o nombre ingresados incorrectos");
			}
		}
	}
	public static void main(String []args) {
		AcontroladorIniciarSesion iB=new AcontroladorIniciarSesion();
		iB.iniciar();
	}
}
