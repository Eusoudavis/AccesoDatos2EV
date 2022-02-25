package Loxica;

import Dao.TaxiDriveDao;
import Entities.TaxiDriver;

public class TaxiDriverLoxica {
    TaxiDriveDao taxiDriveDao = new TaxiDriveDao();

    public void validateCreateTaxiDriver(TaxiDriver taxiDriver){
        taxiDriveDao.create(taxiDriver);
    }
}
