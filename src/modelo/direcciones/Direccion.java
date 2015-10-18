package modelo.direcciones;

/**
 * Dando un giro con respecto a la diagramación UML, por practicidad
 * decidimos manipular las direcciones a partir de la definición de
 * un tipo enumerativo que contenga derecha, izquierda, arriba, abajo
 * y nulidad de dirección por si acaso.
 *
 *
 * @author  Santiago Marrone
 * @version 1.0
 * Para comprender el sentido de los parámetros:
 * @see modelo.dinamica.Dinamico#mover
 *
 */

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
