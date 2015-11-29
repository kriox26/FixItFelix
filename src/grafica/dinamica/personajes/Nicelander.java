package grafica.dinamica.personajes;

import grafica.dinamica.GGO;

import java.awt.image.BufferedImage;
import java.io.IOException;

import modelo.util.RandomAcotado;


public class Nicelander extends GGO {
	private BufferedImage standing, appearing;
	private int tipo;
	private static Integer min = 1;
	private static Integer max = 5;


	public Nicelander (int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setIP("src/grafica/imagenes/nicelander/");
		this.uploadImages();
	}

	private int getTipo () {
		return this.tipo;
	}

	private void setTipo () {
		this.tipo = new RandomAcotado(min, max).getValor();
	}

	public void uploadImages(){
		try {
			if (standing == null) {
				standing = this.up("n-" + this.getTipo() + "-standing.png");
				appearing = this.up("n-" + this.getTipo() + "-appearing.png");
			}
		} catch(IOException e){

		}
	}
}
