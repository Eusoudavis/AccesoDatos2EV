import DAO.*;
import Entity.*;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static Connection.Connection.conection;

@Log4j2
public class Main {
    private static final Faker faker = new Faker();
    static TipoCombustibleDAO tipoCombustibleDAO = new TipoCombustibleDAO();
    static RepostaxeDAO repostaxeDAO = new RepostaxeDAO();
    static EnchidoDAO enchidoDAO = new EnchidoDAO();
    static FacturaDAO facturaDAO = new FacturaDAO();
    static PersoaDAO persoaDAO = new PersoaDAO();
    static String opcion = null;
    static String dniPersoa[] = {"1234", "1221", "4321"};
    static String matricula[]= {"0000smg","2222dgc","0202mgm"};
    static Long idTipoCombustible[] = {Long.valueOf('1'), Long.valueOf('2'), Long.valueOf('3')};
    static String tipoCombustibleNome[] = {"Diesel", "Gasolina", "Diesel Agricola"};
    static Persoa persoa= new Persoa();
    static TipoCombustible tipoCombustible= new TipoCombustible();

    public static void main(String[] args) {
      // conection();
        createPersoas();
        createTipoCombustible();

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
                        delete();
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
            repostaxe.setImporte(faker.number().randomDouble(2, 10, 300));
            log.info(repostaxe.toString());
            log.info("Desexa Factura? [SI/NON]");
            opcion = leerDatos("").toUpperCase(Locale.ROOT);
            if (opcion.equals("SI")) {
                Factura factura = new Factura();
                factura.setId(repostaxe.getId());
                factura.setData(repostaxe.getData());
                factura.setImporte(repostaxe.getImporte());
                Persoa persoa = persoaDAO.findById(leerDatos("DNI "));
                factura.setPersoa(persoa);
                facturaDAO.create(factura);
                log.info(factura.toStringConPersoa());
            } else {
                repostaxeDAO.create(repostaxe);
                log.info(repostaxe.toString());
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
        System.out.println("------------------------ENCHIDOS----------------------------");
        for (Enchido enchido : enchidos
        ) {
            System.out.println(enchido.toString());
        }
    }

    public static void lerRepostaxes() {
        List<Repostaxe> repostaxes = repostaxeDAO.read();
        System.out.println("-----------------------REPOSTAXES-----------------------------");
        for (Repostaxe repostaxe : repostaxes
        ) {
            System.out.println(repostaxe.toString());
        }
    }

    public static void totalVendas(){
        log.info("-----------------------TOTAL VENDAS----------------------------");
        double vendaUd = 0;
        List<Repostaxe> repostaxes = repostaxeDAO.read();
        for (Repostaxe repostaxe : repostaxes
        ) {
           vendaUd = vendaUd + repostaxe.getImporte();
        }
        log.info("-------------------TOTAL VENDAS " + vendaUd + " €----------------------- ");
    }

    public static void delete() {
        try {
            enchidoDAO.delete();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createPersoas(){
        for (int i = 0; i < dniPersoa.length; i++){
            for (int j = 0; j < matricula.length; j++){
                if (i==j){
                    persoa.setDni(dniPersoa[i]);
                    persoa.setMatricula(matricula[j]);
                    persoaDAO.create(persoa);
                }
            }
        }
    }


    private static void createTipoCombustible() {
        for (int i = 0; i < idTipoCombustible.length; i++){
            for (int j = 0; j < tipoCombustibleNome.length; j++){
                if (i==j){
                    tipoCombustible.setIdCombustible(idTipoCombustible[i]);
                    tipoCombustible.setFuel(tipoCombustibleNome[j]);
                    tipoCombustibleDAO.create(tipoCombustible);

                }
            }
        }
    }


}
