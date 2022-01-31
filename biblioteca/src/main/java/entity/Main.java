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
				System.out.println("2.- Crear libro.");
				System.out.println("3.- Borrar libro.");
				System.out.println("4.- Actualizar libro.");
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
					updateLibro();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Opción erronea");
				}
			} catch (Exception e) {
				System.out.println("La opción tiene que ser un número");
			}
		} while (opcion != 5);
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
	}

	private static void updateLibro(){
		Libro libro = new Libro();
		try {
			libro.setIsbn(leerDatos("ISBN: "));
			libro.setTitulo(leerDatos("Titulo: "));
			libro.setAutor(leerDatos("Autor: "));
			//libro.setFecha(Date.valueOf(leerDatos("Data: ")));
			libro.setPrecio(Integer.parseInt(leerDatos("Prezo: ")));
			Loxica loxica = new Loxica();
			loxica.validarUpdate(libro);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
