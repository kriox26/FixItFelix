package grafica.dinamica.personajes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import grafica.dinamica.GGO;


public class Ralph extends GGO {
  private BufferedImage hitOnWay1, hitOnWay2, leftHitFly, rightHitFly, standing, leftHit, rightHit, leftHitM, rightHitM,rightWalkingA, rightWalkingB, leftWalking;

  /*
   * Para cada situacion de movimiento hay un par de imagenes asignado.
   * Las dos imagenes deben alternar entre si en la situacion asignada.
   *
   * hitOnWay1 & hitOnWay2 - se mueve por el edificio entre secciones rompiendo ventanas
   * leftHitFly & rightHitFly - le pega al piso haciendo caer ladrillos con tanta furia que despega los pies del piso
   * leftHitM & rightHitM - le pega al piso con pocas ganas
   * leftHit & rightHit - le pega al piso haciendo caer ladrillos normalmente
   * rightWalkingA & rightWalkingB - camina hacia la derecha
   * standing - cuando Ralph esta parado
   *
   */

  public Ralph (int xParam, int yParam) {
    this.setX(xParam);
    this.setY(yParam);
    this.setIP("src/grafica/imagenes/ralph/");
    this.uploadImages();
  }

  private void uploadImages () {
      try {
          if (standing == null) {
              standing = this.up("u_standing_front.png");
          }
          if (rightWalkingA == null) {
              rightWalkingA = this.up("u_rightWalking_1.png");
          }
          if (rightWalkingB == null) {
              rightWalkingB = this.up("u_rightWalking_2.png");
          }
          if (leftSadWalking == null) {
              leftSadWalkingB = this.up("u_leftWalking_sad.png");
          }
          if (leftHit == null) {
              leftHit = this.up("u_leftHit.png");
          }
          if (rightHit == null) {
              rightHit = this.up("u_rightHit.png");
          }
          if (leftHitM == null) {
              leftHitM = this.up("u_leftHit_mid.png");
          }
          if (rightHitM == null) {
              rightHitM = this.up("u_rightHit_mid.png");
          }
          if (leftHitFly == null) {
              leftHitFly = this.up("u_leftHit_fly.png");
          }
          if (rightHitFly == null) {
              rightHitFly = this.up("u_rightHit_fly.png");
          }
          if (hitOnWay1 == null) {
              hitOnWay1 = this.up("u_hitOnWay_1.png");
          }
          if (hitOnWay2 == null) {
              hitOnWay2 = this.up("u_hitOnWay_2.png");
          }

      } catch (IOException e) {
          System.out.println("Internal Error:" + e.getMessage());
      }
  }
}
