package cruces;

import poblacion.poblacion;

public abstract class algoritmoCruce {
	private double probCruce;
	private poblacion seleccionados;
	private poblacion reproductores;
	private poblacion descendientes;
	
	public algoritmoCruce(double probCruce, poblacion seleccionados) {
		this.setProbCruce(probCruce);
		this.seleccionados=seleccionados;
		reproductores=new poblacion(seleccionados.getSize(), seleccionados.getPrecision(), 
				seleccionados.getFuncion());
		descendientes=new poblacion(seleccionados.getSize(), seleccionados.getPrecision(), 
				seleccionados.getFuncion());
<<<<<<< HEAD
	}
	
	public abstract poblacion cruzar();
	
=======
	}
	public abstract poblacion cruzar();
	
	/*private static algoritmoCruce cruce = null;
	public abstract poblacion iniciarPoblacion(poblacion pb, float porcnt);
	
	public static void createInstance(String cruces) {
		switch (cruces) {
		case "MONOPUNTO":
			cruce = new monopunto();
			break;
		case "UNIFORME":
			cruce = new uniforme();
		default:
			break;
		}
	}
	
	public static algoritmoCruce getInstance() {
		return algoritmoCruce.cruce;
	}*/
>>>>>>> master
	public double getProbCruce() {
		return probCruce;
	}
	public void setProbCruce(double probCruce) {
		this.probCruce = probCruce;
	}
	public poblacion getSeleccionados() {
		return seleccionados;
	}
	public poblacion getDescendientes() {
		return descendientes;
	}
}
