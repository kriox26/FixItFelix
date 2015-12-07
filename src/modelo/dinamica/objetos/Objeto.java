package modelo.dinamica.objetos;

import modelo.dinamica.Dinamico;
import modelo.direcciones.Direccion;

/**
 * La clase Objeto representa a las "cosas" que, por contenerse en el package modelo.dinamica, se mueven durante el juego.
 * Por el caracter de nuestro modelado UML se incluiría también la clase Paloma, pero no está contemplada en el test. Más adelante será añadida.
 *
 * @author  Santiago Marrone
 * @see modelo.dinamica.Posicion
 */
public class Objeto extends Dinamico {
	private int velocidad;
	private static final int kv = 1;
	private boolean existe;
	private int movimiento;
    private boolean golpeo;
    
    public boolean getGolpeo(){
        return this.golpeo;
    }
    
    public void setGolpeo(boolean golpeo){
        this.golpeo = golpeo;
    }

	public void setExiste (boolean tof) {
		this.existe = tof;
	}

	public boolean getExiste() {
		return this.existe;
	}

    public int getMovimiento(){
        return this.movimiento;
    }


	public void unidireccionar (Direccion direccion) {
		while (this.getExiste() == true) {
			this.mover(direccion);
		}
	}

	public int getVelocidad () {
		return this.velocidad;
	}

	public void setVelocidad (int variable) {
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
