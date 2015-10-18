package modelo.dinamica.personajes;

import modelo.dinamica.Posicion;
import modelo.direcciones.*;

public class Ralph extends Personaje {
	private int ladrillos;
	private static final int cuantosTira = 1;
	private static final int kl = 5; // Constante de ladrillos por nivel

  public Ralph(String nombre, int ladrillos, Posicion posicion){
  	super(nombre, posicion);
      this.ladrillos = ladrillos;
  }

	public int getLadrillos () {
		return this.ladrillos;
	}

	public void setLadrillos (int cantidad) {
		this.ladrillos = cantidad;
	}

	private boolean hayLadrillos () {
		if (this.getLadrillos() >= cuantosTira) {
			return true;
		}
		else
			return false;
	}
	
	public void actualizarLadrillos (int nivel) {
		this.setLadrillos(nivel * kl);
	}

	public void tirarLadrillos () {
		if (this.hayLadrillos()) {
			this.setLadrillos(this.getLadrillos() - cuantosTira);
			for (int i=0; i<= cuantosTira; i++) {
				// ladrillo.caerDesde(this.getPosicion());
			}
		}
	}
	
	private boolean alBordeIzquierdo () {
		if (this.getPosicion().getColumna() == 1) {
			return true;
		}
		else 
			return false;
	}
	
	private boolean alBordeDerecho () {
		if (this.getPosicion().getColumna() == 5) {
			return true;
		}
		else 
			return false;
	}
	
	private boolean alBorde () {
		if (this.alBordeDerecho() || this.alBordeIzquierdo()) {
			return true;
		}
		else 
			return false;
	}
	
	private void movimientoParcial (Direccion direction) {
		while (!this.alBorde()) {
			this.mover(direction);
		}
	}
	
	public void movimientoTotal () { 
		if (this.alBorde()) {
			if (this.alBordeIzquierdo()){
				this.movimientoParcial(Direccion.DERECHA);
			}
			else {
				this.movimientoParcial(Direccion.IZQUIERDA);
			}
		}
	}
}
