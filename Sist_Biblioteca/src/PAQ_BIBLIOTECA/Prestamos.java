/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAQ_BIBLIOTECA;

import vistas.vista_libros;
import Datos.fprestamo;
import Logica.ConexionMysql;
import Logica.vprestamo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import vistas.vista_alumno;

/**
 *
 * @author ELVIS
 */
public final class Prestamos extends javax.swing.JFrame {

    /**
     * Creates new form Prestamos
     */
    public Prestamos() {
        initComponents();
        setLocationRelativeTo(null);
        //mostrar("");
        mostrardatos("");
        inhabilitar();
    }
    private String accion = "guardar";

    void ocultar_columnas() {
        TablaPrestamo.getColumnModel().getColumn(0).setMaxWidth(0);
        TablaPrestamo.getColumnModel().getColumn(0).setMinWidth(0);
        TablaPrestamo.getColumnModel().getColumn(0).setPreferredWidth(0);

        TablaPrestamo.getColumnModel().getColumn(1).setMaxWidth(0);
        TablaPrestamo.getColumnModel().getColumn(1).setMinWidth(0);
        TablaPrestamo.getColumnModel().getColumn(1).setPreferredWidth(0);

        TablaPrestamo.getColumnModel().getColumn(4).setMaxWidth(0);
        TablaPrestamo.getColumnModel().getColumn(4).setMinWidth(0);
        TablaPrestamo.getColumnModel().getColumn(4).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtRecibo.setEnabled(false);
        txtcod.setEnabled(false);
        txtDNIA.setEnabled(false);

        txtlibro.setEnabled(false);
        txtaño.setEnabled(false);
        txtgrado.setEnabled(false);
        txtalumno.setEnabled(false);
        txtCantidad.setEnabled(false);
        dcfecha_prestamo.setEnabled(false);
        dcfecha_devolucion.setEnabled(false);

        btnAgregar.setEnabled(false);
        btnbuscar_alumno.setEnabled(false);
        btnbuscar_libro.setEnabled(false);
        btnEditar.setEnabled(false);

        txtRecibo.setText("");
        txtDNIA.setText("");
        txtlibro.setText("");
        txtalumno.setText("");
        txtCantidad.setText("");
        txtcod.setText("");
        txtaño.setText("");
        txtgrado.setText("");

    }

    void habilitar() {
        txtRecibo.setEnabled(false);
        txtcod.setEnabled(false);
        txtDNIA.setEnabled(false);

        txtaño.setEnabled(false);
        txtgrado.setEnabled(false);
        txtlibro.setEnabled(false);
        txtalumno.setEnabled(false);
        txtCantidad.setEnabled(true);

        dcfecha_prestamo.setEnabled(true);
        dcfecha_devolucion.setEnabled(true);

        btnAgregar.setEnabled(true);
        btnbuscar_alumno.setEnabled(true);
        btnbuscar_libro.setEnabled(true);

        txtRecibo.setText("");
        txtDNIA.setText("");
        txtlibro.setText("");
        txtalumno.setText("");
        txtCantidad.setText("");
        txtcod.setText("");
        txtaño.setText("");
        txtgrado.setText("");

    }

    void desaHabiEditar() {

        btnEditar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnmostrar.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnbuscar_libro.setEnabled(true);
        btnbuscar_alumno.setEnabled(true);
        dcfecha_prestamo.setEnabled(true);
        dcfecha_devolucion.setEnabled(true);
        txtCantidad.setEnabled(true);
    }

    void desaHabiEditar2() {
        btnNuevo.setEnabled(true);
        btnmostrar.setEnabled(true);
        btnEditar.setEnabled(false);

        dcfecha_prestamo.setEnabled(false);
        dcfecha_devolucion.setEnabled(false);
        txtCantidad.setEnabled(false);
        btnbuscar_libro.setEnabled(false);
        btnbuscar_alumno.setEnabled(false);

        txtcod.setText("");
        txtlibro.setText("");
        txtaño.setText("");
        txtgrado.setText("");
        txtalumno.setText("");
        txtCantidad.setText("");
        txtDNIA.setText("");
    }

