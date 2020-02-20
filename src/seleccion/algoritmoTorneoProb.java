package seleccion;

import java.util.Random;

import funciones.funcion;
import poblacion.poblacion;

public class algoritmoTorneoProb extends algoritmoTorneo{
	private double p;
	private funcion fun;
	
	public algoritmoTorneoProb(int k, funcion funcion) {
		super(k, funcion);
		fun=funcion;
	}
	
	@Override
	public void luchar() {
		Random r=new Random();
		double intervalo=r.nextDouble()%1;
		if(intervalo > p) {
			super.luchar();//gana el mejor
		}
		else{//gana el peor
			int ganador=0;
			for(int i=1; i < getK(); i++) {
				if(fun.worst(getFromRing(i).getFitness(), getFromRing(ganador).getFitness())){
					ganador=i;
				}
			}
			addSeleccionado(getFromRing(ganador));		
			ganador=0;
			clearRing();
		}
	}

	@Override
	public poblacion ini(poblacion pob) {
		p=Math.random()%1 + 0.5;
		if(p > 1) p-=0.5;
		iniSeleccionados(pob.getSize(), pob.getPrecision(), pob.getFuncion());
		seleccionar(pob);
		getSeleccionados().iniBest();
		return getSeleccionados();
	}
}
