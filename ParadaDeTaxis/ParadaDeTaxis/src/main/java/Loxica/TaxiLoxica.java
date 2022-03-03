package Loxica;

import Dao.TaxiDao;
import Entities.Taxi;

import java.util.List;

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

    public List<Taxi> validateTaxiAvailable(Boolean available) {
        return taxiDao.readTaxi(available);
    }
}
