package modelo.dinamica;

import modelo.direcciones.Direccion;

/**
 * Dinamico es cualquier objeto o personaje.
 * Dincamico representa entidades con movilidad.
 *
 * @version 1.0
 * @see     modelo.dinamica.Posicion
 */

public class Dinamico {
	private Posicion posicion;

	public Posicion getPosicion (){
		return this.posicion;
	}

	public void setPosicion (Posicion position){
		this.posicion = position;
	}

	public void mover (Direccion direction){
		this.setPosicion(this.getPosicion().modificar(direction));
	}
}
