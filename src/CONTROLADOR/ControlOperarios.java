package CONTROLADOR;

import DAOS.DaoOperarios;
import ENTIDAD.Operarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlOperarios {
    private DaoOperarios ojc = new DaoOperarios();
    private Operarios operario = new Operarios();
    private String mensaje = "";
    
    
    
    public String insertarOperario(String id, String nombre, String usuario, String contrasena, int codigo){
        
            try{
            operario.setId(id);
            operario.setNombre(nombre);
            operario.setUsuario(usuario);
            operario.setContrasena(contrasena);
            operario.setCodigo(codigo);
            if(isValidId(id)==false){
                mensaje = "ID inválido";
            }else if(verificarLongitudPassword(contrasena)==false){
                mensaje = "Longitud de Contraseña incorrecta";
            }else if(verificarLongitudUsuario(usuario)==false){
                mensaje = "Longitud de Usuario incorrecta";
            }else if(verificarLongitudNombre(nombre)==false){
                mensaje = "Longitud de Nombre incorrecta";
            }else if(ojc.findOperarios(id)!=null){
                mensaje="Ya existe el operario";
            }else{
                ojc.create(operario);
                mensaje = "Guardado correctamente";
            }
            
        }catch(Exception e){
            System.out.println("Mensaje en guardar "+ e.getMessage());
            mensaje = "No se pudo guardar la información ";
        }
        return mensaje;
    }
    
    public String actualizarOperario(String id, String nombre, String usuario, String contrasena, int codigo){
        try{
            operario.setId(id);
            operario.setNombre(nombre);
            operario.setUsuario(usuario);
            operario.setContrasena(contrasena);
            operario.setCodigo(codigo);
            if(isValidId(id)==false){
                mensaje = "ID inválido";
            }else if(verificarLongitudPassword(contrasena)==false){
                mensaje = "Longitud de Contraseña incorrecta";
            }else if(verificarLongitudUsuario(usuario)==false){
                mensaje = "Longitud de Usuario incorrecta";
            }else if(verificarLongitudNombre(nombre)==false){
                mensaje = "Longitud de Nombre incorrecta";
            }else{
            ojc.edit(operario);
            mensaje = "Actualizado correctamente";
            }
        }catch(Exception e){
            System.out.println("Mensaje en actualizar. "+ e.getMessage());
            mensaje = "No se pudo actualizar la información \n" + e.getMessage();
        }
        return mensaje;
        
    }
    
    public String eliminarOperario(String id){
        try{
            ojc.destroy(id);
            mensaje = "Eliminado correctamente";
        }catch(Exception e){
            System.out.println("Mensaje en eliminar. "+ e.getMessage());
            mensaje = "No se pudo eliminar la información \n" + e.getMessage();
        }
        return mensaje;
    }
    
    public void listarOperarios(JTable tabla, String nombre){
        DefaultTableModel model;
        String [] titulo = {"ID","NOMBRE","USUARIO","CONTRASENA","CODIGO"};
        model = new DefaultTableModel(null, titulo);
        
        List<Operarios> datos = buscarOperario(nombre);
        
        String [] datosOperarios = new String[5];
        for(Operarios o : datos){
            datosOperarios[0] = o.getId()+"";
            datosOperarios[1] = o.getNombre()+"";
            datosOperarios[2] = o.getUsuario()+"";
            datosOperarios[3] = o.getContrasena()+""; 
            datosOperarios[4] = o.getCodigo()+"";
            model.addRow(datosOperarios);
        }
        tabla.setModel(model);
    }
    
    private List<Operarios> buscarOperario(String nombre){
        Operarios o;
        EntityManager em = ojc.getEntityManager();
        Query query = em.createQuery("SELECT o FROM Operarios o WHERE o.nombre LIKE :nombre ");
        query.setParameter("nombre", nombre+"%");
        List<Operarios> lista = query.getResultList();
        return lista;
    }
    
    public Operarios buscarOperarioId(String id){
        Operarios o = new Operarios();
        String mensaje = "";
        EntityManager em = ojc.getEntityManager();
        try {
            Query query = em.createQuery("SELECT o FROM Operarios o WHERE o.id = :id");
            query.setParameter("id", id);
            o = (Operarios) query.getSingleResult();
            JOptionPane.showMessageDialog(null, "Búsqueda exitosa"); 
        } catch (Exception e) {
            if(ojc.findOperarios(id)==null){
                mensaje = "El operario con ID " + id + " No existe";
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }
        return o;   
    }
    
        public Operarios buscarOperarioUsuario(String usuario){
        Operarios o = new Operarios();
        String mensaje = "";
        EntityManager em = ojc.getEntityManager();
        try {
            Query query = em.createQuery("SELECT o FROM Operarios o WHERE o.usuario LIKE :usuario");
            query.setParameter("usuario", usuario);
            o = (Operarios) query.getSingleResult();
            //JOptionPane.showMessageDialog(null, "Búsqueda exitosa"); 
        } catch (Exception e) {
            if(ojc.findOperarios(usuario)==null){
                mensaje = "El operario con ID " + usuario + " No existe";
                //JOptionPane.showMessageDialog(null, mensaje);
            }
        }
        return o;   
    }
    
    public boolean loginOperario (String usuario, String contrasena){
        EntityManager em = ojc.getEntityManager();
        boolean valor;
        try {
            Query query = em.createQuery("SELECT o.usuario, o.contrasena FROM Operarios o WHERE o.usuario = :usuario AND o.contrasena = :contrasena");
            query.setParameter("usuario",usuario);
            query.setParameter("contrasena",contrasena);
            List resultado = query.getResultList();
            if(!resultado.isEmpty()){
                valor = true;
            }else{
                valor = false;           
            }
        } catch (Exception e) {
            valor = false;
        }
        return valor;
    }
    
    private Boolean isDigit(char c){
        String digits="1234567890";
        for(int i=0;i<10;i++)
            if(digits.charAt(i)==c)
               return true;
        return false;
    }
    private Boolean isValidId(String nit){
        if(nit.length()>10||nit.length()<7){
            return false;
        }
        for (int i = 0; i < nit.length(); i++) {
            if(!isDigit(nit.charAt(i)))
                return false;
        }    
        return true;
        
    }
    
    public boolean verificarLongitudNombre (String nombre){
        return (nombre.length()>1 && nombre.length()<=45);
    }
    
    public boolean verificarLongitudUsuario (String usuario){
        return (usuario.length()>1 && usuario.length()<=20);
    }
    
    public boolean verificarLongitudPassword (String password){
        return (password.length()>=4 && password.length()<=20);
    }
    
}
