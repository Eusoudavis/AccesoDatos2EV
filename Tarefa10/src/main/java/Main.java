import Entities.Manual;
import Entities.Revista;
import Loxica.LoxicaManual;
import Loxica.LoxicaRevista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    static LoxicaManual loxicaManual = new LoxicaManual();
    static LoxicaRevista loxicaRevista = new LoxicaRevista();

    public static void main(String[] args) {

        readToDelete();
    }

    public static String leerDatos(final String s) throws IOException {
        System.out.println(s);
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    public static void getManual(){
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

    public static void getRevista(){
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

    public static void oDeLer(){
        List<Revista> revistas = loxicaRevista.validarRead();
        for (Revista revista: revistas) {
            System.out.println(revista.toString());
        }
    }

}
