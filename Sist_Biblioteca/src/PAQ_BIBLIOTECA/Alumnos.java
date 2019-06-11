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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ELVIS
 */
public class Alumnos extends javax.swing.JFrame {

    /**
     * Creates new form Alumnos
     */
    public Alumnos() {
        initComponents();
        mostrardatos("");
        inhabilitar();
        setLocationRelativeTo(null);
        this.setResizable(false);

    }

    void inhabilitar() {
        txtdni.setEnabled(false);
        txtnombre.setEnabled(false);
        txtapep.setEnabled(false);
        txtapem.setEnabled(false);
        cbosexo.setEnabled(false);
        cbosexo.setSelectedIndex(0);
        txtgrado.setEnabled(false);

        txtseccion.setEnabled(false);
        txtdirecc.setEnabled(false);
        txttelefono.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnEditar.setEnabled(false);

        txtdni.setText("");
        txtnombre.setText("");
        txtapep.setText("");
        txtapem.setText("");
        txtgrado.setText("");
        txtseccion.setText("");
        txtdirecc.setText("");
        txttelefono.setText("");

    }

    void habilitar() {
        txtdni.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapep.setEnabled(true);
        txtapem.setEnabled(true);
        cbosexo.setEnabled(true);
        txtgrado.setEnabled(true);
        txtseccion.setEnabled(true);
        txtdirecc.setEnabled(true);
        txttelefono.setEnabled(true);
        btnAgregar.setEnabled(true);

        txtdni.setText("");
        txtnombre.setText("");
        txtapep.setText("");
        txtapem.setText("");
        txtgrado.setText("");
        txtseccion.setText("");
        txtdirecc.setText("");
        txttelefono.setText("");

    }

    void desaHabiEditar() {
        txtdni.setEnabled(true);
        txtnombre.setEnabled(true);
        txtapep.setEnabled(true);
        txtapem.setEnabled(true);
        cbosexo.setEnabled(true);
        txtgrado.setEnabled(true);
        txtseccion.setEnabled(true);
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
        txtgrado.setEnabled(false);
        txtseccion.setEnabled(false);
        txtdirecc.setEnabled(false);
        txttelefono.setEnabled(false);

        txtdni.setText("");
        txtnombre.setText("");
        txtapep.setText("");
        txtapem.setText("");
        txtgrado.setText("");
        txtseccion.setText("");
        txtdirecc.setText("");
        txttelefono.setText("");

    }
    public Integer totalregistros;

    void mostrardatos(String valor) {
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();
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

        //modelo.addColumn("Foto");
        TablaAlumno.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM ALUMNO";
        } else {
            sql = "SELECT * FROM ALUMNO WHERE (DNI_Alumno='" + valor + "' OR Nombre='" + valor + "')";
        }
        String[] datos = new String[10];
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

