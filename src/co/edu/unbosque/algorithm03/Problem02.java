package co.edu.unbosque.algorithm03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem02 {
    public static void main(String[] args) {
        MaquinaCambio maquina = new MaquinaCambio(63);
        maquina.getMonedas().forEach(System.out::println);
        System.out.println(maquina.getMontoObjetivo());
        maquina.getCambio().forEach(System.out::println);
        System.out.println(maquina.getCambioTotal());
    }
}

class MaquinaCambio{

    private List<Moneda> monedas;
    private List<Moneda> cambio;
    private int montoObjetivo;
    private int cambioTotal;

    public MaquinaCambio(int montoObjetivo) {
        this.monedas = new ArrayList<>();
        this.cambio = new ArrayList<>();
        this.montoObjetivo = montoObjetivo;
        cargarMonedas();
        ordenarMonedas();
        this.cambioTotal = darCambio();
    }

    public int darCambio(){
        int cambioActual = 0;
        for(Moneda moneda : monedas){
            while(montoObjetivo >= cambioActual + moneda.getDenominacion()){
                cambio.add(moneda);
                cambioActual += moneda.getDenominacion();
            }
        }
        return cambioActual;
    }

    public void cargarMonedas(){
        monedas.add(new Moneda(1));
        monedas.add(new Moneda(25));
        monedas.add(new Moneda(5));
        monedas.add(new Moneda(10));
    }

    public void ordenarMonedas(){
        Collections.sort(monedas);
    }

    public List<Moneda> getMonedas() {
        return monedas;
    }

    public void setMonedas(List<Moneda> monedas) {
        this.monedas = monedas;
    }

    public List<Moneda> getCambio() {
        return cambio;
    }

    public void setCambio(List<Moneda> cambio) {
        this.cambio = cambio;
    }

    public int getMontoObjetivo() {
        return montoObjetivo;
    }

    public void setMontoObjetivo(int montoObjetivo) {
        this.montoObjetivo = montoObjetivo;
    }

    public int getCambioTotal() {
        return cambioTotal;
    }

    public void setCambioTotal(int cambioTotal) {
        this.cambioTotal = cambioTotal;
    }
}

class Moneda implements Comparable<Moneda>{

    private int denominacion;

    public Moneda(int denominacion) {
        this.denominacion = denominacion;
    }

    public int getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(int denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public int compareTo(Moneda o) {
        return Integer.compare(o.denominacion, this.denominacion);
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "denominacion=" + denominacion +
                '}';
    }

}
