package modelo.niceland;
import modelo.obstaculos.*;
import modelo.direcciones.*;
import modelo.util.RandomAcotado;

public class Irrompible extends Ventana {
    private Obstaculo obstaculo;

    public Irrompible(){
        this.setearObstaculo();
    }

	/*
	 * Para ventanas irrompibles, el unico obstaculo son las persianas
	 * @return boolean
	 * @Override
	 */
	protected boolean pasarHabilitado(Direccion direccion){
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
        		case 0: this.obstaculo = new Persiana (Direccion.IZQUIERDA);
        			break;
        		case 1: this.obstaculo = new Persiana (Direccion.DERECHA);
        			break;
        		}
        }else{
            this.obstaculo = new Obstaculo(Direccion.NULA);
        }
    }
}
