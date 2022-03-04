import Connection.Connection;
import Dao.PlayerDao;
import Dao.TeamDao;
import Entities.Player;
import Entities.Team;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

@Log4j2
public class Main {
    static PlayerDao playerDao = new PlayerDao();
    static TeamDao teamDao = new TeamDao();
    static Faker faker = new Faker(new Locale("pt"));
    public static void main(String[] args) {
        //conection();
        int opcion = 0;
        do {
            try {
                log.info("\n---------MENU-------------");
                log.info("1- Engadir Alumno");
                log.info("2- Baixa Alumno");
                log.info("3- Engadir Portátil");
                log.info("4- Portátil dun alumno");
                log.info("5- Alumno que usa un portátil");
                log.info("6- Ver todos os alumnos");
                log.info("7- Sair");
                switch (opcion = Integer.parseInt(leerDatos("OPCIÓN A ELIXIR"))) {
                    case 1 -> setTeam();
                  //  case 2 -> deleteAlumno();
                    case 3 -> setPlayer();
                 //   case 4 -> buscarOrdenadorPorAlumno();
                  //  case 5 -> buscarAlumnoPorOrdenador();
                 //   case 6 -> readAlumnos();
                    case 7 -> System.exit(0);
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

    public static void setTeam(){
        Team team = new Team();
        team.setNie(faker.idNumber().valid());
        team.setTeamName(faker.team().name());
        teamDao.create(team);
    }

    public static void setPlayer(){
        Player player = new Player();
        player.setNij(faker.idNumber().valid());
        player.setPlayerName(faker.name().fullName());
        player.setMaxScore(faker.number().digits(3));
        playerDao.create(player);
    }
}
