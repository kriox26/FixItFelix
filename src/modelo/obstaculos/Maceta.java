package modelo.obstaculos;
import modelo.direcciones.*;

public class Maceta extends Obstaculo {
    
    /*
     * Si la direccion que se mande es hacia Abajo devuelve false, caso contrario
     * devuelve true.
     * @param direccion : Direccion hacia la que se esta queriendo mover
     * @return boolean Devuelve true si se puede pasar, false caso contrario
     */
    public boolean puedoPasar(Direccion direccion){
        return !(direccion instanceof Abajo);
    }

}
