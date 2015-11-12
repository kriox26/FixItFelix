package modelo.niceland;

/**
 * Representa el estado roto de un panel, el cual se debe arreglar.
 *
 * @author  Matias Pan
 * @see modelo.niceland.Panel
 * @see modelo.niceland.Estado
 */
public class Roto extends Estado {

    /*
     * Devuelve el estado MedioRoto, el cual se debe seguir arreglando.
     * @Override
     * @return MedioRoto: Instancia de MedioRoto, todavia se debe arreglar.
     */
	protected MedioRoto arreglar(){
		return new MedioRoto();
	}
    
    public String to_string(){
        return "roto";
    }
}
