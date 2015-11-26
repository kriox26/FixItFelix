package controlador;

import modelo.main.Main;
import view.Grafica;

public class Controlador {
	private Grafica view;
	private Main model;
	
	public Controlador(){}
	
	public Controlador(Grafica view, Main model){
		this.view=view;
		this.model=model;
	}
	/*Creo que de esta forma se deberia manejar con el Controlador. Cualquier cosa si ven
	 * que se puede cambiar lo que sea para hacerlo mejor, mporque no se si les va a parecer 
	 * un lio de clases, pero bueno jaj. Lo que va a relacionar el modelo con la grafica
	 * va a ser el Boton Play, que ahi cree la clase, pero no mas que eso por cuestiones
	 * que se puede relacionar de muchas formas y no se como empezar.
	 */
	public static void main (String[] args){
		Controlador Ctrl = new Controlador();
		Ctrl.model = new Main(false);
		Ctrl.view = new Grafica();
	}
}
