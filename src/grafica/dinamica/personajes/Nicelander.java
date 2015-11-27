package grafica.dinamica.personajes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import modelo.util.RandomAcotado;

public class Nicelander extendes GGO {
  private BufferedImage standing;
  private int tipo;
  private static Integer min = 1;
  private static Integer max = 5;


  public Nicelander (double x, double y) {
    this.setX(xParam);
    this.setY(yParam);
    this.set
    this.setIP("src/grafica/imagenes/nicelander/");
    this.uploadImages();
  }

  private int getTipo () {
    return this.tipo;
  }

  private void setTipo () {
    this.tipo = new RandomAcotado(min, max).getValor();
  }

  public void uploadImages(){
    try {
        if (standing == null) {
            aloneRunL1 = this.up("n-" + this.getTipo().toString() + "-standing.png");
        }
}
