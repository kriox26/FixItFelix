package grafica.dinamica;

public class GGO {
  private double x, y;
  private String imgPath;

  public void setX (double xParam){
    this.x = xParam;
  }

  public void setY (double yParam){
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
}
