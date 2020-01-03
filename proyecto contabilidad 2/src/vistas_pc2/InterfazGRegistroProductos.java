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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

import com.mysql.jdbc.PreparedStatement;

import Fondo.fondo;


public class InterfazGRegistroProductos extends JFrame {

	private JTextField textField_nombre;
	private JTextField textField_cantidad;
	private JTextField textField_precio;
	private String[] c;
	private String[] cid;
	
	boolean existe=true;
	boolean finalexiste=false;
	private JButton btnRegistrar;
	private JComboBox comboBox_nombre_tipo;
	private JButton btnActualizarProducto;
	private JButton btnSalir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGRegistroProductos frame = new InterfazGRegistroProductos(null);
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
	public InterfazGRegistroProductos(String c[]) {
		this.c=c;
		setTitle("Registrar de Nuevo Producto");
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
		
		JLabel lblbienvenido = new JLabel("Registrar Producto");
		lblbienvenido.setForeground(new Color(33, 33, 33));
		lblbienvenido.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblbienvenido.setBounds(452, 80, 254, 37);
		contentPane.add(lblbienvenido);
		
		JLabel lblIngreseSusDatos = new JLabel("Complete los campos vacios");
		lblIngreseSusDatos.setForeground(new Color(117, 117, 117));
		lblIngreseSusDatos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblIngreseSusDatos.setBounds(444, 139, 291, 36);
		contentPane.add(lblIngreseSusDatos);
		
	    comboBox_nombre_tipo = new JComboBox(c);
	    comboBox_nombre_tipo.setBounds(492, 285, 238, 30);
	    contentPane.add(comboBox_nombre_tipo);
	    
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(346, 215, 121, 36);
		contentPane.add(lblNombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_nombre.setColumns(10);
		textField_nombre.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textFieldKeyTyped(evt);
			}
		});
		textField_nombre.setBounds(492, 220, 238, 30);
		contentPane.add(textField_nombre);
		
		JLabel lblNombreDeUsuario = new JLabel("Tipo:");
		lblNombreDeUsuario.setForeground(new Color(255, 255, 255));
		lblNombreDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombreDeUsuario.setBounds(346, 280, 121, 36);
		contentPane.add(lblNombreDeUsuario);
		

	    textField_precio = new JTextField();
	    textField_precio.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    textField_precio.setColumns(10);
		textField_precio.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textField_1KeyTyped(evt);
			}
		});
	    textField_precio.setBounds(492, 350, 136, 30);
	    contentPane.add(textField_precio);
	    
		JLabel lblContrasea = new JLabel("Precio Unitario:");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblContrasea.setBounds(346, 345, 172, 36);
		contentPane.add(lblContrasea);
	    
	    
	    JLabel lblCantidad = new JLabel("Cantidad:");
	    lblCantidad.setForeground(Color.WHITE);
	    lblCantidad.setFont(new Font("Segoe UI", Font.BOLD, 16));
	    lblCantidad.setBounds(346, 410, 172, 36);
	    contentPane.add(lblCantidad);
	    
		textField_cantidad = new JTextField();
		textField_cantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_cantidad.setColumns(10);
		textField_cantidad.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textField_2KeyTyped(evt);
			}
		});
		textField_cantidad.setBounds(492, 415, 136, 30);
		contentPane.add(textField_cantidad);
	
		
	    JSeparator separator = new JSeparator();
	    separator.setForeground(new Color(93, 64, 55));
	    separator.setBackground(new Color(93, 64, 55));
	    separator.setBounds(307, 559, 511, 10);
	    contentPane.add(separator);
	    
	    JSeparator separator_2 = new JSeparator();
	    separator_2.setForeground(new Color(93, 64, 55));
	    separator_2.setBackground(new Color(93, 64, 55));
	    separator_2.setBounds(307, 181, 511, 10);
	    contentPane.add(separator_2);
	    
	    JTable table1 = new JTable();
	    table1.setBackground(new Color(93, 64, 55));
	    table1.setBounds(640, 119, 178, 22);
	    contentPane.add(table1);
	    
	    JTable table2 = new JTable();
	    table2.setBackground(new Color(93, 64, 55));
	    table2.setBounds(307, 119, 178, 22);
	    contentPane.add(table2);
	    
	    btnActualizarProducto = new JButton("Actualizar Producto");
	    btnActualizarProducto.setForeground(Color.WHITE);
	    btnActualizarProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
	    btnActualizarProducto.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	    btnActualizarProducto.setBackground(new Color(117, 117, 117));
	    btnActualizarProducto.setBounds(480, 520, 178, 33);
	    contentPane.add(btnActualizarProducto);
	 
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.setBackground(new Color(117, 117, 117));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBounds(370, 467, 144, 33);
		contentPane.add(btnRegistrar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(117, 117, 117));
		btnSalir.setBounds(614, 467, 144, 33);
		contentPane.add(btnSalir);
		
	    JTable table_1 = new JTable();
	    table_1.setBackground(new Color(93, 64, 55));
	    table_1.setBounds(317, 183, 493, 376);
	    contentPane.add(table_1);
		this.repaint();
	
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

	public JButton getBtnActualizarProducto() {
		return btnActualizarProducto;
	}

	public void setBtnActualizarProducto(JButton btnActualizarProducto) {
		this.btnActualizarProducto = btnActualizarProducto;
	}

	public JTextField getTextField_nombre() {
		return textField_nombre;
	}

	public void setTextField_nombre(JTextField textField_nombre) {
		this.textField_nombre = textField_nombre;
	}

	public JTextField getTextField_cantidad() {
		return textField_cantidad;
	}

	public void setTextField_cantidad(JTextField textField_cantidad) {
		this.textField_cantidad = textField_cantidad;
	}

	public JTextField getTextField_precio() {
		return textField_precio;
	}

	public void setTextField_precio(JTextField textField_precio) {
		this.textField_precio = textField_precio;
	}

	public JComboBox getComboBox_nombre_tipo() {
		return comboBox_nombre_tipo;
	}

	public void setComboBox_nombre_tipo(JComboBox comboBox_nombre_tipo) {
		this.comboBox_nombre_tipo = comboBox_nombre_tipo;
	}

	
		private void textFieldKeyTyped(java.awt.event.KeyEvent evt) {
			
			char letr=evt.getKeyChar();
			if((letr<'a' || letr>'z') && (letr<'A' || letr>'Z') && (letr>' ')) evt.consume();
		}
	    private void textField_1KeyTyped(java.awt.event.KeyEvent evt) {
			
			char num=evt.getKeyChar();
			if((num<'0' || num>'9') && (num>'.' || num<'.')) evt.consume();
		}
		private void textField_2KeyTyped(java.awt.event.KeyEvent evt) {
			
			char num=evt.getKeyChar();
			if(num<'0' || num>'9') evt.consume();
		}
}
