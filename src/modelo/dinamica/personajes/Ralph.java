package modelo.dinamica.personajes;

import modelo.dinamica.Posicion;
import modelo.direcciones.*;
import modelo.util.RandomAcotado;

public class Ralph extends Personaje {
	private int ladrillos;
	private static final int cuantosTira = 1;
	private static final int kl = 5; // Constante de ladrillos por nivel
	private boolean fijo; // Si está en una sección haciendo sus maldades. O sea, no está cambiando de sección

  public Ralph(String nombre, int ladrillos, Posicion posicion){
  	super(nombre, posicion);
      this.ladrillos = ladrillos;
  }

  	public boolean getFijo() {
  		return this.fijo;
  	}
  	
  	public void setFijo(boolean variable) {
  		this.fijo= variable;
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
	
	private boolean ganasDeAtacar () {
		// Debería relacionarse el nivel actual con las ganas de atacar del malvado Ralph
		// Podría hacerse pasando el nivel como parámetro y jugando con él
		// Se implementa para testing en modo nivel 1
		RandomAcotado rnd = new RandomAcotado (1,8);
		if (rnd.getValor() == 1){
			return true;
		}
		else {
			return false;
		}
	}
	
	private void movimientoParcialLateral (Direccion direction) {
		while (!this.alBorde()) {
			this.mover(direction);
			if (this.ganasDeAtacar()) {
				this.tirarLadrillos();
			}
		}
	}
	
	private void movimientoTotalLateral () { 
		if (this.alBorde()) {
			if (this.alBordeIzquierdo()){
				this.movimientoParcialLateral(Direccion.DERECHA);
			}
			else {
				this.movimientoParcialLateral(Direccion.IZQUIERDA);
			}
		}
	}
	
	public void enUnaSeccion () {
		while (this.getFijo()){
			this.movimientoTotalLateral();
		}
	}
}
