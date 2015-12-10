package grafica.dinamica.objetos;

import grafica.dinamica.GGO;
import java.awt.image.BufferedImage;
import modelo.direcciones.Direccion;


public class PalomaView extends GGO {
	private boolean oculto;
	private int op = 0;

	public PalomaView (BufferedImage img, int oX, int oY, Direccion dir) {
		super(img, oX, oY);
		this.oculto = false;
		this.setOp(dir);
	}

	private void setOp (Direccion dir) {
		if (dir == Direccion.DERECHA) {
			this.op = 1;
		}
		else if (dir == Direccion.IZQUIERDA) {
				this.op = -1;
		}
	}

	private int getOp () {
		return this.op;
	}

	public void actualizar () {
		this.setOffsetX(this.getOffsetX() + this.getOp());
	}

	public boolean getOculto(){
		return this.oculto;
	}

	public void setOcutlo(boolean oculto){
		this.oculto = oculto;
	}
}
