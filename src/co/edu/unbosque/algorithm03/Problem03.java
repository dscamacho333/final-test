package co.edu.unbosque.algorithm03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem03 {
    public static void main(String[] args) {
        Secretaria secretaria = new Secretaria();
        System.out.println("ACTIVIDADES");
        secretaria.getActividades().forEach(System.out::println);
        System.out.println("RESULTADO");
        secretaria.getActividadesSeleccionadas().forEach(System.out::println);
    }
}

class Secretaria{

    private List<Actividad> actividades;
    private List<Actividad> actividadesSeleccionadas;

    public Secretaria() {
        this.actividades = new ArrayList<>();
        this.actividadesSeleccionadas = new ArrayList<>();
        cargarActividades();
        ordenarActividades();
        seleccionarActividades();
    }

    public void seleccionarActividades(){

        actividadesSeleccionadas.add(actividades.get(0));
        int tiempoFinAnterior = actividades.get(0).getHoraFinal();

        for(int i = 1; i < actividades.size(); i++){
            if(actividades.get(i).getHoraInicio() >= tiempoFinAnterior){
                actividadesSeleccionadas.add(actividades.get(i));
                tiempoFinAnterior = actividades.get(i).getHoraFinal();
            }
        }

    }

    public void cargarActividades(){

        actividades.add(new Actividad("F", 5, 9));
        actividades.add(new Actividad("B", 3, 4));
        actividades.add(new Actividad("E", 8, 9));
        actividades.add(new Actividad("C", 0, 6));
        actividades.add(new Actividad("D", 5, 7));
        actividades.add(new Actividad("A", 1, 2));
    }

    public void ordenarActividades(){
        Collections.sort(actividades);
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public List<Actividad> getActividadesSeleccionadas() {
        return actividadesSeleccionadas;
    }

    public void setActividadesSeleccionadas(List<Actividad> actividadesSeleccionadas) {
        this.actividadesSeleccionadas = actividadesSeleccionadas;
    }
}


class Actividad implements Comparable<Actividad>{

    private String nombre;
    private int horaInicio;
    private int horaFinal;

    public Actividad(String nombre, int horaInicio, int horaFinal) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(int horaFinal) {
        this.horaFinal = horaFinal;
    }

    @Override
    public int compareTo(Actividad o) {
        return Integer.compare(this.horaFinal, o.horaFinal);
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "nombre='" + nombre + '\'' +
                ", horaInicio=" + horaInicio +
                ", horaFinal=" + horaFinal +
                '}';
    }
}
