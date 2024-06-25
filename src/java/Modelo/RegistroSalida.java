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
import java.sql.Timestamp;

public class RegistroSalida {
     int id_salida;
     int id_entrada;
     Date fecha_salida;
     int monto_pagado;

    public int getId_salida() {
        return id_salida;
    }

    public void setId_salida(int id_salida) {
        this.id_salida = id_salida;
    }

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(int id_entrada) {
        this.id_entrada = id_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public int getMonto_pagado() {
        return monto_pagado;
    }

    public void setMonto_pagado(int monto_pagado) {
        this.monto_pagado = monto_pagado;
    }
}

