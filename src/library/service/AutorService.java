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
    public Autor buscarAutorPorNombre(String nombreAutor) throws Exception{
        try {
            if (nombreAutor == null||nombreAutor.trim().isEmpty()){
                throw new Exception ("Debe ingresar el nombre del autor.");
            }
            System.out.println("-----------------------------------------------------------------------------------------------");
            Autor autor = autorDAO.buscarAutorPorNombre(nombreAutor);
            System.out.printf("%-15s%-15s\n","NOMBRE","ID");
            System.out.println(autor);
            System.out.println("-----------------------------------------------------------------------------------------------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
//    public Libro buscarLibroPorTitulo(String titulo){
//        try {
//            if (titulo == null||titulo.trim().isEmpty()){
//                throw new Exception ("Debe ingresar el titulo del libro.");
//            }
//            System.out.println("-----------------------------------------------------------------------------------------------");
//            Libro libro = libroDAO.buscarLibroPorTitulo(titulo);
//            System.out.printf("%-15s%-15s%-30s%-25s\n","NOMBRE","ISBN","AUTOR","EDITORIAL");
//            System.out.println(libro);
//            System.out.println("-----------------------------------------------------------------------------------------------");
//            return libro;
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }
}
