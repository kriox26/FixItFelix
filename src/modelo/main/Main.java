package modelo.main;

/* Imports de librerias java */
import java.util.ArrayList;
import java.util.List;

import modelo.dinamica.objetos.Ladrillo;
import modelo.dinamica.objetos.Objeto;
import modelo.niceland.Niceland;

/*
 * Clase que administra el desarrollo y contiene toda la logica del juego.
 * Todas las interacciones del usuario con el juego se dan a traves de esta clase.
 * @author Matias Pan
 */
public class Main {
    private boolean jugando;
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
    public void jugarUnTurno(){
    	if (cont % 25 == 0){
    		coleccionDeObjetos.add(this.getDvp().getRalph().tirarLadrillo());
            tiro++;
    	}
        this.getDvp().getRalph().mover();
        cont++;
        
        actualizarObjetos(); // Actualiza la collecion de objectos lanzados
    }
    
    /*
     * Se actualiza la collecion de objetos que se mantiene, esta coleccion tiene
     * los ladrillos lanzados, tartas, palomas y nicelanders. Ralph y felix se
     * actualizan por separado, ya que dependen directamente de la interaccion
     * del jugador con el juego.
     */
    private void actualizarObjetos(){
        for (Objeto obj: coleccionDeObjetos) {
        	if(obj != null){
        		obj.actualizar();
        		if (obj instanceof Ladrillo){
        			System.out.println("Posicion del ladrillo es: " + obj.getPosicion().to_string());
        			if (obj.getPosicion().equal_to(this.getDvp().getFelix().getPosicion())){
        			System.out.println("Posicion de felix es: " + this.getDvp().getFelix().getPosicion().to_string());
        				this.getDvp().getFelix().golpeadoPorLadrillo();
        			}
        		}
        	}
        }
    }
    
    /*
     * Se ejecuta despues de jugar el turno y actualizar los objetos. Se fija que
     * Felix aun tenga vidas, y que todavia no haya llegado al fin del edificio.
     * @return boolean: True si el juego termino, false caso contrario
     */
    public boolean gameOver(){
        System.out.println("Tiro: " + tiro);
        return this.getDvp().getFelix().getVida() <= 0 ? true : false;
    }

    /*
     * Simulacion del juego. Todas las acciones se manejan desde este metodo.
     * Movimientos de felix y ralph, actualizacion de objetos y estado del juego,
     * ralph tirando ladrillos, etc.
     * @params int nivel: El nivel elegido para el juego actual.
     */
    public void jugar(){
    	this.jugando=true;
        this.inicializar();
        while (!gameOver()) {
            jugarUnTurno();
        }
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
}
