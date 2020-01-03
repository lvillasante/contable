package controlador;

import java.util.ArrayList;

import dao.Control_datos_productos;
import dao.Modelo_dao_proveedor;
import vistas_pc2.InterfazDCompras;

public class Ccontrol_obtener_datos_interfaz_compra {
	InterfazDCompras ic;
//	Control_datos_productos cdp=new Control_datos_productos();
//	Control_datos_proveedor cdprov=new Control_datos_proveedor();
    ArrayList<String>productos=new ArrayList();
    ArrayList<String>proveedores=new ArrayList();
    Dcontrol_interfaz_compra cf;
    Bcontrol_menu_principal cmp;
	public Ccontrol_obtener_datos_interfaz_compra(Bcontrol_menu_principal cmp) {
		this.cmp=cmp;
		solicitarInterfazDCompras();
	}

	private void solicitarInterfazDCompras() {
		// TODO Auto-generated method stub
		cmp.cdp.buscarDatosProductos(productos);
		String[] nombreEst=new String[productos.size()];
		volverEstatico(nombreEst,productos);
		cmp.cdprov.buscarNombreProveedores(proveedores);
		String []provEst=new String[proveedores.size()];
		volverEstatico(provEst,proveedores);
		ic=new InterfazDCompras(nombreEst,provEst);
		cf=new Dcontrol_interfaz_compra(this);
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
		ic.setVisible(true);
		ic.setLocationRelativeTo(null);
	}
}
