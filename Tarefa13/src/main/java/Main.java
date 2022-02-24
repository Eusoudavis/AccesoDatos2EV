import Connection.Connection;
import Entities.Taxi;
import Loxica.TaxiLoxica;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Log4j2
public class Main {
    static Faker faker = new Faker();
    static TaxiLoxica taxiLoxica = new TaxiLoxica();
    public static void main(String[] args) {
       // Connection.conection();
        int opcion = 0;
        do {
            try{
                log.info("---------MENU-------------");
                log.info("1- Engadir Taxi");
                log.info("2- Engadir Taxi");
                log.info("3- Comezo xornada taxista");
                log.info("4- Fin xornada taxista");
                log.info("5- Información dun taxista e do seu taxi");
                log.info("6- Amosar taxista traballando");
                log.info("7- Amosar taxista fora de servixo");
                log.info("8- Sair");
                switch (opcion = Integer.parseInt(leerDatos("OPCIÓN A ELIXIR"))) {
                    case 1 -> setTaxi();
                    case 2 -> setTaxi();
                    case 3 -> setTaxi();
                    case 4 -> setTaxi();
                    case 5 -> setTaxi();
                    case 6 -> setTaxi();
                    case 7 -> setTaxi();
                    case 8 -> setTaxi();
                    default -> log.info("OPCIÓN ERRÓNEA");
                }
            } catch (IOException e) {
                log.error("LA OPCIÓN TIENE QUE SER UN NÚMERO");
            }
        }while (opcion!=9);
    }
    public static String leerDatos(final String s) throws IOException {
        System.out.println(s);
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }
    public static void setTaxi(){
        try {
            Taxi taxi = new Taxi();
            taxi.setCarRegistrationNumber(leerDatos("Matricula "));
            taxi.setAvailable(true);
            taxi.setValue(faker.number().numberBetween(10000, 100000));
            taxi.setNSeats(faker.number().numberBetween(4, 9));
            taxiLoxica.validateCreate(taxi);
            log.info("CREADO CORRECTAMENTE O TAXI CON MATRICULA " + taxi.getCarRegistrationNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
