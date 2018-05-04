package com.example.paola.transporteapi.api;

public class EmpresaTransporte
{
    private String direccion;
    private String nombre_de_la_empresa;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_de_la_empresa() {
        return nombre_de_la_empresa;
    }

    public void setNombre_de_la_empresa(String nombre_de_la_empresa) {
        this.nombre_de_la_empresa = nombre_de_la_empresa;
    }
}
