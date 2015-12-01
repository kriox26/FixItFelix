package grafica.menu;

import grafica.dinamica.personajes.FelixView;
import grafica.niceland.VentanaView;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

import controlador.Controlador;

public class Grafica extends JFrame {
	protected JButton goBack = new JButton();

	public void cargarNiceland(VentanaView[][] building, Map<String, BufferedImage> imagenes, FelixView fView){
		
	}

	public void addMouseEvents(MouseAdapter e){
		
	}

	public void addKeyboardEvents(KeyAdapter e){
		
	}

	public void addBackMenu(MouseAdapter goback){
		goBack.addMouseListener(goback);
	}

	public void turnOff(){
		setVisible(false);
	}

	public void paintComponents(Graphics g){
		super.paintComponents(g);
	}


}
