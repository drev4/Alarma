package es.unican.is2.practica3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.unican.is2.practica3.despertador.Despertador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui1 extends JFrame {

	private JPanel contentPane;
	private JComboBox hora;
	private JComboBox min;
	private JComboBox seg;
	private JComboBox snooze;
	private JPanel panel;
	
	private Despertador des = new Despertador(); //Objeto que tendra todas las funcionalidades de la alarma
	/*
	 * Interfaz grafica de la alarma
	 */
	public Gui1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		/*
		 * Boton que activa la alarma con los valores de los combobox hora, min y seg
		 */
		JButton btnNewButton = new JButton("Alarm On");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					//Nueva hora
				des.alarmaOn(Integer.parseInt(hora.getSelectedItem().toString()), Integer.parseInt(min.getSelectedItem().toString()),
							Integer.parseInt(seg.getSelectedItem().toString()));
				panel.setBackground(Color.RED);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		/*
		 * Boton que activa la alarma al cabo de un tiempo determinado en el combobox snooze
		 */
		JButton btnNewButton_2 = new JButton("Snooze");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				des.snooze(Integer.parseInt(snooze.getSelectedItem().toString()));
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridheight = 2;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 1;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		/*
		 * Campo que permite elegir entre los 3 valores en los que se puede aplazar el sonido de la alarma
		 */
		snooze = new JComboBox();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 6;
		gbc_comboBox_3.gridy = 2;
		contentPane.add(snooze, gbc_comboBox_3);
		snooze.addItem(new Integer(5));
		snooze.addItem(new Integer(10));
		snooze.addItem(new Integer(15));
		
		/*
		 * Campo que permite elegir la hora en la que sonara la alarma
		 * Los valores iran desde 0 a 24
		 */
		hora = new JComboBox();
		GridBagConstraints gbc_hora = new GridBagConstraints();
		gbc_hora.insets = new Insets(0, 0, 5, 5);
		gbc_hora.fill = GridBagConstraints.HORIZONTAL;
		gbc_hora.gridx = 1;
		gbc_hora.gridy = 3;
		contentPane.add(hora, gbc_hora);
		//Añadimos los valores posibles de hora
		for (int i = 0; i < 24; i++) {
			hora.addItem(new Integer(i));
		}
		
		JLabel lblHora = new JLabel("Hora");
		GridBagConstraints gbc_lblHora = new GridBagConstraints();
		gbc_lblHora.insets = new Insets(0, 0, 5, 5);
		gbc_lblHora.gridx = 2;
		gbc_lblHora.gridy = 3;
		contentPane.add(lblHora, gbc_lblHora);
		
		/*
		 * Campo que permite elegir el minuto en el que sonara la alarma
		 */
		min = new JComboBox();
		GridBagConstraints gbc_min = new GridBagConstraints();
		gbc_min.insets = new Insets(0, 0, 5, 5);
		gbc_min.fill = GridBagConstraints.HORIZONTAL;
		gbc_min.gridx = 1;
		gbc_min.gridy = 4;
		contentPane.add(min, gbc_min);
		
		JLabel lblMinuto = new JLabel("Minuto");
		GridBagConstraints gbc_lblMinuto = new GridBagConstraints();
		gbc_lblMinuto.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinuto.gridx = 2;
		gbc_lblMinuto.gridy = 4;
		contentPane.add(lblMinuto, gbc_lblMinuto);
		
		/*
		 * Boton que permite detener el sonido de la alarma sin desprogramarla
		 */
		JButton btnNewButton_3 = new JButton("Stop");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				des.stop();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 4;
		gbc_btnNewButton_3.gridy = 4;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		
		/*
		 * Piloto que cambia de color en funcion de si la alarma esta programada o no
		 * Rojo = Progrmada
		 * Azul = No Programada
		 */
		panel = new JPanel();
		panel.setBackground(Color.BLUE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 6;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		
		/*
		 * Campo que permite elegir el segundo en el que sonara la alarma
		 * Los valores aceptados van desde 0 a 59
		 */
		seg = new JComboBox();
		GridBagConstraints gbc_seg = new GridBagConstraints();
		gbc_seg.insets = new Insets(0, 0, 5, 5);
		gbc_seg.fill = GridBagConstraints.HORIZONTAL;
		gbc_seg.gridx = 1;
		gbc_seg.gridy = 5;
		contentPane.add(seg, gbc_seg);
		//Añadimos los valores posibles a los campos minuto y segundo
		for (int i = 0; i < 60; i++) {
			min.addItem(new Integer(i));
			seg.addItem(new Integer(i));
		}
		
		JLabel lblSegundo = new JLabel("Segundo");
		GridBagConstraints gbc_lblSegundo = new GridBagConstraints();
		gbc_lblSegundo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundo.gridx = 2;
		gbc_lblSegundo.gridy = 5;
		contentPane.add(lblSegundo, gbc_lblSegundo);
		
		/*
		 * Boton que permite activar o desactivar la alarma
		 */
		JButton btnNewButton_4 = new JButton("Buzz");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				des.buzz();
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridheight = 2;
		gbc_btnNewButton_4.gridx = 4;
		gbc_btnNewButton_4.gridy = 6;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
		
		/*
		 * Boton que desprograma la alarma
		 */
		JButton btnNewButton_1 = new JButton("Alarm Off");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				des.alarmaOff(panel);
				
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 7;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
