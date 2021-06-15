package Ejerc_Propuestos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Empleado {
    private String nombre;
    private String apellido;
    private LocalDate nacimiento;
    private Double salario;

    public Empleado(String nombre, String apellido, String nacimiento, String salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = LocalDate.parse(nacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.salario = Double.parseDouble(salario);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = LocalDate.parse(nacimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getSalario() {
        return salario;
    }

    public int getEdad() {
        Period diferencia = Period.between(this.nacimiento, LocalDate.now());
        return diferencia.getYears();
    }

    @Override
    public String toString() {
        return "Empelado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", Nacimiento=" + nacimiento.toString() +
                ", salario=" + salario +
                '}';
    }
}