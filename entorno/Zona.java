package entorno;

import java.util.EnumSet;

import player.Jugador;
import objetos.Item;
import objetos.ItemTipo;

public abstract class Zona {

	public String nombre;
	private int profundidadMin;
	private int profundidadMax;
	private EnumSet<ItemTipo> recursos;
	
	public Zona (String nombre, int min, int max, EnumSet<ItemTipo> items) {
		this.nombre = nombre;
		this.profundidadMin = min;
		this.profundidadMax = max;
		this.recursos = items;
	}

	//public void entrar (Jugador jugador);
	//public void explorar (Jugador jugador);

}
