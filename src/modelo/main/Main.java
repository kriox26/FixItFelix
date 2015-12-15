package modelo.main;

/* Imports de librerias java */
import java.util.ArrayList;
import java.util.List;

import modelo.dinamica.Posicion;
import modelo.dinamica.objetos.Ladrillo;
import modelo.dinamica.objetos.Objeto;
import modelo.dinamica.objetos.Paloma;
import modelo.direcciones.Direccion;
import modelo.niceland.Niceland;
import modelo.util.RandomAcotado;
import excepciones.CambiarSeccionException;
import excepciones.LadrilloInexistenteException;
import excepciones.SeccionesException;
import excepciones.UltimaSeccionException;

/*
 * Clase que administra el desarrollo y contiene toda la logica del juego.
 * Todas las interacciones del usuario con el juego se dan a traves de esta clase.
 */
public class Main {
    private boolean jugando;
	  private boolean gameOver = false;
    public Desarrollo dvp;
    public Niceland niceland;
	  private int nivel;
    private List<Objeto> coleccionDeObjetos = new ArrayList<Objeto>();
    private int cont = 0;
    private int tiro = 0;
    private int ctePaloma = 150; // ¡Ojo! Variable duplicada en Controlador.java

    public Main(boolean jugando, int nivel){
        this.jugando = jugando;
		    this.nivel = nivel;
		    inicializar();
    }

	public Objeto getLadrilloByIndex(int index) throws LadrilloInexistenteException {
		for(Objeto ladrillo : coleccionDeObjetos){
			if((ladrillo instanceof Ladrillo) && ladrillo.getIndex() == index){
				return ladrillo;
			}
		}
		throw new LadrilloInexistenteException();
	}

	public int getCont(){
		return this.cont;
	}

  public List<Objeto> getColeccionDeObjetos(){
      return this.coleccionDeObjetos;
  }

  public boolean getJugando(){
      return this.jugando;
  }

  public void setJugando(boolean jugando){
      this.jugando = jugando;
  }

  public Desarrollo getDvp(){
      return this.dvp;
  }

  public Niceland getNiceland(){
      return this.niceland;
  }

  /*
   * Aca se maneja todo lo que se hace en cada turno, incluyendo personajes
   * tanto estaticos como dinamicos.
   */
    public void jugarUnTurno() throws SeccionesException {
    	if(this.getDvp().getSeccionActual() != (this.nivel * 3) - 1){
    		if(this.getNiceland().getSecciones()[this.getDvp().getSeccionActual()].todoArreglado()){
    			avanzarSeccion();
    			throw new CambiarSeccionException();
    		}
    	} else if(this.getNiceland().getSecciones()[this.getDvp().getSeccionActual()].todoArreglado()){
    		this.gameOver = true;
    		throw new UltimaSeccionException();
    	}
    	if ((this.cont % (50 / this.getNivel())) == 0){
    		coleccionDeObjetos.add(this.getDvp().getRalph().tirarLadrillo(this.cont));
            tiro++;
    	}
      if ((this.cont % (this.getCtePaloma() * this.multiplier(this.getNivel()))) == 0) {
        coleccionDeObjetos.add(this.parirPaloma());
      }
      this.getDvp().getRalph().mover();
      this.cont++;
        actualizarObjetos(); // Actualiza la collecion de objectos lanzados
    }

    private Paloma parirPaloma () {
      RandomAcotado num = new RandomAcotado(1,2); // Para randomizar la elección de la direccion
      RandomAcotado fila = new RandomAcotado (0,2); // Para randomizar la fila en que vuela
      Paloma bird = new Paloma();
      Posicion pos = new Posicion ();
      if (num.getValor() == 1) { // Es un pichoncito de Paloma que volará hacia la derecha
         pos.setColumna(0); // Empieza desde la izquierda
         bird.setDireccion(Direccion.DERECHA);
      }
      else { // Es un pichoncito de Paloma que volará hacia la izquierda
        pos.setColumna(4); // Empieza desde la derecha
    	  bird.setDireccion(Direccion.IZQUIERDA);

      }
      pos.setFila(fila.getValor());
      pos.setSeccion(this.getDvp().getSeccionActual());
      bird.setPosicion(pos);
      return bird;
    }

