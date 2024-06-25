/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author usuario
 */
public class Vehiculos {
    int id_vehiculo, id_usuario_propietario, modelo;
    String tipo, placa, marca, color;

    public Vehiculos() {
    }

    public Vehiculos(int id_vehiculo, int id_usuario_propietario, int modelo, String tipo, String placa, String marca, String color) {
        this.id_vehiculo = id_vehiculo;
        this.id_usuario_propietario = id_usuario_propietario;
        this.modelo = modelo;
        this.tipo = tipo;
        this.placa = placa;
        this.marca = marca;
        this.color = color;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_usuario_propietario() {
        return id_usuario_propietario;
    }

    public void setId_usuario_propietario(int id_usuario_propietario) {
        this.id_usuario_propietario = id_usuario_propietario;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
