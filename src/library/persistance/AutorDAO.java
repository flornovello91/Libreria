package library.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import library.entidad.Autor;

public class AutorDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
    private final EntityManager em = emf.createEntityManager();
    
    public void guardarAutor(Autor autor) throws Exception {
        em.getTransaction().begin();
        em.persist(autor);       
        em.getTransaction().commit();
    }
    public Autor buscarAutorPorNombre(String nombre){
        Autor autor = (Autor) em.createQuery("SELECT d "
                + " FROM Autor d"
                + " WHERE d.nombreAutor LIKE :nombre")
                .setParameter("nombre", nombre).
                getSingleResult();
        return autor;
    }
    /*
    public Libro buscarLibroPorTitulo(String titulo) throws Exception {
        Libro libro = (Libro) em.createQuery("SELECT d "
                + " FROM Libro d"
                + " WHERE d.titulo LIKE :titulo")
                .setParameter("titulo", titulo).
                getSingleResult();
        return libro;
    }
    */
}
