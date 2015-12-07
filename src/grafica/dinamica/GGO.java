package grafica.dinamica;

import java.awt.image.BufferedImage;

public class GGO {
    private BufferedImage imagenActual;
    private int offsetX, offsetY;
    private boolean oculto;
    
    public GGO(BufferedImage imagenActual, int offsetX, int offsetY){
        this.imagenActual = imagenActual;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public void setOculto(boolean oculto){
    	this.oculto = oculto;
    }

    public boolean getOculto(){
    	return this.oculto;
    }

	public BufferedImage getImagenActual() {
		return imagenActual;
	}

	public void setImagenActual(BufferedImage imagenActual) {
		this.imagenActual = imagenActual;
	}

	public int getOffsetX() {
		return offsetX;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	public int getOffsetY() {
		return offsetY;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}
}
