package library.service;

import library.entidad.Autor;
import library.entidad.Editorial;
import library.entidad.Libro;
import library.persistance.LibroDAO;

public class LibroService {
    private final LibroDAO libroDAO;
    private final AutorService autorService;
    private final EditorialService editorialService;


    public LibroService() {
        this.libroDAO = new LibroDAO();
        this.autorService = new AutorService();      
        this.editorialService = new EditorialService();  
    } 

    public void crearLibro(long isbn,String titulo,Integer anio,Boolean alta,String nombreAutor,String nombreEditorial){
        try {
            if (titulo == null || titulo.trim().isEmpty()){
                throw new Exception ("Debe indicar el titulo del libro.");
            }
            if (anio == null){
                throw new Exception ("Debe indicar el año del libro.");
            }
            if (nombreAutor == null || nombreAutor.trim().isEmpty()){
                throw new Exception ("Debe indicar el autor del libro.");
            }
            if (nombreEditorial == null || nombreEditorial.trim().isEmpty()){
                throw new Exception ("Debe indicar la editorial del libro.");
            }
            
            Libro libro = new Libro();
            Autor autor = autorService.crearAutor(nombreAutor);
            Editorial editorial = editorialService.crearEditorial(nombreEditorial);
            
            //SETEAR LOS VALORES
            
            Integer ejemplares = (int) (Math.random()*999+1);
            Integer prestados = ejemplares - (int) (Math.random()*100+1);
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setAlta(true);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(prestados);
            libro.setEjemplaresRestantes(ejemplares-prestados);
            libro.setAnio(anio);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            
            //MANDAR AL DAO
            libroDAO.guardarLibro(libro);
        } catch (Exception e){
            System.out.println("No se creó el libro. "+e.getMessage());
        }
    }
}
/*

    public void modificarClaveUsuario(String id, String claveActual, String nuevaClave) throws Exception {

        try {
            //Validamos
            if (id == null || id.trim().isEmpty()) {
                throw new Exception("Debe indicar el usuario");
            }
            if (claveActual == null || claveActual.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave actual");
            }
            if (nuevaClave == null || nuevaClave.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave nueva");
            }
            //Buscamos
            Usuario usuario = buscarUsuarioPorId(id);

            //Validamos
            if (!usuario.getClave().equals(claveActual)) {
                throw new Exception("La clave actual no es la regsitrada en el sistema para el correo electrónico indicado");
            }
            //Modificamos
            usuario.setClave(nuevaClave);
            daoUsuario.modificarUsuario(usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public void eliminarUsuario(String correoElectronico) throws Exception {

        try {
            //Validamos 
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }
            daoUsuario.eliminarUsuarioCorreo(correoElectronico);
            System.out.println("USUARIO ELIMINADO CON EXITO");
        } catch (Exception e) {
            throw e;
        }
    }

    public Usuario buscarUsuarioPorCorreoElectronico(String correoElectronico) throws Exception {
        try {

            //Validamos
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            Usuario usuario = daoUsuario.buscarUsuarioPorCorreoElectronico(correoElectronico);
            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    public Usuario buscarUsuarioPorId(String id) throws Exception {

        try {
            //Validamos
            if (id == null) {
                throw new Exception("Debe indicar el id del usuario");
            }
            Usuario usuario = daoUsuario.buscarUsuarioPorId(id);
            return usuario;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Usuario> listaUsuarios() throws Exception {

        try {
            Collection<Usuario> usuarios = daoUsuario.listarUsuarios();
            return usuarios;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirUsuarios() throws Exception {
        try {
            //Listamos los usuarios
            Collection<Usuario> usuarios = listaUsuarios();

            //Imprimimos los usuarios - Solo algunos atributos....
            if (usuarios.isEmpty()) {
                throw new Exception("No existen usuarios para imprimir");
            } else {
                for (Usuario u : usuarios) {
                    System.out.println("*****************************************");
                    System.out.println(" Correo Electronico:" + u.getCorreoElectronico()+
                                   "\n DNI:" + u.getDni() +
                                   "\n Fecha Nacimiento:" + u.getNacimiento().getDate()+"/"+ u.getNacimiento().getMonth()+"/"+ u.getNacimiento().getYear()+
                                   "\n Mascota:" + u.getMascota().getApodo());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    public void imprimirUnUsuario(String correoElectronico) throws Exception {
        System.out.println(daoUsuario.buscarUsuarioPorCorreoElectronico(correoElectronico));
    }

 
    public void cargarMascotaUsuario(String apodo,String raza,String idUsuario) throws Exception{
          Usuario usuario = daoUsuario.buscarUsuarioPorId(idUsuario);
          Mascota nueva = mascotaService.crearMascota(apodo, raza);
          usuario.setMascota(nueva);
          daoUsuario.modificarUsuario(usuario);// Utilizo el metodo del DAO           
    }
    
    
    }
*/