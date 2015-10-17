package modelo.main;
import modelo.niceland.*;

public class Main {
    private boolean jugando;
    public Desarrollo dvp;
    public Niceland niceland;

    public Main(boolean jugando){
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

    public void jugar(){
        this.inicializar(); // Para inicializar todo(niceland TODO= personajes)
    }

    private void inicializar(){
        // Inicializamos el edificio Niceland, params: nivel = 1
        // Se crean todas las secciones, ventanas, paneles, estados
        this.niceland = new Niceland(1);
        // this.dvp = new Desarrollo(0, 0); // con nivel actual = 0, puntos = 0
        // Cuando se inicializa la clase Desarrollo, se inicializan los personajes tambien
        this.dvp = new Desarrollo(0, 0);
    }
}
