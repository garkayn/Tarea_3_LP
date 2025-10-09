package entorno;

import java.util.EnumSet;
import objetos.ItemTipo;
import player.Jugador;

public class ZonaProfunda extends Zona {
	private int presion; // Definir valor presión con formula

	public ZonaProfunda() {
		super("Zona Profunda", 200, 999, EnumSet.of(ItemTipo.PLATA, ItemTipo.ORO, ItemTipo.ACERO, ItemTipo.DIAMANTE, ItemTipo.MAGNETITA), 2, 6);
	}
	
	@Override
	public void explorar(Jugador jugador) {

	    System.out.println("Explorando la zona profunda...");
	}
}
