package selectSelect;

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
	
	public algoritmoTorneo(funcion funcion) {
		this.k=3;
		this.fun=funcion;
		ring=new ArrayList<individuo>();
	}
	public abstract poblacion ini(poblacion p);
	public void seleccionar(poblacion p) {
		Random r=new Random();
		int luchador;
		for(int i=0; i < p.getSize(); i++) {
			for(int j=0; j < getK(); j++) {
				luchador=r.nextInt(p.getSize());
				addToRing(p.getIndividuo(luchador));
			}
			luchar();
		}
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
