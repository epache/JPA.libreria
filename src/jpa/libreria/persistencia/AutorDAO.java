package jpa.libreria.persistencia;

import java.util.List;
import jpa.libreria.entidades.Autor;

public final class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor);
    }

    public void eliminar(String nombre) {
        Autor autor = buscarPorNombre(nombre);
        super.eliminar(autor);
    }

    public Autor buscarPorNombre(String nombre) {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre ").setParameter("nombre", nombre).getSingleResult();
        super.desconectar();
        return autor;
    }

    public Long buscarPorNombreID(String nombre) {
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre ").setParameter("nombre", nombre).getSingleResult();
        Long id = autor.getId();
        super.desconectar();
        return id;
    }

    public List<Autor> listarTodos() {
        super.conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        super.desconectar();
        return autores;
    }

}
