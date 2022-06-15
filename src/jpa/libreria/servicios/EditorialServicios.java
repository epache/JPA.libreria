package jpa.libreria.servicios;

import java.util.List;
import java.util.Scanner;
import jpa.libreria.entidades.Editorial;
import jpa.libreria.persistencia.EditorialDAO;

public class EditorialServicios {

    Scanner read = new Scanner(System.in).useDelimiter("\n");

    private final EditorialDAO DAO;

    public EditorialServicios() {
        this.DAO = new EditorialDAO();
    }

    public Editorial crearEditorial() {
        System.out.println("Vamos a crear una editorial");
        Editorial editorial = new Editorial();
        System.out.println("Ingrese nombre de la editorial");
        editorial.setNombre(read.next());
        DAO.guardar(editorial);
        return editorial;
    }

    public Editorial buscarPorNombre(String nombre) {
        Editorial editorial = DAO.buscarPorNombre(nombre);
        return editorial;
    }

    public List<Editorial> imprimirEditoriales() {
        List<Editorial> editoriales = DAO.listarTodos();
        for (Editorial e : editoriales) {
            System.out.println(e.toString());
        }
        return editoriales;
    }

}
