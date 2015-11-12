package modelo.dinamica.objetos;

import modelo.direcciones.Direccion;
import modelo.dinamica.Posicion;

/*
 * Representa la paloma que aparece de manera random, desplazandose desde un extremo
 * hacia al otro y desapareciendo.
 */
public class Paloma extends Objeto{
    private Direccion direccion;
    
    /*
     * El constructor de la paloma recibe la direccion a la que se debe mover.
     * Ya que se puede desplazar de Izquierda -> Derecha o Derecha -> Izquierda.
     */
    public Paloma(Direccion direccion){
        this.direccion = direccion;
    }
    
    public Direccion getDireccion(){
        return this.direccion;
    }
    
    public void setDireccion(Direccion direccion){
        this.direccion = direccion;
    }
    
    public void actualizar(){
        desplazar();
    }
    
    private void desplazar(){
        super.mover(this.getDireccion());
    }
}
