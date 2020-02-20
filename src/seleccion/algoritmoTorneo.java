package seleccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import funciones.funcion;
import poblacion.individuo;
import poblacion.poblacion;

public abstract class algoritmoTorneo extends algoritmoSeleccion{
	private int k;
	private List<individuo> ring;
	private funcion fun;
	
	public algoritmoTorneo(poblacion p, int k, funcion funcion) {
		super(p);
		this.k=k;
		this.fun=funcion;
		ring=new ArrayList<individuo>();
	}
	
	public poblacion seleccionar() {
		Random r=new Random();
		int luchador;
		for(int i=0; i < getSizePoblacion(); i++) {
			for(int j=0; j < getK(); j++) {
				luchador=r.nextInt(getSizePoblacion());
				addToRing(getIndividuo(luchador));
			}
			luchar();
		}
		return getPoblacion();
	}
	public void luchar() {
		int ganador=0;
		for(int i=1; i < getK(); i++) {
			if(fun.best(getFromRing(i).getFitness(), getFromRing(ganador).getFitness())){
				ganador=i;
			}
		}
		addSeleccionado(getFromRing(ganador));		
		ganador=0;
		clearRing();
	}
	public int getK() {
		return k;
	}
	
	public void addToRing(individuo i) {
		ring.add(i);
	}
	
	public individuo getFromRing(int i) {
		return ring.get(i);
	}
	
	public void clearRing() {
		ring.clear();
	}
}
