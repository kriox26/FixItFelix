package modelo.niceland;

/**
 * Representa un tipo de ventana denominada Semicircular. Las carecteristicas
 * de esta ventana son:
 *              - 8 paneles los cuales se pueden romper y arreglar(en orden)
 *              - Esta ventana no puede tener obstaculos
 *
 * @author  Matias Pan
 * @see modelo.niceland.Ventana
 * @see modelo.niceland.Panel
 */
public class Semicircular extends Ventana {
    
    public Semicircular(){
        this.paneles = new Panel[8];
        this.setearPaneles(8);
    }
    
    /*
     * Las ventanas semicirculares tiene 8 paneles, entonces tenemos
     * que seguir arreglando hasta llegar a 8*2 = 16 martillazos
     */
    public void arreglarPanel(){
        if (this.getMartillazosRecibidos() < 16) {
        	super.arreglarPanel();
        }else{
            System.out.println("Esta ventana ya esta arreglada.");
        }
    }
}
