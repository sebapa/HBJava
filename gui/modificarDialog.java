package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Excepciones.ServicioException;
import entidades.Usuario;
import servicios.UsuarioService;

public class modificarDialog {
	
	private JDialog modificar;

	
	public modificarDialog(Usuario aModificar) {
		generarVentanaModificar(aModificar);
	
	}

	private void generarVentanaModificar(Usuario aModificar) {
		String id = String.valueOf(aModificar.getId());
		String nombre = aModificar.getNombre();
		String apellido = aModificar.getApellido();
		
		modificar = new JDialog();
		modificar.setModal(true);
		modificar.setTitle("Modificar");
		modificar.setBounds(100, 100, 210, 170);
		
		JPanel panel = new JPanel();
		modificar.add(panel);
		modificar.getContentPane().add(panel);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		
		JLabel labelDNI = new JLabel("DNI");
		panel.add(labelDNI);
		
		JTextField textDNI = new JTextField(id);
		textDNI.setEnabled(false);
		panel.add(textDNI);
		textDNI.setColumns(10);
		
		JLabel labelNombre = new JLabel("Nombre");
		panel.add(labelNombre);
		
		JTextField textNombre = new JTextField(nombre);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel labelApellido = new JLabel("Apellido");
		panel.add(labelApellido);
		
		JTextField textApellido = new JTextField(apellido);
		panel.add(textApellido);
		textApellido.setColumns(10);
		
		JButton botonAceptar = new JButton("Aceptar");
		panel.add(botonAceptar);
		botonAceptar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Integer documento = Integer.parseInt (textDNI.getText());
						String nombre = textNombre.getText();
						String apellido = textApellido.getText();
						Usuario nuevo = new Usuario(documento, nombre, apellido);
						
						UsuarioService us = new UsuarioService();
						try {
							us.modificarUsuario(nuevo);
							JOptionPane.showMessageDialog(panel, "Se modifico usuario");
						} catch (ServicioException e1) {
							JOptionPane.showMessageDialog(panel, "Error al modificar usuario");
						}
						modificar.dispose(); 
					} 	
				}
				);
		
		JButton botonCancelar = new JButton("Cancelar");
		panel.add(botonCancelar);
		botonCancelar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modificar.dispose(); 
					} 
				}
				);

		modificar.pack();
		modificar.setVisible(true);
	}
	

}
