package FRONTERA;

import CONTROLADOR.ControlParqueadero;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class CrearParqueadero extends javax.swing.JFrame {

    private ControlParqueadero pdao = new ControlParqueadero();
    
    public CrearParqueadero() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Parqueadero");
        Toolkit t= Toolkit.getDefaultToolkit();
        setIconImage(t.getImage(getClass().getResource("/FRONTERA/favicon.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbRegimen = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbTipoParqueadero = new javax.swing.JComboBox();
        txtPoliza = new javax.swing.JTextField();
        txtTarifaBicicleta = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNIT = new javax.swing.JTextField();
        txtTarifaAutomovil = new javax.swing.JTextField();
        txtTarifaMoto = new javax.swing.JTextField();
        btnCrearParqueadero = new javax.swing.JButton();
        lblicono = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PARQUEADERO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tarifa Bicicleta");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo de Parqueadero");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        cbRegimen.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        cbRegimen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Comun", "Simplificado" }));
        jPanel1.add(cbRegimen, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 250, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Régimen");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Dirección");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Teléfono");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No. Póliza");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        cbTipoParqueadero.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        cbTipoParqueadero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "En altura o subterráneo con dos o más niveles", "Subterráneo, un solo nivel y 50 cupos o más", "Subterráneo, un solo nivel con menos de 50 cupos", "A nivel, piso en concreto, asfalto o gravilla lavada de rio compactada, y con 50 cupos o más", "A nivel, piso en concreto, asfalto o gravilla lavada de rio compactada, y con menos de 50 cupos", "A nivel, pisos en afirmado o césped" }));
        cbTipoParqueadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoParqueaderoActionPerformed(evt);
            }
        });
        jPanel1.add(cbTipoParqueadero, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 610, -1));

        txtPoliza.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jPanel1.add(txtPoliza, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 250, -1));

        txtTarifaBicicleta.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtTarifaBicicleta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTarifaBicicletaKeyTyped(evt);
            }
        });
        jPanel1.add(txtTarifaBicicleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 190, -1));

        txtRazonSocial.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jPanel1.add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 250, -1));

        txtDireccion.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 250, -1));

        txtTelefono.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 250, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Razon Social");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NIT");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tarifa Automóvil");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tarifa Motocicleta");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));

        txtNIT.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtNIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNITKeyTyped(evt);
            }
        });
        jPanel1.add(txtNIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 250, -1));

        txtTarifaAutomovil.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtTarifaAutomovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTarifaAutomovilKeyTyped(evt);
            }
        });
        jPanel1.add(txtTarifaAutomovil, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 190, -1));

        txtTarifaMoto.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtTarifaMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTarifaMotoActionPerformed(evt);
            }
        });
        txtTarifaMoto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTarifaMotoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTarifaMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 190, -1));

        btnCrearParqueadero.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnCrearParqueadero.setText("Crear Parqueadero");
        btnCrearParqueadero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearParqueaderoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearParqueaderoMouseExited(evt);
            }
        });
        btnCrearParqueadero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearParqueaderoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearParqueadero, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 190, -1));

        lblicono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTERA/logotipo.png"))); // NOI18N
        jPanel1.add(lblicono, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 100, -1));

        btnMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnMinimizar.setForeground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTERA/btnminimizar.png"))); // NOI18N
        btnMinimizar.setBorder(null);
        btnMinimizar.setBorderPainted(false);
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMinimizar.setOpaque(false);
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseExited(evt);
            }
        });
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        btnMinimizar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                btnMinimizarPropertyChange(evt);
            }
        });
        jPanel1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 20, 20));

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTERA/btncerrar.png"))); // NOI18N
        btnCerrar.setBorder(null);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setOpaque(false);
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarMouseExited(evt);
            }
        });
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 20, -1));

        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTERA/fondo4.jpg"))); // NOI18N
        jPanel1.add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 810, 330));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 810, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearParqueaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearParqueaderoActionPerformed
        String mensaje = "";
        if(txtNIT.getText().equals("")||txtRazonSocial.getText().equals("")||txtDireccion.getText().equals("")||
                txtTelefono.getText().equals("")||txtPoliza.getText().equals("")||txtTarifaAutomovil.getText().equals("")||
                txtTarifaMoto.getText().equals("")||txtTarifaBicicleta.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        }else{
            String nit = txtNIT.getText();
            String razonSocial = txtRazonSocial.getText();
            String regimen = cbRegimen.getSelectedItem().toString();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            String poliza = txtPoliza.getText();
            String tipoParqueadero = cbTipoParqueadero.getSelectedItem().toString();
            double tarifaAutomovil = Double.parseDouble(txtTarifaAutomovil.getText());
            double tarifaMoto = Double.parseDouble(txtTarifaMoto.getText());
            double tarifaBicicleta = Double.parseDouble(txtTarifaBicicleta.getText());
            mensaje = pdao.insertarParqueadero(nit, razonSocial, regimen, direccion, telefono, 
                        poliza, tipoParqueadero, tarifaAutomovil, tarifaMoto, tarifaBicicleta);
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if(mensaje=="Parqueadero guardado correctamente"){
            LoginAdmin la = new LoginAdmin();
            la.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnCrearParqueaderoActionPerformed

    private void txtNITKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNITKeyTyped
        char c = evt.getKeyChar();
        if(c<'0'|| c>'9'){
            evt.consume();
        }
    }//GEN-LAST:event_txtNITKeyTyped

    private void cbTipoParqueaderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoParqueaderoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoParqueaderoActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if(c<'0'|| c>'9'){
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTarifaAutomovilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarifaAutomovilKeyTyped
        char c = evt.getKeyChar();
        if(c!='.'&& (c<'0'||c>'9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtTarifaAutomovilKeyTyped

    private void txtTarifaMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTarifaMotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTarifaMotoActionPerformed

    private void txtTarifaMotoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarifaMotoKeyTyped
        char c = evt.getKeyChar();
        if(c!='.'&& (c<'0'||c>'9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtTarifaMotoKeyTyped

    private void txtTarifaBicicletaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarifaBicicletaKeyTyped
        char c = evt.getKeyChar();
        if(c!='.'&& (c<'0'||c>'9')){
            evt.consume();
        }
    }//GEN-LAST:event_txtTarifaBicicletaKeyTyped

    private void btnCrearParqueaderoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearParqueaderoMouseEntered
        btnCrearParqueadero.setBackground(new Color(255,204,0));
    }//GEN-LAST:event_btnCrearParqueaderoMouseEntered

    private void btnCrearParqueaderoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearParqueaderoMouseExited
        btnCrearParqueadero.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_btnCrearParqueaderoMouseExited

    private void btnMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseEntered
        btnMinimizar.setBackground(new Color(255,204,0));
    }//GEN-LAST:event_btnMinimizarMouseEntered

    private void btnMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseExited
        btnMinimizar.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_btnMinimizarMouseExited

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnMinimizarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_btnMinimizarPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMinimizarPropertyChange

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        btnCerrar.setBackground(new Color(255,204,0));
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        btnCerrar.setBackground(new Color(240,240,240));
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed
 
    private void limpiar(){
        txtNIT.setText("");
        txtRazonSocial.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtPoliza.setText("");
        txtTarifaAutomovil.setText("");
        txtTarifaMoto.setText("");
        txtTarifaBicicleta.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
//          try {
//              UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearParqueadero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearParqueadero;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JComboBox cbRegimen;
    private javax.swing.JComboBox cbTipoParqueadero;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JLabel lblicono;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNIT;
    private javax.swing.JTextField txtPoliza;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTarifaAutomovil;
    private javax.swing.JTextField txtTarifaBicicleta;
    private javax.swing.JTextField txtTarifaMoto;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
