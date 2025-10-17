package utils;

import player.Jugador;
import objetos.Item;
import java.util.List;
import java.util.ArrayList;
import objetos.ItemTipo;
import objetos.RobotExcavador;
import objetos.NaveExploradora;

public class CrearRobotReceta implements Receta {
    @Override
    public String getNombre() {
        return "Crear robot";
    }

    @Override
    public boolean puedeCrear(Jugador jugador) {

        if(jugador.getRobot() == null) {
            int contador = 0;
            for(Item item : jugador.getNave().getBodega()) {
                if ((item.getTipo().name().equals("COBRE") && item.getCantidad() >= 15) || (item.getTipo().name().equals("MAGNETITA") && item.getCantidad() >= 10) || (item.getTipo().name().equals("DIAMANTE") && item.getCantidad() >= 5) || (item.getTipo().name().equals("ACERO") && item.getCantidad() >= 20)) {
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
                if (item.getTipo().name().equals("COBRE")) {
                    item.addCantidad(-15);
                } else if (item.getTipo().name().equals("MAGNETITA")) {
                    item.addCantidad(-10);
                } else if (item.getTipo().name().equals("DIAMANTE")) {
                    item.addCantidad(-5);
                } else if (item.getTipo().name().equals("ACERO")) {
                    item.addCantidad(-20);
                }
            }
            
            RobotExcavador robot = new RobotExcavador();
            ItemTipo robotInventario = ItemTipo.ROBOT_EXCAVADOR;
            jugador.addInventario(robotInventario, 1);
            jugador.setRobot(robot);
            System.out.println("¡Robot excavador creado!");
        }
    }
}