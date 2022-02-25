package Loxica;

import Dao.TaxiDriverDao;
import Entities.TaxiDriver;

public class TaxiDriverLoxica {
    TaxiDriverDao taxiDriveDao = new TaxiDriverDao();

    public void validateCreateTaxiDriver(TaxiDriver taxiDriver){
        taxiDriveDao.create(taxiDriver);
    }
}
