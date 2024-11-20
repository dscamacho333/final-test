package co.edu.unbosque.example;

import java.util.*;

public class VorazPlatos {
    public static void main(String[] args) {
        List<Plato> platos = crearPlatos();
        int objetivo = 750;

        List<Plato> resultado = obtenerMenuVoraz(platos, objetivo);
        System.out.println("Platos seleccionados (Voraz): " + resultado);
    }

    public static List<Plato> obtenerMenuVoraz(List<Plato> platos, int objetivo) {
        Collections.sort(platos); // Ordena por calorías en orden descendente
        List<Plato> seleccionados = new ArrayList<>();
        int suma = 0;

        for (Plato plato : platos) {
            if (suma + plato.getCalorias() <= objetivo) {
                suma += plato.getCalorias();
                seleccionados.add(plato);
            }
        }

        return seleccionados;
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

