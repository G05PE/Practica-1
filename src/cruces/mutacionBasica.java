package cruces;

import poblacion.individuo;
import poblacion.poblacion;

public class mutacionBasica extends mutacion{

  double probMutacion;
  poblacion poblacion;
  
  //Constructor
 public mutacionBasica(double probMutacion, poblacion poblacion){
    super(probMutacion, poblacion);
    this.probMutacion = probMutacion;
    this.poblacion = poblacion;
 }
  
  @Override
  public poblacion mutar(){
	  
	  for(int i = 0; i < poblacion.getSize(); i++) {
		  mutarIndividuo(poblacion.getIndividuo(i));
	  }
	  return poblacion;
  }
  
  public individuo mutarIndividuo(individuo ind) {
	  individuo mutado = ind;
	    
	  for(int i = 0; i < ind.getCromosoma().size(); i++){
		  for(int j = 0; j < ind.getCromosoma().get(i).getTam(); j++) {
			  double rand = Math.random()%1;
			  if(rand < probMutacion){
				  mutado.setBit(j, i, !ind.getBit(j, i, ind.getCromosoma().get(i).getGenotipo().get(j)));
			  }
		  }
	  }	  
	  return mutado;
  }

}
 
