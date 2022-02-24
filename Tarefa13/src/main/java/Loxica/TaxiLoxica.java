package Loxica;

import Dao.TaxiDao;
import Entities.Taxi;

public class TaxiLoxica {
    TaxiDao taxiDao = new TaxiDao();

    public void validateCreate(Taxi taxi) {
        taxiDao.create(taxi);
    }
}
