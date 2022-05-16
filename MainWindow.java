import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class MainWindow extends JFrame {
	
	UsuarioDAO consultaDB = new H2UsuarioDAO();
	private TablaInfoUsuarios molde; 
	private JTable tablaUsuarios; 
	private JScrollPane scrollPaneParaTabla;
	
	
	public MainWindow() {
		generarVentana();
//		cargarComponentes();
//		ventanaInsertar();
	
	}
	
	private void generarVentana () {
		JFrame frame = new JFrame("Home Banking Principal");
		frame.setVisible(true);
//		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		frame.setVisible(true);
//		frame.setLayout(new GridLayout(2,0));
//		frame.pack(); // Compacta la ventana al minimo ancho-largo
//		frame.setSize(new Dimension(700,500));
		
		cargarPanelTablaUsuarios(frame);

	}
	
	private void cargarPanelTablaUsuarios(JFrame frame) {
		JPanel panel = new JPanel();
		JPanel panelBotones = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		frame.getContentPane().add(panelBotones, BorderLayout.SOUTH);

		// TABLA
		molde = new TablaInfoUsuarios();
		tablaUsuarios = new JTable(molde);
		panel.add(tablaUsuarios);
		scrollPaneParaTabla = new JScrollPane(tablaUsuarios);
		panel.add(scrollPaneParaTabla);
		
		List<Usuario> listaTodosLosUsuarios = consultaDB.listar();

		molde.setContenido(listaTodosLosUsuarios);
		molde.fireTableDataChanged();
		
		// Botonera de tabla
		
		JButton botonInsertar = new JButton("Insertar");
		JButton botonEliminar = new JButton("Eliminar");
		JButton botonLimpiar = new JButton("Limpiar");
		
		panelBotones.add(botonInsertar);
		panelBotones.add(botonEliminar);
		panelBotones.add(botonLimpiar);
		
		frame.pack();
	}
	
	private void ventanaInsertar() {
		JFrame frame = new JFrame("Nuevo usuario");
		frame.setVisible(true);

		frame.setBounds(100, 100, 210, 170);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.getContentPane().add(panel);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		
		JLabel labelDNI = new JLabel("DNI");
		panel.add(labelDNI);
		
		JTextField textDNI = new JTextField();
		panel.add(textDNI);
		textDNI.setColumns(10);
		
		JLabel labelNombre = new JLabel("Nombre");
		panel.add(labelNombre);
		
		JTextField textNombre = new JTextField();
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel labelApellido = new JLabel("Apellido");
		panel.add(labelApellido);
		
		JTextField textApellido = new JTextField();
		panel.add(textApellido);
		textApellido.setColumns(10);
		
		JButton botonAceptar = new JButton("Aceptar");
		panel.add(botonAceptar);
		
		JButton botonCancelar = new JButton("Cancelar");
		panel.add(botonCancelar);

		frame.pack();
	}
	
	
	private void botoneraPrincipal() {

	}
	
	
}

