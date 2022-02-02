package loxica;

import DAO.DaoEmpregado;
import entity.Empregado;

public class LoxicaEmpregado {
    private DaoEmpregado daoEmpregado = new DaoEmpregado();

    public void validateCreate(Empregado empregado){
        daoEmpregado.create(empregado);
    }

}
