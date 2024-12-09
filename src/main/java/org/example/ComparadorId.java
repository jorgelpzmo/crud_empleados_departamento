package org.example;

import java.util.Comparator;

public class ComparadorId implements Comparator<DTOEmpleado> {
    public int compare(DTOEmpleado o1, DTOEmpleado o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
