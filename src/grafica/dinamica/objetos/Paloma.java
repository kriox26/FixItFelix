package grafica.dinamica.objetos;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import modelo.direcciones.Direccion;
import grafica.dinamica.GGO;


public class Paloma extends GGO {
    private BufferedImage izqAA, izqAB, derAA, derAB;
    // izq o der indican dirección de vuelo
    // AA: ala alta + AB: ala baja

    public Paloma(int altura, Direccion direccion) {
        this.setIP("src/grafica/imagenes/pajaro/");
        this.uploadImages();
        this.setY(altura);
        if (direccion == Direccion.IZQUIERDA) {
            this.setX(4); // Comienza desde la derecha
        }
        else {
            this.setX(0); // Comienza desde la izquierda
        }
    }

    private void uploadImages () {
        try {
            if (izqAA == null) {
                izqAA = this.up("slice41_41.png");
            }
            if (izqAB == null) {
                izqAB = this.up("slice61_61.png");
            }
            if (derAA == null) {
                derAA = this.up("slice08_08.png");
            }
            if (derAB == null) {
                derAB = this.up("slice09_09.png");
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
    }

    /* Ejemplo de movimiento + visibilidad de misil que deberia adaptarse
    public void move () {
    x += MISSILE_SPEED;
    if (x > BOARD_WIDTH) {
    vis = false;
}
*/
}
