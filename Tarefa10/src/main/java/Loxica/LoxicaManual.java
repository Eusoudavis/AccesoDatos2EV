package Loxica;

import Dao.ManualDao;
import Entities.Manual;

public class LoxicaManual {

    ManualDao manualDao = new ManualDao();

    public void validarCreate(Manual manual){
        manualDao.create(manual);
    }
}
