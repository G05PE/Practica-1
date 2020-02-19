package poblacion;

import java.util.ArrayList;
import java.util.List;

import funciones.funcion;
import genetica.gen;
public class individuo {
	private List<gen> cromosoma;
	private double fitness;
	private List<Double> fenotipos;
	
	public individuo(funcion f, double precision) {
		cromosoma=new ArrayList<gen>();
		crearGenes(f, precision);
		setFitness(f.calcularFuncion(fenotipos));        
	}
	
	public individuo(individuo ind) {
		cromosoma=new ArrayList<gen>();
		for(int i=0; i<ind.getCromosoma().size(); i++) {
			cromosoma.add(new gen(ind.getCromosoma().get(i)));
		}
		fenotipos=new ArrayList<Double>();
		for(int i=0; i < ind.getFenotipos().size(); i++) {
			fenotipos.add(new Double(ind.getFenotipos().get(i)));
		}
		fitness=ind.getFitness();
	}
	
	public void crearGenes(funcion f, double precision) {
		fenotipos=new ArrayList<Double>();
		for(int i=0; i < f.getSize(); i++) {
			double tam=Math.floor(log2(1 +  
					(f.getMaxX(i)-f.getMinX(i)) / precision )) + 1;
			cromosoma.add(new gen(f, precision, tam));
			double fenotipo=f.getMinX(i) + bin2dec(cromosoma.get(i).getGenotipo())*
					(f.getMaxX(i)-f.getMinX(i))/(Math.pow(2, tam)-1);
			cromosoma.get(i).setFenotipo(fenotipo);
			fenotipos.add(fenotipo);
		}
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

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	public List<gen> getCromosoma(){
		return cromosoma;
	}
	
	public List<Double> getFenotipos(){
		return fenotipos;
	}
	
	public int getLongitud(){
		return cromosoma.size();
	}

}
