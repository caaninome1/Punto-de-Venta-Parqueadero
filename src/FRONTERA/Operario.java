package FRONTERA;

import CONTROLADOR.ControlClientes;
import ENTIDAD.Clientes;
import java.awt.Color;
import java.awt.Toolkit;
import java.math.BigInteger;
import java.sql.Timestamp;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

public class Operario extends javax.swing.JFrame {

    private final ControlClientes cdao = new ControlClientes();
    private int x;
    private int y;

    public Operario() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("OPERARIO");
        mostrarTabla();
        Toolkit t = Toolkit.getDefaultToolkit();
        setIconImage(t.getImage(getClass().getResource("/FRONTERA/favicon.png")));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnIngreso = new javax.swing.JButton();
        btnSalida = new javax.swing.JButton();
        cbTipoVehiculo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtIdTicket = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnBuscarIdTicket = new javax.swing.JButton();
        txtValorTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        LValorTotal = new javax.swing.JLabel();
        txtFechaEntrada = new javax.swing.JTextField();
        txtFechaSalida = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtBaseImponible = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClienteDatos = new javax.swing.JTable();
        Puntos = new javax.swing.JLabel();
        txtPuntos = new javax.swing.JTextField();
        txtIVA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JTextField();
        cbformaPago = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnMinimizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblSuperior = new javax.swing.JLabel();
        lblicono = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodOp = new javax.swing.JTextField();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INGRESO Y SALIDA DE CLIENTES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 360, -1));

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseExited(evt);
            }
        });
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 170, 30));

        btnIngreso.setBackground(new java.awt.Color(153, 255, 0));
        btnIngreso.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        btnIngreso.setText("INGRESO");
        btnIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresoMouseExited(evt);
            }
        });
        btnIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 170, 40));

        btnSalida.setBackground(new java.awt.Color(0, 204, 255));
        btnSalida.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        btnSalida.setText("SALIDA");
        btnSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalidaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalidaMouseExited(evt);
            }
        });
        btnSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 170, 40));

        cbTipoVehiculo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        cbTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Automovil", "Motocicleta", "Bicicleta" }));
        jPanel1.add(cbTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 140, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Matrícula");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtMatricula.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        txtMatricula.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyTyped(evt);
            }
        });
        jPanel1.add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 81, 130, 30));

        txtIdTicket.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        txtIdTicket.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIdTicket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdTicketKeyTyped(evt);
            }
        });
        jPanel1.add(txtIdTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 130, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Id Ticket");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 80, 30));

        btnLimpiar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseExited(evt);
            }
        });
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 140, 30));

        btnBuscarIdTicket.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        btnBuscarIdTicket.setText("Buscar");
        btnBuscarIdTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarIdTicketMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarIdTicketMouseExited(evt);
            }
        });
        btnBuscarIdTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIdTicketActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarIdTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 140, 30));

        txtValorTotal.setEditable(false);
        txtValorTotal.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtValorTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorTotalActionPerformed(evt);
            }
        });
        jPanel1.add(txtValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 310, 180, 25));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha Entrada");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 100, 20));

        LValorTotal.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        LValorTotal.setForeground(new java.awt.Color(255, 255, 255));
        LValorTotal.setText("Valor TOTAL ($)");
        jPanel1.add(LValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, -1, 20));

        txtFechaEntrada.setEditable(false);
        txtFechaEntrada.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        txtFechaEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtFechaEntrada.setToolTipText("");
        txtFechaEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtFechaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaEntradaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 180, 25));

        txtFechaSalida.setEditable(false);
        txtFechaSalida.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        txtFechaSalida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 180, 25));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha Salida");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 90, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Base Imponible");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 110, 20));

        txtBaseImponible.setEditable(false);
        txtBaseImponible.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtBaseImponible.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtBaseImponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 180, 25));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("IVA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 40, 20));

        tbClienteDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbClienteDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClienteDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClienteDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 900, 140));

        Puntos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        Puntos.setForeground(new java.awt.Color(255, 255, 255));
        Puntos.setText("Puntos");
        jPanel1.add(Puntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 70, 20));

        txtPuntos.setEditable(false);
        txtPuntos.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtPuntos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtPuntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 180, 25));

        txtIVA.setEditable(false);
        txtIVA.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtIVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, 180, 25));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tiempo (min)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, -1));

        txtTiempo.setEditable(false);
        txtTiempo.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        txtTiempo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(txtTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 180, 25));

        cbformaPago.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        cbformaPago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Efectivo", "T. Crédito", "T. Débito", "Puntos" }));
        jPanel1.add(cbformaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 140, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 580, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 580, 10));

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
        jPanel1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 20, 20));

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
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 20, -1));

        lblSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblSuperiorMouseDragged(evt);
            }
        });
        lblSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblSuperiorMousePressed(evt);
            }
        });
        jPanel1.add(lblSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 30));

        lblicono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTERA/logotipo.png"))); // NOI18N
        jPanel1.add(lblicono, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 510, 100, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Código de Operario");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, 20));

        txtCodOp.setEditable(false);
        txtCodOp.setBackground(new java.awt.Color(27, 32, 36));
        txtCodOp.setForeground(new java.awt.Color(255, 255, 255));
        txtCodOp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodOp.setBorder(null);
        txtCodOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodOpActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 30, 20));

        lblFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FRONTERA/fondo4.jpg"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoActionPerformed
        String mensaje = "";
        if (txtMatricula.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una matrícula");
        } else {
            String matricula = txtMatricula.getText();
            String tipoVehiculo = cbTipoVehiculo.getSelectedItem().toString();
            mensaje = cdao.ingresoCliente(matricula, tipoVehiculo);
            JOptionPane.showMessageDialog(null, mensaje);
        }
        if (mensaje == "Ingresado correctamente") {
            mostrarTabla();
            limpiar();
        }
    }//GEN-LAST:event_btnIngresoActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        FramePrincipal fp = new FramePrincipal();
        fp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaActionPerformed
        String mensaje = "";
        if (txtIdTicket.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un ID Ticket!");
        } else if ((cdao.sacarClientes(new BigInteger(txtIdTicket.getText()))) == false) {
            JOptionPane.showMessageDialog(null, "¡El id no existe!");
            limpiar();
        } else {
            BigInteger IdTicket = new BigInteger(txtIdTicket.getText());
            String formaPago = cbformaPago.getSelectedItem().toString();
            mensaje = cdao.salidaCliente(IdTicket, formaPago);
            JOptionPane.showMessageDialog(null, mensaje);
            mostrarTabla();
            limpiar();
        }
    }//GEN-LAST:event_btnSalidaActionPerformed

    private void txtValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorTotalActionPerformed

    }//GEN-LAST:event_txtValorTotalActionPerformed

    private void tbClienteDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClienteDatosMouseClicked
        int select = tbClienteDatos.getSelectedRow();
        txtIdTicket.setText(tbClienteDatos.getValueAt(select, 0) + "");
        txtMatricula.setText(tbClienteDatos.getValueAt(select, 1) + "");
        cbTipoVehiculo.setSelectedItem(tbClienteDatos.getValueAt(select, 2) + "");
        txtPuntos.setText(tbClienteDatos.getValueAt(select, 3) + "");
        //txtEstado.setText(tbClienteDatos.getValueAt(select, 5)+"");
        txtFechaEntrada.setText(tbClienteDatos.getValueAt(select, 4) + "");
        txtFechaSalida.setText(tbClienteDatos.getValueAt(select, 5) + "");
        txtTiempo.setText(tbClienteDatos.getValueAt(select, 6) + "");
        txtBaseImponible.setText(tbClienteDatos.getValueAt(select, 7) + "");
        txtIVA.setText(tbClienteDatos.getValueAt(select, 8) + "");
        txtValorTotal.setText(tbClienteDatos.getValueAt(select, 9) + "");
    }//GEN-LAST:event_tbClienteDatosMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtFechaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaEntradaActionPerformed

    private void txtMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyTyped

    }//GEN-LAST:event_txtMatriculaKeyTyped

    private void txtMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyReleased
        txtMatricula.setText(txtMatricula.getText().toUpperCase());
    }//GEN-LAST:event_txtMatriculaKeyReleased

    private void btnBuscarIdTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIdTicketActionPerformed
        if (txtIdTicket.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo Id Ticket está vacío");
        } else {
            Clientes c = cdao.buscarClientes(new BigInteger(txtIdTicket.getText()));
            txtMatricula.setText(c.getMatricula());
            txtPuntos.setText(c.getPuntos() + "");
            txtTiempo.setText(c.getTiempo() + "");
            txtFechaEntrada.setText(c.getEntrada());
            txtFechaSalida.setText(c.getSalida());
            txtBaseImponible.setText(c.getBaseImponible() + "");
            txtIVA.setText(c.getIva() + "");
            txtValorTotal.setText(c.getValorTotal() + "");
        }
    }//GEN-LAST:event_btnBuscarIdTicketActionPerformed

    private void txtIdTicketKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdTicketKeyTyped
        char c = evt.getKeyChar();

        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_txtIdTicketKeyTyped

    private void btnMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseEntered
        btnMinimizar.setBackground(new Color(255, 204, 0));
    }//GEN-LAST:event_btnMinimizarMouseEntered

    private void btnMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseExited
        btnMinimizar.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_btnMinimizarMouseExited

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnMinimizarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_btnMinimizarPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMinimizarPropertyChange

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        btnCerrar.setBackground(new Color(255, 204, 0));
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        btnCerrar.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void lblSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuperiorMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_lblSuperiorMouseDragged

    private void lblSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSuperiorMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_lblSuperiorMousePressed

    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        btnLimpiar.setBackground(new Color(255, 204, 0));
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseEntered
        btnCerrarSesion.setBackground(new Color(255, 204, 0));
    }//GEN-LAST:event_btnCerrarSesionMouseEntered

    private void btnBuscarIdTicketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarIdTicketMouseEntered
        btnBuscarIdTicket.setBackground(new Color(255, 204, 0));
    }//GEN-LAST:event_btnBuscarIdTicketMouseEntered

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        btnLimpiar.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_btnLimpiarMouseExited

    private void btnCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseExited
        btnCerrarSesion.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_btnCerrarSesionMouseExited

    private void btnBuscarIdTicketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarIdTicketMouseExited
        btnBuscarIdTicket.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_btnBuscarIdTicketMouseExited

    private void btnIngresoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresoMouseExited
        btnIngreso.setBackground(new Color(153, 255, 0));
    }//GEN-LAST:event_btnIngresoMouseExited

    private void btnSalidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidaMouseExited
        btnSalida.setBackground(new Color(0, 204, 255));
    }//GEN-LAST:event_btnSalidaMouseExited

    private void btnIngresoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresoMouseEntered
        btnIngreso.setBackground(new Color(51, 255, 51));
    }//GEN-LAST:event_btnIngresoMouseEntered

    private void btnSalidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalidaMouseEntered
        btnSalida.setBackground(new Color(153, 255, 255));
    }//GEN-LAST:event_btnSalidaMouseEntered

    private void txtCodOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodOpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodOpActionPerformed
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     */
    public void limpiar() {
        txtIdTicket.setText("");
        txtMatricula.setText("");
        txtPuntos.setText("");
        txtTiempo.setText("");
        txtFechaEntrada.setText("");
        txtFechaSalida.setText("");
        txtBaseImponible.setText("");
        txtIVA.setText("");
        txtValorTotal.setText("");
    }

    private void mostrarTabla() {
        cdao.listarClientes(tbClienteDatos);
    }

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
            java.util.logging.Logger.getLogger(Operario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Operario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Operario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Operario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Operario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LValorTotal;
    private javax.swing.JLabel Puntos;
    private javax.swing.JButton btnBuscarIdTicket;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnIngreso;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSalida;
    private javax.swing.JComboBox cbTipoVehiculo;
    public static javax.swing.JComboBox cbformaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblSuperior;
    private javax.swing.JLabel lblicono;
    private javax.swing.JTable tbClienteDatos;
    private javax.swing.JTextField txtBaseImponible;
    public static javax.swing.JTextField txtCodOp;
    private javax.swing.JTextField txtFechaEntrada;
    private javax.swing.JTextField txtFechaSalida;
    private javax.swing.JTextField txtIVA;
    public static javax.swing.JTextField txtIdTicket;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtPuntos;
    private javax.swing.JTextField txtTiempo;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables
}
