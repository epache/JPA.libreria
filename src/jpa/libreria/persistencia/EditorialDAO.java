
package jpa.libreria.persistencia;

import java.util.List;
import jpa.libreria.entidades.Editorial;

public final class EditorialDAO extends DAO<Editorial> {
    
        @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }

    public void eliminar(String nombre) {
        Editorial editorial = buscarPorNombre(nombre);
        super.eliminar(editorial);
    }

    public Editorial buscarPorNombre(String nombre) {
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre ").setParameter("nombre", nombre).getSingleResult();
        super.desconectar();
        return editorial;
    }

    public List<Editorial> listarTodos() {
        super.conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        super.desconectar();
        return editoriales;
    }
    
}
