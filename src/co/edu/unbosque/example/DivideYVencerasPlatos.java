package co.edu.unbosque.example;

import java.util.*;

public class DivideYVencerasPlatos {
    public static void main(String[] args) {
        List<Plato> platos = crearPlatos();
        int objetivo = 750;

        List<Plato> resultado = obtenerMenuDivideYVenceras(platos, objetivo);
        System.out.println("Platos seleccionados (Divide y Vencerás): " + resultado);
    }

    public static List<Plato> obtenerMenuDivideYVenceras(List<Plato> platos, int objetivo) {
        int mitad = platos.size() / 2;

        Map<Integer, List<Plato>> izquierda = generarCombinaciones(platos.subList(0, mitad));
        Map<Integer, List<Plato>> derecha = generarCombinaciones(platos.subList(mitad, platos.size()));

        int mejorSuma = 0;
        List<Plato> mejorMenu = new ArrayList<>();

        for (int sumaIzq : izquierda.keySet()) {
            for (int sumaDer : derecha.keySet()) {
                int total = sumaIzq + sumaDer;
                if (total <= objetivo && total > mejorSuma) {
                    mejorSuma = total;
                    mejorMenu = new ArrayList<>(izquierda.get(sumaIzq));
                    mejorMenu.addAll(derecha.get(sumaDer));
                }
            }
        }

        return mejorMenu;
    }

    private static Map<Integer, List<Plato>> generarCombinaciones(List<Plato> platos) {
        Map<Integer, List<Plato>> combinaciones = new HashMap<>();
        int n = platos.size();

        for (int i = 0; i < (1 << n); i++) {
            List<Plato> menu = new ArrayList<>();
            int suma = 0;

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    suma += platos.get(j).getCalorias();
                    menu.add(platos.get(j));
                }
            }

            combinaciones.put(suma, menu);
        }

        return combinaciones;
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

