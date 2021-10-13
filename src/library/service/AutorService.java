package library.service;

import library.entidad.Autor;
import library.persistance.AutorDAO;
import library.persistance.LibroDAO;

public class AutorService {
    private AutorDAO autorDAO;
    private LibroDAO libroDAO;
    
    public AutorService() {
        this.autorDAO = new AutorDAO ();
        this.libroDAO = new LibroDAO();
    }
    
    public Autor crearAutor(String nombreAutor) throws Exception{
        Autor autor = new Autor();
        try {
            if (nombreAutor == null || nombreAutor.trim().isEmpty()){
                throw new Exception ("Debe indicar el nombre del autor.");
            }
            autor.setNombreAutor(nombreAutor);
            autor.setAlta(Boolean.TRUE);
            autorDAO.guardarAutor(autor);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return autor;
    }
}
