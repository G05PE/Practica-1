package seleccion;
import java.util.Random;
import poblacion.poblacion;
public class algoritmoTorneoDeter extends algoritmoTorneo{
	
	public algoritmoTorneoDeter(poblacion p, int k, int funcion) {
		super(p, k, funcion);
		seleccionar();
	}
}
