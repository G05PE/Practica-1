package seleccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import poblacion.individuo;
import poblacion.poblacion;

public abstract class algoritmoTorneo extends algoritmoSeleccion{
	private int k;
	private List<individuo> ring;
	private int funcion;
	
	public algoritmoTorneo(poblacion p, int k, int funcion) {
		super(p);
		this.k=k;
		this.funcion=funcion;
		ring=new ArrayList<individuo>();
	}
	
	public void seleccionar() {
		Random r=new Random();
		int luchador;
		for(int i=0; i < getSizePoblacion(); i++) {
			for(int j=0; j < getK(); j++) {
				luchador=r.nextInt(getSizePoblacion());
				addToRing(getIndividuo(luchador));
			}
			luchar();
		}
	}
	public void luchar() {
		int ganador=0;
		if(getFuncion() == 1) {
			ganador=lucharPorMayor();
		}
		else
		{
			ganador=lucharPorMenor();
		}
		addSeleccionado(getFromRing(ganador));		
		ganador=0;
		clearRing();
	}
	public int lucharPorMenor() {
		int ganador=0;
		for(int i=0; i < getK(); i++) {
			if(getFromRing(i).getFitness() < getFromRing(ganador).getFitness()) {
				ganador=i;
			}
		}
		return ganador;
	}
	
	public int lucharPorMayor() {
		int ganador=0;
		for(int i=0; i < getK(); i++) {
			if(getFromRing(i).getFitness() > getFromRing(ganador).getFitness()) {
				ganador=i;
			}
		}
		return ganador;
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
	public int getFuncion() {
		return funcion;
	}
	
	public void clearRing() {
		ring.clear();
	}
}
