package objetos;

import java.util.List;
import java.util.ArrayList;

public abstract class Vehiculo {
	
	private List<Item> bodega;

	public Vehiculo() {
		this.bodega = new ArrayList<>();
	}

	//public void transferirObjetos();
}
