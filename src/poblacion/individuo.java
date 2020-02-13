package poblacion;

import java.util.ArrayList;
import java.util.List;

import funciones.funcion;
import genetica.gen;
public class individuo {
	private List<gen> cromosomas;
	
	public individuo(funcion f, double precision) {
		cromosomas=new ArrayList<gen>();
		for(int i=0; i < f.getSize(); i++) {
			double tam=Math.floor(log2(1 +  (f.getMaxX(i)-f.getMinX(i)) / precision )) + 1;
			cromosomas.add(new gen(f, precision, tam, f.getX(i)));
		}
	}
	public double log2(double x) {
		return Math.log(x) / Math.log(2);
	}
}
