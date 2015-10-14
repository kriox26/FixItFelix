package modelo.niceland;

public class Simple extends Ventana {
	private boolean tarta = false;

    public Simple(boolean tarta){
        this.tarta = tarta;
        this.paneles = new Panel[2];
    }

	public boolean getTarta(){
		return this.tarta;
	}

	public void setTarta(boolean tarta){
		this.tarta = tarta;
	}
    
    /*
     * Las ventanas simples tiene 2 paneles, entonces tenemos
     * que seguir arreglando hasta llegar a 2*2 = 4 martillazos
     */
    protected void arreglarPanel(){
        if (this.getMartillazosRecibidos() <= 4) {
        	super.arreglarPanel();
        }
    }

    /*
     * Devuelve true solo si el panel de abajo esta Roto y si
     * no hay una tarta actualmente
     * @return boolean
     */
	protected boolean sePuedePonerTarta(){
		return paneles[0].estaRoto() && !tarta;
	}
}
