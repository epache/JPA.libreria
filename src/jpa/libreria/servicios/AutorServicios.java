package jpa.libreria.servicios;

import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.objects.NativeArray;
import jpa.libreria.entidades.Autor;
import jpa.libreria.persistencia.AutorDAO;

public class AutorServicios {

    Scanner read = new Scanner(System.in).useDelimiter("\n");

    private final AutorDAO DAO;

    public AutorServicios() {
        this.DAO = new AutorDAO();
    }

    public Autor crearAutor() {
        System.out.println("Vamos a crear un autor");
        Autor autor = new Autor();
        List<Autor> autores = DAO.listarTodos();
        String autorNombre;
        boolean i = true;
        do {
            System.out.println("ingrese nombre del autor");
            autorNombre = read.next();
            for (Autor a : autores) {
                if (a.getNombre().equalsIgnoreCase(autorNombre)) {
                    System.out.println("El nombre ingresado ya existe");
                    i = false;
                    break;
                } else {
                    i = true;
                }
            }
        } while (i != true);
        autor.setNombre(autorNombre);
        DAO.guardar(autor);
        return autor;
    }

    public Long buscarPorNombreID(String nombre) {
        Long id = DAO.buscarPorNombreID(nombre);
        return id;
    }

    public Autor buscarPorNombre(String nombre) {
        Autor autor = DAO.buscarPorNombre(nombre);
        return autor;
    }

    public List<Autor> imprimirAutores() {
        List<Autor> autores = DAO.listarTodos();
        for (Autor a : autores) {
            System.out.println(a.toString());
        }
        return autores;
    }

}
