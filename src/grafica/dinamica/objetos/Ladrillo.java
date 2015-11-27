package grafica.dinamica.objetos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.Timer;
import modelo.direcciones;
import grafica.dinamica.GGO;


import javax.imageio.ImageIO;

public class Ladrillo extends GGO {
	private BufferedImage ladri1, ladri2;
  // izq o der indican dirección de vuelo
  // AA: ala alta + AB: ala baja
  private Timer timer;

  public Ladrillo() {
    initPaloma();
  }

  private void initLadrillo(int paramHorizontal, int seccion) {
    this.timer = new Timer(DELAY, this);
    this.timer.start();
    this.setIP("src/grafica/imagenes/rocas/")
    this.uploadImages();
    this.setX(paramHorizontal);
    this.setY(¡!)// calculado a partir de int seccion
  }

  private void uploadImages () {
    try {
      if (ladri1 == null) {
          ladri1 = this.up("slice11_11.png"));
      }
      if (ladri2 == null) {
        ladri2 = this.up("slice10_10.png"));
      }
    } catch (IOException e) {
      System.out.println("Internal Error:" + e.getMessage());
    }
  }
}
