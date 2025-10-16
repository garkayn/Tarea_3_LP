package objetos;

import java.util.List;
import java.util.ArrayList;
import player.Jugador;

public abstract class Vehiculo {
	
	private List<Item> bodega;

	public Vehiculo() {
		this.bodega = new ArrayList<>();
	}

	public List<Item> getBodega() {
		return this.bodega;
	}

	public void transferirObjetos(Jugador jugador) {
		for (Item item  : jugador.getInventario()) {
			bodega.add(item);
		}
		jugador.getInventario().clear();

		System.out.println("Se han guardado todos los objetos exitosamente.");
	}
}
