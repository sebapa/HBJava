package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dao.H2UsuarioDAO;
import dao.UsuarioDAO;
import entidades.Usuario;


public class MainWindow extends JFrame {
	
	UsuarioDAO consultaDB = new H2UsuarioDAO();
	
	private JFrame frame;
	private TablaInfoUsuarios molde; 
	private JTable tablaUsuarios; 
	private JScrollPane scrollPaneParaTabla;
	
	
	public MainWindow() {
		generarVentana();
//		cargarComponentes();
//		ventanaInsertar();
	
	}
	
	private void generarVentana () {
		frame = new JFrame("Home Banking Principal");
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
		botonInsertar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new insertarDialog(frame, "Insertar", ModalityType.APPLICATION_MODAL);
						recargarTabla();
					} 	
				}
				);
		
		JButton botonEliminar = new JButton("Eliminar");
		botonEliminar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int filaSeleccionada = tablaUsuarios.getSelectedRow();
						Usuario seleccionado = molde.getContenido().get(filaSeleccionada);
						UsuarioDAO cons = new H2UsuarioDAO();
						cons.eliminar(seleccionado);
						recargarTabla();
					} 	
				}
				);
		JButton botonModificar = new JButton("Modificar");
		botonModificar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int filaSeleccionada = tablaUsuarios.getSelectedRow();
						Usuario seleccionado = molde.getContenido().get(filaSeleccionada);
						new modificarDialog(seleccionado);
						recargarTabla();
					} 	
				}
				);
		
		panelBotones.add(botonInsertar);
		panelBotones.add(botonEliminar);
		panelBotones.add(botonModificar);

		
		frame.pack();
	}
	
	private void recargarTabla() {
		List<Usuario> listaTodosLosUsuarios = consultaDB.listar();
		molde.setContenido(listaTodosLosUsuarios);
		molde.fireTableDataChanged();
	}

	
	private void botoneraPrincipal() {

	}
	
	
}

