import Loxica.Loxica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import Entity.Empregado;

public class Main {
    static Loxica loxica = new Loxica();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
      //  Dao dao =new Dao();
        //dao.conection();
       // Persistence.generateSchema("empregado", null);

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
                        System.exit(0);
                    default:
                        System.out.println("Opción erronea");
                }
            } catch (Exception e) {
                System.out.println("La opción tiene que ser un número");
            }
        } while (opcion != 8);
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
            Empregado empregado = new Empregado();
            empregado = loxica.validateFindById(leerDatos("DNI: "));
            System.out.println(empregado.getNombre());
            System.out.println(empregado.getOficina());
            System.out.println(empregado.getPosto());
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

    private static void crearEmpregado() {
        Empregado empregado = new Empregado();
        try {
            empregado.setDni(leerDatos("DNI: "));
            empregado.setNombre(leerDatos("Nome: "));
            empregado.setSueldo(Double.valueOf(leerDatos("Soldo: ")));
            empregado.setOficina(Integer.parseInt(leerDatos("Oficina: ")));
            empregado.setPosto(leerDatos("Posto: "));
            //Loxica loxica = new Loxica();
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
            empregado.setPosto(leerDatos("Posto: "));
            //Loxica loxica = new Loxica();
            loxica.validarUpdate(empregado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static void updateLibro() {
//        Libro libro = new Libro();
//        try {
//            libro.setIsbn(leerDatos("ISBN: "));
//            libro.setTitulo(leerDatos("Titulo: "));
//            libro.setAutor(leerDatos("Autor: "));
//            libro.setPrecio(Integer.parseInt(leerDatos("Prezo: ")));
//            Loxica loxica = new Loxica();
//            loxica.validarUpdate(libro);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}

