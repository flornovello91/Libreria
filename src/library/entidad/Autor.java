package library.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Autor {
    @Id
    @GeneratedValue
    private Integer id;
    
    private String nombreAutor;
    private Boolean alta;

    public Autor() {
    }

    public Autor(Integer id, String nombreAutor, Boolean alta) {
        this.id = id;
        this.nombreAutor = nombreAutor;
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s\n",nombreAutor,id);
    }
    
    
}
