package Loxica;

import Dao.Dao;
import Entity.Empregado;

import java.util.List;

public class Loxica {
    Dao dao = new Dao();

    public void validateCreate(Empregado empregado){
        dao.create(empregado);
    }

    public Empregado validateFindById(String s ){
       Empregado empregado = new Empregado();
       if (s!=null){
           empregado = dao.findById(s);
       }
       return empregado;
    }

    public List<Empregado> validarRead(){
        return dao.read();
    }

    public void validarUpdate(Empregado empregado){
        dao.update(empregado);
    }


    public void validateDelete(Empregado empregado){
        dao.delete(empregado);
    }

}
