package controlador;


import grafica.menu.Grafica;
import grafica.menu.Instrucciones;
import grafica.menu.MainMenu;
import grafica.menu.Play;
import grafica.menu.TopScores;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import modelo.direcciones.Direccion;
import modelo.main.Main;

public class Controlador {
	private Grafica view;
	private Main model;
	private static MainMenu MENU = new MainMenu();
	private Map<String, BufferedImage> imagenes = new TreeMap<String, BufferedImage>();

	private void cargarImagenes(){
		File carpeta = new File("src/grafica/imagenes/");
		File[] lista = carpeta.listFiles();
		cargaRecursiva(lista);
	}

	private void cargaRecursiva(File[] lista){
		for(File act : lista){
			if(act.isDirectory()){
				cargaRecursiva(act.listFiles());
			}else{
				try{
					BufferedImage imagen = ImageIO.read(act);
					imagenes.put(act.getName(), imagen);
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public Controlador(){}

	public Controlador(Main model){
		this.model= model;

		// Cargamos los eventos de la vista MainMenu
		MENU.addMouseEvents(new ManejaPlayAdapter(), new ManejaTopScoresAdapter(), new ManejaInstrucciones());
	}

	public Grafica getView(){
		return this.view;
	}

	public void setView(Grafica view){
		this.view = view;
	}

	public Main getModel(){
		return this.model;
	}
	
	/*Creo que de esta forma se deberia manejar con el Controlador. Cualquier cosa si ven
	 * que se puede cambiar lo que sea para hacerlo mejor, mporque no se si les va a parecer 
	 * un lio de clases, pero bueno jaj. Lo que va a relacionar el modelo con la grafica
	 * va a ser el Boton Play, que ahi cree la clase, pero no mas que eso por cuestiones
	 * que se puede relacionar de muchas formas y no se como empezar.
	 */
	public static void main (String[] args){
		Controlador ctrl = new Controlador(new Main(false, 0));
	}

	class ManejaEventosTeclado extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int movek = e.getKeyCode();
			//Point P = Posicion de Imagen de Felix a usar creo
			switch(movek){
			case KeyEvent.VK_UP:		//Arriba
				model.getDvp().getFelix().mover(Direccion.ARRIBA);
				//P.setLocation(new Point((int) p.getX()),new Point((int) p.getY()+10);
				break;
			case KeyEvent.VK_DOWN:		//Abajo
					model.getDvp().getFelix().mover(Direccion.ABAJO);
					//P.setLocation(new Point((int) p.getX()),new Point((int) p.getY()-10);
					break;
			case KeyEvent.VK_LEFT: //Izquierda
				model.getDvp().getFelix().mover(Direccion.IZQUIERDA);
				//P.setLocation(new Point((int) p.getX()-10),new Point((int) p.getY());
				break;
			case KeyEvent.VK_RIGHT: //Derecha
				model.getDvp().getFelix().mover(Direccion.DERECHA);
				//P.setLocation(new Point((int) p.getX()+10),new Point((int) p.getY());
				break;
			default: 
				break;
			}
		}
	}

	class ManejaPlayAdapter extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			MENU.turnOff();
			view = new Play(model);
			view.addKeyboardEvents(new ManejaEventosTeclado());
			view.addBackMenu(new VolverAMenu());
		}
	}


	class VolverAMenu extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			view.turnOff();
			MENU.turnOn();
		}
	}
	class ManejaTopScoresAdapter extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			MENU.turnOff();
			view = new TopScores();
			view.addBackMenu(new VolverAMenu());
		}
	}
	class ManejaInstrucciones extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			MENU.turnOff();
			view = new Instrucciones();
			view.addBackMenu(new VolverAMenu());
		}
	}

}
