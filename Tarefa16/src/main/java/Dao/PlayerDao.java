package Dao;

import Entities.Player;
import Entities.House;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import java.util.List;

import static Connection.Connection.*;

public class PlayerDao {
    public void create(Player player) {
        conection();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(player);
        tx.commit();
        disconection();
    }

    public Player findById(String id) {
        conection();
        Player player = em.find(Player.class, id);
        disconection();
        return player;
    }

    public List<Player> read() {
        conection();
        TypedQuery<Player> consulta = em.createQuery("Select l from Player l ", Player.class);
        List<Player> players = consulta.getResultList();
        disconection();
        return players;
    }

    public List<Player> readTeamPlayers(House house) {
        conection();
        TypedQuery<Player> consulta = em.createQuery("Select l from Player l where l.house.houseId =?1", Player.class);
        consulta.setParameter(1, house.getHouseId());
        List<Player> players = consulta.getResultList();
        disconection();
        return players;
    }

    public void updatePC(Player player) {
        conection();
        EntityTransaction tx = em.getTransaction();
        Player playerDB = em.find(Player.class, player.getDni());
        tx.begin();
            if (player.getHouse()!=null){
            playerDB.setHouse(player.getHouse());
            }else if (player.getHouse()==(null)){
                playerDB.setHouse(player.getHouse());
            }
        tx.commit();
        disconection();
    }


}
