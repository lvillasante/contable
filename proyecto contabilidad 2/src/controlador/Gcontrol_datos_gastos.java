package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;

import dao.Modelo_datos_gasto;
import modelo.Fechas;
import modelo.Gastos;
import vistas_pc2.InterfazEGastos;

public class Gcontrol_datos_gastos implements ActionListener,ItemListener{
	InterfazEGastos ig;
	Bcontrol_menu_principal cmp;
	Gastos g;
	Modelo_datos_gasto mdg;
	public Gcontrol_datos_gastos(Bcontrol_menu_principal cmp) {
		this.cmp=cmp;
		g=new Gastos();
		ig=new InterfazEGastos();
		ig.getBtnIngresar().addActionListener(this);
		ig.getComboBox_años().addItemListener(this);
		ig.getComboBox_dias().addItemListener(this);
		ig.getComboBox_meses().addItemListener(this);
		ig.getBtnSalir().addActionListener(this);
		mdg=new Modelo_datos_gasto();
	}

	public void mostrar() {
		// TODO Auto-generated method stub
		ig.setVisible(true);
		ig.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ig.getBtnIngresar()) {
			g.setPrecio(ig.getTextField_costo().getText());
			g.setMotivo(ig.getTextField_motivo().getText());
			g.setTipo(ig.getTextField_tipo().getText());
			mdg.registrarGasto(g);
		}
		if(e.getSource()==ig.getBtnSalir()) {
			ig.dispose();
			cmp.mostrarInterfazMenu();;
		}
	}
	int mesSeleccionado=1;
	@Override
	public void itemStateChanged(ItemEvent ec) {
		if(ec.getSource()==ig.getComboBox_meses()) {
			g.setMesGasto(""+(ig.getComboBox_meses().getSelectedIndex()+1));
			int nDias=cmp.f.numeroDeDiasMes(mesSeleccionado+1);
		    String []cdias=new String[nDias];
		    cmp.f.asignarDias(cdias, nDias);
		    ig.getComboBox_dias().setModel(new DefaultComboBoxModel(cdias));
		}
		if(ec.getSource()==ig.getComboBox_dias()) {
			g.setDiaGasto(""+ig.getComboBox_dias().getSelectedItem());
		}
		if(ec.getSource()==ig.getComboBox_años()) {
			g.setAñoGasto(""+ig.getComboBox_años().getSelectedItem());
		}
	}
	
}
