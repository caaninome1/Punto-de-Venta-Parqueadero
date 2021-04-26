package CONTROLADOR;

import DAOS.DaoClientes;
import DAOS.DaoParqueadero;
import ENTIDAD.Clientes;
import ENTIDAD.Parqueadero;
import FRONTERA.Factura;
import FRONTERA.LoginOperario;
import FRONTERA.Operario;
import FRONTERA.Ticket;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class ControlClientes {

    private DaoClientes cjc = new DaoClientes();
    private Clientes clientes = new Clientes();
    private String mensaje = "";
    private int tiempoTranscurrido;
    private ControlParqueadero pdao = new ControlParqueadero();
    private DaoParqueadero pjc = new DaoParqueadero();
    private Parqueadero parqueadero = new Parqueadero();
    public BigInteger Factur;

    public String ingresoCliente(String matricula, String tipoVehiculo) {
        try {
            if (matricula.equals("")) {
                mensaje = "El campo está vacío. Por favor ingrese una matrícula";
            } else if (esMinuscula(matricula) == true && !(matricula.matches("[0-9]+"))) {
                mensaje = "Matricula incorrecta. Por favor digite en mayúscula";
            } else {
                String entrada = Timestamp.from(Instant.now()).toString();
                clientes.setIdTicket(BigInteger.ONE);
                clientes.setMatricula(matricula);

                clientes.setTipoVehiculo(tipoVehiculo);
                clientes.setPuntos(0);
                clientes.setEntrada(entrada);
                clientes.setSalida("No ha salido");
                clientes.setTiempo(0);
                clientes.setBaseImponible(0.0);
                clientes.setIva(0.0);
                clientes.setValorTotal(0.0);
                clientes.setCodigoOperario(0);

                String nitparqueadero = buscarParqueadero().getNit();
                String telparqueadero = buscarParqueadero().getTelefono();
                String nombreparqueadero = buscarParqueadero().getRazonSocial();
                String polizaparqueadero = buscarParqueadero().getPoliza();
                String direccionparqueadero = buscarParqueadero().getDireccion();
                String regimenparqueadero = buscarParqueadero().getRegimen();

                if ((clientes.getTipoVehiculo().equals("Automovil")) && (verificarPlacaCarro(clientes.getMatricula()) == true)) {
                    boolean valor = disponible(matricula, "No ha salido");
                    if (valor == true) {
                        mensaje = "¡Ya ha ingresado un vehículo con esa matrícula!";

                    } else {
                        cjc.create(clientes);
                        mensaje = "Ingresado correctamente";

                        ingresarClientes(matricula, "No ha salido");
                        Ticket ticket = new Ticket();
                        ticket.setVisible(true);
                        ticket.txtNombreParqueaderoTicket.setText(nombreparqueadero);
                        ticket.txtNITticket.setText(nitparqueadero);
                        ticket.txtTelTicket.setText(telparqueadero);
                        ticket.txtDireccionTicket.setText(direccionparqueadero);
                        ticket.txtRegimenTicket.setText(regimenparqueadero);
                        ticket.txtPolizaTicket.setText(polizaparqueadero);
                        ticket.txtNoTicket.setText(clientes.getIdTicket() + "");
                        ticket.txtMatriculaTicket.setText(clientes.getMatricula());
                        ticket.txtEntradaTicket.setText(clientes.getEntrada());
                    }

                } else if ((clientes.getTipoVehiculo().equals("Motocicleta")) && (verificarPlacaMoto(clientes.getMatricula()) == true)) {
                    boolean valor = disponible(matricula, "No ha salido");
                    if (valor == true) {
                        mensaje = "¡Ya ha ingresado un vehículo con esa matrícula!";

                    } else {
                        cjc.create(clientes);
                        mensaje = "Ingresado correctamente";
                        ingresarClientes(matricula, "No ha salido");
                        Ticket ticket = new Ticket();
                        ticket.setVisible(true);
                        ticket.txtNombreParqueaderoTicket.setText(nombreparqueadero);
                        ticket.txtNITticket.setText(nitparqueadero);
                        ticket.txtTelTicket.setText(telparqueadero);
                        ticket.txtDireccionTicket.setText(direccionparqueadero);
                        ticket.txtRegimenTicket.setText(regimenparqueadero);
                        ticket.txtPolizaTicket.setText(polizaparqueadero);
                        ticket.txtNoTicket.setText(clientes.getIdTicket() + "");
                        ticket.txtMatriculaTicket.setText(clientes.getMatricula());
                        ticket.txtEntradaTicket.setText(clientes.getEntrada());
                    }
                } else if ((clientes.getTipoVehiculo().equals("Bicicleta")) && (verificarDocumento(clientes.getMatricula()) == true)) {
                    boolean valor = disponible(matricula, "No ha salido");
                    if (valor == true) {
                        mensaje = "¡Ya ha ingresado un vehículo con esa matrícula!";

                    } else {
                        cjc.create(clientes);
                        mensaje = "Ingresado correctamente";
                        ingresarClientes(matricula, "No ha salido");
                        Ticket ticket = new Ticket();
                        ticket.setVisible(true);
                        ticket.txtNombreParqueaderoTicket.setText(nombreparqueadero);
                        ticket.txtNITticket.setText(nitparqueadero);
                        ticket.txtTelTicket.setText(telparqueadero);
                        ticket.txtDireccionTicket.setText(direccionparqueadero);
                        ticket.txtRegimenTicket.setText(regimenparqueadero);
                        ticket.txtPolizaTicket.setText(polizaparqueadero);
                        ticket.txtNoTicket.setText(clientes.getIdTicket() + "");
                        ticket.txtMatriculaTicket.setText(clientes.getMatricula());
                        ticket.txtEntradaTicket.setText(clientes.getEntrada());
                    }
                } else {
                    mensaje = "Matricula Incorrecta";
                }
            }
        } catch (Exception e) {
            System.out.println("Mensaje en ingresar " + e.getMessage());
            mensaje = "No se pudo ingresar la información ";
        }
        return mensaje;
    }

    public String salidaCliente(BigInteger idTicket, String formaPago) {

        try {
            Clientes c = new Clientes();
            boolean valor = Nodisponible(idTicket, 0);
            if (valor == true) {
                mensaje = "El vehículo no ha ingresado";
            } else {
                String salida = Timestamp.from(Instant.now()).toString();
                String sdate1 = buscarClientes(idTicket).getEntrada();
                String sdate2 = salida;
                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

                SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                Date date1;
                Date date2;
                try {
                    date1 = formatter1.parse(sdate1);
                    date2 = formatter2.parse(sdate2);
                    tiempoTranscurrido = restarFechas(date2, date1);
                } catch (ParseException ex) {
                    System.out.println("Error al obtener el tiempo: " + ex.getMessage());
                }
                int puntosf = puntosFidelizacion(buscarClientes(idTicket).getMatricula());
                
                if (formaPago.equals("Puntos")) {
                    if ((puntosf - (tiempoTranscurrido)) < 0) {
                        mensaje = "No es posible redimir los puntos";
                    } else {
                        int puntosfidelizacion;
                        puntosfidelizacion = puntosf + (tiempoTranscurrido / 60);
                        BigDecimal bdpf = new BigDecimal(puntosfidelizacion);
                        bdpf = bdpf.setScale(0, RoundingMode.DOWN);
                        int puntosfd = bdpf.intValue() - (tiempoTranscurrido);
                        ActualizacionPuntosCero(buscarClientes(idTicket).getMatricula(), puntosfd);

                        String nitparqueadero = buscarParqueadero().getNit();
                        String telparqueadero = buscarParqueadero().getTelefono();
                        String nombreparqueadero = buscarParqueadero().getRazonSocial();
                        String polizaparqueadero = buscarParqueadero().getPoliza();
                        String direccionparqueadero = buscarParqueadero().getDireccion();
                        String regimenparqueadero = buscarParqueadero().getRegimen();

                        Double tarifavehiculo = 0.0;
                        Double valortotal = 0.0;
                        Double ivavehiculo = 0.0;
                        Double baseimponible = 0.0;

                        if (buscarClientes(idTicket).getTipoVehiculo().equals("Automovil")) {
                            tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaAutomovil();
                        } else if (buscarClientes(idTicket).getTipoVehiculo().equals("Motocicleta")) {
                            tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaMoto();
                        } else if (buscarClientes(idTicket).getTipoVehiculo().equals("Bicicleta")) {
                            tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaBicicleta();
                        }

                        valortotal = tarifavehiculo * tiempoTranscurrido;
                        baseimponible = valortotal / 1.19;
                        ivavehiculo = baseimponible * 0.19;

                        valortotal = valortotal - (valortotal % 50) + 50;
                        //baseimponible= baseimponible-(baseimponible%50)+50;
                        //ivavehiculo = ivavehiculo-(ivavehiculo%50)+50;

                        BigDecimal bdvt = new BigDecimal(valortotal);
                        bdvt = bdvt.setScale(0, RoundingMode.HALF_UP);

                        BigDecimal bdbi = new BigDecimal(baseimponible);
                        bdbi = bdbi.setScale(0, RoundingMode.HALF_UP);

                        BigDecimal bdiv = new BigDecimal(ivavehiculo);
                        bdiv = bdiv.setScale(0, RoundingMode.HALF_UP);

                        clientes.setIdTicket(idTicket);
                        clientes.setMatricula(buscarClientes(idTicket).getMatricula());
                        clientes.setTipoVehiculo(buscarClientes(idTicket).getTipoVehiculo());
                        clientes.setPuntos(puntosfd);
                        clientes.setEntrada(buscarClientes(idTicket).getEntrada());
                        clientes.setSalida(salida);
                        clientes.setTiempo(tiempoTranscurrido);
                        clientes.setBaseImponible(bdbi.doubleValue());
                        clientes.setIva(bdiv.doubleValue());
                        clientes.setValorTotal(bdvt.doubleValue());
                        clientes.setCodigoOperario(Integer.parseInt(Operario.txtCodOp.getText()));
                        
                        cjc.edit(clientes);
                        mensaje = "Salida correcta";      
                        buscarClientes(idTicket);
                        
                        Factura factura = new Factura();
                        factura.txtIdFactura.setText(clientes.getIdTicket() + "");
                        factura.txtEntradafactura.setText(clientes.getEntrada());
                        factura.txtDuracionFactura.setText(clientes.getTiempo() + "");
                        factura.txtSalidaFactura.setText(clientes.getSalida());
                        factura.txtIvaFactura.setText(clientes.getIva() + "");
                        factura.txtValorTotalFactura.setText(clientes.getValorTotal() + "");
                        factura.txtBaseImponibleFactura.setText(clientes.getBaseImponible() + "");
                        factura.txtMatriculafactura.setText(clientes.getMatricula());
                        factura.txtPuntosFactura.setText(clientes.getPuntos() + "");
                        factura.txtNITParqueaderoFactura.setText(nitparqueadero);
                        factura.txtTelefonoFactura.setText(telparqueadero);
                        factura.txtDireccionFactura.setText(direccionparqueadero);
                        factura.txtNombreParqueaderoFactura.setText(nombreparqueadero);
                        factura.txtPolizaFactura.setText(polizaparqueadero);
                        factura.txtRegimenFactura.setText(regimenparqueadero);
                        factura.txtFormadePago.setText(formaPago);
                        factura.txtCodigoOperario.setText(Operario.txtCodOp.getText());
                        factura.setVisible(true);
                    }
                } else if(formaPago.equals("Efectivo")) {
                    int puntosfidelizacion;
                    puntosfidelizacion = puntosf + (tiempoTranscurrido / 60);
                    BigDecimal bdpf = new BigDecimal(puntosfidelizacion);
                    bdpf = bdpf.setScale(0, RoundingMode.DOWN);
                    ActualizacionPuntosCero(buscarClientes(idTicket).getMatricula(), bdpf.intValue());

                    String nitparqueadero = buscarParqueadero().getNit();
                    String telparqueadero = buscarParqueadero().getTelefono();
                    String nombreparqueadero = buscarParqueadero().getRazonSocial();
                    String polizaparqueadero = buscarParqueadero().getPoliza();
                    String direccionparqueadero = buscarParqueadero().getDireccion();
                    String regimenparqueadero = buscarParqueadero().getRegimen();

                    Double tarifavehiculo = 0.0;
                    Double valortotal = 0.0;
                    Double ivavehiculo = 0.0;
                    Double baseimponible = 0.0;

                    if (buscarClientes(idTicket).getTipoVehiculo().equals("Automovil")) {
                        tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaAutomovil();
                    } else if (buscarClientes(idTicket).getTipoVehiculo().equals("Motocicleta")) {
                        tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaMoto();
                    } else if (buscarClientes(idTicket).getTipoVehiculo().equals("Bicicleta")) {
                        tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaBicicleta();
                    }

                    valortotal = tarifavehiculo * tiempoTranscurrido;
                    baseimponible = valortotal / 1.19;
                    ivavehiculo = baseimponible * 0.19;

                    valortotal = valortotal - (valortotal % 50) + 50;
                    //baseimponible= baseimponible-(baseimponible%50)+50;
                    //ivavehiculo = ivavehiculo-(ivavehiculo%50)+50;

                    BigDecimal bdvt = new BigDecimal(valortotal);
                    bdvt = bdvt.setScale(0, RoundingMode.HALF_UP);

                    BigDecimal bdbi = new BigDecimal(baseimponible);
                    bdbi = bdbi.setScale(0, RoundingMode.HALF_UP);

                    BigDecimal bdiv = new BigDecimal(ivavehiculo);
                    bdiv = bdiv.setScale(0, RoundingMode.HALF_UP);

                    clientes.setIdTicket(idTicket);
                    clientes.setMatricula(buscarClientes(idTicket).getMatricula());
                    clientes.setTipoVehiculo(buscarClientes(idTicket).getTipoVehiculo());
                    clientes.setPuntos(bdpf.intValue());
                    clientes.setEntrada(buscarClientes(idTicket).getEntrada());
                    clientes.setSalida(salida);
                    clientes.setTiempo(tiempoTranscurrido);
                    clientes.setBaseImponible(bdbi.doubleValue());
                    clientes.setIva(bdiv.doubleValue());
                    clientes.setValorTotal(bdvt.doubleValue());
                    clientes.setCodigoOperario(Integer.parseInt(Operario.txtCodOp.getText()));
                    cjc.edit(clientes);
                    mensaje = "Salida correcta";

                    buscarClientes(idTicket);
                    Factura factura = new Factura();
                    factura.txtIdFactura.setText(clientes.getIdTicket() + "");
                    factura.txtEntradafactura.setText(clientes.getEntrada());
                    factura.txtDuracionFactura.setText(clientes.getTiempo() + "");
                    factura.txtSalidaFactura.setText(clientes.getSalida());
                    factura.txtIvaFactura.setText(clientes.getIva() + "");
                    factura.txtValorTotalFactura.setText(clientes.getValorTotal() + "");
                    factura.txtBaseImponibleFactura.setText(clientes.getBaseImponible() + "");
                    factura.txtMatriculafactura.setText(clientes.getMatricula());
                    factura.txtPuntosFactura.setText(clientes.getPuntos() + "");
                    factura.txtNITParqueaderoFactura.setText(nitparqueadero);
                    factura.txtTelefonoFactura.setText(telparqueadero);
                    factura.txtDireccionFactura.setText(direccionparqueadero);
                    factura.txtNombreParqueaderoFactura.setText(nombreparqueadero);
                    factura.txtPolizaFactura.setText(polizaparqueadero);
                    factura.txtRegimenFactura.setText(regimenparqueadero);
                    factura.txtFormadePago.setText(formaPago);
                    factura.txtCodigoOperario.setText(Operario.txtCodOp.getText());
                    factura.setVisible(true);
                } else if(formaPago.equals("T. Crédito")) {
                    int puntosfidelizacion;
                    puntosfidelizacion = puntosf + (tiempoTranscurrido / 60);
                    BigDecimal bdpf = new BigDecimal(puntosfidelizacion);
                    bdpf = bdpf.setScale(0, RoundingMode.DOWN);
                    ActualizacionPuntosCero(buscarClientes(idTicket).getMatricula(), bdpf.intValue());

                    String nitparqueadero = buscarParqueadero().getNit();
                    String telparqueadero = buscarParqueadero().getTelefono();
                    String nombreparqueadero = buscarParqueadero().getRazonSocial();
                    String polizaparqueadero = buscarParqueadero().getPoliza();
                    String direccionparqueadero = buscarParqueadero().getDireccion();
                    String regimenparqueadero = buscarParqueadero().getRegimen();

                    Double tarifavehiculo = 0.0;
                    Double valortotal = 0.0;
                    Double ivavehiculo = 0.0;
                    Double baseimponible = 0.0;

                    if (buscarClientes(idTicket).getTipoVehiculo().equals("Automovil")) {
                        tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaAutomovil();
                    } else if (buscarClientes(idTicket).getTipoVehiculo().equals("Motocicleta")) {
                        tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaMoto();
                    } else if (buscarClientes(idTicket).getTipoVehiculo().equals("Bicicleta")) {
                        tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaBicicleta();
                    }

                    valortotal = tarifavehiculo * tiempoTranscurrido;
                    baseimponible = valortotal / 1.19;
                    ivavehiculo = baseimponible * 0.19;

                    valortotal = valortotal - (valortotal % 50) + 50;
                    //baseimponible= baseimponible-(baseimponible%50)+50;
                    //ivavehiculo = ivavehiculo-(ivavehiculo%50)+50;

                    BigDecimal bdvt = new BigDecimal(valortotal);
                    bdvt = bdvt.setScale(0, RoundingMode.HALF_UP);

                    BigDecimal bdbi = new BigDecimal(baseimponible);
                    bdbi = bdbi.setScale(0, RoundingMode.HALF_UP);

                    BigDecimal bdiv = new BigDecimal(ivavehiculo);
                    bdiv = bdiv.setScale(0, RoundingMode.HALF_UP);

                    clientes.setIdTicket(idTicket);
                    clientes.setMatricula(buscarClientes(idTicket).getMatricula());
                    clientes.setTipoVehiculo(buscarClientes(idTicket).getTipoVehiculo());
                    clientes.setPuntos(bdpf.intValue());
                    clientes.setEntrada(buscarClientes(idTicket).getEntrada());
                    clientes.setSalida(salida);
                    clientes.setTiempo(tiempoTranscurrido);
                    clientes.setBaseImponible(bdbi.doubleValue());
                    clientes.setIva(bdiv.doubleValue());
                    clientes.setValorTotal(bdvt.doubleValue());
                    clientes.setCodigoOperario(Integer.parseInt(Operario.txtCodOp.getText()));
                    cjc.edit(clientes);
                    mensaje = "Salida correcta";

                    buscarClientes(idTicket);
                    Factura factura = new Factura();
                    factura.txtIdFactura.setText(clientes.getIdTicket() + "");
                    factura.txtEntradafactura.setText(clientes.getEntrada());
                    factura.txtDuracionFactura.setText(clientes.getTiempo() + "");
                    factura.txtSalidaFactura.setText(clientes.getSalida());
                    factura.txtIvaFactura.setText(clientes.getIva() + "");
                    factura.txtValorTotalFactura.setText(clientes.getValorTotal() + "");
                    factura.txtBaseImponibleFactura.setText(clientes.getBaseImponible() + "");
                    factura.txtMatriculafactura.setText(clientes.getMatricula());
                    factura.txtPuntosFactura.setText(clientes.getPuntos() + "");
                    factura.txtNITParqueaderoFactura.setText(nitparqueadero);
                    factura.txtTelefonoFactura.setText(telparqueadero);
                    factura.txtDireccionFactura.setText(direccionparqueadero);
                    factura.txtNombreParqueaderoFactura.setText(nombreparqueadero);
                    factura.txtPolizaFactura.setText(polizaparqueadero);
                    factura.txtRegimenFactura.setText(regimenparqueadero);
                    factura.txtFormadePago.setText(formaPago);
                    factura.txtCodigoOperario.setText(Operario.txtCodOp.getText());
                    factura.setVisible(true);
                }else if(formaPago.equals("T. Débito")) {
                    int puntosfidelizacion;
                    puntosfidelizacion = puntosf + (tiempoTranscurrido / 60);
                    BigDecimal bdpf = new BigDecimal(puntosfidelizacion);
                    bdpf = bdpf.setScale(0, RoundingMode.DOWN);
                    ActualizacionPuntosCero(buscarClientes(idTicket).getMatricula(), bdpf.intValue());

                    String nitparqueadero = buscarParqueadero().getNit();
                    String telparqueadero = buscarParqueadero().getTelefono();
                    String nombreparqueadero = buscarParqueadero().getRazonSocial();
                    String polizaparqueadero = buscarParqueadero().getPoliza();
                    String direccionparqueadero = buscarParqueadero().getDireccion();
                    String regimenparqueadero = buscarParqueadero().getRegimen();

                    Double tarifavehiculo = 0.0;
                    Double valortotal = 0.0;
                    Double ivavehiculo = 0.0;
                    Double baseimponible = 0.0;

                    if (buscarClientes(idTicket).getTipoVehiculo().equals("Automovil")) {
                        tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaAutomovil();
                    } else if (buscarClientes(idTicket).getTipoVehiculo().equals("Motocicleta")) {
                        tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaMoto();
                    } else if (buscarClientes(idTicket).getTipoVehiculo().equals("Bicicleta")) {
                        tarifavehiculo = pjc.findParqueadero(nitparqueadero).getTarifaBicicleta();
                    }

                    valortotal = tarifavehiculo * tiempoTranscurrido;
                    baseimponible = valortotal / 1.19;
                    ivavehiculo = baseimponible * 0.19;

                    valortotal = valortotal - (valortotal % 50) + 50;
                    //baseimponible= baseimponible-(baseimponible%50)+50;
                    //ivavehiculo = ivavehiculo-(ivavehiculo%50)+50;

                    BigDecimal bdvt = new BigDecimal(valortotal);
                    bdvt = bdvt.setScale(0, RoundingMode.HALF_UP);

                    BigDecimal bdbi = new BigDecimal(baseimponible);
                    bdbi = bdbi.setScale(0, RoundingMode.HALF_UP);

                    BigDecimal bdiv = new BigDecimal(ivavehiculo);
                    bdiv = bdiv.setScale(0, RoundingMode.HALF_UP);

                    clientes.setIdTicket(idTicket);
                    clientes.setMatricula(buscarClientes(idTicket).getMatricula());
                    clientes.setTipoVehiculo(buscarClientes(idTicket).getTipoVehiculo());
                    clientes.setPuntos(bdpf.intValue());
                    clientes.setEntrada(buscarClientes(idTicket).getEntrada());
                    clientes.setSalida(salida);
                    clientes.setTiempo(tiempoTranscurrido);
                    clientes.setBaseImponible(bdbi.doubleValue());
                    clientes.setIva(bdiv.doubleValue());
                    clientes.setValorTotal(bdvt.doubleValue());
                    clientes.setCodigoOperario(Integer.parseInt(Operario.txtCodOp.getText()));
                    cjc.edit(clientes);
                    mensaje = "Salida correcta";

                    buscarClientes(idTicket);
                    Factura factura = new Factura();
                    factura.txtIdFactura.setText(clientes.getIdTicket() + "");
                    factura.txtEntradafactura.setText(clientes.getEntrada());
                    factura.txtDuracionFactura.setText(clientes.getTiempo() + "");
                    factura.txtSalidaFactura.setText(clientes.getSalida());
                    factura.txtIvaFactura.setText(clientes.getIva() + "");
                    factura.txtValorTotalFactura.setText(clientes.getValorTotal() + "");
                    factura.txtBaseImponibleFactura.setText(clientes.getBaseImponible() + "");
                    factura.txtMatriculafactura.setText(clientes.getMatricula());
                    factura.txtPuntosFactura.setText(clientes.getPuntos() + "");
                    factura.txtNITParqueaderoFactura.setText(nitparqueadero);
                    factura.txtTelefonoFactura.setText(telparqueadero);
                    factura.txtDireccionFactura.setText(direccionparqueadero);
                    factura.txtNombreParqueaderoFactura.setText(nombreparqueadero);
                    factura.txtPolizaFactura.setText(polizaparqueadero);
                    factura.txtRegimenFactura.setText(regimenparqueadero);
                    factura.txtFormadePago.setText(formaPago);
                    factura.txtCodigoOperario.setText(Operario.txtCodOp.getText());
                    factura.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Forma de pago inexistente");
                    System.out.println("Forma de pago inexistente");
                }
            }
        } catch (Exception e) {
            mensaje = "El ID no existe";
        }
        return mensaje;
    }

    public void listarClientes(JTable tabla) {
        DefaultTableModel model;
        String[] titulo = {"ID_TICKET", "MATRICULA", "TIPO_VEHICULO", "PUNTOS", "ENTRADA", "SALIDA", "TIEMPO",
            "BASE_IMPONIBLE", "IVA", "VALOR_TOTAL"};
        model = new DefaultTableModel(null, titulo);
        List<Clientes> datos = cjc.findClientesEntities();
        String[] datosClientes = new String[10];
        for (Clientes o : datos) {
            datosClientes[0] = o.getIdTicket() + "";
            datosClientes[1] = o.getMatricula() + "";
            datosClientes[2] = o.getTipoVehiculo() + "";
            datosClientes[3] = o.getPuntos() + "";
            datosClientes[4] = o.getEntrada() + "";
            datosClientes[5] = o.getSalida() + "";
            datosClientes[6] = o.getTiempo() + "";
            datosClientes[7] = o.getBaseImponible() + "";
            datosClientes[8] = o.getIva() + "";
            datosClientes[9] = o.getValorTotal() + "";
            model.addRow(datosClientes);
        }
        tabla.setModel(model);
    }

    public int restarFechas(Date fechaMayor, Date fechaMenor) {
        long diferenciaEn_ms = fechaMayor.getTime() - fechaMenor.getTime();
        long Minutos = diferenciaEn_ms / (1000/*    *60    */);
        return (int) Minutos;
    }

    public boolean verificarDocumento(String documento) {
        if ((documento.toUpperCase().matches("^[0-9]{7}$")) || (documento.toUpperCase().matches("^[0-9]{8}$"))
                || (documento.toUpperCase().matches("^[0-9]{9}$")) || (documento.toUpperCase().matches("^[0-9]{10}$"))) {
            return true;
        } else {
            return false;
        }
    }

    boolean verificarPlacaCarro(String placa) {
        if (placa.toUpperCase().matches("^[A-Z]{3}[0-9]{3}$")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarPlacaMoto(String placa) {
        if (placa.toUpperCase().matches("^[A-Z]{3}[0-9]{2}[A-Z]{1}$")) {
            return true;

        } else {
            return false;
        }
    }

    public Clientes buscarClientes(BigInteger idTicket) {
        Clientes c = new Clientes();
        EntityManager em = cjc.getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Clientes c WHERE c.idTicket =:idTicket ");
            query.setParameter("idTicket", idTicket);
            c = (Clientes) query.getSingleResult();
        } catch (Exception e) {
            if (cjc.findClientes(idTicket) == null) {
                JOptionPane.showMessageDialog(null, "El id " + idTicket + " No existe!");
            }
        }
        return c;
    }

    public boolean sacarClientes(BigInteger idTicket) {
        Clientes c = new Clientes();
        boolean d = false;
        EntityManager em = cjc.getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Clientes c WHERE c.idTicket =:idTicket ");
            query.setParameter("idTicket", idTicket);
            d = true;
            c = (Clientes) query.getSingleResult();
        } catch (Exception e) {
            if (cjc.findClientes(idTicket) == null) {
                d = false;
            }
        }
        return d;
    }

    private boolean disponible(String matricula, String salida) {
        EntityManager em = cjc.getEntityManager();
        boolean valor = false;
        try {
            Query query = em.createQuery("SELECT c.matricula,c.salida FROM Clientes c WHERE c.matricula = :matricula AND c.salida = :salida");
            query.setParameter("matricula", matricula);
            query.setParameter("salida", salida);
            List resultado = query.getResultList();
            if (!resultado.isEmpty()) {
                valor = true;
            } else {
                valor = false;
            }
        } catch (Exception e) {
            valor = true;
        }
        return valor;
    }

    private int puntosFidelizacion(String matricula) {
        int puntos = 0;
        EntityManager em = cjc.getEntityManager();
        try {
            Query query = em.createQuery("SELECT MAX(c.puntos)  FROM Clientes c WHERE c.matricula =:matricula");
            query.setParameter("matricula", matricula);
            puntos = (int) query.getSingleResult();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en puntos");
        }
        return puntos;
    }

    private void ActualizacionPuntosCero(String matricula, int puntosfi) {
        EntityManager em = cjc.getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("UPDATE Clientes c SET c.puntos=0 WHERE c.matricula=:matricula AND (c.puntos <:puntosf OR c.puntos >:puntosf)");
            query.setParameter("matricula", matricula);
            query.setParameter("puntosf", puntosfi);
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en actualizacion de puntos a cero: ");
        }
    }

    private boolean Nodisponible(BigInteger idTicket, Integer tiempo) {
        EntityManager em = cjc.getEntityManager();
        boolean valor;
        try {
            Query query = em.createQuery("SELECT c.idTicket,c.tiempo FROM Clientes c WHERE c.idTicket =:idTicket AND c.tiempo = :tiempo");
            query.setParameter("idTicket", idTicket);
            query.setParameter("tiempo", tiempo);
            List resultado = query.getResultList();
            if (!resultado.isEmpty()) {
                valor = false;
            } else {
                valor = true;
            }
        } catch (Exception e) {
            valor = true;
        }
        return valor;
    }

    public Parqueadero buscarParqueadero() {
        Parqueadero pq = new Parqueadero();
        EntityManager em = pjc.getEntityManager();
        try {
            Query query = em.createQuery("SELECT pq  FROM Parqueadero pq");
            pq = (Parqueadero) query.getSingleResult();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return pq;
    }

    public Clientes ingresarClientes(String matricula, String salida) {
        Clientes c = new Clientes();
        EntityManager em = pjc.getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Clientes c WHERE c.matricula = :matricula AND c.salida = :salida");
            query.setParameter("matricula", matricula);
            query.setParameter("salida", salida);
            c = (Clientes) query.getSingleResult();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return c;
    }

    public static boolean esMinuscula(String s) {
        // Regresa el resultado de comparar la original con su versión minúscula
        return s.equals(s.toLowerCase());
    }    
    
}
