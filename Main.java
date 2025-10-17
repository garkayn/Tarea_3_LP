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
import utils.Receta;
import utils.MejoraTanqueReceta;
import utils.MejoraOxigenoReceta;
import utils.TrajeTermicoReceta;
import utils.ModuloProfundidadReceta;
import utils.CrearRobotReceta;
import utils.RepararNaveReceta;

/*
 * Se inicia el juego y contiene el bucle principal de ejecución.
 */
public class Main {
	
	public static void main(String[] args) {
		
		// Se pregunta al jugador si quiere iniciar el juego
		System.out.println("\033[H\033[2J");
		System.out.println("Tu Nave se ha estrellado, sólo tienes una opción... sobrevivir. (x para empezar, q para salir):");
		System.out.print("> ");
		Scanner s = new Scanner(System.in);
		String respuesta = s.nextLine();
		
		boolean flag = true;
		while (flag) {
			if (respuesta.equals("x")) {
				System.out.println("\nElige un nombre para tu personaje:");
				System.out.print("> ");
				s = new Scanner(System.in);
				respuesta = s.nextLine();
				flag = false;
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
		List<Receta> todasLasRecetas = new ArrayList<>();
		todasLasRecetas.add(new MejoraTanqueReceta());
		todasLasRecetas.add(new MejoraOxigenoReceta());
		todasLasRecetas.add(new TrajeTermicoReceta());
		todasLasRecetas.add(new ModuloProfundidadReceta());
		todasLasRecetas.add(new CrearRobotReceta());
		todasLasRecetas.add(new RepararNaveReceta());
		
		jugador.juegoActivo = true;

		while (jugador.juegoActivo) {

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
				Menu.menuNaveExploradora(jugador, zonas, nave, todasLasRecetas);
			} else {
				Menu.menuNado(jugador, zonas);
			}
		}

		System.out.println("\033[H\033[2J");
		System.out.println("Sistemas: ACTIVOS");
		System.out.println("Propulsión: EN LÍNEA");
		System.out.println("Casco: ÍNTEGRO");
		System.out.println("\n¡Has escapado del planeta!");
		System.out.println("¡Felicidades por completar el juego!");
	}
}
