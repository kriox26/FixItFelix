package modelo.niceland;

public class Panel {
	private Estado estado;

	public Estado getEstado(){
		return this.estado;
	}

	public void setEstado(Estado estado){
		this.estado = estado;
	}

	protected void arreglar(){
		this.setEstado(this.getEstado().arreglar());
	}


	/*
	 * Si this.estado es una instancia de Roto, se devuelve true
	 * caso contrario se devuelve false
	 * @return boolean
	 */
	protected boolean estaRoto(){
		if(this.getEstado() instanceof Roto){
			return true;
		} else {
			return false;
		}
	}
}