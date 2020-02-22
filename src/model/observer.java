package model;

import java.util.List;

import funciones.funcion;

public interface observer {
	public void onChangedFunction(funcion f, int tam);
	public void onChangedFunctionParameters();
	public void onChangedPoblationSize();
	public void onChangedGeneration();
	public void onChangedSelection();
	public void onChangedMutation();
	public void onChangedCruce();
	public void onFinished();
	public void onChangedPrecition();
	public void onChangedElitism();
	public void onNextGeneration(double[][] best, double[][] bestGen, double[][] average);
}
