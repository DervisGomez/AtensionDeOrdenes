package org.app.atensiondeordenes;

/**
 * Created by dervis on 16/11/16.
 */
public class Persona {
    private int id;
    private String nombre;
    private int orden;
    private String fecha;
    private String estado;

    public Persona(int id, String nombre, int orden, String fecha, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.orden = orden;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Persona() {
        this.nombre = "";
        this.fecha = "";
        this.estado = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
