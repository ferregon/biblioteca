/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Logica.ConexionMysql;
import PAQ_BIBLIOTECA.Prestamo_profe;
import PAQ_BIBLIOTECA.Prestamos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ELVIS
 */
public class vista_profe extends javax.swing.JFrame {

    /**
     * Creates new form vista_profe
     */
    public vista_profe() {
        initComponents();
        mostrardatos("");
        setLocationRelativeTo(null);
        cbosexo.setEnabled(false);
        btnBuscar.setEnabled(false);
        txtbuscar.setEnabled(false);
    }

    ConexionMysql cc = new ConexionMysql();
    Connection cn = cc.conexion();

    public Integer totalregistros;

    void mostrardatos(String valor) {

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
        String[] datos = new String[8];
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
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("Profesores Registrados: " + Integer.toString(totalregistros));
            }
            TablaProfesor.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoprofesores = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProfesor = new javax.swing.JTable();
        lbltotalregistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        rdgenero = new javax.swing.JRadioButton();
        rddni = new javax.swing.JRadioButton();
        rdespec = new javax.swing.JRadioButton();
        cbosexo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DATOS DE LOS PROFESORES");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnsalir))
                .addContainerGap())
        );

        TablaProfesor.setBackground(new java.awt.Color(204, 255, 102));
        TablaProfesor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
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
        TablaProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaProfesorMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProfesor);

        lbltotalregistros.setBackground(new java.awt.Color(255, 102, 0));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(51, 0, 204));
        lbltotalregistros.setText("total");
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
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

        grupoprofesores.add(rdgenero);
        rdgenero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdgenero.setForeground(new java.awt.Color(0, 0, 102));
        rdgenero.setText("Buscar por Género");
        rdgenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdgeneroActionPerformed(evt);
            }
        });

        grupoprofesores.add(rddni);
        rddni.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rddni.setForeground(new java.awt.Color(0, 0, 102));
        rddni.setText("Buscar por DNI");
        rddni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rddniActionPerformed(evt);
            }
        });

        grupoprofesores.add(rdespec);
        rdespec.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdespec.setForeground(new java.awt.Color(0, 0, 102));
        rdespec.setText("Buscar por Especialidad ");
        rdespec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdespecActionPerformed(evt);
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(rdgenero)
                                .addGap(37, 37, 37))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rddni)
                                .addGap(57, 57, 57)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rdespec))
                .addGap(65, 65, 65)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdgenero)
                                .addComponent(cbosexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(rddni))
                    .addComponent(txtbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdespec)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaProfesorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProfesorMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila = TablaProfesor.getSelectedRow();
            String cod;
            String valor;
            String espec;

            cod = TablaProfesor.getValueAt(fila, 0).toString();
            valor = TablaProfesor.getValueAt(fila, 1).toString() + " " + TablaProfesor.getValueAt(fila, 2).toString();
            espec = TablaProfesor.getValueAt(fila, 5).toString();

            Prestamo_profe.txtDNIP.setText(cod);
            Prestamo_profe.txtprofesor.setText(valor);
            Prestamo_profe.txtespec.setText(espec);

            this.dispose();

        }
    }//GEN-LAST:event_TablaProfesorMousePressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String sexo = cbosexo.getSelectedItem().toString();
        String dni = txtbuscar.getText();
        String espec = txtbuscar.getText();

        if (rdgenero.isSelected() == true) {

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

            sql = "SELECT * FROM PROFESOR WHERE Sexo='" + sexo + "'";

            String[] datos = new String[8];
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
                    totalregistros = totalregistros + 1;
                    modelo.addRow(datos);
                    lbltotalregistros.setText("Profesores Registrados: " + Integer.toString(totalregistros));
                }
                TablaProfesor.setModel(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            }
            cbosexo.setSelectedIndex(0);
            cbosexo.setEnabled(false);

        }
        if (rddni.isSelected() == true) {
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

            sql = "SELECT * FROM PROFESOR WHERE DNI_Profesor='" + dni + "'";

            String[] datos = new String[8];
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
                    totalregistros = totalregistros + 1;
                    modelo.addRow(datos);
                    lbltotalregistros.setText("Profesores Registrados: " + Integer.toString(totalregistros));
                }
                TablaProfesor.setModel(modelo);
            } catch (SQLException ex) {
                Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtbuscar.setText("");
            txtbuscar.setEnabled(false);

        }

        if (rdespec.isSelected() == true) {
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

            sql = "SELECT * FROM PROFESOR WHERE Especialidad='" + espec + "'";

            String[] datos = new String[8];
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
                    totalregistros = totalregistros + 1;
                    modelo.addRow(datos);
                    lbltotalregistros.setText("Profesores Registrados: " + Integer.toString(totalregistros));
                }
                TablaProfesor.setModel(modelo);
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

    private void rdespecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdespecActionPerformed
        // TODO add your handling code here:
        if (rdespec.isSelected() == true) {
            cbosexo.setSelectedIndex(0);
            btnBuscar.setEnabled(true);
            txtbuscar.setEnabled(true);
            txtbuscar.requestFocus();
        }
    }//GEN-LAST:event_rdespecActionPerformed

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
            java.util.logging.Logger.getLogger(vista_profe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista_profe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista_profe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista_profe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista_profe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProfesor;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbosexo;
    private javax.swing.ButtonGroup grupoprofesores;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JRadioButton rddni;
    private javax.swing.JRadioButton rdespec;
    private javax.swing.JRadioButton rdgenero;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
