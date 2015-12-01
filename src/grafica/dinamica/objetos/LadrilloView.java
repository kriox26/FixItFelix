package grafica.dinamica.objetos;

import grafica.dinamica.GGO;

import java.awt.image.BufferedImage;

public class LadrilloView extends GGO {
    private int velocidad = 3;
    
	public LadrilloView (BufferedImage imagenActual, int offsetX, int offsetY) {
		super(imagenActual, offsetX, offsetY);
	}
    
    public void actualizar(){
        this.setOffsetY(this.getOffsetY() - this.velocidad);
    }
}
