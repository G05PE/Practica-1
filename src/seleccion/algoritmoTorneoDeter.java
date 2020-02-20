package seleccion;
import java.util.Random;

import funciones.funcion;
import poblacion.poblacion;
public class algoritmoTorneoDeter extends algoritmoTorneo{
	
	public algoritmoTorneoDeter(int k, funcion funcion) {
		super(k, funcion);
	}

	public poblacion ini(poblacion p) {
		iniSeleccionados(p.getSize(), p.getPrecision(), p.getFuncion());
		seleccionar(p);
		getSeleccionados().iniBest();
		return getSeleccionados();
	}
}
