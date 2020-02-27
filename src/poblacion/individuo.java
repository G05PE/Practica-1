package poblacion;

import java.util.ArrayList;
import java.util.List;

import funciones.funcion;
import genetica.gen;
public class individuo {
	private List<gen> cromosoma;
	private double fitness;
	private List<Double> fenotipos;
	private funcion f;
	
	public individuo(funcion f, double precision) {
		this.f=f;
		cromosoma=new ArrayList<gen>();
		crearGenes(f, precision);
		calcularFitness();        
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
		this.f=ind.getFuncion();
		fitness=ind.getFitness();
	}
	
	/**Crea todos los genes establecidos por la funcion, los añade a la lista de
	 * genes y establece sus fenotipos*/
	public void crearGenes(funcion f, double precision) {
		fenotipos=new ArrayList<Double>();
		for(int i=0; i < f.getSize(); i++) {
			double tam=Math.floor(log2(1 +  
					(f.getMaxX(i)-f.getMinX(i)) / precision )) + 1;
			cromosoma.add(new gen(f, precision, tam));
			fenotipos.add(calcularFenotipo(i));
		}
	}
	
	/**Recalcula los fenotipos de todos los genes*/
	public void recalcularFenotipos() {
		for(int i=0; i < cromosoma.size(); i++) {
			fenotipos.set(i, calcularFenotipo(i));
		}
	}
	
	/**Calcula el fenotipo del gen i, y establece dicho valor en el gen*/
	public double calcularFenotipo(int i) {
		double tam=cromosoma.get(i).getTam();
		double fenotipo=f.getMinX(i) + bin2dec(cromosoma.get(i).getGenotipo())*
				(f.getMaxX(i)-f.getMinX(i))/(Math.pow(2, tam)-1);
		cromosoma.get(i).setvalorReal(fenotipo);
		return fenotipo;
	}
	/**
	 * Calcula el fenotipo de una posiciï¿½n
	 *  especifica despues de haber iniciado el individuo*/
	public void recalcularFenotipo(int i) {
		fenotipos.set(i, calcularFenotipo(i));
	}
	
	/**Transforma un número en base 2 a un número en base 10*/
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
	
	/**Cambia el bit nBit del gen nGen por el el bit que este en el mismo gen
	 * del padre*/
	
	public void cruzarBit(int nGen, int nBit, individuo padre) {
		cromosoma.get(nGen).getGenotipo().set(nBit, 
				padre.getCromosoma().get(nGen).getGenotipo().get(nBit));
	}
	public void calcularFitness() {
		this.fitness=f.calcularFuncion(fenotipos);
	}
	public List<gen> getCromosoma(){
		return cromosoma;
	}
	public funcion getFuncion() {
		return f;
	}
	public gen getCromosomaAt(int i) {
		return cromosoma.get(i);
	}
	public List<Double> getFenotipos(){
		return fenotipos;
	}
	
	public void setGen(int i, gen gen) {
		this.cromosoma.set(i, gen);
	}
	
	public void setFenotiposAt(int i, double valor) {
		this.fenotipos.set(i, valor);
	}
	
	public int getLongitud(){
		return cromosoma.size();
	}

	public double longitudCromosoma() {
		int lg = 0;
		for(int i = 0; i < cromosoma.size(); i++) {
			lg += getCromosomaAt(i).getTam();
		}
		return lg;
	}

	public void cruza(double inicio, double fin, individuo padre) {
	int contador = 0;
	Boolean termina = false;
	
		//Para todos los genes
		for(int i = 0; i < cromosoma.size() && !termina; i++) {
			
			//Recorremos todos los bits de cada gen
			for(int j = 0; j < getCromosomaAt(i).getTam() && !termina; j++) {
				contador += 1;
				if(contador >= inicio && contador <= fin) {
					getCromosomaAt(i).setBit(j, padre.getCromosomaAt(i).getGenotipo().get(j));
				}
				
				if (contador == fin) termina = true;
			}
		}
		
	}
	

}
