package Loxica;

import Dao.JourneyDao;
import Entities.Journey;

import java.util.List;

public class JourneyLoxica {
    JourneyDao journeyDao = new JourneyDao();

    public void validateCreate(Journey journey) {
        journeyDao.create(journey);
    }

    public Journey validateFindById(Long id) {
        return journeyDao.findById(id);
    }

    public List<Journey> validateRead() {
        return journeyDao.read();
    }

    public List<Journey> validateReadCurrentJourney() {
        return journeyDao.readNull();
    }

    public void validateUpdateJourney(Journey journey) {
        journeyDao.updateJourney(journey);
    }

}
