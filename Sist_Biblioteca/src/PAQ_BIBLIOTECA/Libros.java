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
import vistas.vista_categoria;

/**
 *
 */
public class Libros extends javax.swing.JFrame {

    /**
     * Creates new form Libros
     */
    public Libros() {
        initComponents();
        setLocationRelativeTo(null);
        mostrardatos("");
        inhabilitar();
        ocultar_columnas();
    }

    void inhabilitar() {
        txtCod.setEnabled(false);
        txtLibro.setEnabled(false);
        txtAutor.setEnabled(false);
        txtEditorial.setEnabled(false);
        txtAño.setEnabled(false);
        btnAgregar.setEnabled(false);
        btnEditar.setEnabled(false);
        txtcodcat.setEnabled(false);
        txtcateg.setEnabled(false);
        btnbuscar_categoria.setEnabled(false);

        txtCod.setText("");
        txtLibro.setText("");
        txtEditorial.setText("");
        txtAño.setText("");
        txtAutor.setText("");
        txtcateg.setText("");
        txtcodcat.setText("");

    }

    void habilitar() {
        txtCod.setEnabled(true);
        txtLibro.setEnabled(true);
        txtAutor.setEnabled(true);
        txtEditorial.setEnabled(true);
        txtAño.setEnabled(true);
        btnAgregar.setEnabled(true);
        txtcodcat.setEnabled(false);
        txtcateg.setEnabled(false);
        btnbuscar_categoria.setEnabled(true);

        txtCod.setText("");
        txtLibro.setText("");
        txtAutor.setText("");
        txtEditorial.setText("");
        txtAño.setText("");
        txtcodcat.setText("");
        txtcateg.setText("");
    }

    void desaHabiEditar() {
        txtCod.setEnabled(true);
        txtLibro.setEnabled(true);
        txtAutor.setEnabled(true);
        txtEditorial.setEnabled(true);
        txtAño.setEnabled(true);
        btnbuscar_categoria.setEnabled(true);

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
        btnbuscar_categoria.setEnabled(false);

        txtCod.setEnabled(false);
        txtLibro.setEnabled(false);
        txtAutor.setEnabled(false);
        txtEditorial.setEnabled(false);
        txtAño.setEnabled(false);

        txtCod.setText("");
        txtLibro.setText("");
        txtAutor.setText("");
        txtEditorial.setText("");
        txtAño.setText("");
        txtcodcat.setText("");
        txtcateg.setText("");
    }

    void ocultar_columnas() {
        TablaLibros.getColumnModel().getColumn(2).setMaxWidth(2);
        TablaLibros.getColumnModel().getColumn(2).setMinWidth(2);
        TablaLibros.getColumnModel().getColumn(2).setPreferredWidth(2);
    }

    public Integer totalregistros;

