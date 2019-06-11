/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAQ_BIBLIOTECA;

import Logica.ConexionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ELVIS
 */
public class Registrar_Usuario extends javax.swing.JFrame {

    /**
     * Creates new form Registrar_Usuario
     */
    public Registrar_Usuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrardatos("");
        bloquear();
        ocultar();
        btneditar.setEnabled(false);
    }

    void bloquear() {
        txtid.setEnabled(false);
        txtusuario.setEnabled(false);
        passw.setEnabled(false);
        cbselec.setEnabled(false);
        btnregistrar.setEnabled(false);
        btneliminar.setEnabled(false);
        btnaceptar.setEnabled(false);
        passwelim.setEnabled(false);

        passwelim.setText("");
        txtid.setText("");
        txtusuario.setText("");
        passw.setText("");
        cbselec.setSelectedIndex(0);
    }

    void habilitar() {
        txtid.setEnabled(true);
        txtusuario.setEnabled(true);
        passw.setEnabled(true);
        cbselec.setEnabled(true);
        btnregistrar.setEnabled(true);

    }

    void habilitar2() {
        btneditar.setEnabled(true);
        txtid.setEnabled(true);
        txtusuario.setEnabled(true);
        passw.setEnabled(true);
        cbselec.setEnabled(true);

    }

    void bloquear2() {
        btneditar.setEnabled(false);
        txtid.setEnabled(false);
        txtusuario.setEnabled(false);
        passw.setEnabled(false);
        cbselec.setEnabled(false);

        passwelim.setText("");
        txtid.setText("");
        txtusuario.setText("");
        passw.setText("");
        cbselec.setSelectedIndex(0);
    }

    void ocultar() {
        tablausuario.getColumnModel().getColumn(2).setMaxWidth(2);
        tablausuario.getColumnModel().getColumn(2).setMinWidth(2);
        tablausuario.getColumnModel().getColumn(2).setPreferredWidth(2);

    }

    String id = "";

    ConexionMysql cc = new ConexionMysql();
    Connection cn = cc.conexion();

    public Integer totalregistros;

    void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Usuario");
        modelo.addColumn("Password");
        modelo.addColumn("Tipo de Usuario");

        tablausuario.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM Usuario";
        } else {
            sql = "SELECT * FROM Usuario WHERE (id='" + valor + "' OR usuario='" + valor + "')";
        }
        String[] datos = new String[4];
        totalregistros = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("Usuarios Registrados: " + Integer.toString(totalregistros));
            }
            tablausuario.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuEditar = new javax.swing.JMenuItem();
        btneliminar = new javax.swing.JButton();
        btnaceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        passw = new javax.swing.JPasswordField();
        cbselec = new javax.swing.JComboBox();
        btnregistrar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        passwelim = new javax.swing.JPasswordField();
        lbltotalregistros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablausuario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        btnmostrar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();

        menuEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuEditar.setForeground(new java.awt.Color(204, 102, 0));
        menuEditar.setText("Editar");
        menuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEditar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btneliminar.setBackground(new java.awt.Color(255, 255, 0));
        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnaceptar.setBackground(new java.awt.Color(255, 255, 0));
        btnaceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Id:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("Password:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Tipo de Usuario:");

        cbselec.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbselec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "seleccionar:", "ADMINISTRADOR", "INVITADO" }));

        btnregistrar.setBackground(new java.awt.Color(255, 255, 0));
        btnregistrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardarR.png"))); // NOI18N
        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(255, 255, 0));
        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnregistrar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(passw, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbselec, javax.swing.GroupLayout.Alignment.LEADING, 0, 130, Short.MAX_VALUE)
                                .addComponent(txtusuario, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnnuevo)
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbselec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnregistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        lbltotalregistros.setBackground(new java.awt.Color(255, 204, 102));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(153, 0, 0));
        lbltotalregistros.setText("Total:");

        tablausuario.setBackground(new java.awt.Color(153, 204, 255));
        tablausuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tablausuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tablausuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablausuario.setComponentPopupMenu(jPopupMenu1);
        tablausuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablausuarioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablausuarioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablausuario);

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("REGISTRAR USUARIOS");

        btnsalir.setBackground(new java.awt.Color(153, 255, 0));
        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(0, 51, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salirr.png"))); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnmostrar.setBackground(new java.awt.Color(255, 255, 0));
        btnmostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mostrar.png"))); // NOI18N
        btnmostrar.setText("Mostrar Password");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnmostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(92, 92, 92)
                .addComponent(btnsalir)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmostrar)
                    .addComponent(btnsalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btneditar.setBackground(new java.awt.Color(255, 255, 0));
        btneditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Editarr.png"))); // NOI18N
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btneditar)
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwelim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnaceptar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwelim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbltotalregistros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        int fila = tablausuario.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Debes Seleccionar una Fila", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else {
            id = tablausuario.getValueAt(fila, 0).toString();
            JOptionPane.showMessageDialog(null, "Debes Ingresar la Contraseña del Usuario del cual Deseas Eliminar", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

            txtid.requestFocus();
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        // TODO add your handling code here:

        String compara = "";
        String contra = "";
        contra = new String(passw.getText());

        try {
            if (compara.equals(contra)) {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM Usuario WHERE id='" + id + "'");
                pst.executeUpdate();
                mostrardatos("");

                JOptionPane.showMessageDialog(null, "Usuario Eliminado Correctamente", "Eliminando Registro", JOptionPane.INFORMATION_MESSAGE);
            }
            bloquear();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        // TODO add your handling code here:

        if (txtid.getText().equals("") || txtusuario.getText().equals("") || passw.getText().equals("")
                || cbselec.getSelectedItem().equals("seleccionar:")) {
            JOptionPane.showMessageDialog(null, "Todos los Campos son Obligatorios, COMPLETAR", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

        } else {
            try {

                PreparedStatement pst = cn.prepareStatement("INSERT INTO Usuario(id,usuario,password,Tipo_Usuario) VALUES(?,?,?,?)");
                pst.setString(1, txtid.getText());
                pst.setString(2, txtusuario.getText());
                pst.setString(3, passw.getText());
                pst.setString(4, cbselec.getSelectedItem().toString());

                int a = pst.executeUpdate();
                if (a > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario Registrado Correctammente", "Guardando Registro", JOptionPane.INFORMATION_MESSAGE);
                    mostrardatos("");
                    bloquear();
                    ocultar();

                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
            }
        }


    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void tablausuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablausuarioMousePressed
        // TODO add your handling code here:

        passwelim.setEnabled(true);
        btnaceptar.setEnabled(true);
        btneliminar.setEnabled(true);

    }//GEN-LAST:event_tablausuarioMousePressed

    private void tablausuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablausuarioMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tablausuarioMouseClicked

    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        // TODO add your handling code here:
        int fila = tablausuario.getSelectedRow();
        if (fila >= 0) {
            txtid.setText(tablausuario.getValueAt(fila, 0).toString());
            txtusuario.setText(tablausuario.getValueAt(fila, 1).toString());
            passw.setText(tablausuario.getValueAt(fila, 2).toString());
            cbselec.setSelectedItem(tablausuario.getValueAt(fila, 3).toString());
            id = tablausuario.getValueAt(fila, 0).toString();
            habilitar2();
            btneliminar.setEnabled(false);
            passwelim.setEnabled(false);
            btnaceptar.setEnabled(false);

        } else {
            JOptionPane.showMessageDialog(null, "No se ha Seleccionado Ninguna Fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuEditarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE USUARIO SET ID='" + txtid.getText() + "',usuario='" + txtusuario.getText()
                    + "',password='" + passw.getText() + "',Tipo_Usuario='" + cbselec.getSelectedItem().toString() + "' WHERE id='" + id + "' ");
            id = txtid.getText();
            pst.executeUpdate();
            mostrardatos("");
            bloquear2();
            btneditar.setEnabled(false);

            JOptionPane.showMessageDialog(null, "Datos del Usuario Editado Correctamente", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            java.lang.System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al Editar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btneditarActionPerformed

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed
        // TODO add your handling code here:
        mostrardatos("");
    }//GEN-LAST:event_btnmostrarActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnmostrar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbselec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JMenuItem menuEditar;
    private javax.swing.JPasswordField passw;
    private javax.swing.JPasswordField passwelim;
    private javax.swing.JTable tablausuario;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
