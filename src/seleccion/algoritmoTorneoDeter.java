package seleccion;
import java.util.Random;

import funciones.funcion;
import poblacion.poblacion;
public class algoritmoTorneoDeter extends algoritmoTorneo{

	public poblacion ini(poblacion p, funcion f) {
		iniSeleccionados(p.getSize(), p.getPrecision(), p.getFuncion());
		seleccionar(p, f);
		getSeleccionados().iniBest();
		return getSeleccionados();
	}

}
