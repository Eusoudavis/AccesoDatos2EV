package Loxica;

import Connection.Connection;
import Dao.ManualDao;
import Dao.RevistaDao;
import Entities.Manual;
import Entities.Revista;

import java.util.List;

import static Connection.Connection.em;

public class LoxicaRevista {
    static RevistaDao revistaDao = new RevistaDao();
    static ManualDao manualDao = new ManualDao();

    public void validarCreate(Revista revista){
        revistaDao.create(revista);
    }

    public static void validarDelete(Revista revista){
        Connection.conection();
        Revista revista1 = em.find(Revista.class, revista.getIsbn());
        if (revista1 != null){
        Manual manual = new Manual();
        manual.setIsbn(revista.getIsbn());
        revistaDao.delete(revista1);
        manualDao.delete(manual);
        }else {
            System.out.println("Non hai tal manual");
        }
    }

    public List<Revista> validarRead(){
        return revistaDao.read();
    }


    public Revista validateFindById(Long s){
        Revista revista = new Revista();
        if (s!=null){
            revista = revistaDao.findById(s);
        }
        return revista;
    }
}
