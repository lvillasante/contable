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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Fondo.fondo;
import modelo.Empleado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazBmenu_de_opciones extends JFrame {
	private JPanel contentPane;
	public JButton btnRegistrarVenta;
	public JButton btnRegistrarCompra;
	public JButton btnRegistrarGastos;
	public JButton btnMostrarInventarios;
	public JButton btnEstadoDeResultados;
	public JButton btnSalir;
	public InterfazBmenu_de_opciones() {
		setTitle("Menu de Opciones");
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
		
		JLabel lblbienvenido = new JLabel("Seleccione una opci\u00F3n");
		lblbienvenido.setForeground(new Color(33, 33, 33));
		lblbienvenido.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblbienvenido.setBounds(471, 106, 279, 27);
		contentPane.add(lblbienvenido);
		
		btnRegistrarVenta = new JButton("Registrar Venta");
		btnRegistrarVenta.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnRegistrarVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrarVenta.setBackground(new Color(235, 235, 235));
		btnRegistrarVenta.setForeground(new Color(33, 33, 33));
		btnRegistrarVenta.setBounds(487, 174, 240, 33);
		contentPane.add(btnRegistrarVenta);
		
		btnRegistrarCompra = new JButton("Registrar Compra");
		btnRegistrarCompra.setForeground(new Color(33, 33, 33));
		btnRegistrarCompra.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrarCompra.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnRegistrarCompra.setBackground(new Color(235, 235, 235));
		btnRegistrarCompra.setBounds(487, 232, 240, 33);
		contentPane.add(btnRegistrarCompra);
		
		btnRegistrarGastos = new JButton("Registrar Gastos");
		btnRegistrarGastos.setForeground(new Color(33, 33, 33));
		btnRegistrarGastos.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrarGastos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnRegistrarGastos.setBackground(new Color(235, 235, 235));
		btnRegistrarGastos.setBounds(487, 291, 240, 33);
		contentPane.add(btnRegistrarGastos);
		
		btnMostrarInventarios = new JButton("Mostrar Inventarios");
		btnMostrarInventarios.setForeground(new Color(33, 33, 33));
		btnMostrarInventarios.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMostrarInventarios.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnMostrarInventarios.setBackground(new Color(235, 235, 235));
		btnMostrarInventarios.setBounds(487, 348, 240, 33);
		contentPane.add(btnMostrarInventarios);
		
		btnEstadoDeResultados = new JButton("Estado de Finales");
		btnEstadoDeResultados.setForeground(new Color(33, 33, 33));
		btnEstadoDeResultados.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEstadoDeResultados.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnEstadoDeResultados.setBackground(new Color(235, 235, 235));
		btnEstadoDeResultados.setBounds(487, 404, 240, 33);
		contentPane.add(btnEstadoDeResultados);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(117, 117, 117));
		btnSalir.setBounds(543, 503, 132, 33);
		contentPane.add(btnSalir);
		this.repaint();
		

	}
}
