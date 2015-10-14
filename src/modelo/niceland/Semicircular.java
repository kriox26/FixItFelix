package modelo.niceland;

public class Semicircular extends Ventana {
    
    public Semicircular(){
        this.paneles = new Panel[8];
        super.setearPaneles(8);
    }
    
    /*
     * Las ventanas semicirculares tiene 8 paneles, entonces tenemos
     * que seguir arreglando hasta llegar a 8*2 = 16 martillazos
     */
    protected void arreglarPanel(){
        if (this.getMartillazosRecibidos() <= 16) {
        	super.arreglarPanel();
        }
    }
}
