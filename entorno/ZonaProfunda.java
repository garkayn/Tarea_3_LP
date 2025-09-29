package entorno;

import java.util.EnumSet;
import objetos.ItemTipo;

public class ZonaProfunda extends Zona {
	private int presion; // Definir valor presión con formula

	public ZonaProfunda() {
		super("profunda", 200, 999, EnumSet.of(ItemTipo.PLATA, ItemTipo.ORO, ItemTipo.ACERO, ItemTipo.DIAMANTE, ItemTipo.MAGNETITA));
	}
}
