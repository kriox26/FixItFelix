package modelo.main;

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
        this.inicializar(); // Para inicializar el todo
    }
    
    // TODO: implementar todas las funciones
    private void inicializar(){
        // Inicializamos el edificio Niceland
        /*
         * Se tendria que hacer algo asi:
         * niceland = new Niceland(); Para iniciar el edificio, en el test se tiene un solo nivel
         * Esa linea va a crear todas las secciones, ventanas, paneles, estados
         * this.dvp = new Desarrollo(1, 0); // con nivel = 1, puntos = 0
         * Cuando se inicializa la clase Desarrollo, se inicializan los personajes tambien
         * la posicion inicial de Felix va a ser: Fila 0, columna 2(tomandolo con dimensiones de arreglos)
         */
    }
}