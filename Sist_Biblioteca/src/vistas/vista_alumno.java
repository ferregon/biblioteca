/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Logica.ConexionMysql;
import PAQ_BIBLIOTECA.Prestamos;
import java.sql.Connection;
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
public class vista_alumno extends javax.swing.JFrame {

    /**
     * Creates new form vista_alumno
     */
    public vista_alumno() {
        initComponents();
        mostrardatos("");
        setLocationRelativeTo(null);
        txtbuscar.setEnabled(false);
        btnBuscar.setEnabled(false);
        cbosexo.setEnabled(false);

    }

    ConexionMysql cc = new ConexionMysql();
    Connection cn = cc.conexion();

    public Integer totalregistros;

    void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("DNI Alumno");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Sexo");
        modelo.addColumn("Grado");
        modelo.addColumn("Seccion");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        TablaAlumno.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM ALUMNO";
        } else {
            sql = "SELECT * FROM ALUMNO WHERE (DNI_Alumno='" + valor + "' OR Nombre='" + valor + "')";
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
                datos[8] = rs.getString(9);
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("Alumnos Registrados: " + Integer.toString(totalregistros));
            }
            TablaAlumno.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoalumno = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAlumno = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        rdgenero = new javax.swing.JRadioButton();
        rddni = new javax.swing.JRadioButton();
        rdgrado = new javax.swing.JRadioButton();
        cbosexo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TablaAlumno.setBackground(new java.awt.Color(204, 255, 102));
        TablaAlumno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 204)));
        TablaAlumno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaAlumnoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaAlumno);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DATOS DE LOS ALUMNOS");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(104, 104, 104)
                .addComponent(btnsalir)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnsalir))
                .addContainerGap())
        );

        lbltotalregistros.setBackground(new java.awt.Color(255, 102, 0));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(0, 0, 204));
        lbltotalregistros.setText("total");
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)));

        jPanel2.setBackground(new java.awt.Color(204, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 204));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(204, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnMostrar.setBackground(new java.awt.Color(255, 255, 204));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(204, 0, 0));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mostrar.png"))); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        grupoalumno.add(rdgenero);
        rdgenero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdgenero.setForeground(new java.awt.Color(0, 0, 102));
        rdgenero.setText("Buscar por Género");
        rdgenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdgeneroActionPerformed(evt);
            }
        });

        grupoalumno.add(rddni);
        rddni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rddni.setForeground(new java.awt.Color(0, 0, 102));
        rddni.setText("Buscar por DNI");
        rddni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rddniActionPerformed(evt);
            }
        });

        grupoalumno.add(rdgrado);
        rdgrado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdgrado.setForeground(new java.awt.Color(0, 0, 102));
        rdgrado.setText("Buscar por Grado ");
        rdgrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdgradoActionPerformed(evt);
            }
        });

        cbosexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar:", "M", "F" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rddni, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rdgenero)
                            .addGap(37, 37, 37)
                            .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(65, 65, 65)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdgrado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrar)
                    .addComponent(btnBuscar))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdgenero)
                        .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(rddni)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdgrado)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String sexo = cbosexo.getSelectedItem().toString();
        String dni = txtbuscar.getText();
        String grado = txtbuscar.getText();
        

        if (rdgenero.isSelected() == true) {

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("DNI Alumno");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            modelo.addColumn("Sexo");
            modelo.addColumn("Grado");
            modelo.addColumn("Seccion");
            modelo.addColumn("Direccion");
            modelo.addColumn("Telefono");
            TablaAlumno.setModel(modelo);
            String sql = "";
                      
                sql = "SELECT * FROM ALUMNO WHERE Sexo='" + sexo + "'";
            
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
                    datos[8] = rs.getString(9);
                    totalregistros = totalregistros + 1;
                    modelo.addRow(datos);
                    lbltotalregistros.setText("Alumnos Registrados: " + Integer.toString(totalregistros));
                }
                TablaAlumno.setModel(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            }
            cbosexo.setSelectedIndex(0);
            cbosexo.setEnabled(false);

        }
        if (rddni.isSelected() == true) {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("DNI Alumno");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            modelo.addColumn("Sexo");
            modelo.addColumn("Grado");
            modelo.addColumn("Seccion");
            modelo.addColumn("Direccion");
            modelo.addColumn("Telefono");
            TablaAlumno.setModel(modelo);
            String sql = "";

            sql = "SELECT * FROM ALUMNO WHERE DNI_Alumno='" + dni + "'";

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
                    datos[8] = rs.getString(9);
                    totalregistros = totalregistros + 1;
                    modelo.addRow(datos);
                    lbltotalregistros.setText("Alumnos Registrados: " + Integer.toString(totalregistros));
                }
                TablaAlumno.setModel(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtbuscar.setText("");
            txtbuscar.setEnabled(false);

        }

        if (rdgrado.isSelected() == true) {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("DNI Alumno");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido Paterno");
            modelo.addColumn("Apellido Materno");
            modelo.addColumn("Sexo");
            modelo.addColumn("Grado");
            modelo.addColumn("Seccion");
            modelo.addColumn("Direccion");
            modelo.addColumn("Telefono");
            TablaAlumno.setModel(modelo);
            String sql = "";

            sql = "SELECT * FROM ALUMNO WHERE Grado ='" + grado + "'";

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
                    datos[8] = rs.getString(9);
                    totalregistros = totalregistros + 1;
                    modelo.addRow(datos);
                    lbltotalregistros.setText("Alumnos Registrados: " + Integer.toString(totalregistros));
                }
                TablaAlumno.setModel(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtbuscar.setText("");
            txtbuscar.setEnabled(false);
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        mostrardatos("");
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void TablaAlumnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAlumnoMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila = TablaAlumno.getSelectedRow();
            String cod;
            String valor;
            String grado;
            cod = TablaAlumno.getValueAt(fila, 0).toString();
            valor = TablaAlumno.getValueAt(fila, 1).toString() + " " + TablaAlumno.getValueAt(fila, 2).toString();
            grado = TablaAlumno.getValueAt(fila, 5).toString() + " " + TablaAlumno.getValueAt(fila, 6).toString();

            Prestamos.txtDNIA.setText(cod);
            Prestamos.txtalumno.setText(valor);
            Prestamos.txtgrado.setText(grado);

            this.dispose();

        }
    }//GEN-LAST:event_TablaAlumnoMousePressed

    private void rdgeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdgeneroActionPerformed
        // TODO add your handling code here:
        if (rdgenero.isSelected() == true) {
            cbosexo.setSelectedItem(0);
            btnBuscar.setEnabled(true);
            cbosexo.setEnabled(true);

        }
    }//GEN-LAST:event_rdgeneroActionPerformed

    private void rddniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rddniActionPerformed
        // TODO add your handling code here:
        if (rddni.isSelected() == true) {
            cbosexo.setSelectedIndex(0);
            btnBuscar.setEnabled(true);
            txtbuscar.setEnabled(true);
            txtbuscar.requestFocus();
        }
    }//GEN-LAST:event_rddniActionPerformed

    private void rdgradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdgradoActionPerformed
        // TODO add your handling code here:
        if (rdgrado.isSelected() == true) {
            cbosexo.setSelectedIndex(0);
            btnBuscar.setEnabled(true);
            txtbuscar.setEnabled(true);
            txtbuscar.requestFocus();
        }
    }//GEN-LAST:event_rdgradoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

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
            java.util.logging.Logger.getLogger(vista_alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista_alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista_alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista_alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista_alumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAlumno;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbosexo;
    private javax.swing.ButtonGroup grupoalumno;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JRadioButton rddni;
    private javax.swing.JRadioButton rdgenero;
    private javax.swing.JRadioButton rdgrado;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
