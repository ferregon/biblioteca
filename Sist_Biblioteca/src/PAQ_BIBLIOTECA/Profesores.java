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
 */
public class Profesores extends javax.swing.JFrame {

    /**
     * Creates new form Profesores
     */
    public Profesores() {
        initComponents();
        setLocationRelativeTo(null);
        mostrardatos("");
        inhabilitar();
    }

    void inhabilitar() {
        txtdni.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapep.setEnabled(false);
        txtapem.setEnabled(false);
        cbosexo.setEnabled(false);
        cbosexo.setSelectedIndex(0);
        txtEspec.setEnabled(false);
        txtdirecc.setEnabled(false);
        txttelefono.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnEditar.setEnabled(false);

        txtdni.setText("");
        txtnombre.setText("");
        txtapep.setText("");
        txtapem.setText("");
        txtEspec.setText("");
        txtdirecc.setText("");
        txttelefono.setText("");

    }

    void habilitar() {
        txtdni.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapep.setEnabled(true);
        txtapem.setEnabled(true);
        cbosexo.setEnabled(true);
        txtEspec.setEnabled(true);
        txtdirecc.setEnabled(true);
        txttelefono.setEnabled(true);
        btnAgregar.setEnabled(true);

        txtdni.setText("");
        txtnombre.setText("");
        txtapep.setText("");
        txtapem.setText("");
        txtEspec.setText("");
        txtdirecc.setText("");
        txttelefono.setText("");

    }

    void desaHabiEditar() {
        txtdni.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapep.setEnabled(true);
        txtapem.setEnabled(true);
        cbosexo.setEnabled(true);
        txtEspec.setEnabled(true);
        txtdirecc.setEnabled(true);
        txttelefono.setEnabled(true);
        btnEditar.setEnabled(true);

        btnNuevo.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnMostrar.setEnabled(false);
        txtbuscar.setEnabled(false);
        btnAgregar.setEnabled(false);

    }

    void desaHabiEditar2() {
        btnNuevo.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnMostrar.setEnabled(true);
        txtbuscar.setEnabled(true);
        btnEditar.setEnabled(false);

        txtdni.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapep.setEnabled(false);
        txtapem.setEnabled(false);
        cbosexo.setEnabled(false);
        txtEspec.setEnabled(false);
        txtdirecc.setEnabled(false);
        txttelefono.setEnabled(false);

        txtdni.setText("");
        txtnombre.setText("");
        txtapep.setText("");
        txtapem.setText("");
        txtEspec.setText("");
        txtdirecc.setText("");
        txttelefono.setText("");

    }
    public Integer totalregistros;

