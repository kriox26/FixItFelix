package modelo.main;
import modelo.niceland.*;

public class Main {
    private boolean jugando;
    public Desarrollo dvp;

    public Main(boolean jugando){
        this.jugando = jugando;
    }

    public boolean getJugando(){
        return this.jugando;
    }

    public void setJugando(boolean jugando){
        this.jugando = jugando;
    }

    public void jugar(){
        this.inicializar(); // Para inicializar todo(niceland TODO= personajes)
    }

    // TODO: implementar todas las funciones
    private void inicializar(){
        // Inicializamos el edificio Niceland, params: nivel = 1
        // Se crean todas las secciones, ventanas, paneles, estados
        niceland = new Niceland(1);
        // this.dvp = new Desarrollo(0, 0); // con nivel actual = 0, puntos = 0
        // Cuando se inicializa la clase Desarrollo, se inicializan los personajes tambien
        this.dvp = new Desarrollo(0, 0);
				// Habria que inicializar a los personajes, seria ideal que con llamar al new desarrollo
				// se cree todo
    }
}
