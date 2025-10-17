package utils;

import player.Jugador;
import objetos.Item;
import java.util.List;
import java.util.ArrayList;
import objetos.ItemTipo;
import objetos.RobotExcavador;
import objetos.NaveExploradora;

public class RepararNaveReceta implements Receta {
    @Override
    public String getNombre() {
        return "Reparación de la Nave Estrellada (victoria)";
    }

    @Override
    public boolean puedeCrear(Jugador jugador) {
        int contador = 0;
        if(jugador.getTienePlanos()) {
            for(Item item : jugador.getNave().getBodega()) {
                if ((item.getTipo().name().equals("TITANIO") && item.getCantidad() >= 50) || (item.getTipo().name().equals("ACERO") && item.getCantidad() >= 30) || (item.getTipo().name().equals("URANIO") && item.getCantidad() >= 15) || (item.getTipo().name().equals("SULFURO") && item.getCantidad() >= 20)) {
                    contador++;
                }  
            }
            if (contador == 4) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void crear(Jugador jugador) {
        if (puedeCrear(jugador)) {

            for(Item item : jugador.getNave().getBodega()) {
                if (item.getTipo().name().equals("TITANIO")) {
                    item.addCantidad(-50);
                } else if (item.getTipo().name().equals("ACERO")) {
                    item.addCantidad(-30);
                } else if (item.getTipo().name().equals("URANIO")) {
                    item.addCantidad(-15);
                } else if (item.getTipo().name().equals("SULFURO")) {
                    item.addCantidad(-20);
                }
            }
            
            jugador.juegoActivo = false;
            System.out.println("¡La nave ha sido reparada!");
        }
    }
}