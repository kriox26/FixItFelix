package modelo.dinamica.objetos;

import modelo.direcciones.Direccion;
import modelo.dinamica.Posicion;

/*
 * Representa la grua que aparece en las animaciones de introduccion al juego
 */
public class Grua extends Objeto {
    private Direccion direccion;

    public Grua (Posicion position) {
      this.setPosicion(position);
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
