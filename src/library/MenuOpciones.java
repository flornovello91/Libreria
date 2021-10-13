package library;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.InputMismatchException;
import java.util.Scanner;
import library.service.LibroService;

public class MenuOpciones {
    private final Scanner sc ;
    private final LibroService ls;

    public MenuOpciones() {
        this.sc = new Scanner (System.in).useDelimiter("\n");
        this.ls = new LibroService();
    }
   
    public void menu() throws AWTException{
        int rta=0;
        do{
            try {
                System.out.println("\n<<<<MENÚ>>>>\t");
                System.out.println("1-LIBRO\t");
                System.out.println("2-AUTOR\t");
                System.out.println("3-EDITORIAL\t");
                System.out.println("0-SALIR\t");
                int rta1 = sc.nextInt();
                switch (rta1) {
                    case 1:
                        menuLibro();
                        break;
                    case 2:
                        menuAutor();
                        break;
                    case 3:
                        menuEditorial();
                        break;
                    default:
                        System.out.println("Ingreso inválido.");
                        menu();
                }
            }catch (InputMismatchException e){
                System.out.println("Ingreso inválido."+e.getMessage());
            }
            limpiarPantalla();
        }while(rta!=0);    
    }
    public void menuLibro() throws AWTException{
        String rta;
        do{
            try {
                System.out.println("1-MOSTRAR LIBROS\t");
                System.out.println("2-ELIMINAR LIBRO\t");
                System.out.println("3-EDITAR LIBRO\t");
                System.out.println("4-BUSCAR LIBRO\t");
                System.out.println("5-VOLVER AL MENÚ ANTERIOR\t");
                int rta2 = sc.nextInt();
                switch (rta2) {
                    case 1 :
                        break;
                    case 2 :
                        break;
                    case 3 :
                        break;
                    case 4 :
                        try {
                            System.out.println("1-BUSCAR POR TITULO\t");
                            System.out.println("2-BUSCAR POR ISBN\t");
                            System.out.println("3-BUSCAR POR AUTOR\t");
                            System.out.println("4-BUSCAR POR EDITORIAL\t");
                            int rta3 = sc.nextInt();
                            switch (rta3) {
                                case 1:
                                    ls.buscarLibroPorTitulo(ingresoTitulo());
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                default:
                            }
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingreso inválido." + e.getMessage());
            }
            System.out.println("Desea realizar una nueva consulta o gestion ???:SI/NO");
            rta = sc.next();
            rta = rta.toUpperCase();
            limpiarPantalla();
        }while("SI".equals(rta));
    }
    /*
    System.out.println("Desea realizar una nueva consulta o gestion ???:SI/NO");
            respuesta = sc.next();
            respuesta = respuesta.toUpperCase();
            limpiarPantalla();
        } while ("SI".equals(respuesta));
    */
    public void menuEditorial() throws AWTException{
        int rta = 0;
        do{
            try {
                System.out.println("\n1-MOSTRAR LIBROS\t");
                System.out.println("\n2-ELIMINAR LIBRO\t");
                System.out.println("\n3-EDITAR LIBRO\t");
                System.out.println("\n4-BUSCAR LIBRO\t");
                System.out.println("\n5-VOLVER AL MENÚ ANTERIOR\t");
                int rta2 = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ingreso inválido." + e.getMessage());
            }
            limpiarPantalla();
        }while(rta!=5);
    }
    public void menuAutor (){
        
    }
    public void limpiarPantalla() throws AWTException {
        //Dejo esre metodo para ir borrando la consola.. y que no sea un desorden.
        Robot pressbot = new Robot();
        pressbot.setAutoDelay(30); // Tiempo de espera antes de borrar
        pressbot.keyPress(17); // Orden para apretar CTRL key
        pressbot.keyPress(76);// Orden para apretar L key
        pressbot.keyRelease(17); // Orden para soltar CTRL key
        pressbot.keyRelease(76); // Orden para soltar L key

    }
    public String ingresoTitulo(){
        Scanner sc = new Scanner (System.in).useDelimiter("\n");
        System.out.println("Ingrese el titulo del libro que busca : ");
        String titulo = sc.next();
        return titulo;
    }
}
/*
do {
            System.out.println("Seleccione la opción:");
            System.out.println("=====================================");

            System.out.println(" 1- Crear Usuario");//OK
            System.out.println(" 2- Crear Mascota para un usuario");//OK

            System.out.println(" 3- Mostrar Usuarios");//OK
            System.out.println(" 4- Mostrar Mascotas");//OK
            System.out.println(" 5- Mostrar Mascotas de una RAZA");//OK

            System.out.println(" 6- Modificar Clave Usuario");//OK
            System.out.println(" 7- Ver DATOS de un usuario segun correo electronico");//OK
            System.out.println(" 8- Eliminar Usuario");//OK

            System.out.println(" 9 - Modificar Apodo Mascota");
            
            System.out.println(" 0- Salir");

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    usuarioService.crearUsuario(cargarCorreo(), cargarClave(), cargarDni(), cargarFecha(), "PAIS", "PROVINCIA");
                    break;
                case 2:
                    usuarioService.cargarMascotaUsuario(cargarApodo(), cargarRaza(),ingresarIdUsuario());                    
                    break;
                case 3:
                    usuarioService.imprimirUsuarios();
                    break;
                case 4:
                    mascotaService.imprimirMascotas();
                    break;
                case 5:
                    mascotaService.mostarXRaza(cargarRaza());
                    break;
                case 6:
                    usuarioService.modificarClaveUsuario(ingresarIdUsuario(), cargarClave(), cargarNuevaClave());
                    break;
                case 7:
                    usuarioService.imprimirUnUsuario(buscarPorCorreo());
                    break;
                case 8:
                    usuarioService.eliminarUsuario(buscarPorCorreo()); // Tener en cuenta que si elimino usuario, elimino sus mascotas asociadas 
                    break;
                case 9:
                    mascotaService.modificarApodoMascota(cargarIdMascot(), cargarApodo());
                    break;               
                case 0:
                    System.exit(0);
                    break;
            }

            System.out.println("Desea realizar una nueva consulta o gestion ???:SI/NO");
            respuesta = sc.next();
            respuesta = respuesta.toUpperCase();
            limpiarPantalla();
        } while ("SI".equals(respuesta));

    }
*/