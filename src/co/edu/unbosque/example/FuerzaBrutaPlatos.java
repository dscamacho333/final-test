package co.edu.unbosque.example;

import java.util.ArrayList;
import java.util.List;

public class FuerzaBrutaPlatos {
    public static void main(String[] args) {
        List<Plato> platos = crearPlatos();
        int objetivo = 750;

        List<Plato> resultado = obtenerMenuFuerzaBruta(platos, objetivo);
        System.out.println("Platos seleccionados (Fuerza Bruta): " + resultado);
    }

    public static List<Plato> obtenerMenuFuerzaBruta(List<Plato> platos, int objetivo) {
        List<Plato> mejorMenu = new ArrayList<>();
        int mejorSuma = 0;

        int n = platos.size();
        for (int i = 0; i < (1 << n); i++) { // Todas las combinaciones
            List<Plato> menuActual = new ArrayList<>();
            int sumaActual = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // Incluye el plato en la combinación
                    sumaActual += platos.get(j).getCalorias();
                    menuActual.add(platos.get(j));
                }
            }

            if (sumaActual <= objetivo && sumaActual > mejorSuma) {
                mejorSuma = sumaActual;
                mejorMenu = new ArrayList<>(menuActual);
            }
        }

        return mejorMenu;
    }

    private static List<Plato> crearPlatos() {
        List<Plato> platos = new ArrayList<>();
        platos.add(new Plato("Empanada", 180));
        platos.add(new Plato("Arepa", 120));
        platos.add(new Plato("Ajiaco", 500));
        platos.add(new Plato("Lechona", 800));
        platos.add(new Plato("Pastel de Pollo", 150));
        platos.add(new Plato("Arroz con Pollo", 320));
        return platos;
    }
}

