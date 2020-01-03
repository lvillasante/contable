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


public class InterfazDCompras extends JFrame {

	private JTextField textField_costo;
	private JTextField textField_cantidad;
	private JButton btnRegistrar;
	private JButton btnSalir;
	String[] meses= {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
	String[] años= {"2000","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2001","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040"};
	String[] dias= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private JComboBox comboBox_Meses;
	private String[]productos;
	private String[]proveedores;
	private JComboBox comboBox_años;
	private JButton btnRegistrarProveedor;
	private JButton btnRegistrarProducto;
	private JComboBox comboBox_productos;
	private JComboBox comboBox_proveedores;
	public JTextField getTextField_costo() {
		return textField_costo;
	}

	public void setTextField_costo(JTextField textField_costo) {
		this.textField_costo = textField_costo;
	}

	public JTextField getTextField_cantidad() {
		return textField_cantidad;
	}

	public void setTextField_cantidad(JTextField textField_cantidad) {
		this.textField_cantidad = textField_cantidad;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JComboBox getComboBox_Meses() {
		return comboBox_Meses;
	}

	public void setComboBox_Meses(JComboBox comboBox_Meses) {
		this.comboBox_Meses = comboBox_Meses;
	}

	public JComboBox getComboBox_años() {
		return comboBox_años;
	}

	public void setComboBox_años(JComboBox comboBox_años) {
		this.comboBox_años = comboBox_años;
	}

	public JComboBox getComboBox_productos() {
		return comboBox_productos;
	}

	public void setComboBox_productos(JComboBox comboBox_productos) {
		this.comboBox_productos = comboBox_productos;
	}

	public JComboBox getComboBox_proveedores() {
		return comboBox_proveedores;
	}

	public void setComboBox_proveedores(JComboBox comboBox_proveedores) {
		this.comboBox_proveedores = comboBox_proveedores;
	}

	public JComboBox getComboBox_Dias() {
		return comboBox_Dias;
	}

	public void setComboBox_Dias(JComboBox comboBox_Dias) {
		this.comboBox_Dias = comboBox_Dias;
	}

	private JComboBox comboBox_Dias;

	/**
	 * Create the frame.
	 * @param nombreEst 
	 * @param provEst 
	 * @param vendedor 
	 */
	public InterfazDCompras(String[] productos, String[] proveedores) {
		this.productos=productos;
		this.proveedores=proveedores;
		setTitle("Registro de Compra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		fondo contentPane = new fondo("panel.jpg");
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label.setBackground(new Color(240, 240, 240));
		label.setBounds(0, 59, 364, 515);
		contentPane.add(label);
		ImageIcon logo= new ImageIcon(getClass().getResource("puertas.jpg"));
		ImageIcon icono= new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono);
		
		JLabel label_1 = new JLabel("SISTEMA CONTABLE FERRETERIA \"BERNABE\"");
		label_1.setForeground(new Color(227, 231, 175));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 26));
		label_1.setBounds(135, 27, 585, 27);
		contentPane.add(label_1);
		
		JLabel lblbienvenido = new JLabel("Registro de Compra");
		lblbienvenido.setForeground(new Color(33, 33, 33));
		lblbienvenido.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblbienvenido.setBounds(487, 80, 248, 37);
		contentPane.add(lblbienvenido);
		
		JLabel lblIngreseSusDatos = new JLabel("Complete los campos vacios");
		lblIngreseSusDatos.setForeground(new Color(117, 117, 117));
		lblIngreseSusDatos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblIngreseSusDatos.setBounds(487, 139, 248, 36);
		contentPane.add(lblIngreseSusDatos);
		
		
		
		btnRegistrar = new JButton("Registrar Compra");
		btnRegistrar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.setBackground(new Color(117, 117, 117));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBounds(527, 486, 154, 33);
		contentPane.add(btnRegistrar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(117, 117, 117));
		btnSalir.setBounds(527, 585, 154, 33);
		contentPane.add(btnSalir);
		
		JLabel lblNombre = new JLabel("Seleccione Proveedor:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(403, 186, 182, 36);
		contentPane.add(lblNombre);
		
		JLabel lblNombreDeUsuario = new JLabel("Seleccione el Producto:");
		lblNombreDeUsuario.setForeground(new Color(255, 255, 255));
		lblNombreDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombreDeUsuario.setBounds(403, 260, 200, 36);
		contentPane.add(lblNombreDeUsuario);
		
		
		
		textField_cantidad = new JTextField();
		textField_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_cantidad.setColumns(10);
		textField_cantidad.setBounds(479, 370, 67, 30);
		contentPane.add(textField_cantidad);
		
		JLabel lblContrasea = new JLabel("Cantidad:");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblContrasea.setBounds(403, 338, 124, 36);
		contentPane.add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Fecha:");
		lblConfirmarContrasea.setForeground(new Color(255, 255, 255));
		lblConfirmarContrasea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblConfirmarContrasea.setBounds(403, 411, 154, 36);
		contentPane.add(lblConfirmarContrasea);
		
	    JSeparator separator = new JSeparator();
	    separator.setForeground(new Color(93, 64, 55));
	    separator.setBackground(new Color(93, 64, 55));
	    separator.setBounds(374, 530, 460, 10);
	    contentPane.add(separator);
	    
	    JSeparator separator_2 = new JSeparator();
	    separator_2.setForeground(new Color(93, 64, 55));
	    separator_2.setBackground(new Color(93, 64, 55));
	    separator_2.setBounds(374, 181, 460, 10);
	    contentPane.add(separator_2);
	    
	    
	    
		
		
	    comboBox_productos = new JComboBox(this.productos);
	    comboBox_productos.setBounds(479, 297, 213, 30);
	    contentPane.add(comboBox_productos);
	    
	    textField_costo = new JTextField();
		textField_costo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_costo.setBounds(667, 370, 87, 30);
		contentPane.add(textField_costo);
		textField_costo.setColumns(10);
	    
		 
	    comboBox_proveedores = new JComboBox(this.proveedores);
	    comboBox_proveedores.setBounds(479, 219, 178, 30);
	    contentPane.add(comboBox_proveedores);
		
		
	    comboBox_Meses = new JComboBox(meses);
	    comboBox_Meses.setBounds(538, 458, 93, 26);
	    contentPane.add(comboBox_Meses);
	    
	    comboBox_Dias = new JComboBox(dias);
	    comboBox_Dias.setBounds(641, 458, 79, 26);
	    contentPane.add(comboBox_Dias);
	    
	    comboBox_años = new JComboBox(años);
	    comboBox_años.setBounds(480, 458, 48, 26);
	    contentPane.add(comboBox_años);
	    

	    
	    JLabel lblPrecio = new JLabel("Costo total:");
	    lblPrecio.setForeground(Color.WHITE);
	    lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 16));
	    lblPrecio.setBounds(609, 338, 124, 36);
	    contentPane.add(lblPrecio);
	   
	    
	    JTable table_1 = new JTable();
	    table_1.setBackground(new Color(93, 64, 55));
	    table_1.setBounds(394, 183, 426, 347);
	    contentPane.add(table_1);
	    
