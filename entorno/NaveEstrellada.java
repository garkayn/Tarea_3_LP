package entorno;

import objetos.NaveExploradora;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.EnumSet;
import objetos.Item;
import objetos.ItemTipo;
import player.Jugador;
import utils.Probabilidades;

public class NaveEstrellada extends Zona {
	private boolean moduloEncontrado;

	public NaveEstrellada() {
		super("Nave Estrellada", 0, 0, EnumSet.of(ItemTipo.CABLES, ItemTipo.PIEZAS_DE_METAL), 1, 4);
		this.moduloEncontrado = false;
	}

	@Override
	public void explorar (Jugador jugador) {
		
		// Recolección recursos
		if (Probabilidades.especiales(0.25) && !this.moduloEncontrado) {
			ItemTipo tipo = ItemTipo.MODULO_PROFUNDIDAD;
			jugador.addInventario(tipo, 1);

			this.moduloEncontrado = true;
			System.out.println("Modulo de profundidad encontrado...");
		} else {
			int cantidad = 1;
			ItemTipo recurso = Probabilidades.recursosEstrellada();
			jugador.addInventario(recurso, cantidad);
			System.out.println("Se recolectó " + recurso.name() + " (" + cantidad + ")");
		}
	}

	@Override
	public void recolectar(Jugador jugador) {
		
		List<ItemTipo> listaRecursos = new ArrayList<>(getRecursos());

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

		int cantidad = 1; // d = 0
		jugador.addInventario(recursoElegido, cantidad);
		System.out.println("Se recolectó " + recursoElegido.name() + " (" + cantidad + ")");
	}
}
