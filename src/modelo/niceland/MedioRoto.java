package modelo.niceland;

/**
 * Representa el estado medio roto de un panel, el cual se debe arreglar.
 *
 * @author  Matias Pan
 * @see modelo.niceland.Panel
 * @see modelo.niceland.Estado
 */
public class MedioRoto extends Estado {

    /*
     * Devuelve el estado Sano, ya que se lo termino de arreglar.
     * @Override
     * @return Sano: Instancia de sano, se acaba de arreglar.
     */
	protected Sano arreglar(){
		return new Sano();
	}

    public String to_string(){
        return "medio roto";
    }
}
