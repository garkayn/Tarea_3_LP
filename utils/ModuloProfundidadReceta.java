package utils;

import player.Jugador;
import objetos.Item;
import java.util.List;
import java.util.ArrayList;
import objetos.ItemTipo;
import objetos.NaveExploradora;

public class ModuloProfundidadReceta implements Receta {
    @Override
    public String getNombre() {
        return "Instalar módulo de profundidad";
    }

    @Override
    public boolean puedeCrear(Jugador jugador) {

        for(Item item : jugador.getNave().getBodega()) {
            if (item.getTipo().name().equals("MODULO_PROFUNDIDAD")) {
                return true;
            } 
        }
        return false;
    }

    @Override
    public void crear(Jugador jugador) {
        if (puedeCrear(jugador)) {
            List<Item> porBorrar = new ArrayList<>();
            for(Item item : jugador.getNave().getBodega()) {
                if (item.getTipo().name().equals("MODULO_PROFUNDIDAD")) {
                    porBorrar.add(item);
                }  
            }
            for (Item item : porBorrar) {
                jugador.getNave().getBodega().remove(item);
            }

            jugador.setModuloActivo(true);
            jugador.getNave().conseguirMejoraProfundidad();
        }
    }
}