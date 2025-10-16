package entorno;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.EnumSet;
import objetos.Item;
import objetos.ItemTipo;
import player.Jugador;
import utils.Probabilidades;

public class ZonaVolcanica extends Zona {
	private boolean planoEncontrado;

	public ZonaVolcanica() {
		super("Zona Volcánica", 1000, 1500, EnumSet.of(ItemTipo.TITANIO, ItemTipo.SULFURO, ItemTipo.URANIO), 3, 8);
		this.planoEncontrado = false;
	}

	@Override
	public void explorar (Jugador jugador) {
		
		// Gasto de oxigeno
		float d = (jugador.getProfundidadActual() - getProfundidadMin()) / Math.max(1, getProfundidadMax() - getProfundidadMin());
		float costoExplorar = 12 + 10*d;
		jugador.getTanqueOxigeno().consumirO2((int) Math.ceil(costoExplorar));
		
		// Recolección recursos
		if (Probabilidades.especiales(0.15) && !this.planoEncontrado) {
			ItemTipo tipo = ItemTipo.PLANO_NAVE;
			jugador.addInventario(tipo, 1);
			
			this.planoEncontrado = true;
			System.out.println("Plano de la nave estrellada encontrado!!!");
		} else {
			int cantidad = Math.max(1, (int) Math.floor(getUnidadesMin() * d));
			ItemTipo recurso = Probabilidades.recursosVolcanica();
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

		int cantidad = Math.max(1, (int) Math.floor(getUnidadesMin() + (getUnidadesMax() - getUnidadesMin()) * d));		jugador.addInventario(recursoElegido, cantidad);
		System.out.println("Se recolectó " + recursoElegido.name() + " (" + cantidad + ")");
	}
}
