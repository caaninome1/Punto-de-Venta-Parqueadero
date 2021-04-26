package ENTIDAD;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "OPERARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operarios.findAll", query = "SELECT o FROM Operarios o"),
    @NamedQuery(name = "Operarios.findById", query = "SELECT o FROM Operarios o WHERE o.id = :id"),
    @NamedQuery(name = "Operarios.findByNombre", query = "SELECT o FROM Operarios o WHERE o.nombre = :nombre"),
    @NamedQuery(name = "Operarios.findByUsuario", query = "SELECT o FROM Operarios o WHERE o.usuario = :usuario"),
    @NamedQuery(name = "Operarios.findByContrasena", query = "SELECT o FROM Operarios o WHERE o.contrasena = :contrasena"),
    @NamedQuery(name = "Operarios.findByCodigo", query = "SELECT o FROM Operarios o WHERE o.codigo = :codigo")})
public class Operarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "CONTRASENA")
    private String contrasena;
    @Column(name = "CODIGO",unique = true)
    private int codigo ;


    
    public Operarios() {
    }

    public Operarios(String id) {
        this.id = id;
    }

    public Operarios(String id, String nombre, String usuario, String contrasena, int codigo) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.codigo = codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
}
