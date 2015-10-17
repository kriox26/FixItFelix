package modelo.direcciones;

public class Direccion {
	
	private int horizontal;
	private int vertical;
	
	public int getHorizontal () {
		return this.horizontal;
	}
	
	public int getVertical () {
		return this.vertical;
	}
	
	public void setVertical (int variable) {
		this.vertical = variable;
	}
	
	public void setHorizontal (int variable) {
		this.horizontal = variable;
	}
}