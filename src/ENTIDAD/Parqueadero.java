package ENTIDAD;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "PARQUEADERO", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"RAZON_SOCIAL"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parqueadero.findAll", query = "SELECT p FROM Parqueadero p"),
    @NamedQuery(name = "Parqueadero.findByNit", query = "SELECT p FROM Parqueadero p WHERE p.nit = :nit"),
    @NamedQuery(name = "Parqueadero.findByRazonSocial", query = "SELECT p FROM Parqueadero p WHERE p.razonSocial = :razonSocial"),
    @NamedQuery(name = "Parqueadero.findByRegimen", query = "SELECT p FROM Parqueadero p WHERE p.regimen = :regimen"),
    @NamedQuery(name = "Parqueadero.findByDireccion", query = "SELECT p FROM Parqueadero p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Parqueadero.findByTelefono", query = "SELECT p FROM Parqueadero p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Parqueadero.findByPoliza", query = "SELECT p FROM Parqueadero p WHERE p.poliza = :poliza"),
    @NamedQuery(name = "Parqueadero.findByTipoParqueadero", query = "SELECT p FROM Parqueadero p WHERE p.tipoParqueadero = :tipoParqueadero"),
    @NamedQuery(name = "Parqueadero.findByTarifaAutomovil", query = "SELECT p FROM Parqueadero p WHERE p.tarifaAutomovil = :tarifaAutomovil"),
    @NamedQuery(name = "Parqueadero.findByTarifaMoto", query = "SELECT p FROM Parqueadero p WHERE p.tarifaMoto = :tarifaMoto"),
    @NamedQuery(name = "Parqueadero.findByTarifaBicicleta", query = "SELECT p FROM Parqueadero p WHERE p.tarifaBicicleta = :tarifaBicicleta")})
public class Parqueadero implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NIT", nullable = false)
    private String nit;
    @Basic(optional = false)
    @Column(name = "RAZON_SOCIAL", nullable = false, length = 45)
    private String razonSocial;
    @Basic(optional = false)
    @Column(name = "REGIMEN", nullable = false, length = 45)
    private String regimen;
    @Basic(optional = false)
    @Column(name = "DIRECCION", nullable = false, length = 45)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "TELEFONO", nullable = false)
    private String telefono;
    @Basic(optional = false)
    @Column(name = "POLIZA", nullable = false, length = 50)
    private String poliza;
    @Basic(optional = false)
    @Column(name = "TIPO_PARQUEADERO", nullable = false, length = 255)
    private String tipoParqueadero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TARIFA_AUTOMOVIL", precision = 52)
    private Double tarifaAutomovil;
    @Column(name = "TARIFA_MOTO", precision = 52)
    private Double tarifaMoto;
    @Column(name = "TARIFA_BICICLETA", precision = 52)
    private Double tarifaBicicleta;

    public Parqueadero() {
    }

    public Parqueadero(String nit) {
        this.nit = nit;
    }

    public Parqueadero(String nit, String razonSocial, String regimen, String direccion, String telefono, String poliza, String tipoParqueadero) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.regimen = regimen;
        this.direccion = direccion;
        this.telefono = telefono;
        this.poliza = poliza;
        this.tipoParqueadero = tipoParqueadero;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }

    public String getTipoParqueadero() {
        return tipoParqueadero;
    }

    public void setTipoParqueadero(String tipoParqueadero) {
        this.tipoParqueadero = tipoParqueadero;
    }

    public Double getTarifaAutomovil() {
        return tarifaAutomovil;
    }

    public void setTarifaAutomovil(Double tarifaAutomovil) {
        this.tarifaAutomovil = tarifaAutomovil;
    }

    public Double getTarifaMoto() {
        return tarifaMoto;
    }

    public void setTarifaMoto(Double tarifaMoto) {
        this.tarifaMoto = tarifaMoto;
    }

    public Double getTarifaBicicleta() {
        return tarifaBicicleta;
    }

    public void setTarifaBicicleta(Double tarifaBicicleta) {
        this.tarifaBicicleta = tarifaBicicleta;
    }
    
}
