package jpa.libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO<T> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("JPA.libreriaPU");
    protected EntityManager em = EMF.createEntityManager();

    protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void guardar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    protected void editar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    protected void eliminar(T objeto) throws Exception {
        try {
            conectar();
            em.getTransaction().begin();
            //em.remove(objeto);
            em.remove(em.merge(objeto));
            em.getTransaction().commit();
            desconectar();
        } catch (Exception e) {
            em.getTransaction().rollback();
            desconectar();
            throw new Exception("El objeto " + objeto.getClass().getSimpleName() + " no se pudo eliminar");
        }

    }

}
