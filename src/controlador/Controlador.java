package controlador;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import grafica.menu.Grafica;
import grafica.menu.MainMenu;
import grafica.menu.Play;
import modelo.direcciones.Direccion;
import modelo.main.Main;

public class Controlador {
	private Grafica view = new MainMenu();
	private Main model;
	
	public Controlador(){}

	public Controlador(Grafica view, Main model){
		this.view = view;
		this.model= model;

		// Cargamos los eventos de la vista MainMenu
		view.addMouseEvents(new ManejaPlayAdapter());
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
		Controlador ctrl = new Controlador(new MainMenu(), new Main(false, 0));
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
			view.turnOff();
			view = new Play(model);
			view.addKeyboardEvents(new ManejaEventosTeclado());
		}
	}

}
