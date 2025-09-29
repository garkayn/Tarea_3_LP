import java.util.Scanner;
import player.Jugador;
import player.Oxigeon;
import entorno.Zona;
import entorno.Zonas;
import objetos.NaveExploradora;

/*
 * Se inicia el juego y contiene el bucle principal de ejecución.
 */
public class Main {
	
	public static void main(String[] args) {

		// INICIAR JUEGO
		System.out.print("Apreta x para iniciar (q para salir): ");
		Scanner s = new Scanner(System.in);
		if (s == 'x') {
			juegoActivo = true;
		} else if (s == 'q') {
			System.exit();
		}

		// INICIALIZACIÓN ZONAS Y ENTIDADES
		Zona zonaArrecife = Zonas.getArrecife();
		NaveExploradora naveExploradora = new NaveExploradora();
		final int CAPACIDAD_INICIAL_TANQUE = 60;
		Oxigeno tanqueInicial = new Oxigeno(CAPACIDAD_INICIAL_TANQUE);
		Jugador jugador = new Jugador(tanqueInicial, naveExploradora, zonaArrecife);

		// BUCLE PRINCIPAL

		scanner.close();
	}
}
