package modelo.niceland;

public class Simple extends Ventana {
	private Panel[] paneles = new Panel[0];
	private boolean tarta = false;

	public boolean getTarta(){
		return this.tarta;
	}

	public void setTarta(boolean tarta){
		this.tarta = tarta;
	}

	protected boolean sePuedePonerTarta(){
		// Devuelve "true" si paneles[0] es una instancia de Roto, caso contrario devuelve false
		return paneles[0].estaRoto();
	}
}
