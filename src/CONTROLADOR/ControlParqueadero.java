package CONTROLADOR;

import DAOS.DaoParqueadero;
import ENTIDAD.Parqueadero;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlParqueadero {
    private DaoParqueadero pjc = new DaoParqueadero();
    private Parqueadero parqueadero = new Parqueadero();
    private String mensaje = "";
    public String nitparqueadero;
    
    
    public String insertarParqueadero(String nit, String razonSocial, String regimen,
            String direccion, String telefono, 
            String poliza, String tipoParqueadero, double tarifaAutomovil, 
            double tarifaMoto, double tarifaBicicleta){
        try{
            parqueadero.setNit(nit);
            parqueadero.setRazonSocial(razonSocial);
            parqueadero.setRegimen(regimen);
            parqueadero.setDireccion(direccion);
            parqueadero.setTelefono(telefono);
            parqueadero.setPoliza(poliza);
            parqueadero.setTipoParqueadero(tipoParqueadero);
            parqueadero.setTarifaAutomovil(tarifaAutomovil);
            parqueadero.setTarifaMoto(tarifaMoto);
            parqueadero.setTarifaBicicleta(tarifaBicicleta);
            nitparqueadero = parqueadero.getNit();
            if(isValidNit(nit)==false){
                mensaje="NIT inválido";
            }else if(isValidTelphone(telefono)==false){
                mensaje="Teléfono inválido";  
            }else if(parqueadero.getTipoParqueadero().equals("En altura o subterráneo con dos o más niveles")){
                if ((parqueadero.getTarifaAutomovil()> 110) || (parqueadero.getTarifaMoto()>77) || (parqueadero.getTarifaBicicleta()> 10)) {
                    mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                + "110 COP Automovil\n"
                                + "77 COP Motocicleta\n"
                                + "10 COP bicicleta";
                }else{
                    pjc.create(parqueadero);
                    
                    mensaje = "Parqueadero guardado correctamente";
                }
            }else if(parqueadero.getTipoParqueadero().equals("Subterráneo, un solo nivel y 50 cupos o más")){
                if ((parqueadero.getTarifaAutomovil()> 99) || (parqueadero.getTarifaMoto()>69) || (parqueadero.getTarifaBicicleta()> 10)) {
                    mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                + "99 COP Automovil\n"
                                + "69 COP Motocicleta\n"
                                + "10 COP bicicleta";
                }else{
                    pjc.create(parqueadero);
                    mensaje = "Parqueadero guardado correctamente";
                }  
            }else if(parqueadero.getTipoParqueadero().equals("Subterráneo, un solo nivel con menos de 50 cupos")){
                if ((parqueadero.getTarifaAutomovil()> 88) || (parqueadero.getTarifaMoto()>62) || (parqueadero.getTarifaBicicleta()> 10)) {
                    mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                + "88 COP Automovil\n"
                                + "62 COP Motocicleta\n"
                                + "10 COP bicicleta";
                }else{
                    pjc.create(parqueadero);
                    mensaje = "Parqueadero guardado correctamente";
                }
            }else if(parqueadero.getTipoParqueadero().equals("A nivel, piso en concreto, asfalto o gravilla lavada de rio compactada, y con 50 cupos o más")){
                if ((parqueadero.getTarifaAutomovil()> 77) || (parqueadero.getTarifaMoto()>54) || (parqueadero.getTarifaBicicleta()> 10)) {
                    mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                + "77 COP Automovil\n"
                                + "54 COP Motocicleta\n"
                                + "10 COP bicicleta";
                }else{
                    pjc.create(parqueadero);
                    mensaje = "Parqueadero guardado correctamente";
                }
            }else if(parqueadero.getTipoParqueadero().equals("A nivel, piso en concreto, asfalto o gravilla lavada de rio compactada, y con menos de 50 cupos")){
                if ((parqueadero.getTarifaAutomovil()> 66) || (parqueadero.getTarifaMoto()>46) || (parqueadero.getTarifaBicicleta()> 10)) {
                    mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                + "66 COP Automovil\n"
                                + "46 COP Motocicleta\n"
                                + "10 COP bicicleta";
                }else{
                    pjc.create(parqueadero);
                    mensaje = "Parqueadero guardado correctamente";
                }
            }else if(parqueadero.getTipoParqueadero().equals("A nivel, pisos en afirmado o césped")){
                if ((parqueadero.getTarifaAutomovil()> 55) || (parqueadero.getTarifaMoto()>39) || (parqueadero.getTarifaBicicleta()> 10)) {
                    mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                + "55 COP Automovil\n"
                                + "39 COP Motocicleta\n"
                                + "10 COP bicicleta";
                }else{
                    pjc.create(parqueadero);
                    mensaje = "Parqueadero guardado correctamente";
                }
            }
        }catch(Exception e){
            System.out.println("Mensaje en guardar parqueadero "+ e.getMessage());
            mensaje = "No se pudo guardar la información del parqueadero ";
        }
        return mensaje;
    }
    
    public String actualizarParqueadero(String nit, String razonSocial, String regimen, String direccion, String telefono, 
                String poliza, String tipoParqueadero, double tarifaAutomovil, double tarifaMoto, double tarifaBicicleta){
            try{
                parqueadero.setNit(nit);
                parqueadero.setRazonSocial(razonSocial);
                parqueadero.setRegimen(regimen);
                parqueadero.setDireccion(direccion);
                parqueadero.setTelefono(telefono);
                parqueadero.setPoliza(poliza);
                parqueadero.setTipoParqueadero(tipoParqueadero);
                parqueadero.setTarifaAutomovil(tarifaAutomovil);
                parqueadero.setTarifaMoto(tarifaMoto);
                parqueadero.setTarifaBicicleta(tarifaBicicleta);
                if(isValidNit(nit)==false){
                mensaje="NIT inválido";
                }else if(isValidTelphone(telefono)==false){
                    mensaje="Teléfono inválido";  
                }else if(parqueadero.getTipoParqueadero().equals("En altura o subterráneo con dos o más niveles")){
                    if ((parqueadero.getTarifaAutomovil()> 110) || (parqueadero.getTarifaMoto()>77) || (parqueadero.getTarifaBicicleta()> 10)) {
                        mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                    + "110 COP Automovil\n"
                                    + "77 COP Motocicleta\n"
                                    + "10 COP bicicleta";
                    }else{
                        pjc.edit(parqueadero);
                        mensaje = "Parqueadero actualizado correctamente";
                    }
                }else if(parqueadero.getTipoParqueadero().equals("Subterráneo, un solo nivel y 50 cupos o más")){
                    if ((parqueadero.getTarifaAutomovil()> 99) || (parqueadero.getTarifaMoto()>69) || (parqueadero.getTarifaBicicleta()> 10)) {
                        mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                    + "99 COP Automovil\n"
                                    + "69 COP Motocicleta\n"
                                    + "10 COP bicicleta";
                    }else{
                        pjc.edit(parqueadero);
                        mensaje = "Parqueadero actualizado correctamente";
                    }  
                }else if(parqueadero.getTipoParqueadero().equals("Subterráneo, un solo nivel con menos de 50 cupos")){
                    if ((parqueadero.getTarifaAutomovil()> 88) || (parqueadero.getTarifaMoto()>62) || (parqueadero.getTarifaBicicleta()> 10)) {
                        mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                    + "88 COP Automovil\n"
                                    + "62 COP Motocicleta\n"
                                    + "10 COP bicicleta";
                    }else{
                        pjc.edit(parqueadero);
                        mensaje = "Parqueadero actualizado correctamente";
                    }
                }else if(parqueadero.getTipoParqueadero().equals("A nivel, piso en concreto, asfalto o gravilla lavada de rio compactada, y con 50 cupos o más")){
                    if ((parqueadero.getTarifaAutomovil()> 77) || (parqueadero.getTarifaMoto()>54) || (parqueadero.getTarifaBicicleta()> 10)) {
                        mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                    + "77 COP Automovil\n"
                                    + "54 COP Motocicleta\n"
                                    + "10 COP bicicleta";
                    }else{
                        pjc.edit(parqueadero);
                        mensaje = "Parqueadero actualizado correctamente";
                    }
                }else if(parqueadero.getTipoParqueadero().equals("A nivel, piso en concreto, asfalto o gravilla lavada de rio compactada, y con menos de 50 cupos")){
                    if ((parqueadero.getTarifaAutomovil()> 66) || (parqueadero.getTarifaMoto()>46) || (parqueadero.getTarifaBicicleta()> 10)) {
                        mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                    + "66 COP Automovil\n"
                                    + "46 COP Motocicleta\n"
                                    + "10 COP bicicleta";
                    }else{
                        pjc.edit(parqueadero);
                        mensaje = "Parqueadero actualizado correctamente";
                    }
                }else if(parqueadero.getTipoParqueadero().equals("A nivel, pisos en afirmado o césped")){
                    if ((parqueadero.getTarifaAutomovil()> 55) || (parqueadero.getTarifaMoto()>39) || (parqueadero.getTarifaBicicleta()> 10)) {
                        mensaje = "El precio suministrado, ha excedido el precio legal maximo.\n"
                                    + "55 COP Automovil\n"
                                    + "39 COP Motocicleta\n"
                                    + "10 COP bicicleta";
                    }else{
                        pjc.edit(parqueadero);
                        mensaje = "Parqueadero actualizado correctamente";
                    }
                }
            }catch(Exception e){
                System.out.println("Mensaje en actualizar parqueadero "+ e.getMessage());
                mensaje = "No se pudo actualizar la información del parqueadero ";
            }
        return mensaje;
    }
    
        public void listarParqueadero(JTable tabla){
        DefaultTableModel model;
        String [] titulo = {"NIT","RAZON_SOCIAL","REGIMEN","DIRECCION","TELEFONO",
            "POLIZA","TIPO_PARQUEADERO","TARIFA_AUTOMOVIL","TARIFA_MOTO","TARIFA_BICICLETA"};
        model = new DefaultTableModel(null, titulo);
        
        List<Parqueadero> datos = pjc.findParqueaderoEntities();
        
        String [] datosParqueadero = new String[10];
        for(Parqueadero p : datos){
            datosParqueadero[0] = p.getNit()+"";
            datosParqueadero[1] = p.getRazonSocial()+"";
            datosParqueadero[2] = p.getRegimen()+"";
            datosParqueadero[3] = p.getDireccion()+"";
            datosParqueadero[4] = p.getTelefono()+"";
            datosParqueadero[5] = p.getPoliza()+"";
            datosParqueadero[6] = p.getTipoParqueadero()+"";
            datosParqueadero[7] = p.getTarifaAutomovil()+"";
            datosParqueadero[8] = p.getTarifaMoto()+"";
            datosParqueadero[9] = p.getTarifaBicicleta()+"";
            model.addRow(datosParqueadero);
        }
        tabla.setModel(model);
    } 
    
    private boolean isDigit(char c){
        String digits="1234567890";
        for(int i=0;i<10;i++)
            if(digits.charAt(i)==c)
               return true;
        return false;
    }
    
    private boolean isValidNit(String nit){
        if(nit.length()!=10){
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if(!isDigit(nit.charAt(i)))
                return false;
        }    
        return true;    
    }
    
    private boolean isValidTelphone(String tel){
        if(tel.length()<7 || tel.length()>10)
            return false;
        for(int i=0;i<tel.length();i++)
               if(!isDigit(tel.charAt(i)))
                   return false;
        return true;
        
    }
    
}
