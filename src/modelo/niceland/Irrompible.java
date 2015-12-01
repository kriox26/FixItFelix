package modelo.niceland;
import modelo.obstaculos.*;
import modelo.direcciones.*;
import modelo.util.RandomAcotado;

/**
 * Representa un tipo de ventana denominada Irrompible. Las carecteristicas
 * de esta ventana son:
 *              - 2 paneles los cuales son irrompibles
 *              - Estar abierta(con las persianas hacia algun lado) o cerrada.
 *
 * @see modelo.niceland.Ventana
 * @see modelo.niceland.Persiana
 * @see modelo.niceland.Panel
 */
public class Irrompible extends Ventana {

    public Irrompible(){
        this.setearObstaculo();
        this.setearPaneles(2);
    }

    /*
     * Setea cada panel de la ventana, con un estado aleatorio
     * @params cantidad : Cantidad de paneles que tiene que setear
     */
    @Override
    protected void setearPaneles(int cantidad){
        paneles = new Panel[cantidad];
        for (int i = 0; i < cantidad; i++) {
            this.paneles[i] = new Panel(0); // Crea paneles sanos
        }
    }

	/*
	 * Para ventanas irrompibles, el unico obstaculo son las persianas
	 * @return boolean
	 * @Override
	 */
	public boolean pasarHabilitado(Direccion direccion){
        return this.obstaculo.puedoPasar(direccion);
	}

    /*
     * Setea de manera random las persianas, los casos son los siguientes:
     *      hay_persiana es par y para_donde_va = 0 -> Persiana que traba la izquierda
     *      hay_persiana es par y para_donde_va = 1 -> Persiana que traba la derecha
     *      hay_persiana es impar                   -> No se pone persiana
     */
    private void setearObstaculo(){
        int hay_persiana = (int )(Math.random() * 50 + 1);
        RandomAcotado rnd = new RandomAcotado (0,1);
        if (hay_persiana % 2 == 0) {
        		switch (rnd.getValor()) {
        		case 0: this.obstaculo = new Persiana(Direccion.IZQUIERDA);
        			break;
        		case 1: this.obstaculo = new Persiana(Direccion.DERECHA);
        			break;
        		}
        }else{
            this.obstaculo = new Obstaculo(Direccion.NULA);
        }
    }
    public void arreglarPanel(){
    }
}
