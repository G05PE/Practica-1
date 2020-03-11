package poblacion;

import java.util.ArrayList;
import java.util.List;

import funciones.funcion;
import genetica.gen;
import genetica.genReal;
public class individuo {
	private List<genReal> cromosomaReal;
	private List<Double> fenotipos;
	private List<gen> cromosoma;
	private double fitnessReal;
	private double fitness;
	private funcion f;
	private int cod;
	
	public individuo(funcion f, double precision, int codificacion) {
		this.f=f;
		cod=codificacion;
		if(codificacion==0) {
			cromosoma=new ArrayList<gen>();
			crearGenes(f, precision);
			calcularFitness();  
		}else {
			cromosomaReal=new ArrayList<genReal>();
			crearGenesReal(f, codificacion);
			calcularFitnessReal();
		}
	}
	
	public individuo(individuo ind) {
		cod=ind.getCodificacion();
		this.f=ind.getFuncion();
		if(cod==0) {
			cromosoma=new ArrayList<gen>();
			for(int i=0; i<ind.getCromosoma().size(); i++) {
				cromosoma.add(new gen(ind.getCromosoma().get(i)));
			}
			fenotipos=new ArrayList<Double>();
			for(int i=0; i < ind.getFenotipos().size(); i++) {
				fenotipos.add(new Double(ind.getFenotipos().get(i)));
			}
			fitness=ind.getFitness();
		}else {
			cromosomaReal=new ArrayList<genReal>();
			for(int i=0; i < ind.getSizeCromReal(); i++) {
				cromosomaReal.add(new genReal(ind.getGenRealAt(i)));
			}
			fitnessReal=ind.getFitnessReal();
		}
	}
	
	private double getFitnessReal() {
		return fitnessReal;
	}

	private genReal getGenRealAt(int i) {
		return cromosomaReal.get(i);
	}

	private int getSizeCromReal() {
		return cromosomaReal.size();
	}

	/**Crea todos los genes establecidos por la funcion, los a�ade a la lista de
	 * genes y establece sus fenotipos*/
	public void crearGenes(funcion f, double precision) {
		if(cod==0) {
			fenotipos=new ArrayList<Double>();
			for(int i=0; i < f.getSize(); i++) {
				double tam=Math.floor(log2(1 +  
						(f.getMaxX(i)-f.getMinX(i)) / precision )) + 1;
				cromosoma.add(new gen(f, precision, tam));
				fenotipos.add(calcularFenotipo(i));
			}
		}
		else
		{
			crearGenesReal(f, cod);
		}
	}
	
	private void crearGenesReal(funcion f, int cod) {
		for(int i=0; i < f.getSize(); i++) {
			genReal gen=new genReal();
			gen.setCod(cod);
			gen.setMax(f.getMaxX(i));
			gen.setMin(f.getMinX(i));
			double valor=Math.random();
			gen.setGenotipo(valor);
			cromosomaReal.add(gen);
		}
	}
	
	/**Recalcula los fenotipos de todos los genes*/
	public void recalcularFenotipos() {
		if(cod==0) {
			for(int i=0; i < cromosoma.size(); i++) {
				fenotipos.set(i, calcularFenotipo(i));
			}
		}else {
			for(int i=0; i < cromosomaReal.size(); i++) {
				recalcularFenotipo(i);
			}
		}
	}
	
	/**Calcula el fenotipo del gen i, y establece dicho valor en el gen*/
	public double calcularFenotipo(int i) {
		double fenotipo;
		if(cod==0) {
			double tam=cromosoma.get(i).getTam();
			fenotipo=f.getMinX(i) + bin2dec((List<Boolean>) cromosoma.get(i).getGenotipo())*
					(f.getMaxX(i)-f.getMinX(i))/(Math.pow(2, tam)-1);
			cromosoma.get(i).setvalorReal(fenotipo);
		}else {
			fenotipo=(double) ((genReal)cromosomaReal.get(i)).getGenotipo();
			cromosomaReal.get(i).setFenotipo(fenotipo);
		}
		return fenotipo;
	}
	/**
	 * Calcula el fenotipo de una posici�n
	 *  especifica despues de haber iniciado el individuo*/
	public void recalcularFenotipo(int i) {
		if(cod==0) {
			fenotipos.set(i, calcularFenotipo(i));
		}else {
			calcularFenotipo(i);
		}
	}
	
