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

    public void validateUpdateTaxiEnable(String matricula) {
        taxiDao.updateTaxiEnable(matricula);
    }

    public Taxi validateFindByCarNumber(String matricula) {
        return taxiDao.findById(matricula);
    }
}
