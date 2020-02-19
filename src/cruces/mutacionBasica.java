package cruces;

public class mutacionBasica extends mutacion{

  //Constructor
 public mutacionBasica(double probMutcion, individuo recibido){
    super(probMutcion, individuo);
 }
  
  @Override
  public individuo mutar(individuo recibido){
    individuo mutado = recibido;
    
    for(int i = 0; i < log2(recibido); i++){
      double rand = Math.random()%1;
      if(rand < PMutacion){ //Que narices es PMutacion en los apuntes del tema 3?
        mutado.getIndividuo[i].getCromosoma() = !recibido.individuo[i].cromosoma();
      }
    }  
    
    return mutado;
}
