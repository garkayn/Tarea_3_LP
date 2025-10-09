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
	private int piezasObtenidas;

	public ZonaArrecife() {
		super("Zona Arrecife", 0, 199, EnumSet.of(ItemTipo.CUARZO, ItemTipo.SILICIO, ItemTipo.COBRE), 1, 3);
		piezasTanque = 3;
		piezasObtenidas = 0;
	}
	
	@Override
	public void explorar (Jugador jugador) {
		
		// Gasto de oxigeno
		double d = (jugador.getProfundidadActual() - getProfundidadMin()) / Math.max(1, getProfundidadMax() - getProfundidadMin());
		double costoExplorar = 12 + 10*d;
		jugador.getTanqueOxigeno().consumirO2((int) Math.ceil(costoExplorar));
		
		// Obtención PIEZA_TANQUE o recolección recursos
		if (Probabilidades.piezaTanque() && this.piezasObtenidas < 3) {
			ItemTipo tipo = ItemTipo.PIEZA_TANQUE;
			Item piezaTanque = new Item(tipo, 1);
			jugador.addInventario(piezaTanque);

			this.piezasObtenidas++;
			System.out.println("Pieza para mejora del tanque de oxígeno encontrada " + this.piezasObtenidas + "/3");
		} else {
			int cantidad = Math.max(1, (int) Math.floor(getUnidadesMin() * d));
			ItemTipo recurso = Probabilidades.recursosArrecife();
			Item recoleccion = new Item(recurso, cantidad);
			jugador.addInventario(recoleccion);
			System.out.println("Se recolectó " + recurso.name() + " (" + cantidad + ")");
		}
	}
}
