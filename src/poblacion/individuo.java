package poblacion;

import java.util.ArrayList;
import java.util.List;

import funciones.funcion;
import genetica.gen;
public class individuo {
	private List<gen> cromosomas;
	private double fitness;
	public individuo(funcion f, double precision) {
		cromosomas=new ArrayList<gen>();
		List<Double> fenotipos=new ArrayList<Double>();
		for(int i=0; i < f.getSize(); i++) {
			double tam=Math.floor(log2(1 +  
					(f.getMaxX(i)-f.getMinX(i)) / precision )) + 1;
			cromosomas.add(new gen(f, precision, tam));
			double fenotipo=f.getMinX(i) + bin2dec(cromosomas.get(i).getGenotipo())*
					(f.getMaxX(i)-f.getMinX(i))/(Math.pow(2, tam)-1);
			cromosomas.get(i).setFenotipo(fenotipo);
			fenotipos.add(fenotipo);
		}
		fitness=f.calcularFuncion(fenotipos);
	}
	
	public double bin2dec(List<Boolean> binario) {
		int res=0;
		for(int i=binario.size()-1; i >=0 ; i--) {
			if(binario.get(i)) {
				res+=Math.pow(2, i);
			}
		}
		return res;
	}
	public double log2(double x) {
		return Math.log(x) / Math.log(2);
	}
}
