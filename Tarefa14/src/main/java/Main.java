import Connection.Connection;
import Dao.AlumnoDao;
import Dao.OrdenadorDao;
import Entities.Alumno;
import Entities.Ordenador;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static Connection.Connection.conection;

@Log4j2
public class Main {
    static Faker faker = new Faker();
    static AlumnoDao alumnoDao = new AlumnoDao();
    static OrdenadorDao ordenadorDao = new OrdenadorDao();
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
                        case 1 -> setAlumno();
                        case 2 -> lerPC();
                        case 3 -> setPC();
                        case 4 -> lerAlumno();
//                        case 5 -> lerParaCrer();
                        case 6 -> readAlumnos();
                        case 7 -> readAlumnosSinPC();
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
    public static void setAlumno(){
        try {
            Alumno alumno = new Alumno();
            alumno.setIdAlumno(faker.idNumber().valid());
            alumno.setNome(faker.name().fullName());
            alumno.setTelefono(Integer.parseInt(faker.number().digits(9)));
//            Ordenador ordenador = ordenadorDao.findById(leerDatos("ID DE ORDENADOR "));
//            alumno.setOrdenador(ordenador);
            alumnoDao.create(alumno);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void lerPC(){
        log.info(ordenadorDao.findById("id "));
    }
    public static void lerAlumno(){
        log.info(alumnoDao.findById("id "));
    }

    public static void setPC(){
        try {
            Ordenador ordenador = new Ordenador();
            ordenador.setIdPC(faker.idNumber().valid());
            ordenador.setMarcar(faker.chuckNorris().fact().toString());
            ordenador.setModelo(faker.number().digits(3));
            Alumno alumno = new Alumno();
            alumno.setIdAlumno(leerDatos("id alumno"));
            ordenador.setAlumno(alumno);
            ordenadorDao.create(ordenador);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAlumnos(){
        alumnoDao.read().forEach((Alumno alumno)->log.info(alumno.toString()));
    }
    public static void readAlumnosSinPC(){
        alumnoDao.readAlumnoSinPC().forEach((Alumno alumno)->log.info(alumno.toString()));
    }
}
