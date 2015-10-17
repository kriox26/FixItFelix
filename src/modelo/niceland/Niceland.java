package modelo.niceland;

public class Niceland {
	private Seccion[] secciones;
	
    /*
     * Constructor, recibe un entero que indica los niveles del juego, lo cual
     * tambien indica la cantidad de secciones que va a haber. Si el juego es de
     * dos niveles, la cantidad de secciones va a ser: 2 * 3 = 6. Si es un solo
     * hay solo 3 secciones(Inferior, Media, Superior).
     * @params int niveles: Niveles del juego
     */
	public Niceland(int niveles){
        // niveles * 3 es la cantidad de secciones total. Hay 3 pisos por seccion
        int total_secciones = niveles * 3;
        secciones = new Seccion[total_secciones];
        // Parametros: String tipo, boolean piso, boolean techo
        secciones[0] = new Seccion("Inferior", true, false);
        secciones[total_secciones - 1] = new Seccion("Superior", false, true);
        for (int i = 1; i <= total_secciones; i++) {
            secciones[i] = new Seccion("Media", false, false);
        }
	}
}
