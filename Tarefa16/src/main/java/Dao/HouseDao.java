package Dao;

import Entities.House;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

import static Connection.Connection.*;

public class HouseDao {
    public void create(House house) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(house);
        tx.commit();
        disconection();
    }

    public House findById(int id) {
        conection();
        House house = em.find(House.class, id);
        disconection();
        return house;
    }

    public List<House> read() {
        conection();
        TypedQuery<House> consulta = em.createQuery("Select l from House l ", House.class);
        List<House> houses = consulta.getResultList();
        disconection();
        return houses;
    }

    public void delete(House house) {
        conection();
        House houseDelete = em.find(House.class, house.getHouseId());
        if (houseDelete != null ){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(houseDelete);
            tx.commit();
        }else {
            System.out.println("Esta casa non existe");
        }
        disconection();
    }

}
