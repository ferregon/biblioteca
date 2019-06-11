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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ELVIS
 */
public class vista_libros extends javax.swing.JFrame {

    /**
     * Creates new form vista_libros
     */
    public vista_libros() {
        initComponents();
        mostrardatos("");
        setLocationRelativeTo(null);
        ocultar_columnas();
        txtbuscar.setEnabled(false);
        btnBuscar.setEnabled(false);

    }
    
     ConexionMysql cc = new ConexionMysql();
    Connection cn = cc.conexion();

    void ocultar_columnas() {
        TablaLibros.getColumnModel().getColumn(2).setMaxWidth(2);
        TablaLibros.getColumnModel().getColumn(2).setMinWidth(2);
        TablaLibros.getColumnModel().getColumn(2).setPreferredWidth(2);
    }

    public Integer totalregistros;

    void mostrardatos(String valor) {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Libro");
        modelo.addColumn("idcategoria");
        modelo.addColumn("categoria");
        modelo.addColumn("Autor");
        modelo.addColumn("Editorial");
        modelo.addColumn("Año");
        TablaLibros.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT\n"
                    + "     libros.`Cod_Libro` AS Cod_Libro,\n"
                    + "     libros.`Nombre_Libro` AS Nombre_Libro,\n"
                    + "     categoria.`id_categoria` AS id_categoria,\n"
                    + "     categoria.`categoria` AS categoria,\n"
                    + "     libros.`Autor` AS Autor,\n"
                    + "     libros.`Editorial` AS Editorial,\n"
                    + "     libros.`Año` AS Año\n"
                    + "FROM\n"
                    + "     `categoria` categoria INNER JOIN `libros` libros ON categoria.`id_categoria` = libros.`id_categoria`";
        } else {
            sql = "SELECT * FROM LIBROS WHERE (Cod_Libro='" + valor + "' OR Nombre_Libro='" + valor + "')";
        }
        String[] datos = new String[7];
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
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("Libros Registrados: " + Integer.toString(totalregistros));
            }
            TablaLibros.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoLibro = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaLibros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        rdcodigo = new javax.swing.JRadioButton();
        rdlibro = new javax.swing.JRadioButton();
        rdcategoria = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TablaLibros.setBackground(new java.awt.Color(204, 255, 102));
        TablaLibros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        TablaLibros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TablaLibros.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaLibrosMousePressed(evt);
            }
        });
        TablaLibros.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                TablaLibrosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(TablaLibros);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DATOS DE LOS LIBROS");

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
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(77, 77, 77)
                .addComponent(btnsalir)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addContainerGap())
        );

        lbltotalregistros.setBackground(new java.awt.Color(255, 102, 0));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(0, 0, 204));
        lbltotalregistros.setText("total");
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 0));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(204, 0, 0));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnMostrar.setBackground(new java.awt.Color(255, 255, 0));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(204, 0, 0));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mostrar.png"))); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        GrupoLibro.add(rdcodigo);
        rdcodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdcodigo.setForeground(new java.awt.Color(0, 0, 102));
        rdcodigo.setText("Buscar por Código");
        rdcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdcodigoActionPerformed(evt);
            }
        });

        GrupoLibro.add(rdlibro);
        rdlibro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdlibro.setForeground(new java.awt.Color(0, 0, 102));
        rdlibro.setText("Buscar por Nombre Libro");
        rdlibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdlibroActionPerformed(evt);
            }
        });

        GrupoLibro.add(rdcategoria);
        rdcategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdcategoria.setForeground(new java.awt.Color(0, 0, 102));
        rdcategoria.setText("Buscar por Nombre Categoria ");
        rdcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdcategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(rdlibro)
                            .addGap(52, 52, 52)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(rdcodigo)
                            .addGap(212, 212, 212)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rdcategoria)
                        .addGap(75, 75, 75)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrar)
                    .addComponent(btnBuscar))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdcodigo)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rdlibro)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdcategoria)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaLibrosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablaLibrosAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaLibrosAncestorAdded

    private void TablaLibrosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaLibrosMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila = TablaLibros.getSelectedRow();
            String cod;
            String valor;
            String año;

            cod = TablaLibros.getValueAt(fila, 0).toString();
            valor = TablaLibros.getValueAt(fila, 1).toString();
            año = TablaLibros.getValueAt(fila, 4).toString();

            Prestamos.txtcod.setText(cod);
            Prestamos.txtlibro.setText(valor);
            Prestamos.txtaño.setText(año);

            this.dispose();

        }
    }//GEN-LAST:event_TablaLibrosMousePressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        
        String cod = txtbuscar.getText();
        String libro = txtbuscar.getText();
        String categ = txtbuscar.getText();

        if (rdcodigo.isSelected() == true) {

            DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Libro");
        modelo.addColumn("idcategoria");
        modelo.addColumn("categoria");
        modelo.addColumn("Autor");
        modelo.addColumn("Editorial");
        modelo.addColumn("Año");
        TablaLibros.setModel(modelo);
        String sql = "";
        
            sql = "SELECT\n"
                    + "     libros.`Cod_Libro` AS Cod_Libro,\n"
                    + "     libros.`Nombre_Libro` AS Nombre_Libro,\n"
                    + "     categoria.`id_categoria` AS id_categoria,\n"
                    + "     categoria.`categoria` AS categoria,\n"
                    + "     libros.`Autor` AS Autor,\n"
                    + "     libros.`Editorial` AS Editorial,\n"
                    + "     libros.`Año` AS Año\n"
                    + "FROM\n"
                    + "     `categoria` categoria INNER JOIN `libros` libros ON categoria.`id_categoria` = libros.`id_categoria`"
                    + "WHERE Cod_Libro='" + cod + "'";
        
        String[] datos = new String[7];
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
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("Libros Registrados: " + Integer.toString(totalregistros));
            }
            TablaLibros.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
        }
           txtbuscar.setText("");
            txtbuscar.setEnabled(false); 

        }
        if (rdlibro.isSelected() == true) {
            DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Libro");
        modelo.addColumn("idcategoria");
        modelo.addColumn("categoria");
        modelo.addColumn("Autor");
        modelo.addColumn("Editorial");
        modelo.addColumn("Año");
        TablaLibros.setModel(modelo);
        String sql = "";
        
            sql = "SELECT\n"
                    + "     libros.`Cod_Libro` AS Cod_Libro,\n"
                    + "     libros.`Nombre_Libro` AS Nombre_Libro,\n"
                    + "     categoria.`id_categoria` AS id_categoria,\n"
                    + "     categoria.`categoria` AS categoria,\n"
                    + "     libros.`Autor` AS Autor,\n"
                    + "     libros.`Editorial` AS Editorial,\n"
                    + "     libros.`Año` AS Año\n"
                    + "FROM\n"
                    + "     `categoria` categoria INNER JOIN `libros` libros ON categoria.`id_categoria` = libros.`id_categoria`"
                    + "WHERE Nombre_Libro='" + cod + "'";
        
        String[] datos = new String[7];
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
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("Libros Registrados: " + Integer.toString(totalregistros));
            }
            TablaLibros.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
        }
            txtbuscar.setText("");
            txtbuscar.setEnabled(false);

        }

        if (rdcategoria.isSelected() == true) {
           DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Código");
        modelo.addColumn("Libro");
        modelo.addColumn("idcategoria");
        modelo.addColumn("categoria");
        modelo.addColumn("Autor");
        modelo.addColumn("Editorial");
        modelo.addColumn("Año");
        TablaLibros.setModel(modelo);
        String sql = "";
        
            sql = "SELECT\n"
                    + "     libros.`Cod_Libro` AS Cod_Libro,\n"
                    + "     libros.`Nombre_Libro` AS Nombre_Libro,\n"
                    + "     categoria.`id_categoria` AS id_categoria,\n"
                    + "     categoria.`categoria` AS categoria,\n"
                    + "     libros.`Autor` AS Autor,\n"
                    + "     libros.`Editorial` AS Editorial,\n"
                    + "     libros.`Año` AS Año\n"
                    + "FROM\n"
                    + "     `categoria` categoria INNER JOIN `libros` libros ON categoria.`id_categoria` = libros.`id_categoria`"
                    + "WHERE categoria='" + categ + "'";
       
        String[] datos = new String[7];
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
                totalregistros = totalregistros + 1;
                modelo.addRow(datos);
                lbltotalregistros.setText("Libros Registrados: " + Integer.toString(totalregistros));
            }
            TablaLibros.setModel(modelo);
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

    private void rdcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdcodigoActionPerformed
        // TODO add your handling code here:
        if (rdcodigo.isSelected() == true) {
            txtbuscar.setEnabled(true);
            btnBuscar.setEnabled(true);
            txtbuscar.requestFocus();

        }
    }//GEN-LAST:event_rdcodigoActionPerformed

    private void rdlibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdlibroActionPerformed
        // TODO add your handling code here:
        if (rdlibro.isSelected() == true) {
            btnBuscar.setEnabled(true);
            txtbuscar.setEnabled(true);
            txtbuscar.requestFocus();
        }
    }//GEN-LAST:event_rdlibroActionPerformed

    private void rdcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdcategoriaActionPerformed
        // TODO add your handling code here:
        if (rdcategoria.isSelected() == true) {
            btnBuscar.setEnabled(true);
            txtbuscar.setEnabled(true);
            txtbuscar.requestFocus();
        }
    }//GEN-LAST:event_rdcategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(vista_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista_libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista_libros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoLibro;
    private javax.swing.JTable TablaLibros;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JRadioButton rdcategoria;
    private javax.swing.JRadioButton rdcodigo;
    private javax.swing.JRadioButton rdlibro;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

}
