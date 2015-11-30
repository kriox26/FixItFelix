package grafica.niceland;

import java.awt.image.BufferedImage;

public class PuertaView extends VentanaView {
    private int inicialY = 0;
    private int inicialX = 7;

	public PuertaView(BufferedImage imagenActual, int offsetX, int offsetY){
		super(imagenActual, offsetX, offsetY);
	}

	public PuertaView(){}
        
    
    public int getYinicial(){
        return this.inicialY;
    }
    
    public int getXinicial(){
        return this.inicialX;
    }

}
