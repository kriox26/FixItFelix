package grafica.menu;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JFrame{
	private JPanel panel = new JPanel();
	private String imgName = "MainMenu.png";
	private BufferedImage img;
	private JButton instrucciones, play, highscores; 
	private ImageIcon playBoton = new ImageIcon("src/Play.png");
	private ImageIcon instruccionesBoton = new ImageIcon("src/Instrucciones.png");
	private ImageIcon highscoresBoton = new ImageIcon("src/HighScores.png");
	
	public MainMenu(){
		/*Menu principal que seria lo pripero que aparece al lanzar la aplicacion.
		 */
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 550));
		configurarBotones();
		/*Cargo la Imagen de esta forma. Se puede hacer desde entrada salida que
		 *creo que seria mucho mejor de esa forma, pero por ahora esto.
		 */
		URL imgURL = getClass().getClassLoader().getResource(imgName);
		if (imgURL == null)
			System.err.println("No se encuentra el archivo"+imgName);
		else {
			try{
				img= ImageIO.read(imgURL);
			}
			catch (IOException ex){
				ex.printStackTrace();
			}
		}
		/*EL titulo de la Ventana. El tamaño de la ventana ó Frame esta justo para 
		 * la imagen de fondo.
		 */
		this.setResizable(false);
		setTitle("Fix It Felix");
		setSize(919,720);
		setVisible(true);
		dibujar();
	}
	
	public void dibujar (){
		Graphics gr = img.getGraphics();
		this.getGraphics().drawImage(img, 0, 0, null);
	}
	
	private void configurarBotones(){
		instrucciones = new JButton();
		play = new JButton();
		highscores = new JButton();
		play.setIcon(playBoton);
		instrucciones.setIcon(instruccionesBoton);
		highscores.setIcon(highscoresBoton);
		play.setBorderPainted(false);
		play.setContentAreaFilled(false);
		play.setBorder(null);
		highscores.setBorderPainted(false);
		highscores.setContentAreaFilled(false);
		highscores.setBorder(null);
		instrucciones.setBorderPainted(false);
		instrucciones.setContentAreaFilled(false);
		instrucciones.setBorder(null);
		add(instrucciones); add(play); add(highscores);
	}
	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		dibujar();
	}
	public static void main (String[] args){
		MainMenu pruea = new MainMenu();
	}
	

}
