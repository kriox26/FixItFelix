package grafica.obstaculos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import grafica.dinamica.GGO;


public class Moldura extends GGO {
	private BufferedImage imagen;

	public Moldura (int posX, int posY) {
		this.setX(posX);
		this.setY(posY);
		this.setIP("src/grafica/imagenes/obstaculos/");
		this.uploadImage();
	}

	public void uploadImage () {
		try {
			if (imagen == null) {
				imagen = this.up("slice22_22.png");
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
}
