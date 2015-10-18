package modelo.niceland;

public class MedioRoto extends Estado {

	protected Sano arreglar(){
		return new Sano();
	}

    public String to_string(){
        return "medio roto";
    }
}
