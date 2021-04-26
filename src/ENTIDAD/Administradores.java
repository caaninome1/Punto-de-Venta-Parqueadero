package ENTIDAD;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ADMINISTRADORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administradores.findAll", query = "SELECT a FROM Administradores a"),
    @NamedQuery(name = "Administradores.findByIdadministrador", query = "SELECT a FROM Administradores a WHERE a.idadministrador = :idadministrador"),
    @NamedQuery(name = "Administradores.findByAdministrador", query = "SELECT a FROM Administradores a WHERE a.administrador = :administrador"),
    @NamedQuery(name = "Administradores.findByContrasena", query = "SELECT a FROM Administradores a WHERE a.contrasena = :contrasena")})
public class Administradores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDADMINISTRADOR")
    private Integer idadministrador;
    @Basic(optional = false)
    @Column(name = "ADMINISTRADOR")
    private String administrador;
    @Basic(optional = false)
    @Column(name = "CONTRASENA")
    private String contrasena;

    public Administradores() {
    }

    public Administradores(Integer idadministrador) {
        this.idadministrador = idadministrador;
    }

    public Administradores(Integer idadministrador, String administrador, String contrasena) {
        this.idadministrador = idadministrador;
        this.administrador = administrador;
        this.contrasena = contrasena;
    }

    public Integer getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(Integer idadministrador) {
        this.idadministrador = idadministrador;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
