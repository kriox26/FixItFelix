package modelo.dinamica.objetos;

import modelo.dinamica.Posicion;
import modelo.direcciones.Direccion;

/*
 * Representa la paloma que aparece de manera random, desplazandose desde un extremo
 * hacia al otro y desapareciendo.
 */

public class Paloma extends Objeto{
    private Direccion direccion;

    /*
     * El constructor de la paloma recibe la posicion desde la que parte.
     * A partir de ello interpreta si debe ir hacia la derecha o hacia la izquierda.
     * En caso de no poder interpretarlo por haber un error de posicionamiento (la paloma no empieza desde un costado) arroja una excepción de error.
     */

    public Paloma (Posicion pos) {
        this.setPosicion(pos);
        this.setDireccion(this.smartAddress(pos));
    }

    private Direccion smartAddress (Posicion pos) throws IllegalArgumentException {
      if (pos.getColumna() == 0) {
        return Direccion.DERECHA;
      }
      else if (pos.getColumna() == 4) {
        return Direccion.IZQUIERDA;
      }
      else throw new IllegalArgumentException("Parámetro posicional inválido");
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
