package entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.Scanner;

import DAO.DAO;
import loxica.Loxica;

public class Main {
	static Loxica loxica = new Loxica();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion = 0;
		do {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("1.- Buscar un libro");
				System.out.println("2.- Crear rexistro.");
				System.out.println("3.- Actualizar rexistro.");
				System.out.println("4.- Xerar Ficheiro Intecambio.");
				System.out.println("Salir.");
				opcion = sc.nextInt();

				switch (opcion) {
				case 1:
					getCommandLineBook();
					break;
				case 2:
					crearLibro();
					break;
				case 3:
					readToDelete();
					break;
				case 4:
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Opci�n erronea");
				}
			} catch (Exception e) {
				System.out.println("La opcion tiene que ser un numero");
			}
		} while (opcion != 5);
		// Libro miLibro = new Libro("139655532-3");

	}

	public static String leerDatos(final String s) throws IOException {
		System.out.println(s);
		return (new BufferedReader(new InputStreamReader(System.in))).readLine();
	}

	private static void readToDelete(){
		try {
			Libro libro = new Libro();
			libro.setIsbn(leerDatos("ISBN"));
			loxica.validarDelete(libro);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void getCommandLineBook() {
		try {
			Libro libro = new Libro();
			libro = loxica.findByID(leerDatos("Isbn: "));
			System.out.println(libro.getIsbn());
			System.out.println(libro.getAutor());
			System.out.println(libro.getTitulo());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void crearLibro(){
		Libro libro = new Libro();
		try {
			libro.setIsbn(leerDatos("ISBN: "));
			libro.setTitulo(leerDatos("Titulo: "));
			libro.setAutor(leerDatos("Autor: "));
			//libro.setFecha(Date.valueOf(leerDatos("Data: ")));
			libro.setPrecio(Integer.parseInt(leerDatos("Prezo: ")));
			Loxica loxica = new Loxica();
			loxica.validarCreate(libro);
		} catch (IOException e) {
			e.printStackTrace();
		}

//		System.out.println("Titulo: ");
//
//
//		System.out.println("Autor: ");
//
//
//		/*System.out.println("Data: ");
//		libro.setFecha(sc.nextLine());*/
//
//		System.out.println("Prezo: ");
//
	}

}
