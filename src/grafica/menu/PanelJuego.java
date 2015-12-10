package grafica.menu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelJuego extends JPanel{
	public PanelJuego(){
		this.setVisible(true);
		this.setSize(800, 600);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}

}
