package cruces;

public abstract class mutacion {

  private double probMutacion;
  private individuo recibido;
  private individuo mutado;
 
  public mutacion(double probMutacion, individuo recibido){
    this.probMutcion = probMutcion;
    this.genotipo = recibido;
    this.cromosoma = new individuo();
  }

  public abstract poblacion mutar();

  public double getProbCruceMut() {
    return probMutacion;
  }
  public void setProbMut(double probMutacion) {
    this.probMutacion = probMutacion;
  }
  
  public individuo getMutado() {
    return mutado;
  }
  public individuo getEntrada() {
    return recibido;
  }

}
