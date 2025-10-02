package utils;

public class Probabilidades {
	
	private int max = 100, min = 0;
	private int random = min + (int)(Math.random() * ((max - min) + 1));

	public boolean piezaTanque() {

		if (random <= 30) {
			return true;
		} else {
			return false;
		}
	}
}
