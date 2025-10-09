package utils;

import java.util.Scanner;

import player.Jugador;
import objetos.NaveExploradora;
import entorno.Zonas;


public class Menu {

	public static void menuNado (Jugador jugador, Zonas zonas) {
		System.out.println("\n-- " + jugador.getNombre() +" --");
		System.out.println("Zona actual: " + jugador.getZonaActual().getNombre() + " | Profundidad: " + jugador.getProfundidadActual() + " m | Oxígeno: " + jugador.getTanqueOxigeno().getOxigenoRestante());
		System.out.println("1. Ver estado de " + jugador.getNombre() + "");
		System.out.println("2. Abrir inventario");
		System.out.println("3. Volver a la nave");
		System.out.println("4. Subir o descender en profundidad");
		System.out.println("5. Explorar");
		System.out.println("6. Recolectar");
		if (!jugador.getZonaActual().getNombre().equals("Nave Estrellada") && !jugador.getEnNave() && jugador.getProfundidadActual() == 0) {
			System.out.println("7. Entrar a la nave estrellada");
		}
		System.out.println("q. Salir del juego");

		System.out.print("> ");
		Scanner s = new Scanner(System.in);
		String respuesta = s.nextLine();
		
		if (respuesta.equals("1")) {

			jugador.verEstadoJugador();

		} else if (respuesta.equals("3")) {

			jugador.setEnNave(true);
			jugador.getTanqueOxigeno().recargarCompleto();
			System.out.println("Volviendo a la nave...");

		} else if (respuesta.equals("4")) {

			System.out.println("Indica profundidad destino (rango zona " + jugador.getZonaActual().getProfundidadMin() + "-" + jugador.getZonaActual().getProfundidadMax() + " m):");
			System.out.print("> ");
			s = new Scanner(System.in);
			respuesta = s.nextLine();

			int profundidadDeseada = Integer.parseInt(respuesta);

			if (jugador.puedeAcceder(profundidadDeseada) && profundidadDeseada >= jugador.getZonaActual().getProfundidadMin() && profundidadDeseada <= jugador.getZonaActual().getProfundidadMax()) {

				// Gasto de oxigeno
				double d = (jugador.getProfundidadActual() - jugador.getZonaActual().getProfundidadMin()) / Math.max(1, jugador.getZonaActual().getProfundidadMax() - jugador.getZonaActual().getProfundidadMin());
				double costoMover = (3 + 3 * d) * Math.abs(jugador.getProfundidadActual() - profundidadDeseada) / 50;
				jugador.getTanqueOxigeno().consumirO2((int) Math.ceil(costoMover));

				jugador.setProfundidadActual(profundidadDeseada);
				System.out.println("Te moviste a " + jugador.getProfundidadActual() + " m. Costo Oxígeno = " + (int) Math.ceil(costoMover) + ". Oxígeno ahora = " + jugador.getTanqueOxigeno().getOxigenoRestante());
			}

		} else if (respuesta.equals("5")) {

			jugador.getZonaActual().explorar(jugador);

		} else if (!jugador.getZonaActual().getNombre().equals("Nave Estrellada") && !jugador.getEnNave() && jugador.getProfundidadActual() == 0 && respuesta.equals("8")) {
			
			zonas.getEstrellada().entrar(jugador);

		} else if (respuesta.equals("q")) {
			System.out.println("Saliendo...");
			System.exit(0);
		} 
	}

	public static void menuNaveExploradora (Jugador jugador, Zonas zonas, NaveExploradora nave) {
		
		System.out.println("\n-- NAVE EXPLORADORA --");
		System.out.println("Zona actual: " + jugador.getZonaActual().getNombre() + " | Anclaje: " + nave.getProfundidadAnclaje() + " m | Inventario nave: " + nave.getBodega().size());
		System.out.println("1. Ajustar profundidad de la nave");
		System.out.println("2. Guardar TODOS los objetos del jugador en la nave");
		System.out.println("3. Crear objetos");
		System.out.println("4. Moverse a otra zona");
		System.out.println("5. Salir de la nave");
		System.out.println("6. Ver inventario de la nave");
		System.out.println("q. Salir del juego");
		
		System.out.print("> ");
		Scanner s = new Scanner(System.in);
		String respuesta = s.nextLine();

		if (respuesta.equals("1")) {

			System.out.println("Indica nueva profundidad de anclaje (rango zona " + jugador.getZonaActual().getProfundidadMin() + "-" + jugador.getZonaActual().getProfundidadMax() + " m):");
			System.out.print("> ");
			s = new Scanner(System.in);
			respuesta = s.nextLine();

			int profundidadDeseada = Integer.parseInt(respuesta);

			if (jugador.puedeAcceder(profundidadDeseada) && profundidadDeseada >= jugador.getZonaActual().getProfundidadMin() && profundidadDeseada <= jugador.getZonaActual().getProfundidadMax()) {
				jugador.getNave().setProfundidadAnclaje(profundidadDeseada);
				jugador.setProfundidadActual(profundidadDeseada);
				System.out.println("Anclaje fijado a " + jugador.getNave().getProfundidadAnclaje() + " m.");
			}
	
		} else if (respuesta.equals("4")) {

			System.out.println("¿A cuál zona quieres ir?");

			if (!jugador.getZonaActual().getNombre().equals("Zona Arrecife")) {
				System.out.println("a. Zona Arrecife");
			}

			if (!jugador.getZonaActual().getNombre().equals("Zona Profunda")) {
				System.out.println("p. Zona Profunda");
			}

			if (!jugador.getZonaActual().getNombre().equals("Zona Volcánica")) {
				System.out.println("v. Zona Volcánica");
			}

			s = new Scanner(System.in);
			respuesta = s.nextLine();

			if (respuesta.equals("a")) {
				jugador.getNave().setProfundidadAnclaje(0);
				jugador.setProfundidadActual(0);
				zonas.getArrecife().entrar(jugador);
			} else if (respuesta.equals("p")) {
				jugador.getNave().setProfundidadAnclaje(200);
				jugador.setProfundidadActual(200);
				zonas.getProfunda().entrar(jugador);
			} else if (respuesta.equals("v")) {
				if (jugador.puedeAcceder(1000)) {
					jugador.getNave().setProfundidadAnclaje(1000);
					jugador.setProfundidadActual(1000);
					zonas.getVolcanica().entrar(jugador);
				}
			}

			System.out.println("Viajando a " + jugador.getZonaActual().getNombre() + "...");
			System.out.println("Destino alcanzando. (" + jugador.getZonaActual().getNombre() + ", anclaje=" + jugador.getNave().getProfundidadAnclaje() + " m).");

		} else if (respuesta.equals("5")) {
			jugador.setEnNave(false);
			System.out.println("Saliendo de la nave. Profundidad actual: " + jugador.getProfundidadActual() + "m.");

		} else if (respuesta.equals("q")) {
			System.out.println("Saliendo...");
			System.exit(0);
		}

	}
}
