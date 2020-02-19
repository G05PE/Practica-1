package seleccion;

import java.util.Random;

import funciones.funcion;
import poblacion.poblacion;

public class algoritmoTorneoProb extends algoritmoTorneo{
	private double p;
	private funcion fun;
	
	public algoritmoTorneoProb(poblacion pob, int k, funcion funcion) {
		super(pob, k, funcion);
		fun=funcion;
		p=Math.random()%1 + 0.5;
		if(p > 1) p-=0.5;
		seleccionar();
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
}
