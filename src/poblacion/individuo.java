package poblacion;

import java.util.List;

public class individuo {
	private List<gen> cromosoma;
	
	public individuo(List<Integer> crm) {
		setCromosoma(crm);
	}

	public List<Integer> getCromosoma() {
		return cromosoma;
	}

	public void setCromosoma(List<Integer> cromosoma) {
		this.cromosoma = cromosoma;
	}
	
}
