package library.service;

import library.entidad.Editorial;
import library.persistance.EditorialDAO;

public class EditorialService {
    private EditorialDAO editorialDAO;
    
    public EditorialService(){
        this.editorialDAO = new EditorialDAO();
    }
    
    public Editorial crearEditorial (String nombreEditorial){
        Editorial editorial = new Editorial ();
        try {
            if (nombreEditorial==null|| nombreEditorial.trim().isEmpty() ){
                System.out.println("Ingrese el nombre de la editorial");
            }
            editorial.setNombreEditorial(nombreEditorial);
            editorial.setAlta(Boolean.TRUE);
            editorialDAO.guardarEditorial(editorial);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return editorial;
    }
}
