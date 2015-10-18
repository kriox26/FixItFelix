package modelo.main;
import modelo.dinamica.personajes.*;
import modelo.direcciones.*;

public class TestMain {

	public static void main(String[] args) {
		Main juego = new Main(true);
		juego.jugar();
        // Seteamos ambos personajes creados
        Felix felix = juego.dvp.getFelix();
        Ralph ralph = juego.dvp.getRalph(); // Santi no borr� esta l�nea porque supone se usar� m�s adelante
        while (true) {
            felix.mover(Direccion.DERECHA);
            for (int i = 0; i < 4; i++) {
                felix.martillar(juego.getNiceland().getVentana(felix.getPosicion()));
            }
        }
	}

}
