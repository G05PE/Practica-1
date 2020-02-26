package cruces;

import poblacion.poblacion;

public abstract class mutacion {

  private double probMutacion;
  private poblacion recibido;
  private poblacion mutado;
 
  public mutacion(double probMutacion, poblacion recibido){
    this.probMutacion = probMutacion;
    this.recibido = recibido;
  }

  public abstract poblacion mutar();

  public double getProbCruceMut() {
    return probMutacion;
  }
  
  public void setProbMut(double probMutacion) {
    this.probMutacion = probMutacion;
  }
  
  public poblacion getMutado() {
    return mutado;
  }
  public poblacion getEntrada() {
    return recibido;
  }

}
