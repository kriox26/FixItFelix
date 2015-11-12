package modelo.dinamica.objetos;

import modelo.niceland.*;
import modelo.dinamica.*;

public class Nicelander extends Objeto{
	private boolean tieneTarta;
	private boolean apareciendo;
	private Posicion posicion;

	public Posicion getPosicion() {
		return this.posicion;
	}

	public void setPosicion (Posicion variable) {
		this.posicion = variable;
	}

	public boolean getTieneTarta () {
		return this.tieneTarta;
	}

	public void setTieneTarta (boolean variable) {
		this.tieneTarta = variable;
	}

	public boolean getApareciendo () {
		return this.apareciendo;
	}

	public void setApareciendo (boolean variable) {
		this.apareciendo = variable;
	}

	public void aparecer () {
		this.apareciendo = true;
	}

	public void desaparecer () {
		this.apareciendo = false;
	}

	public void servirTarta (Simple window) {
		if (window.sePuedePonerTarta()) {
			window.ponerTarta();
		}
	}
}
