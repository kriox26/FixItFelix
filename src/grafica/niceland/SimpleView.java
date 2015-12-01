package grafica.niceland;

import java.awt.image.BufferedImage;

public class SimpleView extends VentanaView {

	public SimpleView(BufferedImage imagenActual, int offsetX, int offsetY){
		super(imagenActual, offsetX, offsetY);
	}

	public SimpleView(BufferedImage imagenActual){
		super(imagenActual);
	}

	public SimpleView(){}

}
