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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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
import modelo.Proveedor;


public class InterfazFRegistroProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nombre;
	private JTextField textField_nombre_empresa;
	private JTextField textField_direccion;
	private JTextField textField_3;
	private JTable table1;
	private JTable table2;
	private JTable table;
	private JTextField textFieldID;
	private JButton botonBuscar;
	private JTextField textFieldTelefono;
	private boolean existe=true;
	private boolean finalexito=false;
	private JButton btnRegistrar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazFRegistroProveedor frame = new InterfazFRegistroProveedor();
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
	public InterfazFRegistroProveedor() {
		setTitle("Registrar del Proveedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new fondo("panel.jpg");
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(new Color(255, 255, 255));
		lblID.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblID.setBounds(448, 208, 41, 30);
		contentPane.add(lblID);
		
		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldID.setColumns(10);
		textFieldID.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textFieldIDKeyTyped(evt);
			}
		});
		textFieldID.setBounds(484, 210, 119, 30);
		contentPane.add(textFieldID);
		
		botonBuscar=new JButton("Buscar");
		botonBuscar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		botonBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		botonBuscar.setForeground(new Color(255, 255, 255));
		botonBuscar.setBackground(new Color(117, 117, 117));
		botonBuscar.setBounds(623, 209, 93, 30);
		contentPane.add(botonBuscar);
		
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
		
		JLabel lblbienvenido = new JLabel("Registro de Proveedor");
		lblbienvenido.setForeground(new Color(33, 33, 33));
		lblbienvenido.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblbienvenido.setBounds(430, 80, 327, 37);
		contentPane.add(lblbienvenido);
		
		JLabel lblIngreseSusDatos = new JLabel("Complete los campos vacios");
		lblIngreseSusDatos.setForeground(new Color(117, 117, 117));
		lblIngreseSusDatos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblIngreseSusDatos.setBounds(445, 139, 290, 36);
		contentPane.add(lblIngreseSusDatos);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombre.setBounds(350, 270, 106, 30);
		contentPane.add(lblNombre);
		
		 
		textField_nombre = new JTextField();
		textField_nombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_nombre.setColumns(10);
		textField_nombre.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textFieldKeyTyped(evt);
			}
		});
		textField_nombre.setBounds(516, 270, 224, 30);
		contentPane.add(textField_nombre);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre empresa:");
		lblNombreDeUsuario.setForeground(new Color(255, 255, 255));
		lblNombreDeUsuario.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNombreDeUsuario.setBounds(349, 330, 164, 36);
		contentPane.add(lblNombreDeUsuario);
		
		
		 textField_nombre_empresa = new JTextField();
		    textField_nombre_empresa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    textField_nombre_empresa.setColumns(10);
			textField_nombre_empresa.addKeyListener(new java.awt.event.KeyAdapter(){
				public void keyTyped(java.awt.event.KeyEvent evt) {
					textField_1KeyTyped(evt);
				}
			});
			textField_nombre_empresa.setBounds(516, 330, 224, 30);
		    contentPane.add(textField_nombre_empresa);
		
		JLabel lblContrasea = new JLabel("Direccion:");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblContrasea.setBounds(349, 390, 144, 36);
		contentPane.add(lblContrasea);
		
		textField_direccion = new JTextField();
		textField_direccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_direccion.setColumns(10);
		textField_direccion.setBounds(516, 390, 224, 30);
		contentPane.add(textField_direccion);
		
	 
		
		JLabel lblConfirmarContrasea = new JLabel("Telefono:");
		lblConfirmarContrasea.setForeground(new Color(255, 255, 255));
		lblConfirmarContrasea.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblConfirmarContrasea.setBounds(349, 450, 144, 36);
		contentPane.add(lblConfirmarContrasea);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldTelefono.setColumns(10);
		textFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter(){
			public void keyTyped(java.awt.event.KeyEvent evt) {
				textFieldTeflfKeyTyped(evt);
			}
		});
		textFieldTelefono.setBounds(516, 450, 136, 30);
		contentPane.add(textFieldTelefono);
		
		
	    JSeparator separator = new JSeparator();
	    separator.setForeground(new Color(93, 64, 55));
	    separator.setBackground(new Color(93, 64, 55));
	    separator.setBounds(305, 559, 518, 10);
	    contentPane.add(separator);
	    
	    JSeparator separator_2 = new JSeparator();
	    separator_2.setForeground(new Color(93, 64, 55));
	    separator_2.setBackground(new Color(93, 64, 55));
	    separator_2.setBounds(305, 181, 518, 10);
	    contentPane.add(separator_2);
	    
	    table1 = new JTable();
	    table1.setBackground(new Color(93, 64, 55));
	    table1.setBounds(649, 119, 174, 22);
	    contentPane.add(table1);
	    
	    table2 = new JTable();
	    table2.setBackground(new Color(93, 64, 55));
	    table2.setBounds(304, 119, 182, 22);
	    contentPane.add(table2);
	   
		
	   
	    
		
	    
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.setBackground(new Color(117, 117, 117));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBounds(377, 515, 144, 33);
		contentPane.add(btnRegistrar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(117, 117, 117));
		btnSalir.setBounds(608, 515, 144, 33);
		contentPane.add(btnSalir);
		
		table = new JTable();
		table.setBackground(new Color(93, 64, 55));
		table.setBounds(315, 183, 497, 376);
		contentPane.add(table);
		
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

	public JTextField getTextField_nombre_empresa() {
		return textField_nombre_empresa;
	}

	public void setTextField_nombre_empresa(JTextField textField_nombre_empresa) {
		this.textField_nombre_empresa = textField_nombre_empresa;
	}

	public JTextField getTextField_direccion() {
		return textField_direccion;
	}

	public void setTextField_direccion(JTextField textField_direccion) {
		this.textField_direccion = textField_direccion;
	}

	public JTextField getTextFieldTelefono() {
		return textFieldTelefono;
	}

	public void setTextFieldTelefono(JTextField textFieldTelefono) {
		this.textFieldTelefono = textFieldTelefono;
	}

	
	public JTextField getTextFieldID() {
		return textFieldID;
	}

	public void setTextFieldID(JTextField textFieldID) {
		this.textFieldID = textFieldID;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

		public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public void setBotonBuscar(JButton botonBuscar) {
		this.botonBuscar = botonBuscar;
	}

		private void textFieldKeyTyped(java.awt.event.KeyEvent evt) {
			
			char letr=evt.getKeyChar();
			if((letr<'a' || letr>'z') && (letr<'A' || letr>'Z') && (letr>' ')) evt.consume();
		}
		private void textField_1KeyTyped(java.awt.event.KeyEvent evt) {
			
			char letr=evt.getKeyChar();
			if((letr<'a' || letr>'z') && (letr<'A' || letr>'Z') && (letr>' ')) evt.consume();
		}
		private void textFieldIDKeyTyped(java.awt.event.KeyEvent evt) {
			
			char num=evt.getKeyChar();
			if(num<'0' || num>'9') evt.consume();
		}
		private void textFieldTeflfKeyTyped(java.awt.event.KeyEvent evt) {
			
			char num=evt.getKeyChar();
			if(num<'0' || num>'9') evt.consume();
		}

		public void mostrarMensaje(String mensaje) {
			JOptionPane.showMessageDialog(null,mensaje);
			
		}

		public void asignarDatosInterfaz(Proveedor prov) {
			getTextField_nombre().setText(prov.getNombreProv());
			getTextField_nombre_empresa().setText(prov.getNombreEmpresa());
			getTextField_direccion().setText(prov.getDireccion());
			getTextFieldTelefono().setText(prov.getTelefono());			
		}
}
