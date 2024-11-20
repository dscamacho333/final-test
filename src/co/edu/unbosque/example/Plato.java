package co.edu.unbosque.example;

public class Plato implements Comparable<Plato> {

    private String nombre;
    private int calorias;

    public Plato(String nombre, int calorias) {
        this.nombre = nombre;
        this.calorias = calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    @Override
    public int compareTo(Plato otro) {
        return Integer.compare(otro.calorias, this.calorias); // Orden descendente por calorías
    }

    @Override
    public String toString() {
        return nombre + " (" + calorias + " cal)";
    }
}
