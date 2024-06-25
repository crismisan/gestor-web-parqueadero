/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author usuario
 */
public class Estacionamiento {
    int id_plaza, numero_plaza, estado;
    String tipo_vehiculo;

    public Estacionamiento() {
    }

    public Estacionamiento(int id_plaza, int numero_plaza, String tipo_vehiculo, int estado) {
        this.id_plaza = id_plaza;
        this.numero_plaza = numero_plaza;
        this.tipo_vehiculo = tipo_vehiculo;
        this.estado = estado;
    }

    public int getId_plaza() {
        return id_plaza;
    }

    public void setId_plaza(int id_plaza) {
        this.id_plaza = id_plaza;
    }

    public int getNumero_plaza() {
        return numero_plaza;
    }

    public void setNumero_plaza(int numero_plaza) {
        this.numero_plaza = numero_plaza;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
