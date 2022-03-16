import Dao.HouseDao;
import Dao.PlayerDao;
import Entities.House;
import Entities.Player;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

import static Connection.Connection.conection;

@Log4j2
public class Main {
    static PlayerDao playerDao = new PlayerDao();
    static HouseDao houseDao = new HouseDao();
    static Faker faker = new Faker(new Locale("pt"));
    static String[] initHouses = {"Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin"};

    public static void main(String[] args) {
        // conection();
        // createHouses();
        int opcion = 0;
        do {
            try {
                log.info("\n---------MENU-------------");
                log.info("1- Nova Casa");
                log.info("2- Baixa equipa");
                log.info("3- Alta xogador");
                log.info("4- Asignar xogador a unha equipa");
                log.info("5- Amosar equipa");
                log.info("6- Amosar todas as equipas");
                log.info("7- Amosar todos os xogadores");
                log.info("8- Sair");
                switch (opcion = Integer.parseInt(leerDatos("OPCIÓN A ELIXIR"))) {
                    case 1 -> setHouse();
                    case 2 -> deleteTeam();
                    case 3 -> setPlayer();
                    case 4 -> assignPlayer();
                    case 5 -> readHouse();
                    case 6 -> readAllTeams();
                    case 7 -> readAllPlayers();
                    case 8 -> System.exit(0);
                    default -> log.info("OPCIÓN ERRÓNEA");
                }
            } catch (IOException e) {
                log.error("LA OPCIÓN TIENE QUE SER UN NÚMERO");
            }
        } while (opcion != 8);
    }

    public static String leerDatos(final String s) throws IOException {
        System.out.println(s);
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    public static void setHouse() {
        House house = new House();
        house.setHouseName(faker.team().name());
        houseDao.create(house);
        log.info("CREADA A CASA " + house.getHouseName());
    }

    public static void setPlayer() {
        Player player = new Player();
        player.setDni(faker.idNumber().valid());
        player.setPlayerName(faker.name().fullName());
        playerDao.create(player);
        log.info("CREADO O XOGADOR " + player.getPlayerName());
    }

    public static void readHouse() {
        try {
            House team = houseDao.findById(Integer.parseInt(leerDatos("ID DA CASA ")));
            log.info(team.toString());
            List<Player> players = playerDao.readTeamPlayers(team);
            if (players.isEmpty()) {
                log.error("CASA SEN XOGAODRES");
            } else {
                players.forEach((Player player) -> log.info(player.toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAllTeams() {
        houseDao.read().forEach((House house) -> log.info(house.toString()));
    }

    public static void readAllPlayers() {
        playerDao.read().forEach((Player player) -> log.info(player.toString()));
    }

    public static void deleteTeam() {
        try {
            House house = houseDao.findById(Integer.parseInt(leerDatos("ID EQUIPA ")));
            List<Player> players = playerDao.readTeamPlayers(house);
            for (Player player : players
            ) {
                player.setHouse(null);
                playerDao.updatePC(player);
                log.info("XOGADOR DADO DE BAIXA " + house.getHouseName());
            }
            houseDao.delete(house);
            log.info("ELIMINADO A CASA " + house.getHouseName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void assignPlayer() {
        try {
            House house = houseDao.findById(Integer.parseInt(leerDatos("ID DA CASA ")));
            Player player = playerDao.findById(leerDatos("DNI DO XOGADOR"));
            player.setHouse(house);
            playerDao.updatePC(player);
            log.info("XOGADOR " + player.getPlayerName() + " INCORPÓRASE A CASA " + house.getHouseName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createHouses() {
        for (int i = 0; i < initHouses.length; i++) {
            House house = new House();
            house.setHouseName(initHouses[i]);
            houseDao.create(house);
        }
    }
}
