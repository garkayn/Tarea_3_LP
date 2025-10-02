import java.util.Scanner;
import player.Jugador;
import player.Oxigeno;
import entorno.Zona;
import entorno.Zonas;
import objetos.NaveExploradora;
import entorno.ZonaArrecife;
import entorno.ZonaProfunda;
import entorno.ZonaVolcanica;
import entorno.NaveEstrellada;

/*
 * Se inicia el juego y contiene el bucle principal de ejecución.
 */
public class Main {
	
	public static void main(String[] args) {
		
		// Se pregunta al jugador si quiere iniciar el juego
		boolean juegoActivo = false;
		System.out.println("\033[H\033[2J");
		System.out.println("Tu Nave se ha estrellado, sólo tienes una opción... sobrevivir. (x to start, q to quit):\n");
		Scanner s = new Scanner(System.in);
		String respuesta = s.nextLine();
		
		while (!juegoActivo) {
			if (respuesta.equals("x")) {
				System.out.println("Elige un nombre para tu personaje:\n");
				s = new Scanner(System.in);
				respuesta = s.nextLine();
				juegoActivo = true;
			} else if (respuesta.equals("q")) {
				System.out.println("Cerrando el juego...\n");
				return;
			} else {
				System.out.println("Intente nuevamente (x para iniciar, q para salir):\n");
				s = new Scanner(System.in);
				respuesta = s.nextLine();
			}
		}
		
		// Se instancian NaveExploradora y Jugador con los objetos necesarios para su constructor
		Oxigeno tanqueInicial = new Oxigeno();
		NaveExploradora nave = new NaveExploradora();
		Zonas zonas = new Zonas();
		Zona zonaActual = zonas.getArrecife();	
		Jugador jugador = new Jugador(respuesta, tanqueInicial, nave, zonaActual);
		
		while (juegoActivo) {
			System.out.println("Te encuentras en " + jugador.getZonaActual().getNombre() + ". Elige tu acción:\n");
			System.out.println("1. Ver estado de " + jugador.getNombre() + "\n");
			System.out.println("2. Abrir inventario\n");
			System.out.println("3. Entrar a la nave exploradora\n");
			System.out.println("4. Subir\n");
			System.out.println("5. Descender\n");
			System.out.println("6. Explorar\n");
			System.out.println("7. Recolectar\n");
			System.out.println("0. Salir del juego\n");

			s = new Scanner(System.in);
			respuesta = s.nextLine();
			
			if (respuesta.equals("1")) {
				jugador.verEstadoJugador();
			}

			else if (respuesta.equals("4")) {
				System.out.println("Ingresa la distancia que deseas subir:\n");
				s = new Scanner(System.in);
				respuesta = s.nextLine();
				jugador.subir(Integer.parseInt(respuesta));
			}
			else if (respuesta.equals("5")) {
				System.out.println("Ingresa la distancia que deseas descender:\n");
				s = new Scanner(System.in);
				respuesta = s.nextLine();
				jugador.descender(Integer.parseInt(respuesta));

			}
			else if (respuesta.equals("6")) {
				jugador.getZonaActual().explorar(jugador);
			} else if (respuesta.equals("0")) {
				return;
			} 
		}
	}
}
