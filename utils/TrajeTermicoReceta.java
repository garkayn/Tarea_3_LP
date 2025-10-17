package utils;

import player.Jugador;
import objetos.Item;
import java.util.List;
import java.util.ArrayList;
import objetos.ItemTipo;
import objetos.NaveExploradora;

public class TrajeTermicoReceta implements Receta {
    @Override
    public String getNombre() {
        return "Traje térmico";
    }

    @Override
    public boolean puedeCrear(Jugador jugador) {
        int contador = 0;
        if(!jugador.getTrajeTermico()) {
            for(Item item : jugador.getNave().getBodega()) {
                if ((item.getTipo().name().equals("SILICIO") && item.getCantidad() >= 10) || (item.getTipo().name().equals("ORO") && item.getCantidad() >= 3) || (item.getTipo().name().equals("CUARZO") && item.getCantidad() >= 5)) {
                    contador++;
                }  
            }
            if (contador == 3) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void crear(Jugador jugador) {
        if (puedeCrear(jugador)) {

            for(Item item : jugador.getNave().getBodega()) {
                if (item.getTipo().name().equals("SILICIO")) {
                    item.addCantidad(-10);
                } else if (item.getTipo().name().equals("ORO")) {
                    item.addCantidad(-3);
                } else if (item.getTipo().name().equals("CUARZO")) {
                    item.addCantidad(-5);
                }
            }
            jugador.setTrajeTermico(true);
            System.out.println("¡Traje térmico creado!");
        }
    }
}