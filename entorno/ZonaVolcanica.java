package entorno;

import java.util.EnumSet;
import objetos.ItemTipo;

public class ZonaVolcanica extends Zona {
	private boolean planoEncontrado;

	public ZonaVolcanica() {
		super("volcanica", 1000, 1500, EnumSet.of(ItemTipo.TITANIO, ItemTipo.SULFURO, ItemTipo.URANIO));
		this.planoEncontrado = false;
	}
}
