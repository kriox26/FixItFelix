package modelo.niceland;

public class Panel {
	private Estado estado;
    private int golpes_recibidos = 0;

    public Panel(Estado estado, int golpes_recibidos){
        this.estado = estado;
        this.golpes_recibidos = golpes_recibidos;
    }

    public int getGolpesRecibidos(){
        return this.golpes_recibidos;
    }
    
    public void setGolpesRecibidos(int golpes_recibidos){
        this.golpes_recibidos = golpes_recibidos;
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
     * se devuelve true, se lo "arregla" siempre pero solo se le cambia
     * de estado luego de 3 arreglos en cada panel
     * @return boolean
     *
     */
	protected boolean arreglar(){
        if (this.estaSano()) {
            return false;
        }else{
            if (this.getGolpesRecibidos() == 3) {
                this.getEstado().arreglar();
                this.setGolpesRecibidos(0);
                return true;
            }else{
                this.setGolpesRecibidos(++golpes_recibidos);
                return true;
            }
        }
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
    
    private boolean estaSano(){
        if (this.getEstado() instanceof Sano) {
            return true;
        }else{
            return false;
        }
    }
}