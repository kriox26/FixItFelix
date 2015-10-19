package modelo.dinamica.personajes;

import modelo.dinamica.Posicion;
import modelo.direcciones.*;
import modelo.util.RandomAcotado;
import modelo.dinamica.objetos.*;

public class Ralph extends Personaje {
	private int ladrillos;
    private int total_ladrillos_lanzados;
	private static final int cuantosTira = 1;
	private static final int kl = 5; // Constante de ladrillos por nivel
	private Ladrillo[] ladrillos_lanzados;
	private boolean fijo; // Si est� en una secci�n haciendo sus maldades. O sea, no est� cambiando de secci�n

  public Ralph(String nombre, int ladrillos, Posicion posicion){
  	super(nombre, posicion);
      this.ladrillos = ladrillos;
      this.ladrillos_lanzados = new Ladrillo[this.ladrillos];
      this.total_ladrillos_lanzados = 0;
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
    
    public void setTotalLadrillosLanzados(int cantidad){
        this.total_ladrillos_lanzados = cantidad;
    }
    
    public int getTotalLadrillosLanzados(){
        return this.total_ladrillos_lanzados;
    }

	public boolean hayLadrillos () {
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
			for (int i=0; i< cuantosTira; i++) {
                this.getLadrillosLanzados()[this.getTotalLadrillosLanzados()] = new Ladrillo(this.getPosicion());
                System.out.println("Ralph tira un ladrillo desde: (Seccion: " + this.getPosicion().getSeccion() + ", Fila: " + this.getPosicion().getFila() + ", Columna: " + this.getPosicion().getColumna() + ") ");
                this.getLadrillosLanzados()[this.getTotalLadrillosLanzados()].caer();
                this.setTotalLadrillosLanzados(this.getTotalLadrillosLanzados() + 1);
			}
		}
	}
	
	
	private boolean ganasDeAtacar () {
		// Deber�a relacionarse el nivel actual con las ganas de atacar del malvado Ralph
		// Podr�a hacerse pasando el nivel como par�metro y jugando con �l
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
    
    public void mover(Direccion direccion){
        super.mover(direccion);
        System.out.println("Ralph se mueve " + direccion.getHorizontal() + " en el ejex X y " + direccion.getVertical() + " en el eje Y");
    }

	public Ladrillo[] getLadrillosLanzados() {
		return this.ladrillos_lanzados;
	}
}
