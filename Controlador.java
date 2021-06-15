package Ejerc_Propuestos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Controlador {

    public static List<Empleado> empleadosEdad(List<Empleado> empleados) {
        List<Empleado> empleadosEdadMap = new ArrayList<>();
        empleados.sort(Comparator.comparing(Empleado::getEdad));

        empleadosEdadMap.add(empleados.get(0));
        empleadosEdadMap.add(empleados.get(empleados.size() - 1));

        return empleadosEdadMap;
    }

        public static List<Empleado> empleadosSegunSalario(List<Empleado> empleados) {
            List<Empleado> listaEmpleados = new ArrayList<>();
            empleados.sort(Comparator.comparing(Empleado::getSalario));

            listaEmpleados.add(empleados.get(0));
            listaEmpleados.add(empleados.get(empleados.size() - 1));
            return listaEmpleados;
        }

    public static List<Empleado> listaEmpleadosPorInicial(List<Empleado> empleados, String letra) {
        List<Empleado> listaFiltrada = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (letra.equalsIgnoreCase(String.valueOf(empleado.getApellido().charAt(0))))
                listaFiltrada.add(empleado);
        }

        return listaFiltrada;
    }
    public static List<Empleado> cargarEmpleados() {
        File file = null;
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String[] empleado;
        List<Empleado> listaEmpleados = new ArrayList<>();

        Scanner entrada = new Scanner(System.in);
        String filePath = new File("Ejerc_Propuestos\\empleados.txt");
        file = new File(filePath);
        String path = file.getAbsolutePath();
        ArrayList<Empleado> empleados = LeerArchivoPorLineas(path);

        return listaEmpleados;
    }

    public static ArrayList<Empleado> LeerArchivoPorLineas(String filename) {
        String line = null;
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            FileReader r = new FileReader(filename);
            BufferedReader br = new BufferedReader(r);

            while ((line = br.readLine()) != null) {
                Empleado e = createEmpleadoFromString(line);
                empleados.add(e);
            }

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public static List<Empleado> ordenAlfabetico(List<Empleado> empleados) {
        empleados.sort(Comparator.comparing(Empleado::getNombre).thenComparing(Empleado::getApellido));
        return empleados;
    }

}