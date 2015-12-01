package modelo.dinamica.personajes;

import modelo.dinamica.Dinamico;
import modelo.dinamica.Posicion;
import modelo.direcciones.Direccion;
import modelo.niceland.Ventana;
import excepciones.InvalidMoveException;

/*
 * Representa los personajes del juego, tales como Felix y Ralph. Se implementa
 * en esta clase los metodos y propiedades en comun de esos personajes.
 * @see modelo.dinamica.Dinamico
 */
public class Personaje extends Dinamico {
	
	private String nombre;
	
	public Personaje(String nombre, Posicion posicion){
		this.setNombre(nombre);
        super.setPosicion(posicion);
	}

	public String getNombre (){
		return this.nombre;
	}
	
	
	public void setNombre (String name){
		this.nombre = name;
	}
	
    /*
     * Chequea si el personaje actual esta posicionado al borde izquierdo de la
     * fila actual
     * @return boolean: True si esta posicionado al borde izquierdo, false caso contrario
     */
	public boolean alBordeIzquierdo () {
        return this.getPosicion().getColumna() == 0 ? true : false;
	}
	
    /*
     * Chequea si el personaje actual esta posicionado al borde derecho de la
     * fila actual
     * @return boolean: True si esta posicionado al borde derecho, false caso contrario
     */
	public boolean alBordeDerecho () {
        return this.getPosicion().getColumna() == 4 ? true : false;
	}
	
    /*
     * Chequea si el personaje actual esta posicionado al borde inferior de la
     * seccion actual
     * @return boolean: True si esta posicionado al borde inferior, false caso contrario
     */
	public boolean alBordeInferior () {
        return this.getPosicion().getFila() == 0 ? true : false;
	}
	
    /*
     * Chequea si el personaje actual esta posicionado al borde superior de la
     * seccion actual
     * @return boolean: True si esta posicionado al borde superior, false caso contrario
     */
	public boolean alBordeSuperior () {
        return this.getPosicion().getFila() == 3 ? true : false;
	}
	
    /*
     * Chequea si el personaje actual esta posicionado en algun borde.
     * @return boolean: True si esta posicionado en algun borde, false caso contrario
     */
	public boolean alBorde () {
        return (this.alBordeDerecho() || this.alBordeIzquierdo() || this.alBordeInferior() || this.alBordeSuperior()) ? true : false;
	}
	
    /*
     * Cheques si el personaje actual puede moverse en la direccion especificada.
     * @params Direccion direction: Direccion en la que se lo quiere mover
     * @return boolean: True si se puede mover, false caso contrario
     */
	private boolean puedeMoverse (Direccion direction) {
		switch (direction) {
			case ARRIBA : 
				if (this.alBordeSuperior())
                    return false;
			case ABAJO : 
				if (this.alBordeInferior())
                    return false;
			case IZQUIERDA : 
				if (this.alBordeIzquierdo())
                    return false;
			case DERECHA : 
				if (this.alBordeDerecho())
					return false;
            case NULA : return true;
		}
        return true;
	}
	
    /*
     * Se mueve en la direccion especificada siempre y cuando sea posible.
     * @params Direccion direction: Direccion en la que se lo quiere mover al personaje
     * @Override
     */
	public void mover (Direccion direction, Ventana ventana) throws InvalidMoveException{
		if (this.puedeMoverse(direction) && ventana.pasarHabilitado(direction)) {
            super.mover(direction);
		} else{
            throw new InvalidMoveException("Movimiento invalido!");
        }
	}
}