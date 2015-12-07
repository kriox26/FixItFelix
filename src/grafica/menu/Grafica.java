package grafica.menu;

import grafica.dinamica.objetos.LadrilloView;
import grafica.dinamica.personajes.FelixView;
import grafica.dinamica.personajes.RalphView;
import grafica.niceland.VentanaView;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Grafica extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton goBack = new JButton();

	public void cargarNiceland(VentanaView[][] building, FelixView fView, RalphView rView, int desde, int hasta){
		
	}

	public void graficarLadrillos(List<LadrilloView> ladrillos){
		
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

	public void setSeccionActual(BufferedImage img){
		
	}

}
