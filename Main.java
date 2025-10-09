import java.util.Scanner;

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
			
			if (jugador.getEnNave()) {
				Menu.menuNaveExploradora(jugador, zonas, nave);
			} else {
				Menu.menuNado(jugador, zonas);
			}
		}
	}
}
