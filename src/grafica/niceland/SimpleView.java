package grafica.niceland;

import grafica.dinamica.GGO;

import java.awt.image.BufferedImage;

public class SimpleView extends VentanaView {
    private GGO obstaculo;

	public SimpleView(BufferedImage imagenActual, int offsetX, int offsetY){
		super(imagenActual, offsetX, offsetY);
	}

	public SimpleView(BufferedImage imagenActual){
		super(imagenActual);
	}

	public SimpleView(){}

    public void setObstaculoView(GGO obstaculo){
        this.obstaculo = obstaculo;
    }

    public GGO getObstaculoView(){
    	return this.obstaculo;
    }

    public boolean tieneObstaculo(){
    	return this.obstaculo != null;
    }
}
