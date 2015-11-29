package grafica.dinamica.objetos;

import grafica.dinamica.GGO;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.Timer;

public class Ladrillo extends GGO {
	private BufferedImage ladri1, ladri2;
	// izq o der indican dirección de vuelo
	// AA: ala alta + AB: ala baja
	private Timer timer;

	public Ladrillo(int paramHorizontal, int seccion) {
		//    this.timer = new Timer(DELAY, this);
		this.timer.start();
		this.setIP("src/grafica/imagenes/rocas/");
		this.uploadImages();
		this.setX(paramHorizontal);
		this.setY(2); // calculado a partir de int seccion
	}

	private void uploadImages () {
		try {
			if (ladri1 == null) {
				ladri1 = this.up("slice11_11.png");
			}
			if (ladri2 == null) {
				ladri2 = this.up("slice10_10.png");
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
}
