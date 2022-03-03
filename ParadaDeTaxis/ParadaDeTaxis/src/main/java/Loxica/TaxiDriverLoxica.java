package Loxica;

import Dao.TaxiDriverDao;
import Entities.TaxiDriver;

import java.util.List;

public class TaxiDriverLoxica {
    TaxiDriverDao taxiDriveDao = new TaxiDriverDao();

    public void validateCreateTaxiDriver(TaxiDriver taxiDriver) {
        taxiDriveDao.create(taxiDriver);
    }

    public TaxiDriver validateFindByDNI(String dni) {
        return taxiDriveDao.findById(dni);
    }

    public void validateUpdateTaxiDriverActive(String dni) {
        taxiDriveDao.updateTaxiDriverIsEnable(dni);
    }

    public void validateUpdateTaxiDriverNotActive(String dni) {
        taxiDriveDao.updateTaxiDriverIsNotEnable(dni);
    }

    public List<TaxiDriver> validateRead(Boolean active) {
        return taxiDriveDao.readTaxiDriver(active);
    }

}
