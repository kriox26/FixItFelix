package grafica.obstaculos;

import grafica.dinamica.GGO;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Maceta extends GGO {;
	private BufferedImage imagen;

	public Maceta(int xParam, int yParam) {
		this.setX(xParam);
		this.setY(yParam);
		this.setIP("src/grafica/imagenes/obstaculos/");
		this.uploadImage();
	}

	private void uploadImage () {
		try {
			if (imagen == null)
				imagen = this.up("macetero.png");
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
}
