package utils;

public class Probabilidades {

	public static boolean piezaTanque() {

		if (Math.random() <= 0.3) {
			return true;
		} else {
			return false;
		}
	}
}
