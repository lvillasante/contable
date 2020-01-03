package vistas_pc2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import Fondo.fondo;
import modelo.Ventas;




public class InterfazCVentas extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazCVentas frame = new InterfazCVentas(null,null);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private fondo contentPane;
	private JComboBox comboBox_meses;
	String[] meses= {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
	String[] años= {"2000","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2001","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040"};
	String[] dias= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String cantidad;
	private JComboBox comboBox_años;
	private JComboBox comboBox_dias;
	private SpinnerNumberModel model;

	public SpinnerNumberModel getModel() {
		return model;
	}
	public void setModel(SpinnerNumberModel model) {
		this.model = model;
	}
	String productos[];
	public String[] getProductos() {
		return productos;
	}
	public void setProductos(String[] productos) {
		this.productos = productos;
	}
	private JTextField textFieldPrecio;
	private JComboBox comboBox_productos;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JTextField textField_comprador;
	private JTextField textField_cantidad;
	private JSpinner spinner;

	public JTextField getTextFieldPrecio() {
		return textFieldPrecio;
	}
	public void setTextFieldPrecio(JTextField textFieldPrecio) {
		this.textFieldPrecio = textFieldPrecio;
	}
	/**
	 * Create the frame.
	 * @param cantidad 
	 * @param nombreEst 
	 * @param vendedor ]
	 */	public InterfazCVentas(String[] productos, String cantidad) {
		 this.productos=productos;
		 this.cantidad=cantidad;
		setTitle("Registro");
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
		
		JLabel lblbienvenido = new JLabel("Registro de Venta");
		lblbienvenido.setForeground(new Color(33, 33, 33));
		lblbienvenido.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblbienvenido.setBounds(450, 80, 235, 37);
		contentPane.add(lblbienvenido);
		
		JLabel lblIngreseSusDatos = new JLabel("Complete los campos vacios");
		lblIngreseSusDatos.setForeground(new Color(117, 117, 117));
		lblIngreseSusDatos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblIngreseSusDatos.setBounds(441, 139, 248, 36);
		contentPane.add(lblIngreseSusDatos);
		
		textField_comprador = new JTextField();
		textField_comprador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_comprador.setColumns(10);/*
		textField_comprador.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textFieldKeyTyped(evt);
			}
		});*/
		textField_comprador.setBounds(426, 227, 294, 30);
		contentPane.add(textField_comprador);
		
	    btnIngresar = new JButton("Registrar Venta");
		btnIngresar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIngresar.setBackground(new Color(117, 117, 117));
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBounds(381, 515, 144, 33);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(117, 117, 117));
		btnSalir.setBounds(604, 515, 144, 33);
		contentPane.add(btnSalir);
		
		JLabel lblNombre = new JLabel("Nombre del Cliente:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(343, 186, 182, 36);
		contentPane.add(lblNombre);
		
		JLabel lblNombreDeUsuario = new JLabel("Seleccione el Producto:");
		lblNombreDeUsuario.setForeground(new Color(255, 255, 255));
		lblNombreDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombreDeUsuario.setBounds(343, 268, 200, 36);
		contentPane.add(lblNombreDeUsuario);
		
		
		model=new SpinnerNumberModel(new Integer(1),new Integer(1),new Integer(this.cantidad),new Integer(1));
		setModel(model);		
		spinner =new JSpinner(getModel());
		spinner.setBounds(426, 370, 124, 30);
		contentPane.add(spinner);

		
		textField_cantidad = new JTextField();
		textField_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_cantidad.setColumns(10);
		textField_cantidad.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textField_2KeyTyped(evt);
			}
		});
		textField_cantidad.setBounds(426, 370, 124, 30);
		contentPane.add(textField_cantidad);
		
		
		JLabel lblContrasea = new JLabel("Cantidad:");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblContrasea.setBounds(343, 344, 124, 36);
		contentPane.add(lblContrasea);
		
		
		
		
		JLabel lblConfirmarContrasea = new JLabel("Fecha de venta:");
		lblConfirmarContrasea.setForeground(new Color(255, 255, 255));
		lblConfirmarContrasea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblConfirmarContrasea.setBounds(343, 411, 154, 36);
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
	    
	    
	    comboBox_productos = new JComboBox(productos);
	    comboBox_productos.setBounds(426, 309, 215, 30);
	    contentPane.add(comboBox_productos);
	 
	    textFieldPrecio = new JTextField();
	    textFieldPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textFieldPrecio.setBounds(661, 370, 93, 30);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setEditable(false);
		textFieldPrecio.setColumns(10); 
	    
	    
	    comboBox_meses = new JComboBox();
	    comboBox_meses.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
	    comboBox_meses.setBounds(534, 458, 93, 26);
	    contentPane.add(comboBox_meses);
	    
	  
	    comboBox_dias = new JComboBox(dias);
	    comboBox_dias.setBounds(643, 458, 54, 26);
	    contentPane.add(comboBox_dias);
	   
	    

	 
	    comboBox_años = new JComboBox(años);
	    comboBox_años.setBounds(426, 458, 93, 26);
	    contentPane.add(comboBox_años);
	    
	    
	    
	    JTable table = new JTable();
	    table.setBackground(new Color(93, 64, 55));
	    table.setBounds(314, 183, 497, 376);
	    contentPane.add(table);
	    
	    JTable table1 = new JTable();
	    table1.setBackground(new Color(93, 64, 55));
	    table1.setBounds(643, 119, 178, 22);
	    contentPane.add(table1);
	    
	    JTable table2 = new JTable();
	    table2.setBackground(new Color(93, 64, 55));
	    table2.setBounds(304, 119, 178, 22);
	    contentPane.add(table2);
		this.repaint();
	
		
	}
	public JSpinner getSpinner() {
		return spinner;
	}
	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public JTextField getTextField_cantidad() {
		return textField_cantidad;
	}
	public void setTextField_cantidad(JTextField textField_cantidad) {
		this.textField_cantidad = textField_cantidad;
	}
	public JTextField getTextField_comprador() {
		return textField_comprador;
	}
	public void setTextField_comprador(JTextField textField_comprador) {
		this.textField_comprador = textField_comprador;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}
	public JButton getBtnIngresar() {
		return btnIngresar;
	}
	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}
	public JComboBox getComboBox_productos() {
		return comboBox_productos;
	}
	public void setComboBox_productos(JComboBox comboBox_productos) {
		this.comboBox_productos = comboBox_productos;
	}
	public JComboBox getComboBox_dias() {
		return comboBox_dias;
	}
	public void setComboBox_dias(JComboBox comboBox_dias) {
		this.comboBox_dias = comboBox_dias;
	}
	public JComboBox getComboBox_años() {
		return comboBox_años;
	}
	public void setComboBox_años(JComboBox comboBox_años) {
		this.comboBox_años = comboBox_años;
	}
	public JComboBox getComboBox_meses() {
		return comboBox_meses;
	}
	public void setComboBox_meses(JComboBox comboBox_meses) {
		this.comboBox_meses = comboBox_meses;
	}
	int seleccionado=0;
	InterfazBiniciar_sesion is=new InterfazBiniciar_sesion();
	int cp=0;
	
	
	private void textFieldKeyTyped(java.awt.event.KeyEvent evt) {
		
		char letr=evt.getKeyChar();
		if((letr<'a' || letr>'z') && (letr<'A' || letr>'Z') && (letr>' ')) evt.consume();
	}
	private void textField_2KeyTyped(java.awt.event.KeyEvent evt) {
		
		char num=evt.getKeyChar();
		if(num<'0' || num>'9') evt.consume();
	}
	public boolean mostrarMensasjeConfirmacion(Ventas v) {
		boolean acierto=false;
		 int selec2=JOptionPane.showConfirmDialog(null,"Realmente desea registrar la venta con los datos\nNombre del producto:  "+v.getProducto()+"\n"
					+ "Cantidad vendida:  "+v.getCantidad()
					+ "\nPrecio del producto:  "+v.getPrecio()+"\n"
					+ "Fecha de venta:  "+v.getDiaVenta()+"-"+v.getMesVenta()+"-"+v.getAñoVenta()+"\n"
					+ "Comprador:"+v.getComprador(), "Confirmar registro de nuevo producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		 if(selec2==0) {
			 acierto=true;
		 }
		 return acierto;
	}
	public void mostrarMensaje(String string) {
		JOptionPane.showMessageDialog(null, string);
	}
	
	 
}

