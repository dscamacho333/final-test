package co.edu.unbosque.example;

import java.util.*;

public class DinamicaPlatos {
    public static void main(String[] args) {
        List<Plato> platos = crearPlatos();
        int objetivo = 750;

        List<Plato> resultado = obtenerMenuDinamica(platos, objetivo);
        System.out.println("Platos seleccionados (Dinámica): " + resultado);
    }

    public static List<Plato> obtenerMenuDinamica(List<Plato> platos, int objetivo) {
        int n = platos.size();
        int[][] dp = new int[n + 1][objetivo + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= objetivo; j++) {
                if (platos.get(i - 1).getCalorias() <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - platos.get(i - 1).getCalorias()] + platos.get(i - 1).getCalorias());
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        List<Plato> seleccionados = new ArrayList<>();
        int j = objetivo;
        for (int i = n; i > 0 && j > 0; i--) {
            if (dp[i][j] != dp[i - 1][j]) {
                seleccionados.add(platos.get(i - 1));
                j -= platos.get(i - 1).getCalorias();
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

