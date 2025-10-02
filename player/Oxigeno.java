package player;

public class Oxigeno {

	private int oxigenoRestante = 60;
	private int capacidadMaxima = 60;

	// Getters
	public int getOxigenoRestante() {
		return oxigenoRestante;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	
	// Setters
	public void setCapacidadMaxima (int unidades) {
		capacidadMaxima = unidades;
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
