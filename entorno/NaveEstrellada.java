package entorno;

import java.util.EnumSet;
import objetos.ItemTipo;
import player.Jugador;

public class NaveEstrellada extends Zona {
	private boolean moduloEncontrado;

	public NaveEstrellada() {
		super("nave", 0, 0, EnumSet.of(ItemTipo.CABLES, ItemTipo.PIEZAS_DE_METAL));
		this.moduloEncontrado = false;
	}

	public void explorar(Jugador jugador) {

	    System.out.println("Explorando la nave estrellada...");
	}
}
