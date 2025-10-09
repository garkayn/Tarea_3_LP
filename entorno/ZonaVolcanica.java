package entorno;

import java.util.EnumSet;
import objetos.ItemTipo;
import player.Jugador;

public class ZonaVolcanica extends Zona {
	private boolean planoEncontrado;

	public ZonaVolcanica() {
		super("Zona Volcánica", 1000, 1500, EnumSet.of(ItemTipo.TITANIO, ItemTipo.SULFURO, ItemTipo.URANIO), 3, 8);
		this.planoEncontrado = false;
	}

	@Override
	public void explorar(Jugador jugador) {

	    System.out.println("Explorando la zona volcanica...");
	}
}
