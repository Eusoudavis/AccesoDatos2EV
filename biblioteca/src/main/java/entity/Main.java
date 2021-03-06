package entity;

import loxica.Loxica;
import loxica.LoxicaEmpregado;

import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Loxica loxica = new Loxica();
    static LoxicaEmpregado loxicaEmpregado = new LoxicaEmpregado();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        Persistence.generateSchema("empregado", null);
        int opcion = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("1.- Buscar un libro");
                System.out.println("2.- Crear libro.");
                System.out.println("3.- Borrar libro.");
                System.out.println("4.- Actualizar libro.");
                System.out.println("5.- Crear empregado.");
                System.out.println("6.- Numero os libros.");
                System.out.println("Salir.");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        getCommandLineBook();
                        break;
                    case 2:
                        crearLibro();
                        break;
                    case 3:
                        readToDelete();
                        break;
                    case 4:
                        updateLibro();
                        break;
                    case 5:
                        crearEmpregado();
                        break;
                    case 6:
                        System.out.println(loxica.validarRead().size() + " exemplares");
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
            Libro libro = new Libro();
            libro.setIsbn(leerDatos("ISBN"));
            loxica.validarDelete(libro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getCommandLineBook() {
        try {
            Libro libro = new Libro();
            libro = loxica.findByID(leerDatos("Isbn: "));
            System.out.println(libro.getIsbn());
            System.out.println(libro.getAutor());
            System.out.println(libro.getTitulo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void oDeLer(){
        List<Libro> libros = loxica.validarRead();
        for (Libro lib: libros) {
            System.out.println(lib.toString());
        }
    }

    private static void crearLibro() {
        Libro libro = new Libro();
        try {
            libro.setIsbn(leerDatos("ISBN: "));
            libro.setTitulo(leerDatos("Titulo: "));
            libro.setAutor(leerDatos("Autor: "));
            libro.setPrecio(Integer.parseInt(leerDatos("Prezo: ")));
            Loxica loxica = new Loxica();
            loxica.validarCreate(libro);
        } catch (IOException e) {
            e.printStackTrace();
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
            loxicaEmpregado.validateCreate(empregado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateLibro() {
        Libro libro = new Libro();
        try {
            libro.setIsbn(leerDatos("ISBN: "));
            libro.setTitulo(leerDatos("Titulo: "));
            libro.setAutor(leerDatos("Autor: "));
            libro.setPrecio(Integer.parseInt(leerDatos("Prezo: ")));
            Loxica loxica = new Loxica();
            loxica.validarUpdate(libro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
