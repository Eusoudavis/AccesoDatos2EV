package Loxica;

import Dao.ManualDao;
import Entities.Manual;
import Entities.Revista;

import java.util.List;

public class LoxicaManual {

    ManualDao manualDao = new ManualDao();

    public void validarCreate(Manual manual){
        manualDao.create(manual);
    }

    public void validarDelete(Manual manual){
    if (manual.getIsbn() != null){
        manualDao.delete(manual);
    }else {
        System.out.println("Non hai tal manual");
    }
    }

    public List<Manual> validarRead(){
        return manualDao.read();
    }


    public Manual validateFindById(Long s){
        Manual manual = new Manual();
        if (s!=null){
            manual = manualDao.findById(s);
        }
        return manual;
    }

}
