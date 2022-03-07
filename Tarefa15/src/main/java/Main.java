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
import java.util.List;
import java.util.Locale;

import static Connection.Connection.conection;

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
                log.info("1- Nova equipa");
                log.info("2- Baixa equipa");
                log.info("3- Alta xogador");
                log.info("4- Asignar xogador a unha equipa");
                log.info("5- Amosar equipa");
                log.info("6- Amosar todas as equipas");
                log.info("7- Amosar todos os xogadores");
                log.info("8- Sair");
                switch (opcion = Integer.parseInt(leerDatos("OPCIÓN A ELIXIR"))) {
                    case 1 -> setTeam();
                    case 2 -> deleteTeam();
                    case 3 -> setPlayer();
                    case 4 -> assignPlayer();
                    case 5 -> readTeam();
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

    public static void setTeam(){
        Team team = new Team();
        team.setNie(faker.idNumber().valid());
        team.setTeamName(faker.team().name());
        teamDao.create(team);
        log.info("CREADO O EQUIPO " +team.getTeamName());
    }

    public static void setPlayer(){
        Player player = new Player();
        player.setNij(faker.idNumber().valid());
        player.setPlayerName(faker.name().fullName());
        player.setMaxScore(faker.number().digits(3));
        playerDao.create(player);
        log.info("CREADO O XOGADOR " + player.getPlayerName());
    }

    public static void readTeam(){
        try {
            Team team = teamDao.findById(leerDatos("NIE DA EQUIPA "));
            log.info(team.toString());
            List<Player> players = playerDao.readTeamPlayers(team);
            if (players.isEmpty()){
                log.error("EQUIPA SEN XOGAODRES");
            }else {
                players.forEach((Player player)->log.info(player.toString()));}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAllTeams(){
         teamDao.read().forEach((Team team)->log.info(team.toString()));
    }

    public static void readAllPlayers(){
        playerDao.read().forEach((Player player)->log.info(player.toString()));
//        playerDao.readTeamPlayers(teamDao.findById("154-26-8134")).forEach((Player player)->log.info(player.toString()));

    }

    public static void deleteTeam(){
        try {
            Team team = teamDao.findById(leerDatos("NIE EQUIPA "));
            List<Player> players =  playerDao.readTeamPlayers(team);
            for (Player player : players
            ){
                player.setTeam(null);
                playerDao.updatePC(player);
                log.info("XOGADOR DADO DE BAIXA " +team.getTeamName());

            }
            teamDao.delete(team);
            log.info("ELIMINADO O EQUIPO " +team.getTeamName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void assignPlayer(){
        try {
            Team team = teamDao.findById(leerDatos("NIE DA EQUIPA "));
            if (playerDao.readTeamPlayers(team).size()<5){
                Player player = playerDao.findById(leerDatos("NIJ DO XOGADOR"));
                player.setTeam(team);
                playerDao.updatePC(player);
                log.info("XOGADOR " + player.getPlayerName() + " INCORPÓRASE AO EQUIPO " + team.getTeamName());
            }else {
                log.error("EQUIPA CHEA");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
