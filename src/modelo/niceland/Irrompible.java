package modelo.niceland;

public class Irrompible extends Ventana {
	private boolean abierta;

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
