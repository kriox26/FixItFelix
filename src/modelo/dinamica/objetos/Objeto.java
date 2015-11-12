package modelo.dinamica.objetos;

import modelo.direcciones.*;
import modelo.dinamica.Dinamico;
import modelo.dinamica.Posicion;

/**
 * La clase Objeto representa a las "cosas" que, por contenerse en el package modelo.dinamica, se mueven durante el juego.
 * Por el caracter de nuestro modelado UML se incluiría también la clase Paloma, pero no está contemplada en el test. Más adelante será añadida.
 *
 * @author  Santiago Marrone
 * @see modelo.dinamica.Posicion
 */
public class Objeto extends Dinamico {
	private boolean existe;
	private double velocidad;
	private static final double kv = 1;

	public boolean getExiste(){
		return this.existe;
	}

	public void setExiste (boolean variable) {
		this.existe = variable;
	}

	public void unidireccionar (Direccion direccion) {
		while (this.getExiste() == true) {
			this.mover(direccion);
		}
	}

	public void desaparecer () {
		this.setExiste(false);
	}

	public void aparecer (Posicion position) {
		this.setExiste (true);
		this.setPosicion(position);
	}

	public double getVelocidad () {
		return this.velocidad;
	}

	public void setVelocidad (double variable) {
		this.velocidad = variable;
	}

	/**
	 * Un elemento de tipo Objeto necesita actualizar su velocidad
	 * a medida que pasan los niveles para dificultar la jugabilidad
	 *
	 * @param     nivel  para mesurar incremento de velocidad (dificultad).
	 */
	public void actualizarVelocidad (int nivel) {
		this.setVelocidad(nivel * kv);
	}
    
    public void actualizar(){
    }

}
