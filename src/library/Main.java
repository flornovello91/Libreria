
package library;

import java.awt.AWTException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import library.service.LibroService;

public class Main {
    public static void main(String[] args) throws AWTException, Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
        EntityManager em = emf.createEntityManager();
        //mandarLibros();
        MenuOpciones menu = new MenuOpciones();
        menu.menu();
    }
    public static void mandarLibros(){
        LibroService libro1 = new LibroService();
        LibroService libro2 = new LibroService();
        LibroService libro3 = new LibroService();
        LibroService libro4 = new LibroService();
        LibroService libro5 = new LibroService();
        LibroService libro6 = new LibroService();
        LibroService libro7 = new LibroService();
        
        libro1.crearLibro(1234, "Mi planta naranja lima",1968, Boolean.TRUE, "José Mauro de Vasconcelos", "El Ateneo");
        libro2.crearLibro(4567, "La casa de los espiritus",1989, Boolean.TRUE, "Isabel Allende", "Sudamericana");
        libro3.crearLibro(7890, "100 años de soledad", 1989, Boolean.TRUE, "Gabriel García Marquez", "Sudamericana");
        libro4.crearLibro(1245, "Rebelión en la granja", 1945, Boolean.TRUE, "George Orwell", "Zig Zag");
        libro5.crearLibro(5698, "El principito", 1943, Boolean.TRUE, " Antoine de Saint-Exupéry", "Buque de letras");
        libro6.crearLibro(6987, "Porque viven los hombres", 1885, Boolean.TRUE, "León Tolstói", "El Ateneo");
        libro7.crearLibro(6891,"Los miserables", 1862, Boolean.TRUE,"Victor Hugo", "A. Lacroix");    
    }
}
