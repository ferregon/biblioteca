/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Date;

/**
 *
 * @author ELVIS
 */
public class vprestamo_profe {
    private int num_recibo;
    private String dni_profesor;
    private String cod_libro;
    private int cantidad;
    private Date fecha_prestamo;
    private Date fecha_devolucion;

    public vprestamo_profe() {
    }

    public vprestamo_profe(int num_recibo, String dni_profesor, String cod_libro, int cantidad, Date fecha_prestamo, Date fecha_devolucion) {
        this.num_recibo = num_recibo;
        this.dni_profesor = dni_profesor;
        this.cod_libro = cod_libro;
        this.cantidad = cantidad;
        this.fecha_prestamo = fecha_prestamo;
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getNum_recibo() {
        return num_recibo;
    }

    public void setNum_recibo(int num_recibo) {
        this.num_recibo = num_recibo;
    }

    public String getDni_profesor() {
        return dni_profesor;
    }

    public void setDni_profesor(String dni_profesor) {
        this.dni_profesor = dni_profesor;
    }

    public String getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(String cod_libro) {
        this.cod_libro = cod_libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }
    
}