    private int getCtePaloma () {
    	return this.ctePaloma;
    }

    public void avanzarSeccion(){
    	coleccionDeObjetos.clear();
    	this.getDvp().getFelix().getPosicion().setSeccion(this.getDvp().getSeccionActual() + 1);
    	this.getDvp().getFelix().getPosicion().setFila(0);
    	this.getDvp().getRalph().getPosicion().setSeccion(this.getDvp().getSeccionActual() + 1);
    }

    /*
     * Se actualiza la collecion de objetos que se mantiene, esta coleccion tiene
     * los ladrillos lanzados, tartas, palomas y nicelanders. Ralph y felix se
     * actualizan por separado, ya que dependen directamente de la interaccion
     * del jugador con el juego.
     */
    private void actualizarObjetos(){
        int i = 0; // Seems unuseful but better not touch it yet. Then we may delete it...
        for (Objeto obj: coleccionDeObjetos) {
			if (obj instanceof Ladrillo){
				System.out.println("Posicion del ladrillo es: " + obj.getPosicion().to_string());
				System.out.println("Movimiento: " + obj.getMovimiento());
				if(!obj.getGolpeo()){
					obj.actualizar();
				}
				if ((obj.getPosicion().equal_to(this.getDvp().getFelix().getPosicion())) && (!obj.getGolpeo()) && (obj.getMovimiento() > 0)){
					System.out.println("Posicion de felix es: " + this.getDvp().getFelix().getPosicion().to_string());
					this.getDvp().getFelix().golpeadoPorLadrillo();
					obj.setGolpeo(true);
					this.getDvp().getFelix().getPosicion().setColumna(2);
					this.getDvp().getFelix().getPosicion().setFila(0);
				} else if(obj.getMovimiento() < 0){
					obj.setGolpeo(true);
				}
			}
			i++;
        }
    }

  /*
   * Se ejecuta despues de jugar el turno y actualizar los objetos. Se fija que
   * Felix aun tenga vidas, y que todavia no haya llegado al fin del edificio.
   * @return boolean: True si el juego termino, false caso contrario
   */

  public boolean gameOver(){
      System.out.println("Tiro: " + tiro);
	    if (this.getDvp().getFelix().getVida() <= 0) {
		       this.gameOver = true;
	    } else if (this.getNiceland().getSecciones()[this.getDvp().getSeccionActual()].todoArreglado()){
		       avanzar();
	    }
	    return this.gameOver;
  }

  /*
   * Se inicializa todo lo necesario para jugar. El constructor de
   * Niceland crea todas las secciones, vetanas, paneles con sus estados,
   * acorde al nivel elegido. El constructor de Desarrollo crea los personajes
   * respectivas posiciones.
   * @params int nivel: Indica el nivel actual del juego, las secciones dependen
   * de el.
   */

  private void inicializar(){
      this.niceland = new Niceland(this.getNivel());
      this.dvp = new Desarrollo(0, 0);
  }

	public int getNivel(){
		return this.nivel;
	}
	public void setNivel(int nivel){
		this.nivel = nivel;
		inicializar();
	}

	public void avanzar(){
		if(this.getDvp().getSeccionActual() == this.nivel * 3){
			this.gameOver = true;
		}
	}

  public Objeto getLastBird () {
    int i = 0;
    for(Objeto paloma : coleccionDeObjetos){
	  if((paloma instanceof Paloma)){
        i = paloma.getIndex();
      }
    }
    return this.coleccionDeObjetos.get(i);
  }

  private int multiplier (int nivel) { // ¡Ojo! Sobreescritura de còdigo. Este metodo se duplica en Controlador.java
    int nro;
    switch (nivel) {
      case 1: nro = 5;
      break;
      case 2: nro = 3;
      break;
      case 3: nro = 1;
      break;
      default: nro = 7; // Si no recibe nivel como parámetro asume nivel básico como prueba
    }
    return nro;
  }

}
