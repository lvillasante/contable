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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Fondo.fondo;


import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class InterfazPAutorizarNuevoVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nombre;
	private JPasswordField passwordField_contraseña;
	protected static int codi1;
	protected static String propietario;
	protected static String contrase1;
	protected  int intento=0;
	private JButton btnIngresar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPAutorizarNuevoVendedor frame = new InterfazPAutorizarNuevoVendedor();
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
	public InterfazPAutorizarNuevoVendedor() {
		setTitle("Autorizacion");
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
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_2.setBackground(new Color(240, 240, 240));
		label_2.setBounds(381, 260, 64, 57);
		contentPane.add(label_2);
		ImageIcon logo1= new ImageIcon(getClass().getResource("usuario.png"));
		ImageIcon icono1= new ImageIcon(logo1.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_DEFAULT));
		label_2.setIcon(icono1);
		
		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_3.setBackground(new Color(240, 240, 240));
		label_3.setBounds(387, 355, 58, 50);
		contentPane.add(label_3);
		ImageIcon logo2= new ImageIcon(getClass().getResource("llave.png"));
		ImageIcon icono2= new ImageIcon(logo2.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_DEFAULT));
		label_3.setIcon(icono2);
		
		JLabel label_1 = new JLabel("SISTEMA CONTABLE FERRETERIA \"BERNABE\"");
		label_1.setForeground(new Color(227, 231, 175));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 26));
		label_1.setBounds(135, 27, 585, 27);
		contentPane.add(label_1);
		
		JLabel lblbienvenido = new JLabel("Ingrese los Datos de Autorizacion");
		lblbienvenido.setForeground(new Color(33, 33, 33));
		lblbienvenido.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblbienvenido.setBounds(366, 112, 468, 36);
		contentPane.add(lblbienvenido);
		
		JLabel lblIngreseSusDatos = new JLabel("del Propietario");
		lblIngreseSusDatos.setForeground(new Color(33, 33, 33));
		lblIngreseSusDatos.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblIngreseSusDatos.setBounds(488, 152, 255, 36);
		contentPane.add(lblIngreseSusDatos);
		
		textField_nombre = new JTextField();
		textField_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_nombre.setBounds(457, 287, 298, 30);
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		passwordField_contraseña = new JPasswordField();
		passwordField_contraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField_contraseña.setBounds(457, 375, 298, 30);
		contentPane.add(passwordField_contraseña);
		
		btnIngresar = new JButton("Autorizar");
		
		btnIngresar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIngresar.setBackground(new Color(117, 117, 117));
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBounds(377, 455, 132, 33);
		contentPane.add(btnIngresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(117, 117, 117));
		btnSalir.setBounds(636, 455, 132, 33);
		contentPane.add(btnSalir);
		
		JLabel lblUsuario = new JLabel("Propietario:");
		lblUsuario.setForeground(new Color(33, 33, 33));
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsuario.setBounds(457, 257, 106, 27);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(33, 33, 33));
		lblContrasea.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContrasea.setBounds(457, 348, 118, 27);
		contentPane.add(lblContrasea);
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

	public JPasswordField getPasswordField_contraseña() {
		return passwordField_contraseña;
	}

	public void setPasswordField_contraseña(JPasswordField passwordField_contraseña) {
		this.passwordField_contraseña = passwordField_contraseña;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public int Codigopro() {
		
		return codi1;
	}
	public String Propietario() {
		
		return propietario;
	}
	public String Contraseñapro() {
		
		return contrase1;
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
	}
	
}
