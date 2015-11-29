package modelo.niceland;

/**
 * Representa los paneles que las ventanas contienen. Cada panel tiene asignado
 * un Estado, el cual puede ser 1 de tres distintos valores:
 *                  - Sano, no se debe arreglar
 *                  - MedioRoto, se debe arreglar
 *                  - Roto, se debe arreglar
 * Los paneles van pasando de estado a medida que reciben martillazos.
 *
 * @author  Matias Pan
 * @see modelo.niceland.Ventana
 * @see modelo.niceland.Estado
 */
public class Panel {
	private Estado estado;

    public Panel(int estado){
        switch (estado) {
            case 0: this.estado = new Sano();
                    break;
            case 1: this.estado = new MedioRoto();
                    break;
            case 2: this.estado = new Roto();
                    break;
        }
    }

	public Estado getEstado(){
		return this.estado;
	}

	public void setEstado(Estado estado){
		this.estado = estado;
	}

    /*
     * Si el panel que estamos queriendo arreglar esta sano, entonces
     * devolvemos false, ya que ya no se puede arreglar. Caso contrario 
     * se devuelve true.
     * @return boolean
     *
     */
	protected boolean arreglar(){
        if (!this.estaSano()) {
            this.setEstado(this.getEstado().arreglar()); //este arreglar() es de la clase Estado
            return true;
        }else{
            return false;
        }
    }

	/*
	 * Si this.estado es una instancia de Roto, se devuelve true
	 * caso contrario se devuelve false
	 * @return boolean
	 */
	public boolean estaRoto(){
		return this.getEstado() instanceof Roto ? true : false;
	}
    
    public boolean estaSano(){
		return this.getEstado() instanceof Sano ? true : false;
    }
    
    public boolean estaMedioRoto(){
        return this.getEstado() instanceof MedioRoto ? true : false;
    }
    
}
