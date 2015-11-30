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
  private boolean abierta;

    public Puerta(){
        this.paneles = new Panel[4];
        this.setearPaneles(4);
        this.setAbierta(false);
    }

    public void setAbierta(boolean var) {
      this.abierta = var;
    }

    public boolean getAbierta () {
      return this.abierta;
    }
    /*
    * Las puertas tiene 4 paneles, entonces tenemos
    * que seguir arreglando hasta llegar a 4*2 = 8 martillazos
    */
    public void arreglarPanel(){
        if (this.getMartillazosRecibidos() <= 8) {
            super.arreglarPanel();
        }
    }

   /*
    * 0 - sana
    * 1 - abierta
    * 2 - dañados los paneles inferiores
    * 3 - dañados los paneles derechos
    * 4 - dañados todos los paneles salvo el de arriba a la izquierda
    * 5 - dañados todos los paneles salvo el de arriba a la derecha
    * 6 - dañados los paneles de la diagonal en sentido \
    * 7 - dañado el panel de arriba a la izquierda
    * 8 - dañado el panel de arriba a la derecha
    * 9 - dañado el panel de abajo a la izquierda
    * 10 - dañado el panel de abajo a la derecha
    * 11 - dañados todos los paneles salvo el de abajo a la izquierda
    * 12 - dañados todos los paneles salvo el de abajo a la derecha
    * 13- EXC / ERR
    */

    public int estadoTotal() {
      if (this.getAbierta() == true) {
        return 1;
      }
      if (this.estaSana()) {
        return 0;
      }
      if (this.panelMR(0) && this.panelMR(1) && !this.panelMR(2) && !panelMR(3)) {
        return 2;
      }
      if (!this.panelMR(0) && this.panelMR(1) && !this.panelMR(2) && this.panelMR(3)) {
        return 3;
      }
      if (this.panelMR(0) && this.panelMR(1) && !this.panelMR(2) && this.panelMR(3)) {
        return 4;
      }
      if (this.panelMR(0) && !this.panelMR(1) && this.panelMR(2) && !this.panelMR(3)) {
        return 5;
      }
      if (!this.panelMR(0) && this.panelMR(1) && this.panelMR(2) && !this.panelMR(3)) {
        return 6;
      }
      if (!this.panelMR(0) && !this.panelMR(1) && this.panelMR(2) && !this.panelMR(3)) {
        return 7;
      }
      if (!this.panelMR(0) && !this.panelMR(1) && !this.panelMR(2) && this.panelMR(3)) {
        return 8;
      }
      if (this.panelMR(0) && !this.panelMR(1) && !this.panelMR(2) && !this.panelMR(3)) {
        return 9;
      }
      if (!this.panelMR(0) && this.panelMR(1) && !this.panelMR(2) && !this.panelMR(3)) {
        return 10;
      }
      if (!this.panelMR(0) && this.panelMR(1) && this.panelMR(2) && this.panelMR(3)) {
        return 11;
      }
      if (this.panelMR(0) && !this.panelMR(1) && this.panelMR(2) && this.panelMR(3)) {
        return 12;
      }
      return 13;
    }

    /*
     * 0 - panel inferior izquierdo
     * 1 - panel inferior derecho
     * 2 - panel superior izquierdo
     * 3 - panel superior derecho
     */

    private panelMR (int n) { // MR: medio roto // Aclaracioón: en la puerta no hay paneles rotos del todo
      if (this.getPaneles()[n].estaMedioRoto()) {
        return true;
      }
      else
        return false;
    }

}
