package org.app.atensiondeordenes;

/**
 * Created by dervis on 16/11/16.
 */
public class Material {
    private int id;
    private String nombre;
    private int cantidad;
    private int orden;
    private String fecha;
    private String estado;

    public Material(int id, String nombre, int cantidad, int orden, String fecha, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.orden = orden;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Material(){
        this.nombre = "";
        this.cantidad = 0;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
