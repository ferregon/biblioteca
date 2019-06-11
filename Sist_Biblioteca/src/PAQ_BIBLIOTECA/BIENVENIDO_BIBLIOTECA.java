/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAQ_BIBLIOTECA;

import Logica.ConexionMysql;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import vistas.vista_alumno;
import vistas.vista_libros;
import vistas.vista_profe;
import javax.swing.Timer;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ELVIS
 */
public class BIENVENIDO_BIBLIOTECA extends javax.swing.JFrame {

    /**
     * Creates new form BIENVENIDO_BIBLIOTECA
     */
    public BIENVENIDO_BIBLIOTECA() {
        initComponents();
        //setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("SISTEMA DE BIBLIOTECA");

        //fecha del sistema
        Date sistemaFech = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
        fecha.setText(formato.format(sistemaFech));

        //Hora del sistema
        Timer tiempo = new Timer(100, new BIENVENIDO_BIBLIOTECA.horas());
        tiempo.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblimagen = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fecha = new javax.swing.JLabel();
        hora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuadmin = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(6);
        setResizable(false);

        lblimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/book.jpeg"))); // NOI18N

        lblusuario.setBackground(new java.awt.Color(0, 0, 102));
        lblusuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(102, 0, 0));
        lblusuario.setText("Usuario:");
        lblusuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fecha.setForeground(new java.awt.Color(0, 102, 204));
        fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fecha.setText("FECHA  ");

