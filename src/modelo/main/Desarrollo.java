package modelo.main;
import modelo.dinamica.Posicion;

import modelo.dinamica.personajes.*;

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
     * Crea a ralph y a felix
     */
    private void setearPersonajes(){
        Posicion pos_felix = new Posicion(0, 2, 0);
        Posicion pos_ralph = new Posicion(0, 2, 1);
        this.felix = new Felix("Felix", 3, false, pos_felix);
        this.ralph = new Ralph("Ralph", 100, pos_ralph);
    }
}
