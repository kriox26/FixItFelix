package grafica.menu;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.net.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JFrame{
	private String imgPath = "src/grafica/imagenes/";
	private String backgroundImage = imgPath + "MainMenu.png";
	private BufferedImage img;
	private Button instrucciones, play, highscores; 
	
	public MainMenu(){
		/*Menu principal que seria lo pripero que aparece al lanzar la aplicacion.
		 *Primero Agrego los botones al menu principal.
		 */
		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 550));
		instrucciones = new Button("Instrucciones");
		play = new Button("Play");
		highscores = new Button("Highscores");
		add(highscores); add(play);
		add(instrucciones);
		/*
		 * Actualmente, el flow entre ventanas es el siguiente:
		 * 		- Apreto boton por ejemplo "Instrucciones"
		 * 		- Se desabilita la visibilidad de la pantalla actual
		 * 		- Se crea la nueva pantalla y habilita la visibilidad
		 * Hay que preguntar si hay una mejor manera de hacerlo, por ahi reemplazando contenidos?
		 */
		instrucciones.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				setVisible(false);
				Instrucciones inst = new Instrucciones();
			}
		});

		highscores.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				setVisible(false);
				TopScores tps = new TopScores();
			}
		});
		try{
			File image = new File(backgroundImage);
			img = ImageIO.read(image);
		}
		catch (IOException ex){
			ex.printStackTrace();
        }


		/*EL titulo de la Ventana. Creo que igual deberia tener "Fix It Felix".
		 *El tama�o de la ventana � Frame esta justo para la imagen de fondo.
		 */
		setTitle("MainMenu");
		setSize(919,720);
		setVisible(true);
		dibujar();
	}
	
	public void dibujar (){
		Graphics gr = img.getGraphics();
		this.getGraphics().drawImage(img, 0, 0, null);
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
