package player;

public class Oxigeno {

	private int oxigenoRestante;
	private int capacidadMaxima;

	public Oxigeno() {
		this.oxigenoRestante = 60;
		this.capacidadMaxima = 60;
	}

	// Getters
	public int getOxigenoRestante() {
		return oxigenoRestante;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	
	// Setters
	public void addCapacidadMaxima (int unidades) {
		capacidadMaxima += unidades;
	}

	/**/
	public void consumirO2 (int unidades) {
		oxigenoRestante -= unidades;
	}
	
	/**/
	public void recargarCompleto() {
		oxigenoRestante = capacidadMaxima;
	}
}
