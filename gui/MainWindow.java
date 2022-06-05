package gui;
import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import Excepciones.ServicioException;
import entidades.Usuario;
import servicios.UsuarioService;


public class MainWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UsuarioService us = new UsuarioService();
	
	private JFrame frame;
	private TablaInfoUsuarios molde; 
	private JTable tablaUsuarios; 
	private JScrollPane scrollPaneParaTabla;
	
	
	public MainWindow() {
		generarVentana();
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

		recargarTabla();

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
						UsuarioService us = new UsuarioService();
						try {
							us.eliminarUsuario(seleccionado);
							JOptionPane.showMessageDialog(panel, "Se elimino usuario");
						} catch (ServicioException e1) {
							JOptionPane.showMessageDialog(panel, "ERROR al intentar eliminar");
							}
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
		List<Usuario> listaTodosLosUsuarios = null;
		try {
			listaTodosLosUsuarios = us.mostrarUsuarios();
		} catch (ServicioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		molde.setContenido(listaTodosLosUsuarios);
		molde.fireTableDataChanged();
	}

	
//	private void botoneraPrincipal() {
//
//	}
	
	
}

