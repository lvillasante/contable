package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.Control_datos_empleado;
import dao.Control_datos_productos;
import dao.Modelo_dao_proveedor;
import modelo.Empleado;
import modelo.Fechas;
import vistas_pc2.InterfazBmenu_de_opciones;

public class Bcontrol_menu_principal implements ActionListener{
	Empleado usuario;
	Fechas f;
	Control_datos_productos cdp=new Control_datos_productos();
	Modelo_dao_proveedor cdprov=new Modelo_dao_proveedor();
	public Empleado getUsuario() {
		return usuario;
	}
	public void setUsuario(Empleado usuario) {
		this.usuario = usuario;
	}
	InterfazBmenu_de_opciones imo;
	Control_datos_empleado control_datos_empleado;
	public Bcontrol_menu_principal(Empleado usuario) {
		this.usuario=usuario;
		imo=new InterfazBmenu_de_opciones();
		f=new Fechas();
		imo.btnEstadoDeResultados.addActionListener(this);
		imo.btnMostrarInventarios.addActionListener(this);
		imo.btnRegistrarCompra.addActionListener(this);
		imo.btnRegistrarGastos.addActionListener(this);
		imo.btnRegistrarVenta.addActionListener(this);
		imo.btnSalir.addActionListener(this);
		control_datos_empleado=new Control_datos_empleado();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==imo.btnRegistrarCompra) {
			System.out.println(usuario.getNombre()+","+usuario.getContraseña());
			if(control_datos_empleado.verificaPropietario(usuario)) {
				imo.dispose();
				Ccontrol_obtener_datos_interfaz_compra cmic=new Ccontrol_obtener_datos_interfaz_compra(this);
				cmic.mostrar();
			}
		}
		if(e.getSource()==imo.btnRegistrarVenta) {
			imo.dispose();
			Econtrol_obtener_datos_interfaz_venta codiv=new Econtrol_obtener_datos_interfaz_venta(this);
			codiv.mostrar();
		}
		if(e.getSource()==imo.btnRegistrarGastos) {
			if(control_datos_empleado.verificaPropietario(usuario)) {
				imo.dispose();
				Gcontrol_datos_gastos codg=new Gcontrol_datos_gastos(this);
				codg.mostrar();
			}
		}
		if(e.getSource()==imo.btnMostrarInventarios) {
			
		}
		if(e.getSource()==imo.btnEstadoDeResultados) {
			if(control_datos_empleado.verificaPropietario(usuario)) {
				
			}
		}
		if(e.getSource()==imo.btnSalir) {
			imo.dispose();
			AcontroladorIniciarSesion iB=new AcontroladorIniciarSesion();
			iB.iniciar();
		}

	}
	public void mostrarInterfazMenu() {
		imo.setVisible(true);
		imo.setLocationRelativeTo(null);
	}
}
