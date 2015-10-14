package modelo.niceland;

public class Puerta extends Ventana {
    
    public Puerta(){
        this.paneles = new Panel[4];
        super.setearPaneles(4);
    }
    
    /*
    * Las puertas tiene 4 paneles, entonces tenemos
    * que seguir arreglando hasta llegar a 4*2 = 8 martillazos
    */
    protected void arreglarPanel(){
        if (this.getMartillazosRecibidos() <= 8) {
            super.arreglarPanel();
        }
    }

}
