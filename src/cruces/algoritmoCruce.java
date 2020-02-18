package cruces;

import poblacion.poblacion;

public abstract class algoritmoCruce {
	
	private static algoritmoCruce cruce = null;
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
	}
}
