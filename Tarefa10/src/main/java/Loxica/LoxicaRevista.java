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

    public static void validarDelete(Revista revista) throws Exception {
        if (revista.getIsbn() != null){
        revistaDao.delete(revista);
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

    public void validarOutroDelete(Long id) throws Exception {
        revistaDao.outroDelete(id);
    }
}
