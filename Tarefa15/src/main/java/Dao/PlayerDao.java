package Dao;

import Entities.Player;
import Entities.Team;

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

    public List<Player> readTeamPlayers(Team team) {
        conection();
        TypedQuery<Player> consulta = em.createQuery("Select l from Player l where l.team.nie =?1", Player.class);
        consulta.setParameter(1, team.getNie());
        List<Player> players = consulta.getResultList();
        disconection();
        return players;
    }

    public void updatePC(Player player) {
        // Ordenador ordenadorDB = findById(ordenador.getIdPC());
        conection();
        EntityTransaction tx = em.getTransaction();
        Player playerDB = em.find(Player.class, player.getNij());
        tx.begin();
        //if (playerDB.getNij().equals(player.getNij())){
            if (player.getTeam()!=null){
            playerDB.setTeam(player.getTeam());
            }else if (player.getTeam()==(null)){
                playerDB.setTeam(player.getTeam());
            }
      //  }
        tx.commit();
        disconection();
    }


}
