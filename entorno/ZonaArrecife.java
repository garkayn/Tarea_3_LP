package entorno;

import java.util.EnumSet;
import objetos.ItemTipo;
import player.Jugador;
import player.Oxigeno;
import objetos.Item;
import objetos.ItemTipo;
import utils.Probabilidades;

public class ZonaArrecife extends Zona {

	private int piezasTanque;

	public ZonaArrecife() {
		super("Zona Arrecife", 0, 199, EnumSet.of(ItemTipo.CUARZO, ItemTipo.SILICIO, ItemTipo.COBRE));
		piezasTanque = 3;
	}

	public void explorar (Jugador jugador) {
		
		// Gasto de oxigeno
		int d = (jugador.getProfundidadActual() - getProfundidadMin()) / Math.max(1, getProfundidadMax() - getProfundidadMin());
		int costoExp = 12 + 10*d;
		jugador.getTanqueOxigeno().consumirO2(costoExp);
		
		// Obtención PIEZA_TANQUE o recolección recursos
		Probabilidades probabilidad = new Probabilidades();
		if (probabilidad.piezaTanque() && this.piezasTanque > 0) {
			ItemTipo tipo = ItemTipo.PIEZA_TANQUE;
			Item piezaTanque = new Item(tipo, 1);
			jugador.addInventario(piezaTanque);

			this.piezasTanque--;
			System.out.println("Pieza encontrada");
		} else {
			System.out.println("No se encontro ninguna pieza");
		}
	}
}
