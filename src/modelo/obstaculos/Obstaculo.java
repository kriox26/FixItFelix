package modelo.obstaculos;
import modelo.direcciones.*;

public class Obstaculo {
    protected Direccion direccion_que_bloquea;

    public Obstaculo(){
        this.direccion_que_bloquea = new Direccion();
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

}
