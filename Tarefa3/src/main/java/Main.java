import Loxica.Loxica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import Entity.Empregado;

public class Main {
    static Loxica loxica = new Loxica();

    public static void main(String[] args) {

        int opcion = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("1.- Buscar empregado");
                System.out.println("2.- Crear empregado.");
                System.out.println("3.- Borrar empregado.");
                System.out.println("4.- Actualizar empregado.");
                System.out.println("5.- Todos os empregados.");
                System.out.println("6.- Numero os empregados.");
                System.out.println("7.- Buscar por oficina.");
                System.out.println("8.- Buscar medias de salario por oficina.");
                System.out.println("9.- Actualizar comercial");
                System.out.println("10.- Borrar empregado con salario negativo");
                System.out.println("11.- Borrar empregado por oficina");


                System.out.println("Salir.");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        getCommandLineBook();
                        break;
                    case 2:
                        crearEmpregado();
                        break;
                    case 3:
                        readToDelete();
                        break;
                    case 4:
                        updateEmpregado();
                        break;
                    case 5:
                        oDeLer();
                        break;
                    case 6:
                        System.out.println(loxica.validarRead().size() + " empregados");
                        break;
                    case 7:
                        oDeLerByOffice();
                        break;
                    case 8:
                        oDeLerByOfficeSalaryStatsByOffice();
                        break;
                    case 9:
                        loxica.validarUpdateComercial();
                        break;
                    case 10:
                        loxica.validarDeleteNegativeSalary();
                        break;
                    case 11:
                        buscarEmpregadoPorOficina();
                        break;
                    case 12:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción erronea");
                }
            } catch (Exception e) {
                System.out.println("La opción tiene que ser un número");
            }
        } while (opcion != 13);
    }

    public static String leerDatos(final String s) throws IOException {
        System.out.println(s);
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    private static void readToDelete() {
        try {
            Empregado empregado = new Empregado();
            empregado.setDni(leerDatos("DNI"));
            loxica.validateDelete(empregado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getCommandLineBook() {
        try {
            Empregado empregado;
            empregado = loxica.validateFindById(leerDatos("DNI: "));
            System.out.println(empregado.getNombre());
            System.out.println(empregado.getOficina());
            System.out.println(empregado.getPuesto());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void oDeLer(){
        List<Empregado> empregados = loxica.validarRead();
        for (Empregado lib: empregados) {
            System.out.println(lib.toString());
        }
    }

    public static void oDeLerByOffice(){
        List<Empregado> empregados = loxica.validateFindByOficce();
        for (Empregado lib: empregados) {
            System.out.println(lib.toString());
        }
    }

    public static void oDeLerByOfficeSalaryStatsByOffice(){
        List<Object[]> empregados = loxica.validatesalaryStatsByOffice();
        for (Object[] emp: empregados) {
            System.out.println("Soldo max " + emp[0] + " Soldo minimo " + emp[1] + " soldo medio " + emp[2] + " para a oficina " + emp[3]);
        }
    }

    private static void crearEmpregado() {
        Empregado empregado = new Empregado();
        try {
            empregado.setDni(leerDatos("DNI: "));
            empregado.setNombre(leerDatos("Nome: "));
            empregado.setSueldo(Double.valueOf(leerDatos("Soldo: ")));
            empregado.setOficina(Integer.parseInt(leerDatos("Oficina: ")));
            empregado.setPuesto(leerDatos("Posto: "));
            loxica.validateCreate(empregado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateEmpregado() {
        Empregado empregado = new Empregado();
        try {
            empregado.setDni(leerDatos("DNI: "));
            empregado.setNombre(leerDatos("Nome: "));
            empregado.setSueldo(Double.valueOf(leerDatos("Soldo: ")));
            empregado.setOficina(Integer.parseInt(leerDatos("Oficina: ")));
            empregado.setPuesto(leerDatos("Posto: "));
            loxica.validarUpdate(empregado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buscarEmpregadoPorOficina(){
        try {
            List<Integer> oficinas = loxica.validarReadAllOffice();
            for (Integer ofi: oficinas
            ) {
                System.out.println("Oficina " + ofi);
            }
            List<Empregado> empregados = loxica.validarFindEmployeeByOffice(Integer.parseInt(leerDatos("Introduce num de oficina")));
            for (Empregado emp: empregados
                 ) {
                System.out.println(emp.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

