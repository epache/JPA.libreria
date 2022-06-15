package jpa.libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jpa.libreria.entidades.Autor;
import jpa.libreria.entidades.Editorial;
import jpa.libreria.entidades.Libro;
import jpa.libreria.persistencia.LibroDAO;

public class LibroServicios {

    Scanner read = new Scanner(System.in).useDelimiter("\n");

    AutorServicios autorservicios = new AutorServicios();
    EditorialServicios editorialservicios = new EditorialServicios();

    private final LibroDAO DAO;

    public LibroServicios() {
        this.DAO = new LibroDAO();
    }

    public Libro crearLibro() {

        System.out.println("Vamos a crear un LIBRO");
        Libro libro = new Libro();

        System.out.println("De la siguiente lista de autores, ingrese el nombre del AUTOR del LIBRO");
        autorservicios.imprimirAutores();
        String autorNombre = read.next();
        Autor autor = autorservicios.buscarPorNombre(autorNombre);
        libro.setAutor(autor);

        System.out.println("De la siguiente lista de editoriales, ingrese el nombre de la EDITORIAL del LIBRO");
        editorialservicios.imprimirEditoriales();
        String editorialNombre = read.next();
        Editorial editorial = editorialservicios.buscarPorNombre(editorialNombre);
        libro.setEditorial(editorial);

        System.out.println("Ingrese titulo del libro");
        libro.setTitulo(read.next());

        System.out.println("Ingrese año del libro");
        libro.setAnio(read.nextInt());

        DAO.guardar(libro);

        return libro;
    }

    public List<Libro> buscarPorAutor() {
        System.out.println("Ingresar nombre del autor para obtener lista de sus libros");
        String autor = read.next();
        Long id = autorservicios.buscarPorNombreID(autor);
        List<Libro> libros = new ArrayList();
        libros = DAO.buscarPorAutorID(id);
        return libros;
    }

    public List<Libro> imprimirLibros() {
        List<Libro> libros = DAO.listarTodos();
        for (Libro l : libros) {
            System.out.println(l.toString());
        }
        return libros;
    }

    public void eliminarLibro() {
        System.out.println("Ingrese el isbn del libro que desea eliminar");
        imprimirLibros();
        Long isbn = read.nextLong();
        DAO.eliminar(isbn);
        System.out.println("La nueva lista de libros es:"); 
        System.out.println("PACHE TE AMOOOOOOOOOOOOO ");
        imprimirLibros();
    }

}