    void mostrardatos(String valor) {
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaLibros = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbltotalregistros = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtLibro = new javax.swing.JTextField();
        txtAño = new javax.swing.JTextField();
        txtEditorial = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcodcat = new javax.swing.JTextField();
        txtcateg = new javax.swing.JTextField();
        btnbuscar_categoria = new javax.swing.JButton();

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
        menuEliminar.setForeground(new java.awt.Color(153, 51, 0));
        menuEliminar.setText("Eliminar");
        menuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(menuEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRAR LIBROS");
        setBackground(new java.awt.Color(255, 204, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaLibros.setBackground(new java.awt.Color(153, 255, 255));
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
        TablaLibros.setComponentPopupMenu(jPopupMenu1);
        TablaLibros.setGridColor(new java.awt.Color(0, 0, 102));
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 500, 239));

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
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 100, 40));

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
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 100, 40));

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
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 100, 40));
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 120, 30));

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
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, -1, 40));

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
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, 40));

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51)));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("REGISTRAR  LIBROS");

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

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Libros.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel9)
                .addGap(87, 87, 87)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsalir))
                .addContainerGap())
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 770, 50));

        lbltotalregistros.setBackground(new java.awt.Color(255, 102, 0));
        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(0, 0, 204));
        lbltotalregistros.setText("total");
        lbltotalregistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)));
        getContentPane().add(lbltotalregistros, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 130, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("Buscar por Código o Nombre :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtLibro.setBackground(new java.awt.Color(255, 255, 204));
        txtLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLibroActionPerformed(evt);
            }
        });

        txtAño.setBackground(new java.awt.Color(255, 255, 204));
        txtAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAñoActionPerformed(evt);
            }
        });

        txtEditorial.setBackground(new java.awt.Color(255, 255, 204));
        txtEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEditorialActionPerformed(evt);
            }
        });

        txtAutor.setBackground(new java.awt.Color(255, 255, 204));
        txtAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAutorActionPerformed(evt);
            }
        });

        txtCod.setBackground(new java.awt.Color(255, 255, 204));
        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("Libro:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 0));
        jLabel5.setText("Editorial:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("Código:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 0));
        jLabel7.setText("Año:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("Autor:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 0));
        jLabel8.setText("Categoría:");

        txtcodcat.setBackground(new java.awt.Color(255, 255, 204));
        txtcodcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodcatActionPerformed(evt);
            }
        });

        txtcateg.setBackground(new java.awt.Color(255, 255, 204));
        txtcateg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcategActionPerformed(evt);
            }
        });

        btnbuscar_categoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnbuscar_categoria.setText("...");
        btnbuscar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_categoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtcodcat, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbuscar_categoria))
                            .addComponent(txtcateg, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcodcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar_categoria)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtcateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(71, 71, 71))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 250, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaLibrosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_TablaLibrosAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaLibrosAncestorAdded

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
        txtCod.transferFocus();
    }//GEN-LAST:event_txtCodActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        mostrardatos(txtbuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed
    String id = "";
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        mostrardatos("");
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();

        if (txtCod.getText().equals("") || txtLibro.getText().equals("") || txtcodcat.getText().equals("")
                || txtAutor.getText().equals("") || txtEditorial.getText().equals("") || txtAño.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Todos los Campos son Obligatorios,COMPLETAR", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

        } else {
            try {
                PreparedStatement pst = cn.prepareStatement("INSERT INTO LIBROS(Cod_Libro,Nombre_Libro,id_categoria,Autor,Editorial,Año) VALUES(?,?,?,?,?,?)");
                pst.setString(1, txtCod.getText());
                pst.setString(2, txtLibro.getText());
                pst.setString(3, txtcodcat.getText());
                pst.setString(4, txtAutor.getText());
                pst.setString(5, txtEditorial.getText());
                pst.setString(6, txtAño.getText());
                int a = pst.executeUpdate();
                if (a > 0) {
                    JOptionPane.showMessageDialog(null, "Libro Registrado Correctamente", "Guardando Registro", JOptionPane.INFORMATION_MESSAGE);
                    mostrardatos("");
                    ocultar_columnas();
                    inhabilitar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
            } // TO
        }


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();

        try {

            PreparedStatement pst = cn.prepareStatement("UPDATE LIBROS SET Nombre_Libro='" + txtLibro.getText() + "',Cod_Libro='" + txtCod.getText() + "',id_categoria='" + txtcodcat.getText()
                    + "',Autor='" + txtAutor.getText() + "',Editorial='" + txtEditorial.getText() + "',Año='" + txtAño.getText() + "' WHERE Cod_Libro='" + id + "' ");
            id = txtCod.getText();
            pst.executeUpdate();
            mostrardatos("");
            ocultar_columnas();
            desaHabiEditar2();
            JOptionPane.showMessageDialog(null, "Datos del Libro Editado Correctamente", "Editando Registro", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            java.lang.System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al Editar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void menuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarActionPerformed
        // TODO add your handling code here:
        int fila = TablaLibros.getSelectedRow();
        if (fila >= 0) {
            txtCod.setText(TablaLibros.getValueAt(fila, 0).toString());
            txtLibro.setText(TablaLibros.getValueAt(fila, 1).toString());
            txtcodcat.setText(TablaLibros.getValueAt(fila, 2).toString());
            txtcateg.setText(TablaLibros.getValueAt(fila, 3).toString());
            txtAutor.setText(TablaLibros.getValueAt(fila, 4).toString());
            txtEditorial.setText(TablaLibros.getValueAt(fila, 5).toString());
            txtAño.setText(TablaLibros.getValueAt(fila, 6).toString());
            id = TablaLibros.getValueAt(fila, 0).toString();
            desaHabiEditar();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuEditarActionPerformed

    private void menuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEliminarActionPerformed
        // TODO add your handling code here:
        ConexionMysql cc = new ConexionMysql();
        Connection cn = cc.conexion();
        int fila = TablaLibros.getSelectedRow();
        String cod = "";
        cod = TablaLibros.getValueAt(fila, 0).toString();
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Realmente Desea Eliminar el Libro", "CONFIRMAR", 2);
        try {
            if (confirmacion == 0) {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM LIBROS WHERE Cod_Libro='" + cod + "'");
                pst.executeUpdate();
                mostrardatos("");
                ocultar_columnas();
                inhabilitar();
                JOptionPane.showMessageDialog(null, "Libro Eliminado Correctamente", "Eliminando Registro", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuEliminarActionPerformed

    private Connection conec = new ConexionMysql().conexion();

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLibroActionPerformed
        // TODO add your handling code here:
        txtLibro.transferFocus();
    }//GEN-LAST:event_txtLibroActionPerformed

    private void txtAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActionPerformed
        // TODO add your handling code here:
        txtAutor.transferFocus();
    }//GEN-LAST:event_txtAutorActionPerformed

    private void txtEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEditorialActionPerformed
        // TODO add your handling code here:
        txtEditorial.transferFocus();
    }//GEN-LAST:event_txtEditorialActionPerformed

    private void txtAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAñoActionPerformed
        // TODO add your handling code here:
        txtAño.transferFocus();
    }//GEN-LAST:event_txtAñoActionPerformed

    private void txtcodcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodcatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodcatActionPerformed

    private void txtcategActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcategActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcategActionPerformed

    private void btnbuscar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_categoriaActionPerformed
        // TODO add your handling code here:
        vista_categoria categ = new vista_categoria();
        categ.setVisible(true);
    }//GEN-LAST:event_btnbuscar_categoriaActionPerformed

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
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaLibros;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnbuscar_categoria;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JMenuItem menuEditar;
    private javax.swing.JMenuItem menuEliminar;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtLibro;
    private javax.swing.JTextField txtbuscar;
    public static javax.swing.JTextField txtcateg;
    public static javax.swing.JTextField txtcodcat;
    // End of variables declaration//GEN-END:variables

}
