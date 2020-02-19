package cruces;

public abstract class mutacion {

  private double probMutacion;
  private int bitMutado;
  private individuo recibido;
  private individuo mutado;
 
  public mutacion(double probMutacion, individuo recibido){
    this.probMutcion = probMutcion;
    this.genotipo = recibido;
    this.cromosoma = new individuo();
  }

  public abstract poblacion mutar();

  /*private static algoritmoCruce cruce = null;
  public abstract poblacion iniciarPoblacion(poblacion pb, float porcnt);

  public static void createInstance(String tipo) {
    switch (tipo) {
      case "BASICA":
        cruce = new mutacionBasica();
        break;
      default:
        break;
    }

  }
  
  public static mutacion getInstance() {
    return mutacion.tipo;
  }*/
  
  public double getProbCruceMut() {
    return probMutacion;
  }
  public void setProbMut(double probMutacion) {
    this.probMutacion = probMutacion;
  }
  public individuo getMutado() {
    return mutado;
  }
  public poblacion getEntrada() {
    return recibido;
  }

}
