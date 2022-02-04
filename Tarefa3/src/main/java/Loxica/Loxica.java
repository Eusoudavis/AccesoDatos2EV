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

    public List<Empregado> validateFindByOficce(){
        return dao.findByOffice();
    }

    public List<Object[]> validatesalaryStatsByOffice(){
        return dao.salaryStatsByOffice();
    }


    public List<Empregado> validarRead(){
        return dao.read();
    }

    public void validarUpdate(Empregado empregado){
        dao.update(empregado);
    }

    public void validarDeleteNegativeSalary(){
        dao.deleteNegativeSalary();
    }

    public void validarUpdateComercial(){
        dao.updateComercial();
    }

    public List<Integer> validarReadAllOffice(){
        return dao.readAllOffice();
    }

    public List<Object[]> validarNumEmployeesByPosition(){
        return dao.numEmployeesByPosition();
    }

    public List<Empregado> validarFindEmployeeByOffice(int num){
        return dao.findEmployeeByOffice(num);
    }


    public void validateDelete(Empregado empregado){
        dao.delete(empregado);
    }

}
