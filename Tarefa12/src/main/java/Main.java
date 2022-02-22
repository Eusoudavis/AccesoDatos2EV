import DAO.EnchidoDAO;
import DAO.FacturaDAO;
import DAO.RepostaxeDAO;
import Entity.*;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Log4j2
public class Main {
    private static final Faker faker = new Faker();
    static RepostaxeDAO repostaxeDAO = new RepostaxeDAO();
    static EnchidoDAO enchidoDAO = new EnchidoDAO();
    static FacturaDAO facturaDAO = new FacturaDAO();
    static String opcion = null;

    public static void main(String[] args) {
        // Connection.conection();
        int opcion = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("1.- Repostaxe normal");
                System.out.println("2.- Ver todos os repostaxes.");
                System.out.println("3.- Total vendas.");
                System.out.println("4.- Enchido depósito.");
                System.out.println("5.- Borrar último enchido.");
                System.out.println("6.- Total enchidos.");
                System.out.println("7,- Salir.");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        setRepostaxe();
                        break;
                    case 2:
                        lerRepostaxes();
                        break;
                    case 3:
                        totalVendas();
                        break;
                    case 4:
                        setEnchido();
                        break;
                    case 5:

                        break;
                    case 6:
                        lerEnchidos();
                        break;
                    case 7:
                        System.exit(0);
                        break;
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

    public static void setRepostaxe() {
        try {
            Repostaxe repostaxe = new Repostaxe();
            repostaxe.setData(LocalDateTime.now().toString());
            repostaxe.setImporte(faker.number().randomDouble(3, 10, 300));
            log.info(repostaxe.toString());
            log.info("Desexa Factura? [SI/NON]");
            opcion = leerDatos("").toUpperCase(Locale.ROOT);
            if (opcion.equals("SI")) {
                Factura factura = new Factura();
                factura.setId(repostaxe.getId());
                factura.setData(repostaxe.getData());
                factura.setImporte(repostaxe.getImporte());
                Persoa persoa = new Persoa();
                persoa.setDni(leerDatos("DNI "));
                factura.setPersoa(persoa);
                facturaDAO.create(factura);
            } else {
                repostaxeDAO.create(repostaxe);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void setEnchido() {
        try {
            Enchido enchido = new Enchido();
            TipoCombustible tipoCombustible = new TipoCombustible();
            enchido.setImporteTotal(faker.number().randomDouble(3, 5000, 10000));
            enchido.setLitros(faker.number().numberBetween(5000, 1000));
            tipoCombustible.setIdCombustible(Long.valueOf(leerDatos("Id ")));
            enchido.setTipoCombustible(tipoCombustible);
            enchidoDAO.create(enchido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerEnchidos() {
        List<Enchido> enchidos = enchidoDAO.read();
        System.out.println("----------------------------------------------------");
        for (Enchido enchido : enchidos
        ) {
            System.out.println(enchido.toString());
        }
    }

    public static void lerRepostaxes() {
        List<Repostaxe> repostaxes = repostaxeDAO.read();
        System.out.println("----------------------------------------------------");
        for (Repostaxe repostaxe : repostaxes
        ) {
            System.out.println(repostaxe.toString());
        }
    }

    public static void totalVendas(){
        log.info("---------------------------------------------------");
        double vendaUd = 0;
        List<Repostaxe> repostaxes = repostaxeDAO.read();
        for (Repostaxe repostaxe : repostaxes
        ) {
           vendaUd = vendaUd + repostaxe.getImporte();
        }
        log.info("TOTAL VENDAS " + vendaUd + " € ");

    }

    public static void readToDelete() {
        try {
            Enchido enchido = new Enchido();
            enchido.setId(Long.valueOf(leerDatos("ID  ")));
            enchidoDAO.delete(enchido);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
