package org.example;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class DTODepartamento {
    private int idDepartamento;
    private String nombre;
    private Set<DTOEmpleado> empleados;

    public DTODepartamento(int idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        empleados = new TreeSet<>(new ComparadorId());
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set<DTOEmpleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(Set<DTOEmpleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "DTODepartamento{" +
                "idDepartamento=" + idDepartamento +
                ", nombre='" + nombre + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}
