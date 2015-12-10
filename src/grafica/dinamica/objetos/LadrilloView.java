package grafica.dinamica.objetos;

import grafica.dinamica.GGO;
import java.awt.image.BufferedImage;

public class LadrilloView extends GGO {
	private int velocidad = 1;
	private boolean oculto;
<<<<<<< HEAD

	public LadrilloView (BufferedImage imagenActual, int offsetX, int offsetY) {
=======
	private int index;
    
	public LadrilloView (BufferedImage imagenActual, int offsetX, int offsetY, int index) {
>>>>>>> origin/master
		super(imagenActual, offsetX, offsetY);
		this.oculto = false;
		this.index = index;
	}

	public int getIndex(){
		return this.index;
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
