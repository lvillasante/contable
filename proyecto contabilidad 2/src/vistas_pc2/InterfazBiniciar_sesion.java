package vistas_pc2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Fondo.fondo;

public class InterfazBiniciar_sesion extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;
	private static int codi;
	protected static String nombre;
	protected static String contrase;
	protected  int intento=0;
	public JButton btnNuevoUsuario;
	public JButton btnSalir;
	public JButton btnIngresar;
	
	public InterfazBiniciar_sesion() {
		setTitle("Iniciar Sesion");
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
		label.setBounds(0, 55, 364, 519);
		contentPane.add(label);
		ImageIcon logo= new ImageIcon(getClass().getResource("puerta1.jpg"));
		ImageIcon icono= new ImageIcon(logo.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(icono);
		
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_2.setBackground(new Color(240, 240, 240));
		label_2.setBounds(441, 260, 64, 57);
		contentPane.add(label_2);
		ImageIcon logo1= new ImageIcon(getClass().getResource("usuario.png"));
		ImageIcon icono1= new ImageIcon(logo1.getImage().getScaledInstance(label_2.getWidth(), label_2.getHeight(), Image.SCALE_DEFAULT));
		label_2.setIcon(icono1);
		
		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_3.setBackground(new Color(240, 240, 240));
		label_3.setBounds(447, 355, 58, 50);
		contentPane.add(label_3);
		ImageIcon logo2= new ImageIcon(getClass().getResource("llave.png"));
		ImageIcon icono2= new ImageIcon(logo2.getImage().getScaledInstance(label_3.getWidth(), label_3.getHeight(), Image.SCALE_DEFAULT));
		label_3.setIcon(icono2);
		
		JLabel label_1 = new JLabel("SISTEMA CONTABLE FERRETERIA \"BERNABE\"");
		label_1.setForeground(new Color(227, 231, 175));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 26));
		label_1.setBounds(135, 27, 585, 27);
		contentPane.add(label_1);
		
		JLabel lblbienvenido = new JLabel("\"Bienvenido\"");
		lblbienvenido.setForeground(new Color(33, 33, 33));
		lblbienvenido.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblbienvenido.setBounds(517, 112, 187, 27);
		contentPane.add(lblbienvenido);
		
		JLabel lblIngreseSusDatos = new JLabel("Ingrese sus Datos");
		lblIngreseSusDatos.setForeground(new Color(33, 33, 33));
		lblIngreseSusDatos.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblIngreseSusDatos.setBounds(498, 144, 242, 36);
		contentPane.add(lblIngreseSusDatos);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(517, 287, 279, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(517, 375, 279, 30);
		contentPane.add(passwordField);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIngresar.setBackground(new Color(117, 117, 117));
		btnIngresar.setForeground(new Color(255, 255, 255));
		btnIngresar.setBounds(427, 455, 132, 33);
		contentPane.add(btnIngresar);
		
	    btnSalir = new JButton("Salir");
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(117, 117, 117));
		btnSalir.setBounds(650, 455, 132, 33);
		contentPane.add(btnSalir);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(33, 33, 33));
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsuario.setBounds(517, 257, 106, 27);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(33, 33, 33));
		lblContrasea.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContrasea.setBounds(517, 348, 118, 27);
		contentPane.add(lblContrasea);
		
		btnNuevoUsuario = new JButton("Presione para registrar un nuevo usuario");
		btnNuevoUsuario.setForeground(new Color(33, 33, 33));
		btnNuevoUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNuevoUsuario.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnNuevoUsuario.setBackground(new Color(215, 204, 200));
		btnNuevoUsuario.setBounds(459, 537, 299, 33);
		contentPane.add(btnNuevoUsuario);
		this.repaint();

	}
	
	
}
