package modelo.main;

/* Imports de librerias java */
import java.util.ArrayList;
import java.util.List;

import modelo.dinamica.objetos.Ladrillo;
import modelo.dinamica.objetos.Objeto;
import modelo.niceland.Niceland;
import excepciones.CambiarSeccionException;
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

    public Main(boolean jugando, int nivel){
        this.jugando = jugando;
		    this.nivel = nivel;
		    inicializar();
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
    	if (cont % 50 == 0){
   			System.out.println("Agrega ladrillo objeto");
    		coleccionDeObjetos.add(this.getDvp().getRalph().tirarLadrillo());
            tiro++;
    	}
        this.getDvp().getRalph().mover();
        cont++;

        actualizarObjetos(); // Actualiza la collecion de objectos lanzados
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
        int i = 0;
        for (Objeto obj: coleccionDeObjetos) {
			if (obj instanceof Ladrillo){
				System.out.println("Posicion del ladrillo es: " + obj.getPosicion().to_string());
				System.out.println("Movimiento: " + obj.getMovimiento());
				if(!obj.getGolpeo()){
					obj.actualizar();
				}
				if (obj.getPosicion().equal_to(this.getDvp().getFelix().getPosicion()) && !obj.getGolpeo()){
					System.out.println("Posicion de felix es: " + this.getDvp().getFelix().getPosicion().to_string());
					this.getDvp().getFelix().golpeadoPorLadrillo();
					obj.setGolpeo(true);

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
		}else if (this.getNiceland().getSecciones()[this.getDvp().getSeccionActual()].todoArreglado()){
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

	public void avanzar(){
		if(this.getDvp().getSeccionActual() == this.nivel * 3){
			this.gameOver = true;
		}
	}
}
