package modelo.obstaculos;
import modelo.direcciones.*;

/*
 * Representa un obstaculo generico que no bloquea nada. Esta clase es usada por
 * el resto de los obstaculos, donde direccion_que_bloquea es la variable que
 * especifica hacia donde bloquea el obstaculo actual.
 * @author Matias Pan
 * @see modelo.obstaculos.Obstaculo
 */
public class Obstaculo {
    protected Direccion direccion_que_bloquea;

    public Obstaculo(){
        this.direccion_que_bloquea = Direccion.NULA;
    }
    
    public Obstaculo(Direccion direccion){
        this.direccion_que_bloquea = direccion;
    }

    /*
     * Si se inicializa un Obstaculo, entonces siempre se va a poder pasar sin
     * importar que direccion se mande.
     * @param direccion : Direccion hacia la que se esta queriendo mover
     * @return boolean Devuelve true si se puede pasar, false caso contrario
     */
    public boolean puedoPasar(Direccion direccion){
        return true;
    }
    
    public Direccion getDireccion(){
        return this.direccion_que_bloquea;
    }

}
