package objetos;

public class Item {

	private ItemTipo tipo;
	private int cantidad;

	public Item (ItemTipo tipo, int cantidad) {
		this.tipo = tipo;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return tipo + " (" + cantidad + ")";
	}

	public ItemTipo getTipo() {
		return this.tipo;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void addCantidad(int agregar) {
		this.cantidad += agregar;
	}
}
