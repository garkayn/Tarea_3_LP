package player;

import java.util.List;
import java.util.ArrayList;

import objetos.AccesoProfundidad;
import objetos.Item;
import objetos.NaveExploradora;
import entorno.Zona;

public class Jugador implements AccesoProfundidad {

	private Oxigeno tanqueOxigeno;
	private List<Item> inventario;
	private Zona zonaActual;
	private int profundidadActual;
	private boolean tienePlanos;
	private NaveExploradora nave;
	private boolean trajeTermico;
	private boolean mejoraTanque;

	public Jugador(Oxigeno tanqueInicial, NaveExploradora naveExploradora, Zona zonaInicial) {
		this.tanqueOxigeno = tanqueInicial;
		this.inventario = new ArrayList<>();
		this.zonaActual = zonaInicial;
		this.profundidadActual = 0;
		this.tienePlanos = false;
		this.nave = naveExploradora;
		this.trajeTermico = false;
		this.mejoraTanque = false;
	}
	
	//public void verEstadoJugador();
}
