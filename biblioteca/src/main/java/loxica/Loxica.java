package loxica;

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
			daoLibro.delete(libro);
	}

	public void validarCreate(Libro libro){
		if (daoLibro.findById(libro.getIsbn()) == null){
		daoLibro.create(libro);
		}else {
			System.out.println("Libro xa existente.");
		}
	}

	public void validarUpdate(Libro libro){
			daoLibro.update(libro);
	}

}
