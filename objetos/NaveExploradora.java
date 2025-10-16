package objetos;

import player.Jugador;
import objetos.AccesoProfundidad;

public class NaveExploradora extends Vehiculo implements AccesoProfundidad {
	
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

	@Override
	public boolean puedeAcceder (int requerido) {
		
		if (requerido < 0 || requerido > 1500) {
			System.out.println("No puedes acceder a esa profundidad");
			return false;
		} else if (requerido > this.profundidadSoportada) {
			System.out.println("Necesitas el modulo de profundidad para descender a más de 500m");
			return false;
		} else {
			return true;
		}
	} 

	public void conseguirMejoraProfundidad() {
        ModuloProfundidad modulo = new ModuloProfundidad();
        modulo.aumentarProfundidad();
        System.out.println("¡Módulo de profundidad instalado!");
    }

	public class ModuloProfundidad {

		private int profundidadExtra;

		public ModuloProfundidad() {
			profundidadExtra = 1000;
		}

		public void aumentarProfundidad() {
			profundidadSoportada += profundidadExtra;
		}
	}
}
