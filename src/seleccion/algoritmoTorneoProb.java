package seleccion;

import java.util.Random;
import poblacion.poblacion;

public class algoritmoTorneoProb extends algoritmoTorneo{
	private double p;
	
	public algoritmoTorneoProb(poblacion pob, int k, int funcion) {
		super(pob, k, funcion);
		Random r=new Random();
		p=r.nextDouble()%1 + 0.5;
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
			if(getFuncion() == 1) {
				ganador=lucharPorMenor();;
			}
			else
			{
				ganador=lucharPorMayor();
			}
			addSeleccionado(getFromRing(ganador));		
			ganador=0;
			clearRing();
		}
	}
}
