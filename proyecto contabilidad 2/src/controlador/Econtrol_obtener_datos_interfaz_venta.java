package controlador;

import java.util.ArrayList;

import dao.Control_datos_productos;
import vistas_pc2.InterfazCVentas;

public class Econtrol_obtener_datos_interfaz_venta {
	public InterfazCVentas iv;
	Control_datos_productos cdp=new Control_datos_productos();
    ArrayList<String>productos=new ArrayList();
    Fcontrol_datos_interfaz_venta cdiv;
    Bcontrol_menu_principal cmp;
	public Econtrol_obtener_datos_interfaz_venta(Bcontrol_menu_principal cmp) {
		this.cmp=cmp;
		solicitarInterfazDCompras();
	}

	private void solicitarInterfazDCompras() {
		// TODO Auto-generated method stub
		cdp.buscarDatosProductos(productos);
		String[] nombreEst=new String[productos.size()];
		volverEstatico(nombreEst,productos);
		System.out.println(productos);
		System.out.println(nombreEst[0]);
		iv=new InterfazCVentas(nombreEst,(String)cdp.buscarCantidad(nombreEst[0]));
		iv.getTextFieldPrecio().setText(cdp.obtenerPrecio(nombreEst[0]));
		cdiv=new Fcontrol_datos_interfaz_venta(this);
	}

	private void volverEstatico(String[] nombreEst, ArrayList<String> nombres2) {
		// TODO Auto-generated method stub
		int i=0;
		for(String tipo:nombres2) {
			nombreEst[i]=tipo;
			i++;
		}
	}


	public void mostrar() {
		// TODO Auto-generated method stub
		iv.setVisible(true);
		iv.setLocationRelativeTo(null);
	}

	public void obtenerControlMenuPrincipal() {
		cmp=new Bcontrol_menu_principal(cmp.getUsuario());
		cmp.mostrarInterfazMenu();
	}
}
