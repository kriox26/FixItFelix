package modelo.niceland;
import modelo.dinamica.Posicion;

public class Niceland {
	private Seccion[] secciones;
    private int seccion_actual;
	
    public int getSeccionActual(){
        return this.seccion_actual;
    }
    
    public void setSeccionActual(int seccion_actual){
        this.seccion_actual = seccion_actual;
    }

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
        for (int i = 1; i < total_secciones; i++) {
            secciones[i] = new Seccion("Media", false, false);
        }
        seccion_actual = 0;
	}
    
    /*
     * Devuelve la ventana en la que felix esta actualmente
     * @param posicion : Es la posicion en la que esta felix
     * @return Ventana : Ventana en la que esta parado felix
     */
    public Ventana rastrear(Posicion posicion){
        return secciones[this.getSeccionActual()].getVentanas()[posicion.getFila()][posicion.getColumna()];
    }
    
    
}
