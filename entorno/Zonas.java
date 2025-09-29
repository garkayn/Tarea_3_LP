package entorno;

public class Zonas {
	private static final ZonaArrecife ARRECIFE = new ZonaArrecife();
	private static final ZonaProfunda PROFUNDA = new ZonaProfunda();
	private static final ZonaVolcanica VOLCANICA = new ZonaVolcanica();
	private static final NaveEstrellada ESTRELLADA = new NaveEstrellada();

	//private Zonas();

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
