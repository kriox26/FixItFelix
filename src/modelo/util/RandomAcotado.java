package modelo.util;
import java.util.Random;

/*
 * Clase de utilidad. Genera un numero random en un rango acotado.
 * @author Santiago Marrone
 * @author Matias Pan
 */
public class RandomAcotado {
	private int numero;
	
	public RandomAcotado (int min, int max) {
        Random rand = new Random();
        this.numero = rand.nextInt((max - min) + 1) + min;
    }
	
	public int getValor () {
		return this.numero;
	}
}
