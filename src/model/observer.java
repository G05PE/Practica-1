package model;

import java.util.List;

import funciones.funcion;

public interface observer {
	public void onFinished(double[][] best, double[][] bestGen, double[][] average, List<Double> bestVars);
	public void onNextGeneration();
	public void changedCode(int codificacion);
}
