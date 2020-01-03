package vistas_pc2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Fondo.fondo;


public class InterfazEGastos extends JFrame {

	private JPanel contentPane;
	private JTextField textField_tipo;
	private JTextField textField_costo;
	public JTextField getTextField_costo() {
		return textField_costo;
	}

	public void setTextField_costo(JTextField textField_costo) {
		this.textField_costo = textField_costo;
	}

	private JTextField textField_motivo;
	private JTable table;
	private JTable table1;
	private JTable table2;
	String[] meses= {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
	String[] años= {"2000","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2001","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040"};
	String[] dias= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private JButton btnIngresar;
	private JComboBox comboBox_meses;
	private JComboBox comboBox_años;
	private JButton btnSalir;
	private JComboBox comboBox_dias;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazEGastos frame = new InterfazEGastos();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param vendedor 
	 */
	public InterfazEGastos() {
		setTitle("Registro de Gastos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new fondo("panel.jpg");
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label.setBackground(new Color(240, 240, 240));
		label.setBounds(0, 59, 280, 515);
		contentPane.add(label);
		ImageIcon logo= new ImageIcon(getClass().getResource("puertas.jpg"));
		ImageIcon icono= new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono);
		
		JLabel label_1 = new JLabel("SISTEMA CONTABLE FERRETERIA \"BERNABE\"");
		label_1.setForeground(new Color(227, 231, 175));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 26));
		label_1.setBounds(135, 27, 585, 27);
		contentPane.add(label_1);
		
		JLabel lblbienvenido = new JLabel("Registro de Gastos");
		lblbienvenido.setForeground(new Color(33, 33, 33));
		lblbienvenido.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblbienvenido.setBounds(454, 80, 241, 37);
		contentPane.add(lblbienvenido);
		
		JLabel lblIngreseSusDatos = new JLabel("Complete los campos vacios");
		lblIngreseSusDatos.setForeground(new Color(117, 117, 117));
		lblIngreseSusDatos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblIngreseSusDatos.setBounds(449, 139, 248, 36);
		contentPane.add(lblIngreseSusDatos);
		
		textField_tipo = new JTextField();
		textField_tipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_tipo.setBounds(439, 227, 256, 30);
		contentPane.add(textField_tipo);
		textField_tipo.setColumns(10);
		
		btnIngresar = new JButton("Registrar Gasto");
		
		btnIngresar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIngresar.setBackground(new Color(117, 117, 117));
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBounds(376, 515, 144, 33);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(117, 117, 117));
		btnSalir.setBounds(607, 515, 144, 33);
		contentPane.add(btnSalir);
		
		JLabel lblNombre = new JLabel("Tipo de Gasto:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(343, 186, 182, 36);
		contentPane.add(lblNombre);
		
		JLabel lblNombreDeUsuario = new JLabel("Motivo o Servicio del Gasto: ");
		lblNombreDeUsuario.setForeground(new Color(255, 255, 255));
		lblNombreDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombreDeUsuario.setBounds(343, 268, 235, 36);
		contentPane.add(lblNombreDeUsuario);
		
		textField_motivo = new JTextField();
		textField_motivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_motivo.setColumns(10);
		textField_motivo.setBounds(439, 305, 256, 30);
		contentPane.add(textField_motivo);
		
		JLabel lblContrasea = new JLabel("Precio del Gasto:");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblContrasea.setBounds(343, 344, 153, 36);
		contentPane.add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Fecha:");
		lblConfirmarContrasea.setForeground(new Color(255, 255, 255));
		lblConfirmarContrasea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblConfirmarContrasea.setBounds(343, 420, 154, 36);
		contentPane.add(lblConfirmarContrasea);
		
	    JSeparator separator = new JSeparator();
	    separator.setForeground(new Color(93, 64, 55));
	    separator.setBackground(new Color(93, 64, 55));
	    separator.setBounds(304, 559, 518, 10);
	    contentPane.add(separator);
	    
	    JSeparator separator_2 = new JSeparator();
	    separator_2.setForeground(new Color(93, 64, 55));
	    separator_2.setBackground(new Color(93, 64, 55));
	    separator_2.setBounds(304, 181, 518, 10);
	    contentPane.add(separator_2);
	    
	  
	    comboBox_meses = new JComboBox();
	    comboBox_meses.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
	    comboBox_meses.setBounds(535, 447, 94, 26);
	    contentPane.add(comboBox_meses);

	    
	    comboBox_años = new JComboBox(años);
	    comboBox_años.setBounds(439, 447, 86, 26);
	    contentPane.add(comboBox_años);
	    
	    comboBox_dias = new JComboBox(dias);
  	    comboBox_dias.setBounds(639, 447, 58, 26);
  	    contentPane.add(comboBox_dias);
  
	    
	    
	    table1 = new JTable();
	    table1.setBackground(new Color(93, 64, 55));
	    table1.setBounds(648, 119, 178, 22);
	    contentPane.add(table1);
	    
	    table2 = new JTable();
	    table2.setBackground(new Color(93, 64, 55));
	    table2.setBounds(304, 119, 178, 22);
	    contentPane.add(table2);
	    
	    textField_costo = new JTextField();
	    textField_costo.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textField_costo.setColumns(10);
		textField_costo.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textField_1KeyTyped(evt);
			}
		});
	    textField_costo.setBounds(439, 384, 122, 30);
	    contentPane.add(textField_costo);
	    
	    table = new JTable();
	    table.setBackground(new Color(93, 64, 55));
	    table.setBounds(314, 183, 497, 376);
	    contentPane.add(table);
		this.repaint();
		
	}
	
    public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JTextField getTextField_motivo() {
		return textField_motivo;
	}

	public void setTextField_motivo(JTextField textField_motivo) {
		this.textField_motivo = textField_motivo;
	}

	public JTextField getTextField_tipo() {
		return textField_tipo;
	}

	public void setTextField_tipo(JTextField textField_tipo) {
		this.textField_tipo = textField_tipo;
	}

	public JComboBox getComboBox_años() {
		return comboBox_años;
	}

	public void setComboBox_años(JComboBox comboBox_años) {
		this.comboBox_años = comboBox_años;
	}

	public JComboBox getComboBox_dias() {
		return comboBox_dias;
	}

	public void setComboBox_dias(JComboBox comboBox_dias) {
		this.comboBox_dias = comboBox_dias;
	}

	public JComboBox getComboBox_meses() {
		return comboBox_meses;
	}

	public void setComboBox_meses(JComboBox comboBox_meses) {
		this.comboBox_meses = comboBox_meses;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public JTextField getTextField() {
		return textField_tipo;
	}

	public void setTextField(JTextField textField) {
		this.textField_tipo = textField;
	}

	private void textField_1KeyTyped(java.awt.event.KeyEvent evt) {
		
		char num=evt.getKeyChar();
		if((num<'0' || num>'9') && (num>'.' || num<'.')) evt.consume();
	}
}
