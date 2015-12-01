package grafica.niceland;

import grafica.dinamica.GGO;

import java.awt.image.BufferedImage;

public class VentanaView {
	private GGO obstaculo;
	private BufferedImage imagenActual;
	private int offsetX, offsetY;
    private int inicialY = -10;
    private int inicialX = 21;
    private int ajusteX = 9;
    private int ajusteY = -3;

	public VentanaView(BufferedImage imagenActual, int offsetX, int offsetY){
		this.imagenActual = imagenActual;
		this.offsetX = offsetX;
		this.offsetY= offsetY;
	}

	public VentanaView(BufferedImage imagenActual){
		this.imagenActual = imagenActual;
	}

	public VentanaView(){}

	public BufferedImage getImagenActual(){
		return this.imagenActual;
	}

	public int getOffsetX(){
		return this.offsetX;
	}

	public int getOffsetY(){
		return this.offsetY;
	}

	public void setImagenActual(BufferedImage imagenActual) {
		this.imagenActual = imagenActual;
	}

	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}

	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}
    
    public int getYinicial(){
        return this.inicialY;
    }
    
    public int getXinicial(){
        return this.inicialX;
    }

    public int getAjusteX(){
    	return this.ajusteX;
    }

    public int getAjusteY(){
    	return this.ajusteY;
    }
    
    public void setObstaculoView(GGO obs){
    }

    public GGO getObstaculoView(){
    	return this.obstaculo;
    }

    public boolean tieneObstaculo(){
    	return this.obstaculo != null;
    }
}