        hora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hora.setForeground(new java.awt.Color(0, 102, 204));
        hora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hora.setText("HORA");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("HORA:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("FECHA:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hora)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha)
                    .addComponent(jLabel2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );

        jMenuBar2.setBackground(new java.awt.Color(102, 102, 0));
        jMenuBar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar2.setForeground(new java.awt.Color(204, 0, 0));

        jMenu4.setBackground(new java.awt.Color(204, 204, 0));
        jMenu4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu4.setForeground(new java.awt.Color(102, 0, 0));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sistema.png"))); // NOI18N
        jMenu4.setText("SISTEMA BIBLIOTECA");

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem6.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sesion.png"))); // NOI18N
        jMenuItem6.setText("Cerrar Sesión");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem12.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salirr.png"))); // NOI18N
        jMenuItem12.setText("Salir");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuBar2.add(jMenu4);

        jMenu5.setForeground(new java.awt.Color(0, 102, 204));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/añadir libro.png"))); // NOI18N
        jMenu5.setText("Añadir");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem1.setText("Categoría");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem8.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem8.setText("Libros");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuBar2.add(jMenu5);

        jMenu2.setForeground(new java.awt.Color(0, 102, 204));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/agregar_usuarios.png"))); // NOI18N
        jMenu2.setText("Registrar");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setBackground(new java.awt.Color(255, 255, 0));
        jMenuItem4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem4.setText("Profesores");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem9.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem9.setText("Alumnos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar2.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(0, 102, 204));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/prestamo.png"))); // NOI18N
        jMenu3.setText("Movimientos");

        jMenu1.setForeground(new java.awt.Color(51, 102, 0));
        jMenu1.setText("Préstamos Para");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem2.setText("Profesor");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem3.setText("Alumno");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenu3.add(jMenu1);

        jMenuBar2.add(jMenu3);

        jMenu7.setForeground(new java.awt.Color(0, 102, 204));
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/consultar.png"))); // NOI18N
        jMenu7.setText("Consultas");

        jMenuItem13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem13.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem13.setText("Alumnos");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem13);

        jMenuItem14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem14.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem14.setText("Profesores");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem14);

        jMenuItem15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem15.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem15.setText("Libros");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem15);

        jMenuBar2.add(jMenu7);

        jMenu10.setForeground(new java.awt.Color(0, 102, 204));
        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/reporte.png"))); // NOI18N
        jMenu10.setText("Reportes");

        jMenuItem16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem16.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem16.setText("Libros");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem16);

        jMenu11.setForeground(new java.awt.Color(51, 102, 0));
        jMenu11.setText("Usuarios");

        jMenuItem17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem17.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem17.setText("Profesores");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem17);

        jMenuItem18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem18.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem18.setText("Alumnos");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem18);

        jMenu10.add(jMenu11);

        jMenu12.setForeground(new java.awt.Color(51, 102, 0));
        jMenu12.setText("Préstamos a");

        jMenuItem19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem19.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem19.setText("Profesores");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem19);

        jMenuItem20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem20.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem20.setText("Alumos");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem20);

        jMenu10.add(jMenu12);

        jMenuBar2.add(jMenu10);

        jMenu6.setForeground(new java.awt.Color(0, 102, 204));
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/configuracion-.png"))); // NOI18N
        jMenu6.setText("Configuracion");

        jMenuItem5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem5.setText("Cambiar Fondo ");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuBar2.add(jMenu6);

        menuadmin.setForeground(new java.awt.Color(0, 102, 204));
        menuadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/administrador.png"))); // NOI18N
        menuadmin.setText("Administrador");

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem7.setText("Registrar Usuario");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuadmin.add(jMenuItem7);

        jMenuBar2.add(menuadmin);

        jMenu8.setBackground(new java.awt.Color(204, 204, 0));
        jMenu8.setForeground(new java.awt.Color(0, 102, 204));
        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/ayuda.png"))); // NOI18N
        jMenu8.setText("Ayuda");

        jMenu9.setForeground(new java.awt.Color(51, 102, 0));
        jMenu9.setText("Acerca de");

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem10.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem10.setText("Sistema");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenuItem11.setForeground(new java.awt.Color(51, 102, 0));
        jMenuItem11.setText("Manual de Usuario");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem11);

        jMenu8.add(jMenu9);

        jMenuBar2.add(jMenu8);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblusuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(lblimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    class horas implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Date sistemaHora = new Date();
            String pmAm = "hh:mm:ss a";
            SimpleDateFormat formato = new SimpleDateFormat(pmAm);
            Calendar now = Calendar.getInstance();
            hora.setText(String.format(formato.format(sistemaHora), now));
        }
    }


    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Profesores profe = new Profesores();
        profe.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        Alumnos alum = new Alumnos();
        alum.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:7
        Categoria cat = new Categoria();
        cat.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Prestamo_profe prest = new Prestamo_profe();
        prest.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Prestamos prest = new Prestamos();
        prest.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        System sist = new System();
        sist.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        ManualSystem man = new ManualSystem();
        man.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        dispose();
        LOGIN log = new LOGIN();
        log.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        Configuracion conf = new Configuracion();
        conf.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        Registrar_Usuario usu = new Registrar_Usuario();
        usu.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        Libros lib = new Libros();
        lib.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        vista_alumno alum = new vista_alumno();
        alum.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        vista_profe profe = new vista_profe();
        profe.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        vista_libros lib = new vista_libros();
        lib.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private Connection conec = new ConexionMysql().conexion();
    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed

       /*try {
            JasperReport reporte = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/newReport2.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporte, null, this.conec);
            JasperViewer view = new JasperViewer(print, false);
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setTitle("Reporte de Libros");
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(BIENVENIDO_BIBLIOTECA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */

    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:

        try {
            JasperReport reporte = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/Alumnos.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporte, null, this.conec);
            JasperViewer view = new JasperViewer(print, false);
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setTitle("Reporte de Alumnos");
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(BIENVENIDO_BIBLIOTECA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        /* try {
            ConexionMysql cc = new ConexionMysql();
            Connection cn = cc.conexion();

            JasperReport reporte = null;
            String path = "src\\Reportes\\rptalumno.jasper";

            //Map parametro = new HashMap();
            //parametro.put("DNI_Alumno", 36);
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, cn);

            JasperViewer view = new JasperViewer(jprint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(BIENVENIDO_BIBLIOTECA.class.getName()).log(Level.SEVERE, null, ex);
        }*/


    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jMenuItem19ActionPerformed

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
            java.util.logging.Logger.getLogger(BIENVENIDO_BIBLIOTECA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BIENVENIDO_BIBLIOTECA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BIENVENIDO_BIBLIOTECA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BIENVENIDO_BIBLIOTECA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BIENVENIDO_BIBLIOTECA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel hora;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JMenu jMenu1;
    javax.swing.JMenu jMenu10;
    javax.swing.JMenu jMenu11;
    javax.swing.JMenu jMenu12;
    javax.swing.JMenu jMenu2;
    javax.swing.JMenu jMenu3;
    javax.swing.JMenu jMenu4;
    javax.swing.JMenu jMenu5;
    javax.swing.JMenu jMenu6;
    javax.swing.JMenu jMenu7;
    javax.swing.JMenu jMenu8;
    javax.swing.JMenu jMenu9;
    javax.swing.JMenuBar jMenuBar2;
    javax.swing.JMenuItem jMenuItem1;
    javax.swing.JMenuItem jMenuItem10;
    javax.swing.JMenuItem jMenuItem11;
    javax.swing.JMenuItem jMenuItem12;
    javax.swing.JMenuItem jMenuItem13;
    javax.swing.JMenuItem jMenuItem14;
    javax.swing.JMenuItem jMenuItem15;
    javax.swing.JMenuItem jMenuItem16;
    javax.swing.JMenuItem jMenuItem17;
    javax.swing.JMenuItem jMenuItem18;
    javax.swing.JMenuItem jMenuItem19;
    javax.swing.JMenuItem jMenuItem2;
    javax.swing.JMenuItem jMenuItem20;
    javax.swing.JMenuItem jMenuItem3;
    javax.swing.JMenuItem jMenuItem4;
    javax.swing.JMenuItem jMenuItem5;
    javax.swing.JMenuItem jMenuItem6;
    javax.swing.JMenuItem jMenuItem7;
    javax.swing.JMenuItem jMenuItem8;
    javax.swing.JMenuItem jMenuItem9;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lblimagen;
    public static javax.swing.JLabel lblusuario;
    javax.swing.JMenu menuadmin;
    // End of variables declaration//GEN-END:variables

}
