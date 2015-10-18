package modelo.dinamica.personajes;

import modelo.direcciones.Direccion;
import modelo.dinamica.Posicion;
import modelo.niceland.Ventana;
import modelo.niceland.Simple;
import modelo.niceland.Irrompible;
import modelo.niceland.Puerta;

/**
 * La clase Felix representa al protagonista del juego.
 * Debe poder moverse por toda la sección actual arreglando ventanas
 * cuando lo desee y comiendo pasteles cuando se tope con ellos.
 *
 * En la versión 1.0 de cara al testing, no se implementa la cuestión
 * de los pasteles ni la propiedad de recomenzar (reaparecer en
 * misma pantalla) que más tarde se añadirá.
 *
 * @author  Santiago Marrone w Matias Pan's collab.
 * @version 1.0
 * @see modelo.niceland.Ventana
 *
 */

public class Felix extends Personaje{
	private int vida;
	private boolean inmunidad;

    public Felix(String nombre, int vida, boolean inmunidad, Posicion posicion){
    	super(nombre, posicion);
        this.vida = vida;
        this.inmunidad = inmunidad;
    }

	public int getVida(){
		return this.vida;
	}

	public void setVida (int variable){
		this.vida = variable;
	}

	public boolean getInmunidad() {
		return this.inmunidad;
	}

	public void setInmunidad (boolean variable){
		this.inmunidad = variable;
	}

	public boolean estaInmune () {
        return this.getInmunidad() ? true : false;
	}

	public void activarInmunidad () {
		this.inmunidad = true;
	}

	public void desactivarInmunidad () {
		this.inmunidad = false;
	}

	public void golpeadoPorLadrillo () {
		if (this.estaInmune()) {
			this.desactivarInmunidad();
		}
		this.setVida (this.getVida()-1);
        System.out.println("Un ladrillo lo golpea a Felix, le quedan " + this.getVida() + " vidas.");
	}

	public void golpeadoPorPaloma (){
		this.recomenzar();
	}

	public void recomenzar () {
		// Vuelve a empezar de la misma pantalla... WTF?
	}

	public void comerTarta () {
		// Debe recibir la ventana de la tarta como parámetro para quitar la tarta
		// Debe ejecutarse si en Felix.posicion hay un sabroso pastel
		this.activarInmunidad();
	} // Completar para version 2.0

	private void reparar (Ventana ventana){
      ventana.arreglarPanel();
	}

	/**
	 * Felix puede ejecutar martillar cuantas veces quiera pero sólo
	 * si la ventana está rota será reparada (lógico, ¿no?).
	 *
	 * @param     ventana  es la ventana de la posicion donde se encuentra Felix con su información
	 * @see modelo.dinamica.personajes.Felix#reparar
	 */

	public void martillar (Ventana ventana) {
		if (!ventana.estaSana()) {
			this.reparar(ventana);
      System.out.println("Felix da un martillazo");
		}
	}

  public void mover(Direccion direccion){
      super.mover(direccion);
      System.out.println("Felix se mueve " + direccion.getHorizontal() + " en el ejex X y " + direccion.getVertical() + " en el eje Y");
    }
}
