package cruces;

public class mutacionBasica extends mutacion{

  double probMutacion;
  individuo recibido;
  
  //Constructor
 public mutacionBasica(double probMutcion, individuo recibido){
    super(probMutcion, individuo);
    this.probMutacion = probMutacion;
    this.recibido = recibido;
 }
  
  @Override
  public individuo mutar(individuo recibido){
    individuo mutado = recibido;
    
    for(int i = 0; i < log2(recibido); i++){
      double rand = Math.random()%1;
      if(rand < probMutcion){
        mutado.getIndividuo[i].getCromosoma() = !recibido.getIndividuo[i].getCromosoma();
      }
    }  
    
    return mutado;
}
