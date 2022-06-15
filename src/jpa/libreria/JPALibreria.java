package jpa.libreria;

import jpa.libreria.entidades.Autor;
import jpa.libreria.entidades.Editorial;
import jpa.libreria.servicios.AutorServicios;
import jpa.libreria.servicios.EditorialServicios;
import jpa.libreria.servicios.LibroServicios;

public class JPALibreria {

    public static void main(String[] args) {

        AutorServicios autorservicios = new AutorServicios();
        EditorialServicios editorialservicios = new EditorialServicios();
        LibroServicios libroservicios = new LibroServicios();

        //Autor autor = autorservicios.crearAutor();
        //Editorial editorial = editorialservicios.crearEditorial();
        //libroservicios.crearLibro();
        //libroservicios.buscarPorAutor().forEach((a) -> System.out.println(a.toString()));
        //autorservicios.imprimirAutores().forEach((a) -> System.out.println(a.toString()));
        libroservicios.eliminarLibro();
        //libroservicios.imprimirLibros();
    }
}
