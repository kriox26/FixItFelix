package modelo.niceland;

/**
 * Representa un tipo de ventana denominada Puerta. Las carecteristicas
 * de esta ventana son:
 *              - 4 paneles los cuales se pueden romper y arreglar(en orden)
 *              - Esta ventana no puede tener obstaculos
 *
 * @author  Matias Pan
 * @see modelo.niceland.Ventana
 * @see modelo.niceland.Panel
 */
public class Puerta extends Ventana {
    
    public Puerta(){
        this.paneles = new Panel[4];
        this.setearPaneles(4);
    }
    
    /*
    * Las puertas tiene 4 paneles, entonces tenemos
    * que seguir arreglando hasta llegar a 4*2 = 8 martillazos
    */
    public void arreglarPanel(){
        if (this.getMartillazosRecibidos() <= 8) {
            super.arreglarPanel();
        }else{
            System.out.println("Esta ventana ya esta arreglada.");
        }
    }

}
