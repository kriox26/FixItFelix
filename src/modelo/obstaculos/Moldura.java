package modelo.obstaculos;
import modelo.direcciones.*;

/*
 * Representa al obstaculo que puede aparecer de manera random en ventanas simples.
 * Este obstaculo bloquea a Felix, no le permite moverse hacia arriba estando en la ventana.
 * @author Matias Pan
 * @see modelo.obstaculos.Obstaculo
 */
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
