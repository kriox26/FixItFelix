package grafica.niceland;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import grafica.dinamica.GGO;


public class Pasto extends GGO {
	private BufferedImage imagen;

	public Pasto (int posX, int posY) {
		this.setX(posX);
		this.setY(posY);
		this.setIP("src/grafica/imagenes/");
		this.uploadImage();
	}

	public void uploadImage () {
		try {
			if (imagen == null) {
				imagen = this.up("pasto.png");
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
}
