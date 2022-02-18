import DAO.ArtigoDAO;
import DAO.XornalistaDAO;
import Entity.Artigos;
import Entity.Xornalista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static XornalistaDAO xornalistaDAO = new XornalistaDAO();
    static ArtigoDAO artigoDAO = new ArtigoDAO();
    public static void main(String[] args) throws IOException {

        int opcion = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("1.- Alta xornalista");
                System.out.println("2.- Baixa xornalista.");
                System.out.println("3.- Novo artigo.");
                System.out.println("4.- Amosar artigos dun xornalista.");
                System.out.println("5.- Amosar artigos dun ano.");
                System.out.println("Salir.");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        setXornalista();
                        break;
                    case 2:
                        readToDelete();
                        break;
                    case 3:
                        setArtigo();
                        break;
                    case 4:
                      //  updateEmpregado();
                        break;
                    case 5:
                       // oDeLer();
                        break;
                    case 13:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción erronea");
                }
            } catch (Exception e) {
                System.out.println("La opción tiene que ser un número");
            }
        } while (opcion != 6);
    }


    public static void setXornalista() throws IOException {
        Xornalista xornalista = new Xornalista();
        xornalista.setDni(leerDatos("DNI "));
        xornalista.setName(leerDatos("Nome "));
        xornalista.setTelf(Integer.parseInt(leerDatos("Telf ")));
        xornalistaDAO.create(xornalista);
    }

    public static void setArtigo(){
        try {
            //Buscar xornalista:
            Xornalista xornalista = readByDni();
            System.out.println(xornalista.toString());
            System.out.println("Desexa engadir un artigo para este xornalista?");
            Scanner scanner = new Scanner(System.in);
            String opcion = scanner.next().toUpperCase(Locale.ROOT);
            while (opcion.equals("SI")){
            Artigos artigos = new Artigos();
                artigos.setIsbn(Long.valueOf(leerDatos("ISBN ")));
                artigos.setTitle(leerDatos("Titalo: "));
                artigos.setYear(Integer.parseInt(leerDatos("Ano: ")));
                artigos.setWord(Integer.parseInt(leerDatos("Numero de palabras: ")));
                xornalista.setDni(leerDatos("DNI "));
                artigos.setXornalista(xornalista);
                xornalista.getArtigos().add(new Artigos());
                artigoDAO.create(artigos);}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readToDelete(){
        try {
            Xornalista xornalista = new Xornalista();
            xornalista.setDni(leerDatos("DNI XORNALISTA "));
            xornalistaDAO.delete(xornalista);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Xornalista readByDni() throws IOException {
      //  Xornalista xornalista;
        return xornalistaDAO.findById(leerDatos("DNI do xornalista"));

    }

    public static String leerDatos(final String s) throws IOException {
        System.out.println(s);
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }
}
