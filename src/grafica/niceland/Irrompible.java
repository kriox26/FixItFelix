package grafica.niceland;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import grafica.dinamica.GGO;


public class Irrompible extends GGO {
	private BufferedImage cerrada, izqAbierta, derAbierta, fullAbierta;

	/*
	 * cerrada - ambas persianas cerradas (no obstaculiza)
	 * izqAbierta - persiana izquierda abierta (obstaculiza)
	 * derAbierta - persiana derecha abierta (obstaculiza)
	 * fullAbierta - ambas persianas abiertas (obstaculiza encerrando)
	 *
	 */

	public Irrompible (int posX, int posY) {
		this.setX(posX);
		this.setY(posY);
		this.setIP("src/grafica/imagenes/ventanas_y_panel/");
		this.uploadImage();
	}

	public void uploadImage () {
		try {
			if (cerrada == null) {
				cerrada = this.up("wpclosed.png");
			}
			if (izqAbierta == null) {
				izqAbierta = this.up("wpopenleft.png");
			}
			if (derAbierta == null) {
				derAbierta = this.up("wpopenright.png");
			}
			if (fullAbierta == null) {
				fullAbierta = this.up("wpopenright.png");
			}
		} catch (IOException e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
}
