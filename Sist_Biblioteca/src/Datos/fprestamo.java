 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Logica.ConexionMysql;
import Logica.vprestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;



public class fprestamo {
    private ConexionMysql mysql=new ConexionMysql();
    private Connection cn=mysql.conexion();
    private String sSQL="";
   
     
        
    public boolean insertar(vprestamo dts){
        sSQL="insert into PRESTAMO_ALUMNO (Cod_Libro,DNI_Alumno,Cantidad,Fecha_Prestamo,Fecha_Devolucion)" +
               "values (?,?,?,?,?)";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            pst.setString(1, dts.getCod_libro());
            pst.setString(2, dts.getDni_alumno());
            pst.setInt(3, dts.getCantidad());
            pst.setDate(4, dts.getFecha_prestamo());
            pst.setDate(5, dts.getFecha_devolucion());
            
            int n=pst.executeUpdate();
            
            if (n!=0) {
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
                
   }
        
   }
