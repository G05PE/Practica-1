package cruces;

import poblacion.poblacion;

public class monopunto extends algoritmoCruce{
	private int punto;
	
	public monopunto(double probCruce, poblacion pob) {
		super(probCruce, pob);
	}

	@Override
	public poblacion cruzar() {//Tema 3 pag 49
		double alea;
		for(int i=0; i < getSeleccionados().getSize(); i++) {
			alea=Math.random()%1;
			if(alea > getProbCruce()) {
				//seleccionar individuos a cruzarse y almacenarlos en el array reproductores
			}
		}
		//Cruzar individuos y almacenarlos en el array descendientes
		return getDescendientes();
	}
	
	/*@Override
	public poblacion iniciarPoblacion(poblacion pb, float porcnt) {
		//Y el punto de corte? 
		poblacion a = new poblacion(0, porcnt, null), b = new poblacion();//por que 2?
		boolean existeGen;
		int tamCromosoma = pb.getIndividuo(0).getLongitud();
		int aux;
		
		for(int i = 0; i < pb.getSize(); i++) {
			if(Math.random() < porcnt) {//Tiene que ser %1
				a.add(pb.getIndividuo(i).getCromosoma()); //Añadimos un nuevo cromosoma a la población
			}
			else  b.getIndividuo(i).getCromosoma();//Para que guardar los que no seran seleccionados?
		}
		
		for(int i = 0; i < a.getSize() - 1; i+=2) {
			aux = (int) ((Math.random() * tamCromosoma - 2) + 1); //Cuidado con el  -2
			for(int p = 0; p < aux; p++) {
				existeGen = a.getIndividuo(i).getCromosoma().get(p) != null;
				a.getIndividuo(i).getCromosoma().set(p, a.getIndividuo(i + 1).getCromosoma().get(p)); //Metemos el gen p del siguiente elemento
			}//Se mezclan los genes no los cromosomas=individuos
		}
		
		for(int i = 0; i < b.getSize(); i++) {
			a.add(b.getIndividuo(i).getCromosoma());
		}
		
		return a;
	}*/
}
