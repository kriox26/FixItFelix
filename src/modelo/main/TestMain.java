package modelo.main;
import modelo.dinamica.personajes.*;
import modelo.niceland.*;
import modelo.direcciones.*;

public class TestMain {

	public static void main(String[] args) {
		Main juego = new Main(true);
		juego.jugar();
        // Seteamos ambos personajes creados
        Felix felix = juego.dvp.getFelix();
        Ralph ralph = juego.dvp.getRalph();
        Izquierda izquierda = new Izquierda();
        Derecha derecha = new Derecha();
        Abajo abajo = new Abajo();
        Arriba arriba = new Arriba();
        
        while (true) {
            felix.mover(derecha);
            for (int i = 0; i < 4; i++) {
                felix.martillar(juego.getNiceland().getVentana(felix.getPosicion()));
            }
        }
	}

}
