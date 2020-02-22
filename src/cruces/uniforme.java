package cruces;

import poblacion.individuo;
import poblacion.poblacion;

public class uniforme extends algoritmoCruce{ //Tema 3 pagina 12

	
	public uniforme(double probCruce, poblacion seleccionados) {
		super(probCruce, seleccionados);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public poblacion cruzar() {
		seleccionaReproductores();
		creaDescendientes();
		return descendientes;
	}


	private void seleccionaReproductores() {
		
		for(int i = 0; i < getSeleccionados().getSize(); i += 2) {
			individuo ind1 = getSeleccionadoConcreto(i);
			individuo ind2 = getSeleccionadoConcreto(i + 1);
			
			if(Math.random() < getProbCruce()) addReprpoductor(ind1);
			else addReprpoductor(ind2);
		}
	}
	
	private void creaDescendientes() {
		
	}

}
