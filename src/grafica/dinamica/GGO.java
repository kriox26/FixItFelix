package grafica.dinamica;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GGO {
  private double x, y;
  private String imgPath;

  public void setX (int xParam){
    this.x = xParam;
  }

  public void setY (int yParam){
    this.y= yParam;
  }

  public double getX () {
    return this.x;
  }

  public double getY () {
    return this.y;
  }

  public String getIP () {
    return this.imgPath;
  }

  public void setIP (String ip) {
    this.imgPath = ip;
  }
  
  public BufferedImage up (String str) throws IOException {
    return ImageIO.read(new File(imgPath + str));
  }
}
