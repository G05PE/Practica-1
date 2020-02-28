package seleccion;

import funciones.funcion;
import poblacion.poblacion;
public class algoritmoTorneoDeter extends algoritmoTorneo{

	@Override
	public poblacion ini(poblacion p, funcion f) {
		iniSeleccionados(p.getSize(), p.getPrecision(), p.getFuncion());
		seleccionar(p, f);
		getSeleccionados().iniBest();
		return getSeleccionados();
	}
	
}
