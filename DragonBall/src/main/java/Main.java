import Connection.Connection;
import Dao.DragonDao;
import Dao.GoodCharacterDao;
import Dao.ResurrectionDao;
import Entities.Dragon;
import Entities.GoodCharacter;
import Entities.MainCharacter;
import Entities.Resurrection;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

@Log4j2
public class Main {
    static DragonDao dragonDao = new DragonDao();
    static GoodCharacterDao goodCharacterDao = new GoodCharacterDao();
    static ResurrectionDao resurrectionDao = new ResurrectionDao();
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
                        case 1 -> createDragon();
                        case 2 -> buscarDragonNome();
                        case 3 -> buscarPersonaxeNome();
                        case 4 -> createResurrection();
                        case 5 -> morteMorrida();
//                        case 6 -> readAllTeams();
//                        case 7 -> readAllPlayers();
                        case 8 -> System.exit(0);
                        default -> log.info("OPCIÓN ERRÓNEA");
                    }
                } catch (IOException e) {
                    log.error("LA OPCIÓN TIENE QUE SER UN NÚMERO");
                }
            } while (opcion != 8);
        }
        //Connection.conection();
        //buscarDragonNome();
        //createResurrection();
        //createDragon();


    public static String leerDatos(final String s) throws IOException {
        System.out.println(s);
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }
    public static void createDragon(){
        try {
            MainCharacter mainCharacter = new MainCharacter();
            mainCharacter.setName(faker.dragonBall().character());
            mainCharacter.setKi(faker.random().nextInt(1, 10000));
            mainCharacter.setPlanet(faker.space().planet());
            mainCharacter.setAlive(false);
            log.info(mainCharacter.getName());
            if (leerDatos("É un dragon? SI/NON").toUpperCase(Locale.ROOT).equals("SI")) {
                Dragon dragon = new Dragon();
                dragon.setName(mainCharacter.getName());
                dragon.setKi(mainCharacter.getKi());
                dragon.setPlanet(mainCharacter.getPlanet());
                dragon.setAlive(mainCharacter.getAlive());
                dragonDao.create(dragon);
            }else if (leerDatos("É un dos bos? SI/NON").toUpperCase(Locale.ROOT).equals("SI")) {
                GoodCharacter goodCharacter = new GoodCharacter();
                goodCharacter.setName(mainCharacter.getName());
                goodCharacter.setKi(mainCharacter.getKi());
                goodCharacter.setPlanet(mainCharacter.getPlanet());
                goodCharacter.setAlive(mainCharacter.getAlive());
                goodCharacter.setRessurrectionCount(0);
                goodCharacterDao.create(goodCharacter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Dragon buscarDragonID()  {
        Dragon dragon = null;
        try {
            dragon = dragonDao.findById(Integer.valueOf(leerDatos("Id Dragon")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(dragon.getName());
        return dragon;
    }

    public static Dragon buscarDragonNome()  {
        Dragon dragon = null;
        try {
            dragon = dragonDao.findByName((leerDatos("Nome Dragon")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(dragon.getName() + " " + dragon.getKi());
        return dragon;
    }

    public static GoodCharacter buscarPersonaxeNome()  {
        GoodCharacter goodCharacter = null;
        try {
            goodCharacter = goodCharacterDao.findByName((leerDatos("Nome GoodCharacter")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(goodCharacter.getName() + " " + goodCharacter.getKi());
        return goodCharacter;
    }

    public static void createResurrection(){
        try{
            Resurrection resurrection = new Resurrection();
            Dragon dragon = dragonDao.findByName(leerDatos("Dragon "));
            GoodCharacter goodCharacter = goodCharacterDao.findByName(leerDatos("Personaxe "));
            resurrection.setDragon(dragon);
            resurrection.setGoodCharacter(goodCharacter);
            resurrectionDao.create(resurrection);
            goodCharacter.setAlive(true);
            goodCharacterDao.update(goodCharacter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void morteMorrida(){
        try {
            GoodCharacter goodCharacter = goodCharacterDao.findByName(leerDatos("nome"));
            List<Resurrection> resurrectionList = resurrectionDao.read();
            for (Resurrection resurrection: resurrectionList
                 ) {
                if (resurrection.getGoodCharacter().getId().equals(goodCharacter.getId())){
                    resurrectionDao.delete(resurrection);
                }
            }
            goodCharacterDao.delete(goodCharacter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