	    JTable table1 = new JTable();
	    table1.setBackground(new Color(93, 64, 55));
	    table1.setBounds(656, 119, 178, 22);
	    contentPane.add(table1);
	    
	    JTable table2 = new JTable();
	    table2.setBackground(new Color(93, 64, 55));
	    table2.setBounds(374, 119, 178, 22);
	    contentPane.add(table2);
	    
	    btnRegistrarProveedor = new JButton("Registrar Nuevo Proveedor");
	    btnRegistrarProveedor.setForeground(Color.WHITE);
	    btnRegistrarProveedor.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnRegistrarProveedor.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	    btnRegistrarProveedor.setBackground(new Color(117, 117, 117));
	    btnRegistrarProveedor.setBounds(374, 541, 211, 33);
	    contentPane.add(btnRegistrarProveedor);
	    
	    btnRegistrarProducto = new JButton("Registrar Nuevo Producto");
	    btnRegistrarProducto.setForeground(Color.WHITE);
	    btnRegistrarProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnRegistrarProducto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	    btnRegistrarProducto.setBackground(new Color(117, 117, 117));
	    btnRegistrarProducto.setBounds(623, 541, 211, 33);
	    contentPane.add(btnRegistrarProducto);
	}

	public JButton getBtnRegistrarProducto() {
		return btnRegistrarProducto;
	}

	public void setBtnRegistrarProducto(JButton btnRegistrarProducto) {
		this.btnRegistrarProducto = btnRegistrarProducto;
	}

	public JButton getBtnRegistrarProveedor() {
		return btnRegistrarProveedor;
	}

	public void setBtnRegistrarProveedor(JButton btnRegistrarProveedor) {
		this.btnRegistrarProveedor = btnRegistrarProveedor;
	}

	public String[] getProductos() {
		return productos;
	}

	public void setProductos(String[] productos) {
		this.productos = productos;
	}

	public String[] getProveedores() {
		return proveedores;
	}

	public void setProveedores(String[] proveedores) {
		this.proveedores = proveedores;
	}
	
	
}
