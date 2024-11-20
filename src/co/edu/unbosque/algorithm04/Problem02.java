package co.edu.unbosque.algorithm04;

import java.util.ArrayList;
import java.util.List;

public class Problem02 {
    public static void main(String[] args) {
        Mochila mochila = new Mochila(7);
        mochila.getItems().forEach(System.out::println);
        System.out.println(mochila.getCapacidad());
        System.out.println(mochila.getValorMax());
        mochila.getItemsSeleccionados().forEach(System.out::println);

    }
}

class Mochila{

    private List<Item> items;
    private int capacidad;
    private List<Item> itemsSeleccionados;
    private int valorMax;

    public Mochila(int capacidad){
        this.capacidad = capacidad;
        this.items = new ArrayList<>();
        this.itemsSeleccionados = new ArrayList<>();
        cargarItems();
        this.valorMax = resolverProblema();
    }

    public int resolverProblema(){

        int n = items.size();
        int[][] dp = new int[n + 1][capacidad + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= capacidad; j++){
                if(items.get(i - 1).getPeso() <= j){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items.get(i - 1).getPeso() ] + items.get(i - 1).getValor()  );
                } else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacidad];
    }

    public void cargarItems(){
        items.add(new Item("A",1,1));
        items.add(new Item("B",3,4));
        items.add(new Item("C",4,5));
        items.add(new Item("D",5,7));
    }

    public int getValorMax() {
        return valorMax;
    }

    public void setValorMax(int valorMax) {
        this.valorMax = valorMax;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Item> getItemsSeleccionados() {
        return itemsSeleccionados;
    }

    public void setItemsSeleccionados(List<Item> itemsSeleccionados) {
        this.itemsSeleccionados = itemsSeleccionados;
    }
}

class Item{

    private String nombre;
    private int peso;
    private int valor;

    public Item(String nombre, int peso, int valor) {
        this.nombre = nombre;
        this.peso = peso;
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", valor=" + valor +
                '}';
    }
}
