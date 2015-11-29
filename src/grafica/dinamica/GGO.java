package grafica.dinamica;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GGO {
    private BufferedImage imagenActual;
    private int offsetX, offsetY;
    
    public GGO(BufferedImage imagenActual, int offsetX, int offsetY){
        this.imagenActual = imagenActual;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }
}
