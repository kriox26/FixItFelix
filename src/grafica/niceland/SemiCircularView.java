package grafica.niceland;

import java.awt.image.BufferedImage;

public class SemiCircularView extends VentanaView {
    private int inicialY = -15;
    private int inicialX = 7;

	public SemiCircularView(BufferedImage imagenActual, int offsetX, int offsetY){
		super(imagenActual, offsetX, offsetY);
	}

	public SemiCircularView(){}
        
    public int getYinicial(){
        return this.inicialY;
    }
    
    public int getXinicial(){
        return this.inicialX;
    }
	
}
