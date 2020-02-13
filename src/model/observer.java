package model;

import java.util.List;

import funciones.funcion;

public interface observer {
	public void onChangedFunction(funcion f, List<Double> valores);
	public void onChangedFunctionParameters();
	public void onChangedPoblationSize();
	public void onChangedGeneration();
	public void onChangedSelection();
	public void onChangedMutation();
	public void onChangedCruce();
	public void onChangedPrecition();
	public void onChangedElitism();
}
