import Dao.AlumnoDao;
import Dao.OrdenadorDao;
import Entities.Alumno;
import Entities.Ordenador;
import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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
                        case 2 -> deleteAlumno();
                        case 3 -> setPC();
                        case 4 -> buscarOrdenadorPorAlumno();
                        case 5 -> buscarAlumnoPorOrdenador();
                        case 6 -> readAlumnos();
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


    public static void setAlumno(){
        try {
            Alumno alumno = new Alumno();
            alumno.setIdAlumno(faker.idNumber().valid());
            alumno.setNome(faker.name().fullName());
            alumno.setTelefono(Integer.parseInt(faker.number().digits(9)));
            Ordenador ordenador = readPCsinAlumnos();
            ordenador.setAlumno(alumno);
            alumno.setOrdenador(ordenador);
            alumnoDao.create(alumno);
            ordenadorDao.updatePC(ordenador);
            log.info("------------------------CREADO O ALUMNO  "+ alumno.getNome()+ "---------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setPC(){
        try {
            Ordenador ordenador = new Ordenador();
            ordenador.setIdPC(faker.idNumber().valid());
            ordenador.setMarca(faker.chuckNorris().fact().toString());
            ordenador.setModelo(faker.number().digits(3));
            ordenadorDao.create(ordenador);
            log.info("------------------------CREADO O PC MODELO "+ ordenador.getModelo()+ "---------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readAlumnos(){
        alumnoDao.read().forEach((Alumno alumno)->log.info(alumno.toString()));
    }
    public static void buscarOrdenadorPorAlumno(){
        try {
            log.info(ordenadorDao.findById(alumnoDao.findById(leerDatos("id ")).getOrdenador().getIdPC()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buscarAlumnoPorOrdenador(){
        try {
            log.info(alumnoDao.findById(ordenadorDao.findById(leerDatos("id ")).getAlumno().getIdAlumno()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Ordenador readPCsinAlumnos(){
        List<Ordenador> ordenadores = ordenadorDao.readSinAlumno();
        Ordenador ordenador =new Ordenador();
        if (!ordenadores.isEmpty()){
            ordenador = ordenadores.get(0);
        }
        return ordenador;
    }

    public static void deleteAlumno(){
        try {
            Alumno alumno = alumnoDao.findById(leerDatos("id alumno"));
        Ordenador ordenador = ordenadorDao.findById(alumno.getOrdenador().getIdPC());
        ordenador.setAlumno(null);
        ordenadorDao.updatePCNoDelete(ordenador);
        alumnoDao.delete(alumno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
