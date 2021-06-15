package Ejerc_Propuestos;

import java.util.List;
import java.util.Scanner;


public class Menu {

    public static void main(String[] args) {
        List<Empleado> listaEmpleados = Controlador.cargarEmpleados();
        System.out.println(listaEmpleados);
        while(true){
            Scanner entrada = new Scanner(System.in);
            System.out.println("* * * * * M E N U * * * * *");
            System.out.println("Ingrese una opción: ");
            System.out.println("1 - Buscar por inicial del apellido");
            System.out.println("2 - Lista de empleados en orden alfabético");
            System.out.println("3 - Empleado con menor y mayor de edad");
            System.out.println("4 - Empleado con menor y mayor salario");
            System.out.println("0 - Salir");
            String ingreso = entrada.nextLine();

            if(ingreso.equals("1")){
                System.out.println("-------------------------------------------------");
                System.out.println("Ingrese una letra inicial del apellido: ");
                String letra = entrada.next();
           
                List<Empleado> empleadosFiltrados = Controlador.listaEmpleadosPorInicial(listaEmpleados, letra);
                if (empleadosFiltrados.isEmpty()){
                    System.out.println("--------- No se encontraron apellidos con esa inicial ----------\n");
                }
                
                else {
                    for (Empleado e : empleadosFiltrados) {
                        System.out.println(e + "\n");
                    }
                }

            }

            else if (ingreso.equals("2")){
                List<Empleado> empleadosOrdenados = Controlador.ordenAlfabetico(listaEmpleados);
                for (Empleado e : empleadosOrdenados){
                    String nombre = String.format(
                            "Nombre: %s %s - Edad: %s", e.getNombre(), e.getApellido(), e.getEdad());
                    System.out.println(nombre + "\n");
                }
            }
            else if (ingreso.equals("3")){
                List<Empleado> empleadosXEdad = Controlador.empleadosEdad(listaEmpleados);
                System.out.println("------ Empleados ------");
                for (Empleado e : empleadosXEdad){
                    String nombre = String.format(
                            "Nombre: %s %s - Edad: %s", e.getNombre(), e.getApellido(), e.getEdad());
                    System.out.println(nombre + "\n");

                }

            }
            else if (ingreso.equals("4")){
                List<Empleado> empleadosXSalario = Controlador.empleadosSegunSalario(listaEmpleados);

                System.out.println("------ Empleados ------");
                for (Empleado e : empleadosXSalario){
                    String nombre = String.format(
                            "Nombre: %s %s - Salario: %s", e.getNombre(), e.getApellido(), e.getSalario());
                    System.out.println(nombre + "\n");

                }

            }
            else if (ingreso.equals("0")){
                System.out.println("* * * Muchas Gracias * * *");
                break;
            }
            else {
                System.out.println("Opción inválida\n");
            }
        }
    }
}