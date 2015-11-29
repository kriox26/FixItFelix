package grafica.dinamica.objetos;

import grafica.dinamica.GGO;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.Timer;

public class Tarta extends GGO {
	private BufferedImage tar1, tar2;
	// izq o der indican dirección de vuelo
	// AA: ala alta + AB: ala baja
	private Timer timer;

	public Tarta (int x, int y) {
		//    this.timer = new Timer(DELAY, this);
		this.timer.start();
		this.setIP("src/grafica/imagenes/pastel/");
		this.uploadImages();
		this.setX(x);
		this.setY(y);
	}

	private void uploadImages () {
		try {
			if (tar1 == null) {
				tar1 = this.up("slice12_12.png");
			}
			if (tar1 == null) {
				tar2 = this.up("slice13_13.png");
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
}
