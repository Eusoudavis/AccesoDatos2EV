package Loxica;

import Dao.TaxiDriverDao;
import Entities.Taxi;
import Entities.TaxiDriver;

public class TaxiDriverLoxica {
    TaxiDriverDao taxiDriveDao = new TaxiDriverDao();

    public void validateCreateTaxiDriver(TaxiDriver taxiDriver){
        taxiDriveDao.create(taxiDriver);
    }

    public TaxiDriver validateFindByDNI(String dni){
        return taxiDriveDao.findById(dni);
    }

    public void validateUpdateTaxiDriver(TaxiDriver taxiDriver){
        taxiDriveDao.updateTaxiDriver(taxiDriver);
    }


}
