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
        }
    }
    
   /*
    * 0 - sana
    * 1 - dañada abajo a la izquierda de todo
    * 2 - dañada abajo en todo el sector izquierdo
    * 3 - dañada abajo en todo el sector izquierdo y parte del derecho
    * 4 - dañada abajo por completo
    * 5 - dañada arriba a la izquierda de todo
    * 6 - dañada arriba en todo el sector izquierdo
    * 7 - dañada arriba en el panel izquierdo del centro
    * 8- dañada arriba en los dos paneles centrales
    * 9 - dañada arriba en los paneles de la derecha tanto del sector izquierdo como del derecho
    * 10 - dañada en el panel derecho del centro
    * 11 - dañada a la derecha de todo
    */

    public int estadoTotal() {
      if (this.estaSana()) {
        return 0;
      }
      if (this.estaSanaArriba() && this.panelMR(4) && !this.panelMR(5) && !this.panelMR(6) && !this.panelMR(7)) {
        return 1;
      }
      if (this.estaSanaArriba() && this.panelMR(4) && this.panelMR(5) && !this.panelMR(6) && !this.panelMR(7)) {
        return 2;
      }
      if (this.estaSanaArriba() && this.panelMR(4) && this.panelMR(5) && this.panelMR(6) && !this.panelMR(7)) {
        return 3;
      }
      if (this.estaSanaArriba() && this.estaRotaAbajo()) {
        return 4;
      }
      if (this.estaSanaAbajo() && this.panelMR(0) && !this.panelMR(1) && !this.panelMR(2) && !this.panelMR(3)) {
        return 5;
      }
      if (this.estaSanaAbajo() && this.panelMR(0) && this.panelMR(1) && !this.panelMR(2) && !this.panelMR(3)) {
        return 6;
      }
      if (this.estaSanaAbajo() && !this.panelMR(0) && this.panelMR(1) && !this.panelMR(2) && !this.panelMR(3)) {
        return 7;
      }
      if (this.estaSanaAbajo() && !this.panelMR(0) && this.panelMR(1) && this.panelMR(2) && !this.panelMR(3)) {
        return 8;
      }
      if (this.estaSanaAbajo() && !this.panelMR(0) && this.panelMR(1) && !this.panelMR(2) && this.panelMR(3)) {
        return 9;
      }
      if (this.estaSanaAbajo() && !this.panelMR(0) && !this.panelMR(1) && this.panelMR(2) && !this.panelMR(3)) {
        return 10;
      }
      if (this.estaSanaAbajo() && !this.panelMR(0) && !this.panelMR(1) && this.panelMR(2) && !this.panelMR(3)) {
        return 11;
      }
      return 12;
    }

    /*
     * 0 - panel superior izquierdo
     * 1 - panel superior central izquierdo
     * 2 - panel superior central derecho
     * 3 - panel superior derecho
     * 4 - panel inferior izquierdo
     * 5 - panel inferior central izquierdo
     * 6 - panel inferior central derecho
     * 7 - panel inferior derecho
     */

    private boolean estaSanaArriba() {
      if (!this.panelMR(0) && !this.panelMR(1) && !this.panelMR(2) && !this.panelMR(3)) { // Si ningun panel superior esta roto
          return true;
      }
      else {
        return false;
      }
    }

//    private boolean estaRotaArriba() { // rota por completo arriba
//      if (this.panelMR(0) && this.panelMR(1) && this.panelMR(2) && this.panelMR(3)) {
//          return true;
//      }
//      else {
//        return false;
//      }
//    }

    private boolean estaSanaAbajo() {
      if (!this.panelMR(4) && !this.panelMR(5) && !this.panelMR(6) && !this.panelMR(7)) { // Si ningun panel superior esta roto
          return true;
      }
      else {
        return false;
      }
    }

    private boolean estaRotaAbajo() { // rota rpo completo abajo
      if (this.panelMR(4) && this.panelMR(5) && this.panelMR(6) && this.panelMR(7)) { // Si ningun panel superior esta roto
          return true;
      }
      else {
        return false;
      }
    }
}
