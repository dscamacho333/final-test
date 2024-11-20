package co.edu.unbosque.algorithm03;

import java.util.*;

public class Problem01 {
    public static void main(String[] args) {

        Mochila mochila = new Mochila(10);
        System.out.println("-------Elementos-------");
        mochila.getItems().forEach(System.out::println);
        System.out.println("-------Capacidad maxima mochila-------");
        System.out.println(mochila.getCapacidad());
        System.out.println("-------Elementos que caben en la mochila-------");
        mochila.getItemsEnMochila().forEach(System.out::println);
        System.out.println("-------Valor maximo mochila-------");
        System.out.println(mochila.getValorMaximo());

    }


}

class Mochila{

    private List<Item> items;
    private int capacidad;
    private List<Item> itemsEnMochila;
    private int valorMaximo;

    public Mochila(int capacidad){
        this.items = new ArrayList<>();
        this.capacidad = capacidad;
        this.itemsEnMochila = new ArrayList<>();
        cargarItems();
        ordenarElementos();
        this.valorMaximo = llenarMochila();
    }

    public void cargarItems(){
        items.add(new Item("Agua", 10, 60));
        items.add(new Item("Zapatos", 20, 100));
        items.add(new Item("Comida", 30, 120));
        //items.add(new Item("Ropa", 4, 60));
        //items.add(new Item("Tienda", 6, 40));
    }

    public int llenarMochila(){
        int valorMaximo = 0;
        int pesoActual = 0;
        for(Item item: items){
            if(capacidad >= pesoActual + item.getPeso()){
                itemsEnMochila.add(item);
                pesoActual += item.getPeso();
                valorMaximo += item.getValor();
            }
        }
        return valorMaximo;
    }

    public void ordenarElementos(){
        Collections.sort(items);
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

    public List<Item> getItemsEnMochila() {
        return itemsEnMochila;
    }

    public void setItemsEnMochila(List<Item> itemsEnMochila) {
        this.itemsEnMochila = itemsEnMochila;
    }

    public int getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }
}

class Item implements Comparable<Item>{

    private String nombre;
    private int peso;
    private int valor;
    private double beneficio;

    public Item(String nombre, int peso, int valor) {
        this.nombre = nombre;
        this.peso = peso;
        this.valor = valor;
        this.beneficio = (double) valor/peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(this.beneficio, o.beneficio);
    }


    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", valor=" + valor +
                ", beneficio=" + beneficio +
                '}';
    }
}
