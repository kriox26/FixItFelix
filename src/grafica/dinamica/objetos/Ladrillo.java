package grafica.dinamica.objetos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;
import modelo.direcciones;

import javax.imageio.ImageIO;

public class Ladrillo extends GameObj{
  private String imgPath = "src/grafica/imagenes/rocas/";
	private BufferedImage ladri1, ladri2;
  // izq o der indican dirección de vuelo
  // AA: ala alta + AB: ala baja
  private Timer timer;
  private double x, y;

  public Ladrillo() {
    initPaloma();
  }

  private void initLadrillo(double paramHorizontal, int seccion) {
    this.timer = new Timer(DELAY, this);
    this.timer.start();
    this.uploadImages();
    this.x = paramHorizontal;
    this.y = // calculado a partir de int seccion
  }

  private void uploadImages () {
    try {
      if (ladri1 == null) {
          ladri1 = ImageIO.read(new File(imgPath + "slice11_11.png"));
      }
      if (ladri2 == null) {
        ladri2 = ImageIO.read(new File(imgPath + "slice10_10.png"));
      }
    } catch (IOException e) {
      System.out.println("Internal Error:" + e.getMessage());
    }
  }
}
