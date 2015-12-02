package modelo.dinamica.personajes;

import modelo.dinamica.Posicion;
import modelo.dinamica.objetos.Ladrillo;
import modelo.direcciones.Direccion;
import modelo.util.RandomAcotado;

/**
 * La clase Ralph representa al villano del juego.
 * Debe poder moverse horizontalmente por toda la fila
 * asignada desde la que lanzará ladrillos dependiendo
 * de su ira que incrementa nivel a nivel.
 *
 * @see modelo.dinamica.personajes.Personaje
 * @see modelo.dinamica.Dinamico
 */

public class Ralph extends Personaje {
	private int ladrillos;
    private int total_ladrillos_lanzados;
	private static final int cuantosTira = 3;
	private static final int kl = 5; // Constante de ladrillos por nivel
	private Ladrillo[] ladrillos_lanzados;
	private boolean fijo; // Si est� en una secci�n haciendo sus maldades. O sea, no est� cambiando de secci�n
	private boolean ganasDeAtacar;

  public Ralph(String nombre, int ladrillos, Posicion posicion){
  	super(nombre, posicion);
      this.ladrillos = ladrillos;
      this.ladrillos_lanzados = new Ladrillo[this.ladrillos];
      this.total_ladrillos_lanzados = 0;
  }

	public void setGanas (boolean tof) {
		this.ganasDeAtacar = tof;
	}

	public boolean getGanas () {
		return this.ganasDeAtacar;
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

    /*
     * Tira la cantidad de ladrillos especificada por la variable cuantosTira.
     */
	public void tirarLadrillos () {
		if (this.hayLadrillos()) {
			this.setLadrillos(this.getLadrillos() - cuantosTira);
			for (int i=0; i< cuantosTira; i++) {
                this.getLadrillosLanzados()[this.getTotalLadrillosLanzados()] = new Ladrillo(this.getPosicion());
                this.getLadrillosLanzados()[this.getTotalLadrillosLanzados()].caerDesde(this.getPosicion());
                this.setTotalLadrillosLanzados(this.getTotalLadrillosLanzados() + 1);
			}
		}
	}
    
    public Ladrillo tirarLadrillo(){
        if (this.hayLadrillos()) {
            this.setLadrillos(this.getLadrillos() - 1);
            return new Ladrillo(this.getPosicion().getSeccion(), this.getPosicion().getFila(), this.getPosicion().getColumna() );
        }
        return null;
    }

	private void movimientoParcialLateral (Direccion direction) {
		while (!this.alBorde()) {
			this.mover(direction);
			if (this.getGanas()) {
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

    /*
     * Mueve a ralph en la direccion especificada.
     * @params Direccion direction: Direccion en la que se lo quiere mover
     */
    public void mover(){
        RandomAcotado rnd = new RandomAcotado(0,1);
        switch (rnd.getValor()) {
            case 0: 
                if(!this.alBordeDerecho())
                    this.setPosicion(this.getPosicion().modificar(Direccion.DERECHA));
                break;
            case 1:
                if(!this.alBordeIzquierdo())
                    this.setPosicion(this.getPosicion().modificar(Direccion.IZQUIERDA));
                break;
            default: break;
        }
    }

	public Ladrillo[] getLadrillosLanzados() {
		return this.ladrillos_lanzados;
	}
}
