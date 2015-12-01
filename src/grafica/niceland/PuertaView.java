package grafica.niceland;

import java.awt.image.BufferedImage;

public class PuertaView extends VentanaView {
    private int inicialY = 0;
    private int inicialX = 7;
    private int ajusteY = 45;
    private int ajusteX = 14;

	public PuertaView(BufferedImage imagenActual, int offsetX, int offsetY){
		super(imagenActual, offsetX, offsetY);
	}

	public PuertaView(BufferedImage imagenActual){
		super(imagenActual);
	}

	public PuertaView(){}
        
    
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

}
