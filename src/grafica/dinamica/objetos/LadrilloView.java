package grafica.dinamica.objetos;

import grafica.dinamica.GGO;
import java.awt.image.BufferedImage;

public class LadrilloView extends GGO {
	private int velocidad = 1;
	private boolean oculto;

	public LadrilloView (BufferedImage imagenActual, int offsetX, int offsetY) {
		super(imagenActual, offsetX, offsetY);
		this.oculto = false;
	}

    public void actualizar(){
        this.setOffsetY(this.getOffsetY() - this.velocidad);
    }

    public boolean getOculto(){
    	return this.oculto;
    }

    public void setOcutlo(boolean oculto){
    	this.oculto = oculto;
    }

}
