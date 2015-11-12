package modelo.dinamica.objetos;

/*
 * Representa la tarta que se posicion por un nicelander en ventanas cuyo
 * panel inferior esta Roto.
 */
public class Tarta extends Objeto {
    private boolean devorada;
    
    public void actualizar(){
        
    }
    
    public boolean getDevorada(){
        return this.devorada;
    }
    
    public void setDevorada(boolean devorada){
        this.devorada = devorada;
    }
    
}
