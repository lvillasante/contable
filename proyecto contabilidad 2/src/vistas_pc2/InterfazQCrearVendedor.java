package vistas_pc2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.PreparedStatement;

import Fondo.fondo;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InterfazQCrearVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nombre;
	private JPasswordField passwordField_nueva_contraseña;
	private JTextField textField_apellido;
	private JTextField textField_nombre_usuario;
	private JTextField textField_telefono;
	private JPasswordField passwordField_confirmacion_nueva;
	private JButton btnIngresar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazQCrearVendedor frame = new InterfazQCrearVendedor();
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
	 */
	public InterfazQCrearVendedor() {
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
		label.setBounds(0, 55, 284, 519);
		contentPane.add(label);
		ImageIcon logo= new ImageIcon(getClass().getResource("puerta1.jpg"));
		ImageIcon icono= new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono);
		
		JLabel label_1 = new JLabel("SISTEMA CONTABLE FERRETERIA \"BERNABE\"");
		label_1.setForeground(new Color(227, 231, 175));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 26));
		label_1.setBounds(135, 27, 585, 27);
		contentPane.add(label_1);
		
		JLabel lblbienvenido = new JLabel("Registro del Usuario");
		lblbienvenido.setForeground(new Color(33, 33, 33));
		lblbienvenido.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblbienvenido.setBounds(444, 83, 247, 37);
		contentPane.add(lblbienvenido);
		
		JLabel lblIngreseSusDatos = new JLabel("Complete los campos vacios para el nuevo usuario");
		lblIngreseSusDatos.setForeground(new Color(117, 117, 117));
		lblIngreseSusDatos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblIngreseSusDatos.setBounds(355, 123, 479, 36);
		contentPane.add(lblIngreseSusDatos);
		
		textField_nombre = new JTextField();
		textField_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_nombre.setBounds(355, 227, 190, 30);
		textField_nombre.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textFieldKeyTyped(evt);
			}
		});
		textField_nombre.setColumns(10);
		contentPane.add(textField_nombre);
		
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(33, 33, 33));
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(355, 186, 111, 36);
		contentPane.add(lblNombre);
		
		JLabel lblApallido = new JLabel("Apellido:");
		lblApallido.setForeground(new Color(33, 33, 33));
		lblApallido.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblApallido.setBounds(575, 186, 124, 36);
		contentPane.add(lblApallido);
		
		textField_apellido = new JTextField();
		textField_apellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_apellido.setColumns(10);
		textField_apellido.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textField_1KeyTyped(evt);
			}
		});
		textField_apellido.setBounds(575, 227, 190, 30);
		contentPane.add(textField_apellido);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setForeground(new Color(33, 33, 33));
		lblNombreDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombreDeUsuario.setBounds(360, 294, 190, 36);
		contentPane.add(lblNombreDeUsuario);
		
		textField_nombre_usuario = new JTextField();
		textField_nombre_usuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_nombre_usuario.setColumns(10);
		textField_nombre_usuario.setBounds(567, 299, 193, 30);
		contentPane.add(textField_nombre_usuario);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setForeground(new Color(33, 33, 33));
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTelefono.setBounds(360, 342, 119, 36);
		contentPane.add(lblTelefono);
		
		textField_telefono = new JTextField();
		textField_telefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_telefono.setColumns(10);
		textField_telefono.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textField_3KeyTyped(evt);
			}
		});
		textField_telefono.setBounds(567, 347, 193, 30);
		contentPane.add(textField_telefono);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(33, 33, 33));
		lblContrasea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblContrasea.setBounds(360, 390, 124, 36);
		contentPane.add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contrase\u00F1a:");
		lblConfirmarContrasea.setForeground(new Color(33, 33, 33));
		lblConfirmarContrasea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblConfirmarContrasea.setBounds(360, 438, 185, 36);
		contentPane.add(lblConfirmarContrasea);
		
		
		passwordField_nueva_contraseña = new JPasswordField();
		passwordField_nueva_contraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField_nueva_contraseña.setBounds(567, 395, 193, 30);
		contentPane.add(passwordField_nueva_contraseña);
		
		passwordField_confirmacion_nueva = new JPasswordField();
		passwordField_confirmacion_nueva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField_confirmacion_nueva.setBounds(567, 443, 193, 30);
		contentPane.add(passwordField_confirmacion_nueva);
		
	    JSeparator separator = new JSeparator();
	    separator.setForeground(new Color(93, 64, 55));
	    separator.setBackground(new Color(93, 64, 55));
	    separator.setBounds(309, 495, 513, 10);
	    contentPane.add(separator);
	    
	    JSeparator separator_1 = new JSeparator();
	    separator_1.setForeground(new Color(93, 64, 55));
	    separator_1.setBackground(new Color(93, 64, 55));
	    separator_1.setBounds(309, 278, 513, 10);
	    contentPane.add(separator_1);
	    
	    JSeparator separator_2 = new JSeparator();
	    separator_2.setForeground(new Color(93, 64, 55));
	    separator_2.setBackground(new Color(93, 64, 55));
	    separator_2.setBounds(309, 181, 513, 10);
	    contentPane.add(separator_2);
	    
		btnIngresar = new JButton("Registrar Vendedor");
		btnIngresar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIngresar.setBackground(new Color(117, 117, 117));
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBounds(355, 522, 172, 33);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(117, 117, 117));
		btnSalir.setBounds(605, 522, 172, 33);
		contentPane.add(btnSalir);
		
		this.repaint();
		

	}
	
		public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

		public JTextField getTextField_nombre() {
		return textField_nombre;
	}

	public void setTextField_nombre(JTextField textField_nombre) {
		this.textField_nombre = textField_nombre;
	}

	public JPasswordField getPasswordField_nueva_contraseña() {
		return passwordField_nueva_contraseña;
	}

	public void setPasswordField_nueva_contraseña(JPasswordField passwordField_nueva_contraseña) {
		this.passwordField_nueva_contraseña = passwordField_nueva_contraseña;
	}

	public JTextField getTextField_apellido() {
		return textField_apellido;
	}

	public void setTextField_apellido(JTextField textField_apellido) {
		this.textField_apellido = textField_apellido;
	}

	public JTextField getTextField_nombre_usuario() {
		return textField_nombre_usuario;
	}

	public void setTextField_nombre_usuario(JTextField textField_nombre_usuario) {
		this.textField_nombre_usuario = textField_nombre_usuario;
	}

	public JTextField getTextField_telefono() {
		return textField_telefono;
	}

	public void setTextField_telefono(JTextField textField_telefono) {
		this.textField_telefono = textField_telefono;
	}

	public JPasswordField getPasswordField_confirmacion_nueva() {
		return passwordField_confirmacion_nueva;
	}

	public void setPasswordField_confirmacion_nueva(JPasswordField passwordField_confirmacion_nueva) {
		this.passwordField_confirmacion_nueva = passwordField_confirmacion_nueva;
	}

		public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

		private void textFieldKeyTyped(java.awt.event.KeyEvent evt) {
			
			char letr=evt.getKeyChar();
			if((letr<'a' || letr>'z') && (letr<'A' || letr>'Z') && (letr>' ')) evt.consume();
		}
		private void textField_1KeyTyped(java.awt.event.KeyEvent evt) {
			
			char letr=evt.getKeyChar();
			if((letr<'a' || letr>'z') && (letr<'A' || letr>'Z') && (letr>' ')) evt.consume();
		}
		private void textField_3KeyTyped(java.awt.event.KeyEvent evt) {
			
			char num=evt.getKeyChar();
			if(num<'0' || num>'9') evt.consume();
		}

		public void mostrarMensaje(String mensaje) {
			JOptionPane.showMessageDialog(null, mensaje);
		}
}
