package entorno;

import java.util.EnumSet;
import objetos.ItemTipo;

public class ZonaArrecife extends Zona {

	private int piezasTanque;

	public ZonaArrecife() {
		super("arrecife", 0, 199, EnumSet.of(ItemTipo.CUARZO, ItemTipo.SILICIO, ItemTipo.COBRE));
		piezasTanque = 3;
	}
}
