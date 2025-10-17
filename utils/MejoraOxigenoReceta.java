package utils;

import player.Jugador;
import objetos.Item;
import java.util.List;
import java.util.ArrayList;
import objetos.ItemTipo;
import objetos.NaveExploradora;

public class MejoraOxigenoReceta implements Receta {
    @Override
    public String getNombre() {
        return "Mejora de oxígeno";
    }

    @Override
    public boolean puedeCrear(Jugador jugador) {

        int contador = 0;
        if(jugador.getMejoraTanque()) {
            for(Item item : jugador.getNave().getBodega()) {
                if ((item.getTipo().name().equals("PLATA") && item.getCantidad() >= 10) || (item.getTipo().name().equals("CUARZO") && item.getCantidad() >= 15)) {
                    contador++;
                }  
            }
            if (contador == 2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void crear(Jugador jugador) {
        if (puedeCrear(jugador)) {

            for(Item item : jugador.getNave().getBodega()) {
                if (item.getTipo().name().equals("PLATA")) {
                    item.addCantidad(-10);
                } else if (item.getTipo().name().equals("CUARZO")) {
                    item.addCantidad(-15);
                }
            }
            jugador.getTanqueOxigeno().addCapacidadMaxima(30);
            jugador.getTanqueOxigeno().recargarCompleto();
            System.out.println("¡Mejora de oxígeno creada!");
        }
    }
}