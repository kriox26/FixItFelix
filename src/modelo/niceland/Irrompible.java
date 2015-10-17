package modelo.niceland;
import modelo.obstaculos.*;
import modelo.direcciones.*;

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
        int para_donde_va = this.numeroRandom(0,1);
        if (hay_persiana % 2 == 0) {
        	Direccion dir = new Direccion();
            switch (para_donde_va) {
                case 0: dir = new Izquierda();
                        break;
                case 1: dir = new Derecha();
                		break;
            }
            this.obstaculo = new Persiana(dir);
        }else{
        	Direccion aux = new Direccion();
            this.obstaculo = new Obstaculo(aux);
        }
    }
}
