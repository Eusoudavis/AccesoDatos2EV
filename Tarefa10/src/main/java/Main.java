import Entities.Manual;
import Entities.Revista;
import Loxica.LoxicaManual;
import Loxica.LoxicaRevista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {

    static LoxicaManual loxicaManual = new LoxicaManual();
    static LoxicaRevista loxicaRevista = new LoxicaRevista();

    public static void main(String[] args) {

        int opcion = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("1.- Crear revista");
                System.out.println("2.- Buscar todas as revistas .");
                System.out.println("3.- Buscar revista.");
                System.out.println("4.- Borrar revista.");
                System.out.println("5.- Crear Manual.");
                System.out.println("6.- Buscar manual.");
                System.out.println("7.- Buscar todas os manuais .");
                System.out.println("8.- Borrar manual.");
                System.out.println("Salir.");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        setRevista();
                        break;
                    case 2:
                        oDeLer();
                        break;
                    case 3:
                        readById();
                        break;
                    case 4:
                        readToDelete();
                        break;
                    case 5:
                        setManual();
                        break;
                    case 6:
                        readByIdManual();
                        break;
                    case 7:
                        oDeLerManual();
                        break;
                    case 8:
                        readToOutroDelete();
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción erronea");
                }
            } catch (Exception e) {
                System.out.println("La opción tiene que ser un número");
            }
        } while (opcion != 10);    }

    public static String leerDatos(final String s) throws IOException {
        System.out.println(s);
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    public static void setManual(){
        Manual manual = new Manual();
        try {
            manual.setIsbn(Long.valueOf(leerDatos("ISBN: ")));
            manual.setTitle(leerDatos("Titulo: "));
            manual.setPrice(Integer.parseInt(leerDatos("Prezo: ")));
            loxicaManual.validarCreate(manual);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setRevista(){
        Revista revista = new Revista();
        try {
            revista.setIsbn(Long.valueOf(leerDatos("ISBN: ")));
            revista.setTitle(leerDatos("Titulo: "));
            revista.setPrice(Integer.parseInt(leerDatos("Prezo: ")));
            revista.setPages(Integer.parseInt(leerDatos("Paxinas: ")));
            revista.setDate(Integer.parseInt(leerDatos("Mes: ")));
            loxicaRevista.validarCreate(revista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readToDelete() {
        try {
            Revista revista = new Revista();
            revista.setIsbn(Long.valueOf(leerDatos("ISBN: ")));
            loxicaRevista.validarDelete(revista);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readToOutroDelete() {
        try {
            Manual manual = new Manual();
            manual.setIsbn(Long.valueOf(leerDatos("ISBN: ")));
            loxicaManual.validarDelete(manual);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readById(){
        try {
            Revista revista = loxicaRevista.validateFindById(Long.valueOf(leerDatos("ISBN ")));
            System.out.println(revista.getTitle());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readByIdManual(){
        try {
            Manual manual = loxicaManual.validateFindById(Long.valueOf(leerDatos("ISBN ")));
            System.out.println(manual.getTitle());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void oDeLer(){
        List<Revista> revistas = loxicaRevista.validarRead();
        for (Revista revista: revistas) {
            System.out.println(revista.toString());
        }
    }

    public static void oDeLerManual(){
        List<Manual> manuais = loxicaManual.validarRead();
        for (Manual manual: manuais) {
            System.out.println(manual.toString());
        }
    }

}