                //datos[10] = rs.getBlob(11).toString();
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuEditar = new javax.swing.JMenuItem();
        menuEliminar = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdirecc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtseccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtapem = new javax.swing.JTextField();
        txtbuscar = new javax.swing.JTextField();
        txtapep = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAlumno = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        txttelefono = new javax.swing.JTextField();
        txtgrado = new javax.swing.JTextField();
        lbltotalregistros = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbosexo = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();

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
        setTitle("REGISTRAR ALUMNOS");
        setBackground(new java.awt.Color(255, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 60, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setText("Apellido Paterno:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 100, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("DNI Alumno:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 80, -1));

        txtnombre.setBackground(new java.awt.Color(255, 255, 204));
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 93, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setText("Sección:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 50, -1));

        txtdirecc.setBackground(new java.awt.Color(255, 255, 204));
        txtdirecc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccActionPerformed(evt);
            }
        });
        getContentPane().add(txtdirecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 93, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("Grado:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 60, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setText("Dirección:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 60, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 0));
        jLabel3.setText("Apellido Materno:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 110, -1));

        txtseccion.setBackground(new java.awt.Color(255, 255, 204));
        txtseccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtseccionActionPerformed(evt);
            }
        });
        getContentPane().add(txtseccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 93, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setText("Sexo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 50, -1));

        txtapem.setBackground(new java.awt.Color(255, 255, 204));
        txtapem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapemActionPerformed(evt);
            }
        });
        getContentPane().add(txtapem, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 93, -1));
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, 100, 30));

        txtapep.setBackground(new java.awt.Color(255, 255, 204));
        txtapep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapepActionPerformed(evt);
            }
        });
        getContentPane().add(txtapep, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 93, -1));

        txtdni.setBackground(new java.awt.Color(255, 255, 204));
        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });
        getContentPane().add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(144, 96, 93, -1));

        TablaAlumno.setBackground(new java.awt.Color(153, 255, 255));
        TablaAlumno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 153)));
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
        TablaAlumno.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(TablaAlumno);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 880, 210));

        btnEditar.setBackground(new java.awt.Color(255, 255, 51));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 51, 153));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Editarr.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 100, 40));

        btnNuevo.setBackground(new java.awt.Color(255, 255, 51));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 51, 153));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 110, 40));

        btnAgregar.setBackground(new java.awt.Color(255, 255, 51));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(0, 51, 153));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardarR.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 110, 40));

        btnMostrar.setBackground(new java.awt.Color(255, 255, 51));
        btnMostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(0, 51, 153));
        btnMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mostrar.png"))); // NOI18N
        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, -1, 40));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 51));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 51, 153));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar-.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 110, 40));

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
                .addContainerGap(349, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(214, 214, 214)
                .addComponent(btnsalir)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 910, -1));

        txttelefono.setBackground(new java.awt.Color(255, 255, 204));
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txttelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 93, -1));

        txtgrado.setBackground(new java.awt.Color(255, 255, 204));
        txtgrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgradoActionPerformed(evt);
            }
        });
        getContentPane().add(txtgrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 93, -1));

        lbltotalregistros.setBackground(new java.awt.Color(255, 102, 0));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(51, 0, 204));
        lbltotalregistros.setText("total");
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)));
        getContentPane().add(lbltotalregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 540, 140, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Buscar por DNI o Nombre ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, -1, -1));

        cbosexo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbosexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elegir:", "M", "F" }));
        cbosexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbosexoActionPerformed(evt);
            }
        });
        getContentPane().add(cbosexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 100, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 0, 0));
        jLabel12.setText("Teléfono:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitar();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();

        if (txtdni.getText().equals("") || txtnombre.getText().equals("") || txtapep.getText().equals("")
                || txtapem.getText().equals("") || cbosexo.getSelectedItem().equals("Elegir:") || txtgrado.getText().equals("")
                || txtseccion.getText().equals("") || txtdirecc.getText().equals("")||txttelefono.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los Campos son Obligatorios, COMPLETAR", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

        } else {
            try {

                PreparedStatement pst = cn.prepareStatement("INSERT INTO ALUMNO(DNI_Alumno,Nombre,Apellido_Paterno,Apellido_Materno,Sexo,Grado,Seccion,Direccion,Telefono) VALUES(?,?,?,?,?,?,?,?,?)");
                pst.setString(1, txtdni.getText());
                pst.setString(2, txtnombre.getText());
                pst.setString(3, txtapep.getText());
                pst.setString(4, txtapem.getText());
                pst.setString(5, cbosexo.getSelectedItem().toString());
                pst.setString(6, txtgrado.getText());
                pst.setString(7, txtseccion.getText());
                pst.setString(8, txtdirecc.getText());
                pst.setString(9, txttelefono.getText());

                int a = pst.executeUpdate();
                if (a > 0) {
                    JOptionPane.showMessageDialog(null, "Alumno Registrado Correctammente", "Guardando Registro", JOptionPane.INFORMATION_MESSAGE);
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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        mostrardatos(txtbuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed
    String id = "";
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();

        try {

            PreparedStatement pst = cn.prepareStatement("UPDATE ALUMNO SET Nombre='" + txtnombre.getText() + "',DNI_Alumno='" + txtdni.getText() + "',Apellido_Paterno='" + txtapep.getText()
                    + "',Apellido_Materno='" + txtapem.getText() + "',Sexo='" + cbosexo.getSelectedItem().toString() + "',Grado='" + txtgrado.getText() + "',Direccion='" + txtdirecc.getText() + "',Seccion='" + txtseccion.getText()
                    + "',Telefono='" + txttelefono.getText() + "' WHERE DNI_Alumno='" + id + "' ");

            id = txtdni.getText();
            pst.executeUpdate();
            mostrardatos("");
            desaHabiEditar2();
            JOptionPane.showMessageDialog(null, "Datos del Alumno Editado Correctamente", "Editando Registro", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            java.lang.System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al Editar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        // TODO add your handling code here:
        int fila = TablaAlumno.getSelectedRow();
        if (fila >= 0) {
            txtdni.setText(TablaAlumno.getValueAt(fila, 0).toString());
            txtnombre.setText(TablaAlumno.getValueAt(fila, 1).toString());
            txtapep.setText(TablaAlumno.getValueAt(fila, 2).toString());
            txtapem.setText(TablaAlumno.getValueAt(fila, 3).toString());
            cbosexo.setSelectedItem(TablaAlumno.getValueAt(fila, 4).toString());
            txtgrado.setText(TablaAlumno.getValueAt(fila, 5).toString());
            txtseccion.setText(TablaAlumno.getValueAt(fila, 6).toString());
            txtdirecc.setText(TablaAlumno.getValueAt(fila, 7).toString());
            txttelefono.setText(TablaAlumno.getValueAt(fila, 8).toString());

            //lblfoto.setIcon((Icon) TablaAlumno.getValueAt(fila, 10));
            id = TablaAlumno.getValueAt(fila, 0).toString();
            desaHabiEditar();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuEditarActionPerformed

    private void menuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarActionPerformed
        // TODO add your handling code here:
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();
        int fila = TablaAlumno.getSelectedRow();
        String cod = "";
        cod = TablaAlumno.getValueAt(fila, 0).toString();
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Realmente Desea Eliminar al Alumno", "CONFIRMAR", 2);
        try {
            if (confirmacion == 0) {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM ALUMNO WHERE DNI_Alumno='" + cod + "'");
                pst.executeUpdate();
                mostrardatos("");
                inhabilitar();
                JOptionPane.showMessageDialog(null, "Alumno Eliminado Correctamente", "Eliminando Registro", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuEliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtdniActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtapepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapepActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtapepActionPerformed

    private void txtapemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapemActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtapemActionPerformed

    private void txtgradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgradoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtgradoActionPerformed

    private void txtseccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtseccionActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtseccionActionPerformed

    private void txtdireccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtdireccActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txttelefonoActionPerformed

    private void cbosexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbosexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbosexoActionPerformed

    //private Connection connec=new ConexionMysql().conectar();
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
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAlumno;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbosexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JMenuItem menuEditar;
    private javax.swing.JMenuItem menuEliminar;
    private javax.swing.JTextField txtapem;
    private javax.swing.JTextField txtapep;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdirecc;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtgrado;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtseccion;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

    private void mostardatos(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
