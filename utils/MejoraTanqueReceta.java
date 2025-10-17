package utils;

import player.Jugador;
import objetos.Item;
import java.util.List;
import java.util.ArrayList;
import objetos.ItemTipo;
import objetos.NaveExploradora;

public class MejoraTanqueReceta implements Receta {
    @Override
    public String getNombre() {
        return "Mejora de tanque";
    }

    @Override
    public boolean puedeCrear(Jugador jugador) {

        if(!jugador.getMejoraTanque()) {
            for(Item item : jugador.getNave().getBodega()) {
                if (item.getTipo().name().equals("PIEZA_TANQUE") && item.getCantidad() == 3) {
                    return true;
                }  
            }
        }
        return false;
    }

    @Override
    public void crear(Jugador jugador) {

        if (puedeCrear(jugador)) {
            List<Item> porBorrar = new ArrayList<>();
            for(Item item : jugador.getNave().getBodega()) {
                if (item.getTipo().name().equals("PIEZA_TANQUE")) {
                    porBorrar.add(item);
                }  
            }
            for (Item item : porBorrar) {
                jugador.getNave().getBodega().remove(item);
            }
            jugador.setMejoraTanque(true);
            jugador.getTanqueOxigeno().addCapacidadMaxima(60);
            jugador.getTanqueOxigeno().recargarCompleto();
            System.out.println("¡Mejora de tanque creada!");
        }
    }
}