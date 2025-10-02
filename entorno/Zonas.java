package entorno;

// Esta clase se encarga de instancias una unica vez a cada zona del juego.
// Esto permite ir entregando la zona que se requiera durante la ejecución, pero manteniendolas persistentes.
public class Zonas {
	private static final ZonaArrecife ARRECIFE = new ZonaArrecife();
	private static final ZonaProfunda PROFUNDA = new ZonaProfunda();
	private static final ZonaVolcanica VOLCANICA = new ZonaVolcanica();
	private static final NaveEstrellada ESTRELLADA = new NaveEstrellada();

	public static Zona getArrecife() {
		return ARRECIFE;
	}
	public static Zona getProfunda() {
		return PROFUNDA;
	}
	public static Zona getVolcanica() {
		return VOLCANICA;
	}
	public static Zona getEstrellada() {
		return ESTRELLADA;
	}

}
