package ENTIDAD;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name = "CLIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdTicket", query = "SELECT c FROM Clientes c WHERE c.idTicket = :idTicket"),
    @NamedQuery(name = "Clientes.findByMatricula", query = "SELECT c FROM Clientes c WHERE c.matricula = :matricula"),
    @NamedQuery(name = "Clientes.findByTipoVehiculo", query = "SELECT c FROM Clientes c WHERE c.tipoVehiculo = :tipoVehiculo"),
    @NamedQuery(name = "Clientes.findByPuntos", query = "SELECT c FROM Clientes c WHERE c.puntos = :puntos"),
    @NamedQuery(name = "Clientes.findByEntrada", query = "SELECT c FROM Clientes c WHERE c.entrada = :entrada"),
    @NamedQuery(name = "Clientes.findBySalida", query = "SELECT c FROM Clientes c WHERE c.salida = :salida"),
    @NamedQuery(name = "Clientes.findByTiempo", query = "SELECT c FROM Clientes c WHERE c.salida = :tiempo"),
    @NamedQuery(name = "Clientes.findByBaseImponible", query = "SELECT c FROM Clientes c WHERE c.baseImponible = :baseImponible"),
    @NamedQuery(name = "Clientes.findByIva", query = "SELECT c FROM Clientes c WHERE c.iva = :iva"),
    @NamedQuery(name = "Clientes.findByValorTotal", query = "SELECT c FROM Clientes c WHERE c.valorTotal = :valorTotal")})
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TICKET", nullable = false)
    private BigInteger idTicket;
    @Column(name = "MATRICULA", nullable = true, length = 10)
    private String matricula;
    @Basic(optional = false)
    @Column(name = "TIPO_VEHICULO", nullable = false, length = 11)
    private String tipoVehiculo;
    
    @Column(name = "PUNTOS", nullable = true)
    private int puntos;
    
    
    @Column(name = "ENTRADA",nullable = true)
    private String entrada;
    
    @Column(name = "SALIDA", nullable = true)
    private String salida;
    
    @Column(name = "TIEMPO", nullable = true)
    private Integer tiempo;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BASE_IMPONIBLE", nullable = true, precision = 52)
    private Double baseImponible;
    
    @Column(name = "IVA", nullable = true, precision = 52)
    private Double iva;
    
    @Column(name = "VALOR_TOTAL", nullable = true, precision = 52)
    private Double valorTotal;
    
    @Column(name = "CODIGO_OPERARIO")
    private int codigoOperario;

    public Clientes() {
    }

    public Clientes(BigInteger idTicket) {
        this.idTicket = idTicket;
    }

    public Clientes(BigInteger idTicket, String matricula, String tipoVehiculo,int puntos, String entrada,
                        String salida, Integer tiempo, Double baseImponible, Double iva, Double valorTotal, int codigoOperario ) {
        this.idTicket = idTicket;
        this.matricula = matricula;
        this.tipoVehiculo = tipoVehiculo;
        this.puntos = puntos;
        //this.estado = estado;
        this.entrada = entrada;
        this.salida = salida;
        this.tiempo = tiempo;
        this.baseImponible = baseImponible;
        this.iva = iva;
        this.valorTotal = valorTotal;
        this.codigoOperario = codigoOperario;
        
    }
    
    public BigInteger getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(BigInteger idTicket) {
        this.idTicket = idTicket;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

//    public String getEstado() {
//        return estado;
//    }
//
//    public void setEstado(String estado) {
//        this.estado = estado;
//    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
    
    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    
    public Double getBaseImponible() {
        return baseImponible;
    }

    public void setBaseImponible(Double baseImponible) {
        this.baseImponible = baseImponible;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getCodigoOperario() {
        return codigoOperario;
    }

    public void setCodigoOperario(int codigoOperario) {
        this.codigoOperario = codigoOperario;
    }
  
}
