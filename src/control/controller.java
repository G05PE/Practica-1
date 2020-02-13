package control;
import model.manager;
import model.observer;
public class controller {

    private manager manager;
	
	public controller(manager m)
	{
		manager=m;
	}
	public void addObserver(observer o) {
		manager.addObserver(o);
	}
	
	public void establecerFuncion(int funcion) {
		
		manager.establecerFuncion(funcion);
	}
	public void iniciarPoblacion(int tam, double precision) {
		manager.iniciarPoblacion(tam, precision);
	}
}
