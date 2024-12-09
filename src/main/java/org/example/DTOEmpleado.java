package org.example;

public class DTOEmpleado {
    private int id;
    private String nombre;
    private int edad;
    private int idDpto;

    public DTOEmpleado(Integer id, String nombre, int edad, int idDpto) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.idDpto = idDpto;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getIdDpto() {
        return idDpto;
    }
    public void setIdDpto(int idDpto) {
        this.idDpto = idDpto;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