	/**Transforma un n�mero en base 2 a un n�mero en base 10*/
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
		if(cod==0) {
			return fitness;
		}else {
			return fitnessReal;
		}
	}
	
	/**Cambia el bit nBit del gen nGen por el el bit que este en el mismo gen
	 * del padre*/
	
	public void cruzarBit(int nGen, int nBit, individuo padre) {
		((List<Boolean>)cromosoma.get(nGen).getGenotipo()).set(nBit, 
				((List<Boolean>)padre.getCromosoma().get(nGen).getGenotipo()).get(nBit));
	}
	public void calcularFitness() {
		if(cod==0) {
			this.fitness=f.calcularFuncion(fenotipos);
		}else {
			calcularFitnessReal();
		}
	}
	public void calcularFitnessReal() {
		List<Double> fen=new ArrayList<Double>();
		for(int i=0; i < cromosomaReal.size(); i++) {
			fen.add(cromosomaReal.get(i).getFenotipo());
		}
		fitnessReal=f.calcularFuncion(fen);
	}
	public List<gen> getCromosoma(){
			return cromosoma;
	}
	public funcion getFuncion() {
		return f;
	}
	public int getCodificacion() {
		return cod;
	}
	public gen getCromosomaAt(int i) {
		if(cod==0) {
		return cromosoma.get(i);
		}else {
			return cromosomaReal.get(i);
		}
	}
	public List<Double> getFenotipos(){
		return fenotipos;
	}
	
	public void setGen(int i, gen gen) {
		if(cod==0) {
		this.cromosoma.set(i, gen);
		}else {
			cromosomaReal.set(i, (genReal) gen);
		}
	}
	public int genRealSize() {
		return cromosomaReal.size();
	}
	
	public void setFenotiposAt(int i, double valor) {
		if(cod==0) {
			this.fenotipos.set(i, valor);
		}else {
			cromosomaReal.get(i).setFenotipo(valor);
		}
	}
	
	public int getLongitud(){
		if(cod==0) {
			return cromosoma.size();
		}else {
			return cromosomaReal.size();
		}
	}
	public void setGenReal(int i, double valor) {
		cromosomaReal.get(i).setGenotipo(valor);
		cromosomaReal.get(i).setFenotipo(valor);
	}
	public genReal getGenReal(int i) {
		return cromosomaReal.get(i);
	}
	
	/*public void cruzarAritm(individuo padre1, individuo padre2) {
		double valor;
		for(int i=0; i < cromosomaReal.size(); i++) {
			valor=(padre1.getGenReal(i).getGenotipo()+
					padre2.getGenReal(i).getGenotipo())/2;
			valor %=f.getMaxX(i)+f.getMinX(i);
			if(valor > f.getMaxX(i))
				valor-=f.getMinX(i);
			cromosomaReal.get(i).setGenotipo(valor);
		}
	}*/
	
	public double longitudCromosoma() {
		int lg = 0;
		if(cod == 0) {
			for(int i = 0; i < cromosoma.size(); i++) {
				lg += getCromosomaAt(i).getTam();
			}
		}
		else {
			return cromosomaReal.size();
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
					getCromosomaAt(i).setBit(j, ((List<Boolean>)padre.getCromosomaAt(i).getGenotipo()).get(j));
				}
				
				if (contador == fin) termina = true;
			}
		}
		
	}

	public double getGenotipoReal(int j) {
		return (double) cromosomaReal.get(j).getGenotipo();
	}

	public void setCod(int codificacion) {
		cod=codificacion;
		if(cromosomaReal!=null) {
			for(int i=0; i<cromosomaReal.size(); i++) {
				cromosomaReal.get(i).setCod(codificacion);
			}
		}
	}

	public void setFitness(double d) {
		if(cod==0) {
			fitness=d;
		}else {
			fitnessReal=d;
		}
	}
	
public void cruzaReales(double inicio, double fin, individuo padre) {
		
		//Para todos los genes
		for(int i = (int)inicio; i < cromosomaReal.size() && i < (int)fin; i++) {
			double aux = (double) padre.getCromosomaAt(i).getGenotipo();
			((genReal)getCromosomaAt(i)).setGenotipo(aux);
		}
	}

}
