package player;

import java.util.List;
import java.util.ArrayList;

import objetos.AccesoProfundidad;
import objetos.Item;
import objetos.ItemTipo;
import objetos.NaveExploradora;
import entorno.Zona;
import objetos.RobotExcavador;

public class Jugador implements AccesoProfundidad {

	private String nombre;
	private Oxigeno tanqueOxigeno;
	private List<Item> inventario;
	private Zona zonaActual;
	private int profundidadActual;
	private boolean tienePlanos;
	private NaveExploradora nave;
	private boolean trajeTermico;
	private boolean mejoraTanque;
	private boolean enNave; // Determina si el jugador se encuentra en la nave exploradora
	private int profundidadRequerida; // La profundidad que se quiere mover el jugador
	private boolean sofocacion;
	private boolean moduloActivo;
	private RobotExcavador robot;
	public boolean juegoActivo;

	public Jugador(String nombre, Oxigeno tanqueInicial, NaveExploradora naveExploradora, Zona zonaInicial) {
		this.nombre = nombre;
		this.tanqueOxigeno = tanqueInicial;
		this.inventario = new ArrayList<>();
		this.zonaActual = zonaInicial;
		this.profundidadActual = 0;
		this.tienePlanos = false;
		this.nave = naveExploradora;
		this.trajeTermico = false;
		this.mejoraTanque = false;
		this.enNave = true;
		this.sofocacion = false;
		this.moduloActivo = false;
		this.juegoActivo = false;
	}

	// Getters
	public String getNombre() {
		return this.nombre;
	}

	public Oxigeno getTanqueOxigeno() {
		return this.tanqueOxigeno;
	}

	public List<Item> getInventario() {
		return this.inventario;
	}

	public Zona getZonaActual() {
		return this.zonaActual;
	}

	public int getProfundidadActual() {
		return this.profundidadActual;
	}

	public boolean getTienePlanos() {
		return this.tienePlanos;
	}

	public NaveExploradora getNave() {
		return this.nave;
	}

	public boolean getTrajeTermico() {
		return this.trajeTermico;
	}

	public boolean getMejoraTanque() {
		return this.mejoraTanque;
	}

	public boolean getEnNave() {
		return this.enNave;
	}

	public boolean getSofocacion() {
		return this.sofocacion;
	}

	public boolean getModuloActivo() {
		return this.moduloActivo;
	}

	public RobotExcavador getRobot() {
		return this.robot;
	}

	// Setters
	public void setTanqueOxigeno(Oxigeno t) {
		this.tanqueOxigeno = t;
	}

public void addInventario(ItemTipo tipo, int cantidad) {
    boolean itemEncontrado = false;

    for (Item itemActual : this.inventario) {
        if (itemActual.getTipo().equals(tipo)) {
            itemActual.addCantidad(cantidad);
            itemEncontrado = true;
            break;
        }
    }

    if (!itemEncontrado) {
        Item nuevoItem = new Item(tipo, cantidad);
        this.inventario.add(nuevoItem);
    }
}

	public void setZonaActual(Zona z) {
		this.zonaActual = z;
	}

	public void setProfundidadActual(int p) {
		this.profundidadActual = p;
	}

	public void setTienePlanos(boolean p) {
		this.tienePlanos = p;
	}

	public void setNave(NaveExploradora n) {
		this.nave = n;
	}

	public void setTrajeTermico(boolean t) {
		this.trajeTermico = t;
	}

	public void setMejoraTanque(boolean t) {
		this.mejoraTanque = t;
	}

	public void setEnNave(boolean value) {
		this.enNave = value;
	}

	public void setSofocacion(boolean value) {
		this.sofocacion = value;
	}

	public void setModuloActivo(boolean value) {
		this.moduloActivo = value;
	}

	public void setRobot(RobotExcavador nuevoRobot) {
		this.robot = nuevoRobot;
	}


	public void verEstadoJugador() {

		System.out.println("--- Estado de " + this.nombre + " ---");
		System.out.println("Oxigeno: " + this.tanqueOxigeno.getOxigenoRestante() + "/" + this.tanqueOxigeno.getCapacidadMaxima());
		System.out.print("Inventario: [");
		for (int i = 0; i < this.inventario.size(); i++) {
			System.out.print(this.inventario.get(i));
			if(i < this.inventario.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		System.out.println("Zona actual: " + this.zonaActual.nombre);
		System.out.println("Profundidad actual: " + this.profundidadActual + "m");
		System.out.println("-----------------------------------");
		
		if (this.mejoraTanque) {
			System.out.println("- Mejora del tanque realizada");
		}

		if (this.trajeTermico) {
			System.out.println("- Traje térmico creado");
		}

		if (this.tienePlanos) {
			System.out.println("- Planos de la nave estrellada encontrados");
		}

		if (this.moduloActivo) {
			System.out.println("- Módulo de profundidad instalado");
		}
	}
	
	@Override
	public boolean puedeAcceder (int requerido) {
		
		if (requerido < 0 || requerido > 1500) {
			System.out.println("No puedes acceder a esa profundidad");
			return false;
		} else if (!this.mejoraTanque && !this.trajeTermico && requerido > 999) {
			System.out.println("No puedes acceder a la Zona Volcánica hasta que tengas la mejora de tanque y el traje térmico.");
			return false;
		} else {
			return true;
		}
	} 
}
