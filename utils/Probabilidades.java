package utils;

import objetos.ItemTipo;
import objetos.Item;

public class Probabilidades {

	public static boolean especiales(double probabilidad) {

		if (Math.random() <= probabilidad) {
			return true;
		} else {
			return false;
		}
	}

	public static ItemTipo recursosArrecife() {

		double rand = Math.random(); 

		if (rand < 1.0 / 3.0) {
			return ItemTipo.CUARZO;
		} else if (rand < 2.0 / 3.0) {
			return ItemTipo.SILICIO;
		} else {
			return ItemTipo.COBRE;
		}
	}

	public static ItemTipo recursosProfunda() {

		double rand = Math.random(); 

		if (rand < 0.2) {
			return ItemTipo.PLATA;
		} else if (rand < 0.4) {
			return ItemTipo.ORO;
		} else if (rand < 0.6) {
			return ItemTipo.ACERO;
		} else if (rand < 0.8) {
			return ItemTipo.DIAMANTE;
		} else {
			return ItemTipo.MAGNETITA;
		}
	}

	public static ItemTipo recursosVolcanica() {

		double rand = Math.random(); 

		if (rand < 1.0 / 3.0) {
			return ItemTipo.TITANIO;
		} else if (rand < 2.0 / 3.0) {
			return ItemTipo.SULFURO;
		} else {
			return ItemTipo.URANIO;
		}
	}

	public static ItemTipo recursosEstrellada() {

		double rand = Math.random(); 

		if (rand < 0.5) {
			return ItemTipo.CABLES;
		} else {
			return ItemTipo.PIEZAS_DE_METAL;
		}
	}
}
