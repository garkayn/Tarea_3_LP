package utils;

import objetos.ItemTipo;
import objetos.Item;

public class Probabilidades {

	public static boolean piezaTanque() {

		if (Math.random() <= 0.3) {
			return true;
		} else {
			return false;
		}
	}

	public static ItemTipo recursosArrecife() {

			ItemTipo recurso = ItemTipo.CUARZO; 

			if (Math.random() <= 0.3) {
				recurso = ItemTipo.CUARZO;
			} else if (Math.random() <= 0.6) {
				recurso = ItemTipo.SILICIO;
			} else if (Math.random() <= 1) {
				recurso = ItemTipo.COBRE;
			}

			return recurso;
	}
}
