package library.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Editorial {
    @Id
    @GeneratedValue
    private Integer id;
    
    private String nombreEditorial;
    private Boolean alta;

    public Editorial() {
    }

    public Editorial(Integer id, String nombreEditorial, Boolean alta) {
        this.id = id;
        this.nombreEditorial = nombreEditorial;
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Editorial{" + "id=" + id + ", nombreEditorial=" + nombreEditorial + ", alta=" + alta + '}';
    }
    
    
}
