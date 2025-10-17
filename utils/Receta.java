package utils;

import player.Jugador;
import objetos.Item;
import java.util.List;
import java.util.ArrayList;

public interface Receta {

    String getNombre();

    boolean puedeCrear(Jugador jugador);

    void crear(Jugador jugador);
}