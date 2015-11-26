package grafica.obstaculos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import modelo.direcciones;

import javax.imageio.ImageIO;

public class Maceta extends GameObj{
  private String imgPath = "src/grafica/imagenes/obstaculos/macetero.png";
	private BufferedImage imagen;
  // izq o der indican dirección de vuelo
  // AA: ala alta + AB: ala baja
  private double x, y;

  public Maceta() {
    initMaceta();
  }

  private void initMaceta(double x, double y) {
    this.uploadImage();
    this.x = x;
    this.y = y;
  }

  private void uploadImage () {
    try {
      if (imagen == null) {
          imagen = ImageIO.read(new File(imgPath));
    } catch (IOException e) {
      System.out.println("Internal Error:" + e.getMessage());
    }
  }
}
