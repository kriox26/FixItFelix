package modelo.util;
import java.util.Random;

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