    void mostrardatos(String valor) {
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("DNI Profesor");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Sexo");
        modelo.addColumn("Especialidad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");

        TablaProfesor.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM PROFESOR";
        } else {
            sql = "SELECT * FROM PROFESOR WHERE (DNI_Profesor='" + valor + "' OR Nombre='" + valor + "')";
        }
        String[] datos = new String[9];
        totalregistros = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);

                //datos[9] = rs.getBinaryStream(10).toString();
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("Profesores Registrados: " + Integer.toString(totalregistros));
            }
            TablaProfesor.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuEditar = new javax.swing.JMenuItem();
        menuEliminar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        txtapem = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProfesor = new javax.swing.JTable();
        txtdni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txtapep = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        txtdirecc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnsalir1 = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        txtEspec = new javax.swing.JTextField();
        lbltotalregistros = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbosexo = new javax.swing.JComboBox();

        menuEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuEditar.setForeground(new java.awt.Color(255, 153, 0));
        menuEditar.setText("Editar");
        menuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEditar);

        menuEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuEliminar.setForeground(new java.awt.Color(102, 51, 0));
        menuEliminar.setText("Eliminar");
        menuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRAR PROFESORES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("DNI Profesor:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        txtapem.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(txtapem, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 95, -1));

        btnNuevo.setBackground(new java.awt.Color(255, 255, 51));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 0, 153));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 100, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("Sexo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        txttelefono.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 93, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("Apellido Paterno:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        txtnombre.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 93, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("Dirección:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        TablaProfesor.setBackground(new java.awt.Color(153, 255, 255));
        TablaProfesor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        TablaProfesor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TablaProfesor.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaProfesor.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(TablaProfesor);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 273, 880, 202));

        txtdni.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 93, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Especialidad:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 51));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 0, 153));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardarR.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 80, 110, 40));

        txtapep.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(txtapep, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 95, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Apellido Materno:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        btnEditar.setBackground(new java.awt.Color(255, 255, 51));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 0, 153));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Editarr.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 100, 40));

        txtdirecc.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(txtdirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 93, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("Teléfono:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 51));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 153));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 100, 40));

        btnMostrar.setBackground(new java.awt.Color(255, 255, 51));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(0, 0, 153));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mostrar.png"))); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 110, 40));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DATOS DE LOS PROFESORES");

        btnsalir1.setBackground(new java.awt.Color(153, 255, 0));
        btnsalir1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsalir1.setForeground(new java.awt.Color(0, 51, 255));
        btnsalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salirr.png"))); // NOI18N
        btnsalir1.setText("Salir");
        btnsalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(btnsalir1)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnsalir1))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 7, 890, -1));
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, 100, 30));

        txtEspec.setBackground(new java.awt.Color(255, 255, 204));
        getContentPane().add(txtEspec, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 93, -1));

        lbltotalregistros.setBackground(new java.awt.Color(255, 102, 0));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(0, 0, 204));
        lbltotalregistros.setText("total");
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)));
        getContentPane().add(lbltotalregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 160, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Buscar por DNI o Nombre ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, -1, -1));

        cbosexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elegir:", "M", "F" }));
        getContentPane().add(cbosexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();

        if (txtdni.getText().equals("") || txtnombre.getText().equals("") || txtapep.getText().equals("") || txtapem.getText().equals("")
                || cbosexo.getSelectedItem().equals("Elegir:") || txtEspec.getText().equals("")
                || txtdirecc.getText().equals("") || txttelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los Campos son Obligatorios,COMPLETAR", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

        } else {
            try {
                //FileInputStream foto;
                PreparedStatement pst = cn.prepareStatement("INSERT INTO PROFESOR(DNI_Profesor,Nombre,Apellido_Paterno,Apellido_Materno,Sexo,Especialidad,Telefono,Direccion) VALUES(?,?,?,?,?,?,?,?)");
                pst.setString(1, txtdni.getText());
                pst.setString(2, txtnombre.getText());
                pst.setString(3, txtapep.getText());
                pst.setString(4, txtapem.getText());
                pst.setString(5, cbosexo.getSelectedItem().toString());
                pst.setString(6, txtEspec.getText());
                pst.setString(7, txttelefono.getText());
                pst.setString(8, txtdirecc.getText());

                //foto=new FileInputStream(txtruta.getText());
                //pst.setBinaryStream(10, foto);
                int a = pst.executeUpdate();
                if (a > 0) {
                    JOptionPane.showMessageDialog(null, "Profesor Registrado Correctamente", "Guardando Registro", JOptionPane.INFORMATION_MESSAGE);
                    mostrardatos("");
                    inhabilitar();

                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
            } // TO
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        mostrardatos("");
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();
        try {

            PreparedStatement pst = cn.prepareStatement("UPDATE PROFESOR SET Nombre='" + txtnombre.getText() + "',DNI_Profesor='" + txtdni.getText() + "',Apellido_Paterno='" + txtapep.getText()
                    + "',Apellido_Materno='" + txtapem.getText() + "',Sexo='" + cbosexo.getSelectedItem().toString() + "',Especialidad='" + txtEspec.getText() + "',Direccion='" + txtdirecc.getText()
                    + "',Telefono='" + txttelefono.getText() + "' WHERE DNI_Profesor='" + id + "' ");
            id = txtdni.getText();
            pst.executeUpdate();
            mostrardatos("");
            desaHabiEditar2();
            JOptionPane.showMessageDialog(null, "Datos del Profesor Editado Correctamente", "Editando Registro", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            java.lang.System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al Editar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        mostrardatos(txtbuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed
    String id = "";
    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        // TODO add your handling code here:
        int fila = TablaProfesor.getSelectedRow();
        if (fila >= 0) {
            txtdni.setText(TablaProfesor.getValueAt(fila, 0).toString());
            txtnombre.setText(TablaProfesor.getValueAt(fila, 1).toString());
            txtapep.setText(TablaProfesor.getValueAt(fila, 2).toString());
            txtapem.setText(TablaProfesor.getValueAt(fila, 3).toString());
            cbosexo.setSelectedItem(TablaProfesor.getValueAt(fila, 4).toString());
            txtEspec.setText(TablaProfesor.getValueAt(fila, 5).toString());
            txttelefono.setText(TablaProfesor.getValueAt(fila, 6).toString());
            txtdirecc.setText(TablaProfesor.getValueAt(fila, 7).toString());

            id = TablaProfesor.getValueAt(fila, 0).toString();
            desaHabiEditar();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuEditarActionPerformed

    private void menuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarActionPerformed
        // TODO add your handling code here:
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();
        int fila = TablaProfesor.getSelectedRow();
        String cod = "";
        cod = TablaProfesor.getValueAt(fila, 0).toString();
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Realmente Desea Eliminar al Profesor", "CONFIRMAR", 2);
        try {
            if (confirmacion == 0) {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM PROFESOR WHERE DNI_Profesor='" + cod + "'");
                pst.executeUpdate();
                mostrardatos("");
                inhabilitar();
                JOptionPane.showMessageDialog(null, "Profesor Eliminado Correctamente", "Eliminando Registro", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuEliminarActionPerformed

    private void btnsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalir1ActionPerformed

    private Connection conec = new ConexionMysql().conexion();

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
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profesores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProfesor;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnsalir1;
    private javax.swing.JComboBox cbosexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JMenuItem menuEditar;
    private javax.swing.JMenuItem menuEliminar;
    private javax.swing.JTextField txtEspec;
    private javax.swing.JTextField txtapem;
    private javax.swing.JTextField txtapep;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdirecc;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
