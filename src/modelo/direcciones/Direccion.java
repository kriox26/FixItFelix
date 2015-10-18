package modelo.direcciones;

public enum Direccion {
	ARRIBA(0,1), ABAJO(0,-1), IZQUIERDA(-1,0), DERECHA(1,0), NULA (0,0);
	
		private final int h;
		private final int v;
		
		private Direccion (int hParam, int vParam){
			h=hParam;
			v=vParam;
		}
		
		public int getHorizontal () {
			return this.h;
		}
		
		public int getVertical () {
			return this.v;
		}
}