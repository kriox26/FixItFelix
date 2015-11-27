package grafica.menu;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.main.Main;

public class Play extends Grafica {
	private String imgPath = "src/grafica/niceland/";
	private String backgroundImage = imgPath + "FondoNiceland.jpg";
	private JLabel fondo;

	/*
	 * Se crean todas las imagenes de Niceland, ventanas con obstaculos
	 * todo.
	 */
	public Play(Main main){
		File imgFondo = new File(backgroundImage);
		JLabel fondo = new JLabel(new ImageIcon(imgFondo.getAbsolutePath()));
		add(goBack);
		setContentPane(fondo);
		setSize(919, 720);
		cargarNiceland();
		setVisible(true);
	}


	public void addKeyboardEvents(KeyAdapter keyadapter){
		this.addKeyListener(keyadapter);
	}

	public void cargarNiceland(){
//		this.getGraphics().drawImage(imgs.get("seccion1"), 20, 0, null);
	}

	public void paint(Graphics g){
		super.paintComponents(g);
	}

}
