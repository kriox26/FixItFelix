package grafica.niceland;

import java.awt.image.BufferedImage;

public class VentanaView {
	private BufferedImage imagenActual;

	public VentanaView(BufferedImage imagenActual){
		this.imagenActual = imagenActual;
	}

	public BufferedImage getImagenActual(){
		return this.imagenActual;
	}

}
