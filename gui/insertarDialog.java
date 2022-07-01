package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Excepciones.ServicioException;
import entidades.Usuario;
import servicios.UsuarioService;

public class insertarDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialog insertar;
	
	public insertarDialog(JFrame frame, String titulo, ModalityType opcion) {
		generarVentanaInsertar(frame, titulo, opcion);
	
	}

	private void generarVentanaInsertar(JFrame frame, String titulo, ModalityType opcion) {
		insertar = new JDialog(frame, titulo, opcion);

		
//
		insertar.setBounds(100, 100, 210, 170);
		
		JPanel panel = new JPanel();
		insertar.add(panel);
		insertar.getContentPane().add(panel);
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
		botonAceptar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!textDNI.getText().isEmpty() && !textNombre.getText().isEmpty() && !textApellido.getText().isEmpty()){
							Integer documento = Integer.parseInt (textDNI.getText());
							String nombre = textNombre.getText();
							String apellido = textApellido.getText();
							Usuario nuevo = new Usuario(documento, nombre, apellido);
							UsuarioService us = new UsuarioService();
							try {
								us.nuevoUsuario(nuevo);
								
							} catch (ServicioException e1) {
								JOptionPane.showMessageDialog(panel, "ERROR al intentar crear nuevo usuario");
							}		
	
							insertar.dispose(); 
						}else {
							JOptionPane.showMessageDialog(panel, "Complete los campos");
						}
						
					} 	
				}
				);
		
		JButton botonCancelar = new JButton("Cancelar");
		panel.add(botonCancelar);
		botonCancelar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						insertar.dispose(); 
					} 
				}
				);

		insertar.pack();
		insertar.setVisible(true);
	}
	

}
	