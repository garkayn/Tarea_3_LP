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

	// Getters
	public String getNombre() {
		return nombre;
	}

	public int getProfundidadMin() {
		return profundidadMin;
	}
	
	public int getProfundidadMax() {
		return profundidadMax;
	}

	public EnumSet<ItemTipo> getRecursos() {
		return recursos;
	}

	// Setters
	public void setProfundidadMin(int p) {
		this.profundidadMin = p;
	}

	public void setProfundidadMax(int p) {
		this.profundidadMax = p;
	}

	public void setRecursos(EnumSet<ItemTipo> r) {
		this.recursos = r;
	}

	/*
	 * Cambia la zona en la que se encuentra el jugador 
	 * @param jugador: Jugador
	 * @return void
	 */
	public void entrar (Jugador jugador) {
		jugador.setZonaActual(this);		
	}

	public abstract void explorar (Jugador jugador);
}
