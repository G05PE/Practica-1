package seleccion;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import funciones.funcion;
import poblacion.individuo;
import poblacion.poblacion;
public class algoritmoTorneoDeter extends algoritmoSeleccion{
	private int k;
	private List<individuo> ring;
	private int funcion;
	
	public algoritmoTorneoDeter(poblacion p, int k, int funcion) {
		super(p);
		this.k=k;
		this.funcion=funcion;
		ring=new ArrayList<individuo>();
		seleccionar();
	}

	@Override
	public void seleccionar() {
		Random r=new Random();
		int luchador;
		int ganador=0;
		for(int i=0; i < getSizePoblacion(); i++) {
			for(int j=0; j < k; j++) {
				luchador=r.nextInt(getSizePoblacion());
				ring.add(getIndividuo(luchador));
				if(funcion == 1) {
					if(ring.get(j).getFitness() > ring.get(ganador).getFitness()) {
						ganador=j;
					}
				}
				else
				{
					if(ring.get(j).getFitness() < ring.get(ganador).getFitness()) {
						ganador=j;
					}
				}
			}
			addSeleccionado(getIndividuo(ganador));		
			ganador=0;
			ring.clear(); 
		}
	}

}
