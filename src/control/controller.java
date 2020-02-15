package control;
import java.util.List;

import model.manager;
import model.observer;
import poblacion.poblacion;
public class controller {

    private manager manager;
	
	public controller(manager m)
	{
		manager=m;
	}
	public void addObserver(observer o) {
		manager.addObserver(o);
	}
	
	public void establecerFuncion(int funcion, int tam) {
		manager.establecerFuncion(funcion, tam);
	}
	
	public void establecerMetodoSeleccion(int metodo, int k) {
		manager.establerMetodoSeleccion(metodo, k);
	}
	public void iniciarPoblacion(int tam, double precision) {
		manager.iniciarPoblacion(tam, precision);
	}
}
