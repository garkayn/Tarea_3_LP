package objetos;

import player.Jugador;

public class NaveExploradora extends Vehiculo {
	
	private int profundidadSoportada;
	private int profundidadAnclaje;

	public NaveExploradora() {
		super();
		this.profundidadSoportada = 500;
	}

	public int getProfundidadAnclaje() {
		return this.profundidadAnclaje;
	}

	public void setProfundidadAnclaje(int requerido) {
		this.profundidadAnclaje = requerido;
	}

	public class ModuloProfundidad {

		private int profundidadExtra;

		//public void aumentarProfundidad();
	}
}
