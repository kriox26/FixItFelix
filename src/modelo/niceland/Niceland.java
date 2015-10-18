package modelo.niceland;
import modelo.dinamica.Posicion;

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
        int total_secciones = niveles * 3;
        secciones = new Seccion[total_secciones];
        secciones[0] = new Seccion("Inferior", true, false);
        secciones[total_secciones - 1] = new Seccion("Superior", false, true);
        for (int i = 1; i < (total_secciones - 1); i++) {
            secciones[i] = new Seccion("Media", false, false);
        }
	}
    
	public Seccion[] getSecciones(){
		return this.secciones;
	}

    public Ventana getVentana(Posicion posicion){
        return this.getSecciones()[posicion.getSeccion()].getVentanas()[posicion.getFila()][posicion.getColumna()];
    }
}
