package entorno;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.EnumSet;
import objetos.ItemTipo;
import player.Jugador;
import player.Oxigeno;
import objetos.Item;
import utils.Probabilidades;

public class ZonaArrecife extends Zona {

	private int piezasTanque;
	private int piezasObtenidas;

	public ZonaArrecife() {
		super("Zona Arrecife", 0, 199, EnumSet.of(ItemTipo.CUARZO, ItemTipo.SILICIO, ItemTipo.COBRE), 1, 3);
		piezasTanque = 3;
		piezasObtenidas = 0;
	}
	
	@Override
	public void explorar (Jugador jugador) {
		
		// Gasto de oxigeno
		float d = (jugador.getProfundidadActual() - getProfundidadMin()) / Math.max(1, getProfundidadMax() - getProfundidadMin());
		float costoExplorar = 12 + 10*d;
		jugador.getTanqueOxigeno().consumirO2((int) Math.ceil(costoExplorar));
		
		// Obtención PIEZA_TANQUE o recolección recursos
		if (Probabilidades.especiales(0.3) && this.piezasObtenidas < 3) {
			ItemTipo tipo = ItemTipo.PIEZA_TANQUE;
			jugador.addInventario(tipo, 1);

			this.piezasObtenidas++;
			System.out.println("Pieza para mejora del tanque de oxígeno encontrada " + this.piezasObtenidas + "/3");
		} else {
			int cantidad = Math.max(1, (int) Math.floor(getUnidadesMin() * d));
			ItemTipo recurso = Probabilidades.recursosArrecife();
			jugador.addInventario(recurso, cantidad);
			System.out.println("Se recolectó " + recurso.name() + " (" + cantidad + ")");
		}
	}

	@Override
	public void recolectar(Jugador jugador) {

		List<ItemTipo> listaRecursos = new ArrayList<>(getRecursos());

		float d = (jugador.getProfundidadActual() - getProfundidadMin()) / Math.max(1, getProfundidadMax() - getProfundidadMin());
		float costoRecolectar = 10 + 6*d;
		jugador.getTanqueOxigeno().consumirO2((int) Math.ceil(costoRecolectar));
		
		int contador = 1;
		System.out.println("¿Cuales recursos deseas extraer?");
		for(ItemTipo tipo : listaRecursos) {
			System.out.println(contador + ") " + tipo);
			contador++;
		}
		Scanner s = new Scanner(System.in);
		String respuesta = s.nextLine();

		int seleccion = Integer.parseInt(respuesta);
		ItemTipo recursoElegido = listaRecursos.get(seleccion - 1);

		int cantidad = Math.max(1, (int) Math.floor(getUnidadesMin() + (getUnidadesMax() - getUnidadesMin()) * d));
		jugador.addInventario(recursoElegido, cantidad);
		System.out.println("Se recolectó " + recursoElegido.name() + " (" + cantidad + ")");
	}
}
