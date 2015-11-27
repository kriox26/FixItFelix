package grafica.niceland;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pasto extends GGO {
  private BufferedImage imagen;

  public Pasto (double posX, double posY) {
    this.setX(posX);
    this.setY(posY);
    this.setIP("src/grafica/imagenes/");
    this.uploadImage();
  }

  public uploadImage () {
    try {
      if (imagen == null) {
          imagen = this.up("pasto.png"));
      }
    } catch (IOException e) {
      System.out.println("Internal Error:" + e.getMessage());
    }
  }
}
