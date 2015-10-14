package modelo.niceland;

public class Irrompible extends Ventana {
	private boolean abierta;

    public Irrompible(boolean abierta){
        this.abierta = abierta;
        this.paneles = new Panel[2];
        super.setearPaneles(2);
    }

	public boolean getAbierta(){
		return this.abierta;
	}

	public void setAbierta(boolean abierta){
		this.abierta = abierta;
	}

	/*
	 * Para ventanas irrompibles, el unico obstaculo son las persianas
	 * @return boolean
	 * @Override
	 */
	protected boolean pasarHabilitado(){
		if(this.getAbierta() == true){
			return false;
		} else {
			return true;
		}
	}
}