    public Integer totalregistros;

    void mostrardatos(String valor) {
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Num Recibo");
        modelo.addColumn("Cod Libro");
        modelo.addColumn("Libro");
        modelo.addColumn("Año");
        modelo.addColumn("DNI");
        modelo.addColumn("Alumno");
        modelo.addColumn("Grado");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Fecha Préstamo");
        modelo.addColumn("Fecha a Devolver");
        TablaPrestamo.setModel(modelo);
        ocultar_columnas();

        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT\n"
                    + "     prestamo_alumno.`Recibo_alumno` AS prestamo_alumno_Recibo_alumno,\n"
                    + "     prestamo_alumno.`Cod_Libro` AS prestamo_alumno_Cod_Libro,\n"
                    + "     libros.`Nombre_Libro` AS libros_Nombre_Libro,\n"
                    + "     libros.`Año` AS libros_Año,\n"
                    + "     prestamo_alumno.`DNI_Alumno` AS prestamo_alumno_DNI_Alumno,\n"
                    + "     concat(alumno.`Nombre`,' ',\n"
                    + "     alumno.`Apellido_Paterno`)AS Alumno,\n"
                    + "     concat(alumno.`Grado`,' ',\n"
                    + "     alumno.`Seccion`) AS Grado,\n"
                    + "     prestamo_alumno.`Cantidad` AS prestamo_alumno_Cantidad,\n"
                    + "     prestamo_alumno.`Fecha_Prestamo` AS prestamo_alumno_Fecha_Prestamo,\n"
                    + "     prestamo_alumno.`Fecha_Devolucion` AS prestamo_alumno_Fecha_Devolucion\n"
                    + "FROM\n"
                    + "     `alumno` alumno INNER JOIN `prestamo_alumno` prestamo_alumno ON alumno.`DNI_Alumno` = prestamo_alumno.`DNI_Alumno`\n"
                    + "     INNER JOIN `libros` libros ON prestamo_alumno.`Cod_Libro` = libros.`Cod_Libro` order by Recibo_alumno desc ";
        } else {
            sql = "SELECT * FROM PRESTAMO_ALUMNO WHERE (Cod_Libro='" + valor + "' OR DNI_Alumno='" + valor + "')";
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
                datos[9] = rs.getString(10);

                totalregistros = totalregistros + 1;

                modelo.addRow(datos);
                lbltotalregistros.setText("Total Prestamos a Alumnos: " + Integer.toString(totalregistros));
            }
            TablaPrestamo.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuEliminar = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenuItem();
        PrestamosProfesor = new javax.swing.JPanel();
        txtRecibo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtlibro = new javax.swing.JTextField();
        txtcod = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnbuscar_libro = new javax.swing.JButton();
        btnbuscar_alumno = new javax.swing.JButton();
        dcfecha_devolucion = new com.toedter.calendar.JDateChooser();
        dcfecha_prestamo = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtDNIA = new javax.swing.JTextField();
        txtalumno = new javax.swing.JTextField();
        txtaño = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtgrado = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPrestamo = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnmostrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();

        menuEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuEliminar.setForeground(new java.awt.Color(0, 0, 102));
        menuEliminar.setText("Eliminar");
        menuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEliminar);

        menuEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menuEditar.setForeground(new java.awt.Color(102, 102, 0));
        menuEditar.setText("Editar");
        menuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEditar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REALIZAR PRESTAMO");

        PrestamosProfesor.setBackground(new java.awt.Color(153, 102, 0));
        PrestamosProfesor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Realizar Préstamo Para Alumno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 0, 22), new java.awt.Color(204, 255, 51))); // NOI18N
        PrestamosProfesor.setForeground(new java.awt.Color(0, 204, 51));
        PrestamosProfesor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReciboActionPerformed(evt);
            }
        });
        PrestamosProfesor.add(txtRecibo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 60, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Año:");
        PrestamosProfesor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        txtlibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlibroActionPerformed(evt);
            }
        });
        PrestamosProfesor.add(txtlibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 100, -1));
        PrestamosProfesor.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 60, -1));
        PrestamosProfesor.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 100, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("Cantidad:");
        PrestamosProfesor.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Fecha a Devolver:");
        PrestamosProfesor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setText("Fecha de Préstamo:");
        PrestamosProfesor.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        btnbuscar_libro.setBackground(new java.awt.Color(204, 255, 51));
        btnbuscar_libro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar_libro.setText("Libro");
        btnbuscar_libro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_libroActionPerformed(evt);
            }
        });
        PrestamosProfesor.add(btnbuscar_libro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 80, -1));

        btnbuscar_alumno.setBackground(new java.awt.Color(204, 255, 51));
        btnbuscar_alumno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar_alumno.setText("Alumno");
        btnbuscar_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_alumnoActionPerformed(evt);
            }
        });
        PrestamosProfesor.add(btnbuscar_alumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 80, -1));
        PrestamosProfesor.add(dcfecha_devolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 120, -1));
        PrestamosProfesor.add(dcfecha_prestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 120, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Grado:");
        PrestamosProfesor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));
        PrestamosProfesor.add(txtDNIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 80, -1));
        PrestamosProfesor.add(txtalumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 160, 100, -1));
        PrestamosProfesor.add(txtaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 60, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Libro:");
        PrestamosProfesor.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Alumno:");
        PrestamosProfesor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        txtgrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgradoActionPerformed(evt);
            }
        });
        PrestamosProfesor.add(txtgrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 60, -1));

        btnEditar.setBackground(new java.awt.Color(255, 153, 51));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(204, 0, 0));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Editarr.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        TablaPrestamo.setBackground(new java.awt.Color(204, 255, 102));
        TablaPrestamo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        TablaPrestamo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TablaPrestamo.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaPrestamo.setComponentPopupMenu(jPopupMenu1);
        TablaPrestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaPrestamoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TablaPrestamoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(TablaPrestamo);

        btnNuevo.setBackground(new java.awt.Color(255, 153, 51));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(204, 0, 0));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(255, 153, 51));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(204, 0, 0));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardarR.png"))); // NOI18N
        btnAgregar.setText("Guardar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnmostrar.setBackground(new java.awt.Color(255, 153, 51));
        btnmostrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmostrar.setForeground(new java.awt.Color(204, 0, 0));
        btnmostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mostrar.png"))); // NOI18N
        btnmostrar.setText("Mostrar");
        btnmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostrarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("REALIZAR PRÉSTAMOS");

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
                .addGap(328, 328, 328)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnsalir))
                .addContainerGap())
        );

        lbltotalregistros.setBackground(new java.awt.Color(255, 102, 0));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(51, 0, 204));
        lbltotalregistros.setText("total");
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PrestamosProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnmostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addComponent(PrestamosProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        vprestamo dts = new vprestamo();
        fprestamo func = new fprestamo();

        dts.setCod_libro(txtcod.getText());
        dts.setDni_alumno(txtDNIA.getText());
        dts.setCantidad(Integer.parseInt(txtCantidad.getText()));

        Calendar cal;
        int d, m, a;
        cal = dcfecha_prestamo.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_prestamo(new Date(a, m, d));

        cal = dcfecha_devolucion.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        dts.setFecha_devolucion(new Date(a, m, d));

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Préstamo Fue Registrado Correctamente");
                //   mostrar("");
                mostrardatos("");
                inhabilitar();

            }

        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostrarActionPerformed

        mostrardatos("");
    }//GEN-LAST:event_btnmostrarActionPerformed
    String id = "";
    private void menuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarActionPerformed

        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();
        int fila = TablaPrestamo.getSelectedRow();
        String cod = "";
        cod = TablaPrestamo.getValueAt(fila, 0).toString();
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Realmente Desea Eliminar el Préstamo", "CONFIRMAR", 2);
        try {
            if (confirmacion == 0) {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM PRESTAMO_ALUMNO WHERE Recibo_alumno='" + cod + "'");
                pst.executeUpdate();
                mostrardatos("");
                inhabilitar();
                JOptionPane.showMessageDialog(null, "Préstamo Eliminado Correctamente", "Eliminando Registro", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuEliminarActionPerformed

    private void TablaPrestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPrestamoMouseClicked
        
    }//GEN-LAST:event_TablaPrestamoMouseClicked

    private void btnbuscar_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_alumnoActionPerformed
        // TODO add your handling code here:
        vista_alumno alumn = new vista_alumno();
        alumn.setVisible(true);
    }//GEN-LAST:event_btnbuscar_alumnoActionPerformed

    private void btnbuscar_libroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_libroActionPerformed
        // TODO add your handling code here:
        vista_libros lib = new vista_libros();
        lib.setVisible(true);
    }//GEN-LAST:event_btnbuscar_libroActionPerformed

    private void txtlibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlibroActionPerformed

    private void txtReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReciboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReciboActionPerformed

    private void txtgradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgradoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        // TODO add your handling code here:
        int fila = TablaPrestamo.getSelectedRow();
        if (fila >= 0) {
            txtcod.setText(TablaPrestamo.getValueAt(fila, 1).toString());
            txtlibro.setText(TablaPrestamo.getValueAt(fila, 2).toString());
            txtaño.setText(TablaPrestamo.getValueAt(fila, 3).toString());
            txtDNIA.setText(TablaPrestamo.getValueAt(fila, 4).toString());
            txtalumno.setText(TablaPrestamo.getValueAt(fila, 5).toString());
            txtgrado.setText(TablaPrestamo.getValueAt(fila, 6).toString());
            txtCantidad.setText(TablaPrestamo.getValueAt(fila, 7).toString());
            id = TablaPrestamo.getValueAt(fila, 0).toString();
            desaHabiEditar();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_menuEditarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();

        try {

            PreparedStatement pst = cn.prepareStatement("UPDATE PRESTAMO_ALUMNO SET Cod_Libro='" + txtcod.getText() + "',DNI_Alumno='" + txtDNIA.getText() + "',Cantidad='" + txtCantidad.getText()
                    + "' WHERE Recibo_alumno='" + id + "' ");
            id = txtcod.getText();
            pst.executeUpdate();
            mostrardatos("");
            desaHabiEditar2();

            JOptionPane.showMessageDialog(null, "Datos del Préstamo Editado Correctamente", "Editando Registro", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            java.lang.System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al Editar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed
    private Connection conec = new ConexionMysql().conexion();

    private void TablaPrestamoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaPrestamoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaPrestamoMouseEntered

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
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prestamos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PrestamosProfesor;
    private javax.swing.JTable TablaPrestamo;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnbuscar_alumno;
    private javax.swing.JButton btnbuscar_libro;
    private javax.swing.JButton btnmostrar;
    private javax.swing.JButton btnsalir;
    private com.toedter.calendar.JDateChooser dcfecha_devolucion;
    private com.toedter.calendar.JDateChooser dcfecha_prestamo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JMenuItem menuEditar;
    private javax.swing.JMenuItem menuEliminar;
    private javax.swing.JTextField txtCantidad;
    public static javax.swing.JTextField txtDNIA;
    private javax.swing.JTextField txtRecibo;
    public static javax.swing.JTextField txtalumno;
    public static javax.swing.JTextField txtaño;
    public static javax.swing.JTextField txtcod;
    public static javax.swing.JTextField txtgrado;
    public static javax.swing.JTextField txtlibro;
    // End of variables declaration//GEN-END:variables
}
