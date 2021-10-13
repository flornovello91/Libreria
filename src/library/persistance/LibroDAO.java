package library.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import library.entidad.Libro;

public class LibroDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
    private final EntityManager em = emf.createEntityManager();
    
    public void guardarLibro(Libro libro) throws Exception {
        em.getTransaction().begin();
        em.persist(libro);       
        em.getTransaction().commit();
    }
    public Libro buscarLibroPorTitulo(String titulo) throws Exception {
        Libro libro = (Libro) em.createQuery("SELECT d "
                + " FROM Libro d"
                + " WHERE d.titulo LIKE :titulo")
                .setParameter("titulo", titulo).
                getSingleResult();
        return libro;
    }
}
/*
public void guardarUsuario(Usuario usuario) throws Exception {
        em.getTransaction().begin();
        em.persist(usuario);       
        em.getTransaction().commit();
    }

    public void modificarUsuario(Usuario usuario) throws Exception {
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }

    public void eliminarUsuarioId(String id) throws Exception {
        Usuario usuario = buscarUsuarioPorId(id);
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
    }

    public void eliminarUsuarioCorreo(String correo) throws Exception {
        Usuario usuario = buscarUsuarioPorCorreoElectronico(correo);
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
    }

    public Usuario buscarUsuarioPorId(String id) throws Exception {
        Usuario usuario = em.find(Usuario.class, id); // Esto que envio es la llave primaria
        return usuario;
    }
    //CONSULTA CON PARAMETROS

    public Usuario buscarUsuarioPorCorreoElectronico(String correoElectronico) throws Exception {
        Usuario usuario = (Usuario) em.createQuery("SELECT d "
                + " FROM Usuario d"
                + " WHERE d.correoElectronico LIKE :correoElectronico").
                setParameter("correoElectronico", correoElectronico).
                getSingleResult();      
        return usuario;
    }
    //CONSULTA SIN PARAMETROS

    public List<Usuario> listarUsuarios() throws Exception {
        List<Usuario> usuarios = em.createQuery("SELECT d FROM Usuario d")
                .getResultList();
        return usuarios;
    }

*/