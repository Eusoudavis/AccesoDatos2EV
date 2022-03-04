import Entities.Journey;
import Entities.Taxi;
import Entities.TaxiDriver;
import Loxica.JourneyLoxica;
import Loxica.TaxiDriverLoxica;
import Loxica.TaxiLoxica;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;

@Log4j2
public class Main {
    static Faker faker = new Faker();
    static TaxiLoxica taxiLoxica = new TaxiLoxica();
    static TaxiDriverLoxica taxiDriverLoxica = new TaxiDriverLoxica();
    static JourneyLoxica journeyLoxica = new JourneyLoxica();

    public static void main(String[] args) {
        //conection();
        int opcion = 0;
        do {
            try {
                log.info("\n---------MENU-------------");
                log.info("1- Engadir Taxista");
                log.info("2- Engadir Taxi");
                log.info("3- Comezo xornada taxista");
                log.info("4- Fin xornada taxista");
                log.info("5- Información dun taxista e do seu taxi");
                log.info("6- Amosar taxista traballando");
                log.info("7- Amosar taxista fora de servixo");
                log.info("8- Sair");
                switch (opcion = Integer.parseInt(leerDatos("OPCIÓN A ELIXIR"))) {
                    case 1 -> setTaxiDriver();
                    case 2 -> setTaxi();
                    case 3 -> initJourney();
                    case 4 -> endJourney();
                    case 5 -> lerParaCrer();
                    case 6 -> lerTaxistasTraballando();
                    case 7 -> lerTaxistasNonTraballando();
                    case 8 -> setTaxi();
                    default -> log.info("OPCIÓN ERRÓNEA");
                }
            } catch (IOException e) {
                log.error("LA OPCIÓN TIENE QUE SER UN NÚMERO");
            }
        } while (opcion != 9);
    }

    public static String leerDatos(final String s) throws IOException {
        System.out.println(s);
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    public static void setTaxi() {
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

    public static void setTaxiDriver() {
        TaxiDriver taxiDriver = new TaxiDriver();
        taxiDriver.setDni(faker.idNumber().valid());
        taxiDriver.setBirthdate(faker.date().birthday().toString());
        taxiDriver.setName(faker.funnyName().name());
        taxiDriver.setActive(false);

        taxiDriverLoxica.validateCreateTaxiDriver(taxiDriver);
        log.info("CREADO CORRECTAMENTE O TAXISTA " + taxiDriver.toString());
    }

    public static void initJourney() {
        try {
            lerTaxistasNonTraballando();
            TaxiDriver taxiDriver = taxiDriverLoxica.validateFindByDNI(leerDatos("DNI "));
            if (!taxiDriver.getDni().equals(null)) {
                taxiDriverLoxica.validateUpdateTaxiDriverActive(taxiDriver.getDni());
            } else {
                log.info("DNI NON ATOPADO");
            }
            Boolean available = true;
            taxiLoxica.validateTaxiAvailable(available).forEach((Taxi taxi)->log.info(taxi.toString()));
            Taxi taxi = taxiLoxica.validateFindByCarNumber(leerDatos("Matricula "));
            if (!taxi.getCarRegistrationNumber().equals(null)) {
                taxiLoxica.validateUpdate(taxi.getCarRegistrationNumber());
            } else {
                log.info("MATRÍCULA NON ATOPADA");
            }
            Journey journey = new Journey();
            journey.setTaxiDriver(taxiDriver);
            journey.setTaxi(taxi);
            journey.setDate(LocalDate.now().toString());
            journey.setInitHour(LocalTime.now().toString());
            journeyLoxica.validateCreate(journey);
            log.info("-----------INICIADA A XORNADA PARA O TAXISTA "+ journey.getTaxiDriver().getName()+", BOA SORTE!------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void endJourney() {
        try {
            journeyLoxica.validateReadCurrentJourney().forEach((Journey journey)->log.info(journey.toString()));
            Journey journey = journeyLoxica.validateFindById(Long.valueOf(leerDatos("ID XORNADA ")));
            journey.setEndHour(LocalTime.now().toString());
            journeyLoxica.validateUpdateJourney(journey);

            TaxiDriver taxiDriver = taxiDriverLoxica.validateFindByDNI(journey.getTaxiDriver().getDni());
            if (!taxiDriver.getDni().equals(null)) {
                taxiDriverLoxica.validateUpdateTaxiDriverNotActive(taxiDriver.getDni());
            } else {
                log.info("DNI NON ATOPADO");
            }
            Taxi taxi = taxiLoxica.validateFindByCarNumber(journey.getTaxi().getCarRegistrationNumber());
            if (!taxi.getCarRegistrationNumber().equals(null)) {
                taxiLoxica.validateUpdateTaxiEnable(taxi.getCarRegistrationNumber());
            } else {
                log.info("MATRÍCULA NON ATOPADA");
            }

            log.info("------XORNADA REMATADA PARA O TAXISTA "+journey.getTaxiDriver().getName() +"-------");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerParaCrer() {
        try {
            journeyLoxica.validateRead().forEach((Journey journey)->log.info(journey.toStringTaxiAndTaxiDriver()));
            log.info(journeyLoxica.validateFindById(Long.valueOf(leerDatos("ID XORNADA "))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerTaxistasTraballando() {
        Boolean active = true;
        log.info("----------------------------TRABALLANDO---------------------------------");
        taxiDriverLoxica.validateRead(active).forEach((TaxiDriver taxiDriver) -> log.info(taxiDriver.toString()));
    }

    public static void lerTaxistasNonTraballando() {
        Boolean active = false;
        log.info("----------------------------FORA DE SERVIZO---------------------------------");
        taxiDriverLoxica.validateRead(active).forEach((TaxiDriver taxiDriver)-> log.info(taxiDriver.toString()));
    }
}
