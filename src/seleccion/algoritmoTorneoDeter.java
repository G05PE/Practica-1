package seleccion;
import java.util.Random;

import funciones.funcion;
import poblacion.poblacion;
public class algoritmoTorneoDeter extends algoritmoTorneo{
	
	public algoritmoTorneoDeter(poblacion p, int k, funcion funcion) {
		super(p, k, funcion);
		seleccionar();
	}
}
