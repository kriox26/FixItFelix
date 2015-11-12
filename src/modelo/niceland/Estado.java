package modelo.niceland;

/**
 * Representa el estado de rotura de cada panel.
 *
 * @author  Matias Pan
 * @see modelo.niceland.Panel
 */
public class Estado {

	/*
	 * Este metodo se sobreescribe en todas las subclases.
	 * En cada una va a devolver el siguiente estado una vez arreglado
	 * @return Estado
	 */
	protected Estado arreglar(){
		return this;
	}
    
    public String to_string(){
        return "estado";
    }
}