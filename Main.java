import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;
import objetos.Item;
import objetos.ItemTipo;
import player.Jugador;
import player.Oxigeno;
import entorno.Zonas;
import objetos.NaveExploradora;
import utils.Menu;

/*
 * Se inicia el juego y contiene el bucle principal de ejecución.
 */
public class Main {
	
	public static void main(String[] args) {
		
		// Se pregunta al jugador si quiere iniciar el juego
		boolean juegoActivo = false;
		System.out.println("\033[H\033[2J");
		System.out.println("Tu Nave se ha estrellado, sólo tienes una opción... sobrevivir. (x para empezar, q para salir):");
		System.out.print("> ");
		Scanner s = new Scanner(System.in);
		String respuesta = s.nextLine();
		
		while (!juegoActivo) {
			if (respuesta.equals("x")) {
				System.out.println("\nElige un nombre para tu personaje:");
				System.out.print("> ");
				s = new Scanner(System.in);
				respuesta = s.nextLine();
				juegoActivo = true;
			} else if (respuesta.equals("q")) {
				System.out.println("Cerrando el juego...\n");
				return;
			} else {
				System.out.println("\nIntente nuevamente (x para empezar, q para salir):");
				System.out.print("> ");
				s = new Scanner(System.in);
				respuesta = s.nextLine();
			}
		}
		
		// Se instancian NaveExploradora y Jugador con los objetos necesarios para su constructor
		Oxigeno tanqueInicial = new Oxigeno();
		NaveExploradora nave = new NaveExploradora();
		Zonas zonas = new Zonas();
		Jugador jugador = new Jugador(respuesta, tanqueInicial, nave, zonas.getArrecife());
		
		while (juegoActivo) {

			if(jugador.getTanqueOxigeno().getOxigenoRestante() <= 0 || jugador.getSofocacion()) {
				List<Item> porBorrar = new ArrayList<>();
				for (Item item : jugador.getInventario()) {
					if (!(item.getTipo().name().equals("PIEZA_TANQUE") || item.getTipo().name().equals("MODULO_PROFUNDIDAD") || item.getTipo().name().equals("PLANO_NAVE") || item.getTipo().name().equals("MEJORA_TANQUE") || item.getTipo().name().equals("TRAJE_TERMICO") || item.getTipo().name().equals("ROBOT_EXCAVADOR"))) {
						porBorrar.add(item);
					}
				}
				for (Item item : porBorrar) {
					jugador.getInventario().remove(item);
				}
				jugador.setEnNave(true);
				jugador.setProfundidadActual(jugador.getNave().getProfundidadAnclaje());
				jugador.getTanqueOxigeno().recargarCompleto();
				jugador.setSofocacion(false);
				System.out.println("Has perdido el conocimiento. Volviendo a la nave...");
			}
			
			if (jugador.getEnNave()) {
				Menu.menuNaveExploradora(jugador, zonas, nave);
			} else {
				Menu.menuNado(jugador, zonas);
			}
		}
	}
}
