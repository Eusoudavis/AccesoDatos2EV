package loxica;

import java.util.List;
import java.util.Scanner;

import DAO.DAO;
import entity.Libro;

public class Loxica {

   
	private DAO daoLibro = new DAO();
	
	public Libro findByID(String id) {
		Libro libro = new Libro();
		if(id!=null) {
			libro = daoLibro.findById(id);
		}
		return libro;
	}

	public void validarDelete(Libro libro){

		libro = daoLibro.findById(libro.getIsbn());
		if ( libro != null){
			System.out.println("ISBN " + libro.getIsbn());
			daoLibro.delete(libro);
		}else {
			System.out.println("Libro non existente.");
		}	}

	public void validarCreate(Libro libro){
		if (daoLibro.findById(libro.getIsbn()) == null){
		daoLibro.create(libro);
		}else {
			System.out.println("Libro xa existente.");
		}
	}

	public void validarUpdate(Libro libro){
		if (daoLibro.findById(libro.getIsbn()) != null){
			daoLibro.update(libro);
		}else {
			System.out.println("Libro non existente.");
		}
	}

}
