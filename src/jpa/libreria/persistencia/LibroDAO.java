package jpa.libreria.persistencia;

import java.util.List;
import jpa.libreria.entidades.Libro;

public final class LibroDAO extends DAO<Libro> {

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    public void eliminar(Long isbn) {
        Libro libro = buscarPorISBN(isbn);
        super.eliminar(libro);
    }

    public Libro buscarPorISBN(Long isbn) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn ").setParameter("isbn", isbn).getSingleResult();
        super.desconectar();
        return libro;
    }

    public Libro buscarPorTitulo(String titulo) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :titulo ").setParameter("titulo", titulo).getSingleResult();
        super.desconectar();
        return libro;
    }
    
        public List<Libro> buscarPorAutorID(Long id) {
        conectar();
        List libros = (List) em.createQuery("SELECT l FROM Libro l WHERE l.autor.id LIKE :id ").setParameter("id", id).getResultList();
        super.desconectar();
        return libros;
    }

    public List<Libro> listarTodos() {
        super.conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        super.desconectar();
        return libros;
    }

}
