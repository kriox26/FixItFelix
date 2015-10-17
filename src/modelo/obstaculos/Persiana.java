package modelo.obstaculos;
import modelo.direcciones.*;

public class Persiana extends Obstaculo {

    public Persiana(Direccion direccion){
    	super(direccion);
    }
    
    /*
     * Indica si se puede pasar. Si la variable direccion_que_bloquea es del
     * mismo tipo que la direccion que se mande, devuelve true, caso contrario
     * devuelve false.
     * @param direccion : Direccion hacia la que se esta queriendo mover
     * @return boolean Devuelve true si se puede pasar, false caso contrario
     */
    public boolean puedoPasar(Direccion direccion){
        return direccion.getClass().equals(this.direccion_que_bloquea.getClass());
    }
}
