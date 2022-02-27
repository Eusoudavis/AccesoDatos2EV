package Loxica;

import Dao.JourneyDao;
import Entities.Journey;

public class JourneyLoxica {
    JourneyDao journeyDao = new JourneyDao();

    public void validateCreate(Journey journey) {
        journeyDao.create(journey);
    }

    public Journey validateFindById(Long id) {
        return journeyDao.findById(id);
    }

    public void validateUpdateJourney(Journey journey) {
        journeyDao.updateJourney(journey);
    }

}
