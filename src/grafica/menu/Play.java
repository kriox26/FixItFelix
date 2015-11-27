package grafica.menu;

import java.awt.event.KeyAdapter;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.main.Main;

public class Play extends Grafica {
	private String imgPath = "src/grafica/niceland/";
	private String backgroundImage = imgPath + "FondoNiceland.png";
	private JLabel fondo;

	/*
	 * Se crean todas las imagenes de Niceland, ventanas con obstaculos
	 * todo.
	 */
	public Play(Main main){
		File imgFondo = new File(backgroundImage);
		JLabel fondo = new JLabel(new ImageIcon(imgFondo.getAbsolutePath()));
		setVisible(true);
	}


	public void addKeyboardEvents(KeyAdapter keyadapter){
		this.getFondo().addKeyListener(keyadapter);
	}

	public JLabel getFondo(){
		return this.fondo;
	}
}