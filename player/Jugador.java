package player;

import java.util.List;
import java.util.ArrayList;

import objetos.AccesoProfundidad;
import objetos.Item;
import objetos.NaveExploradora;
import entorno.Zona;

public class Jugador implements AccesoProfundidad {

	private String nombre;
	private Oxigeno tanqueOxigeno;
	private List<Item> inventario;
	private Zona zonaActual;
	private int profundidadActual;
	private boolean tienePlanos;
	private NaveExploradora nave;
	private boolean trajeTermico;
	private boolean mejoraTanque;
	private boolean enNave; // Determina si el jugador se encuentra en la nave exploradora

	public Jugador(String nombre, Oxigeno tanqueInicial, NaveExploradora naveExploradora, Zona zonaInicial) {
		this.nombre = nombre;
		this.tanqueOxigeno = tanqueInicial;
		this.inventario = new ArrayList<>();
		this.zonaActual = zonaInicial;
		this.profundidadActual = 0;
		this.tienePlanos = false;
		this.nave = naveExploradora;
		this.trajeTermico = false;
		this.mejoraTanque = false;
		this.enNave = true;
	}

	// Getters
	public String getNombre() {
		return nombre;
	}

	public Oxigeno getTanqueOxigeno() {
		return tanqueOxigeno;
	}

	public List<Item> getInventario() {
		return inventario;
	}

	public Zona getZonaActual() {
		return zonaActual;
	}

	public int getProfundidadActual() {
		return profundidadActual;
	}

	public boolean getTienePlanos() {
		return tienePlanos;
	}

	public NaveExploradora getNave() {
		return nave;
	}

	public boolean getTrajeTermico() {
		return trajeTermico;
	}

	public boolean getMejoraTanque() {
		return mejoraTanque;
	}

	// Setters
	public void setTanqueOxigeno(Oxigeno t) {
		this.tanqueOxigeno = t;
	}

	public void addInventario(Item i) {
		this.inventario.add(i);
	}

	public void setZonaActual(Zona z) {
		this.zonaActual = z;
	}

	public void setProfundidadActual(int p) {
		this.profundidadActual = p;
	}

	public void setTienePlanos(boolean p) {
		this.tienePlanos = p;
	}

	public void setNave(NaveExploradora n) {
		this.nave = n;
	}

	public void setTrajeTermico(boolean t) {
		this.trajeTermico = t;
	}

	public void setMejoraTanque(boolean t) {
		this.mejoraTanque = t;
	}

	public void verEstadoJugador() {

		System.out.println("--- Estado de " + this.nombre + " ---\n");
		System.out.println("Oxigeno: " + this.tanqueOxigeno.getOxigenoRestante() + "/" + this.tanqueOxigeno.getCapacidadMaxima() + "\n");
		System.out.println("Inventario: " + this.inventario + "\n");
		System.out.println("Zona actual: " + this.zonaActual.getNombre() + "\n");
		System.out.println("Profundidad actual: " + this.profundidadActual + "m\n");
		System.out.println("-----------------------------------\n");
		
		if (this.enNave) {
			System.out.println("Te encuentras dentro de la nave exploradora");		
		}

		System.out.println("-----------------------------------\n");
		
		if (this.mejoraTanque) {
			System.out.println("Mejora del tanque realizada\n");
		}

		if (this.trajeTermico) {
			System.out.println("Tienes el traje térmico\n");
		}

		if (this.tienePlanos) {
			System.out.println("Tienes los planos de la nave estrellada\n");
		}
	}
	
	public void subir (int requerido) {

		if (this.profundidadActual - requerido < 0) {
			System.out.println("No es posible subir esa distancia");
			return;
		}

		this.profundidadActual -= requerido;
	}

	public void descender (int requerido) {

		if (this.profundidadActual + requerido > 1500) {
			System.out.println("No es posible descender esa distancia");
			return;
		}

		this.profundidadActual += requerido;
	}
}
