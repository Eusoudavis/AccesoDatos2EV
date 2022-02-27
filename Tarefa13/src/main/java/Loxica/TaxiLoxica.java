package Loxica;

import Dao.TaxiDao;
import Entities.Taxi;

public class TaxiLoxica {
    TaxiDao taxiDao = new TaxiDao();

    public void validateCreate(Taxi taxi) {
        taxiDao.create(taxi);
    }

    public void validateUpdate(String matricula) {
        taxiDao.updateTaxiNoEnable(matricula);
    }
    public Taxi validateFindByCarNumber(String matricula){
       /// return taxiDao.findById(matricula);
        Taxi taxi = taxiDao.findById(matricula);
        return taxi;
    }
}
