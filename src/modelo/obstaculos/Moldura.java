package modelo.obstaculos;
import modelo.direcciones.*;

public class Moldura extends Obstaculo {

    /*
     * Si la direccion que se mande es hacia Arriba devuelve false, caso contrario
     * devuelve true.
     * @param direccion : Direccion hacia la que se esta queriendo mover
     * @return boolean Devuelve true si se puede pasar, false caso contrario
     */
    public boolean puedoPasar(Direccion direccion){
        return !(direccion == Direccion.ARRIBA);
    }

}
