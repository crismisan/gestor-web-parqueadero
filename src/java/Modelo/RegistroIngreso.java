/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author usuario
 */
public class RegistroIngreso {
    int id_ingreso, id_vehiculo, numero_parqueadero;
    String placa, tipo, propietario;
    Date fecha_ingreso;

    public RegistroIngreso() {
    }

    public RegistroIngreso(int id_ingreso, int id_vehiculo, String propietario, String placa, String tipo, String parqueadero, Date fecha_ingreso) {
        this.id_ingreso = id_ingreso;
        this.id_vehiculo = id_vehiculo;
        this.numero_parqueadero = numero_parqueadero;
        this.placa = placa;
        this.tipo = tipo;
        this.propietario = propietario;
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_ingreso() {
        return id_ingreso;
    }

    public void setId_ingreso(int id_ingreso) {
        this.id_ingreso = id_ingreso;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getNumero_parqueadero() {
        return numero_parqueadero;
    }

    public void setNumero_parqueadero(int numero_parqueadero) {
        this.numero_parqueadero = numero_parqueadero;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }


    
    
}
