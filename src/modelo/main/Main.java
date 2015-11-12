package modelo.main;

/* Imports de librerias java */
import java.util.ArrayList;
import java.util.List;

/* Imports de clases relacionadas al proyecto */
import modelo.dinamica.Dinamico;
import modelo.dinamica.personajes.*;
import modelo.niceland.*;

public class Main {
    private boolean jugando;
    public Desarrollo dvp;
    public Niceland niceland;
    private List<Dinamico> collecionDeObjetos = new ArrayList<Dinamico>();

    public Main(boolean jugando, int nivel){
        this.jugando = jugando;
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
        actualizarObjetos(); // Actualiza la collecion de objectos lanzados
    }
    
    private void actualizarObjetos(){
        
    }

    /*
     * Simulacion del juego. Todas las acciones se manejan desde este metodo.
     * Movimientos de felix y ralph, actualizacion de objetos y estado del juego,
     * ralph tirando ladrillos, etc.
     * @params int nivel: El nivel elegido para el juego actual.
     */
    public void jugar(int nivel){
        this.inicializar(nivel);
        while (!gameOver()) {
            jugarUnTurno();
            actualizarObjetos();
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
    private void inicializar(int nivel){
        this.niceland = new Niceland(nivel);
        this.dvp = new Desarrollo(0, 0);
    }
}
