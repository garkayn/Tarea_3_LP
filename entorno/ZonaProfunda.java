package entorno;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.EnumSet;
import objetos.Item;
import objetos.ItemTipo;
import player.Jugador;
import utils.Probabilidades;

public class ZonaProfunda extends Zona {
	private int presion;

	public ZonaProfunda() {
		super("Zona Profunda", 200, 999, EnumSet.of(ItemTipo.PLATA, ItemTipo.ORO, ItemTipo.ACERO, ItemTipo.DIAMANTE, ItemTipo.MAGNETITA), 2, 6);
		this.presion = 10;
	}
	
	@Override
	public void explorar (Jugador jugador) {
		
		// Gasto de oxigeno
		float d = (jugador.getProfundidadActual() - getProfundidadMin()) / Math.max(1, getProfundidadMax() - getProfundidadMin());
		float costoExplorar = 12 + 10*d + this.presion + 6*d;
		jugador.getTanqueOxigeno().consumirO2((int) Math.ceil(costoExplorar));
		
		// Recolección recursos
		int cantidad = Math.max(1, (int) Math.floor(getUnidadesMin() * d));
		ItemTipo recurso = Probabilidades.recursosProfunda();
		jugador.addInventario(recurso, cantidad);
		System.out.println("Se recolectó " + recurso.name() + " (" + cantidad + ")");
	}

	@Override
	public void recolectar(Jugador jugador) {

		List<ItemTipo> listaRecursos = new ArrayList<>(getRecursos());

		float d = (jugador.getProfundidadActual() - getProfundidadMin()) / Math.max(1, getProfundidadMax() - getProfundidadMin());
		float costoRecolectar = 10 + 6*d;
		if(!jugador.getMejoraTanque()) {
			costoRecolectar += this.presion + 6*d;
		} 
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
