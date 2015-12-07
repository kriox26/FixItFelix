package modelo.main;
import modelo.dinamica.Posicion;

import modelo.dinamica.personajes.*;

/*
 * Encargada de guardar el desarrollo actual del juego, incluyendo estado de personajes,
 * puntos acumulados, y nivel actual.
 * Esta clase es administrada desde Main.
 * @author Matias Pan
 * @see modelo.main.Main
 */
public class Desarrollo {
    private int nivel;
    private int puntos;
    public Ralph ralph;
    public Felix felix;

    public Desarrollo(int nivel, int puntos){
        this.nivel = nivel;
        this.puntos = puntos;
        this.setearPersonajes();
    }

	public int getSeccionActual(){
		return this.getFelix().getPosicion().getSeccion();
	}

    public int getNivel(){
        return this.nivel;
    }

    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public int getPuntos(){
        return this.puntos;
    }

    public void setPuntos(int puntos){
        this.puntos = puntos;
    }
    
    public Felix getFelix(){
        return this.felix;
    }
    
    public Ralph getRalph(){
        return this.ralph;
    }
    
    /*
     * Crea a ralph y a felix con las posiciones por default en la seccion
     * inicial del juego.
     */
    private void setearPersonajes(){
        Posicion pos_felix = new Posicion(0, 2, 0);
        Posicion pos_ralph = new Posicion(0, 2, 1);
        this.felix = new Felix("Felix", 4, false, pos_felix);
        this.ralph = new Ralph("Ralph", 100, pos_ralph);
    }
}
