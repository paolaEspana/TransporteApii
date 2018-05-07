package com.example.paola.transporteapi.api;

public class EmpresaTransporte
{
    private String direcci_n;
    private String nombre_de_la_empresa;
    private String clase;
    private String modalidad;
    private String nit;
    private String radio_de_acci_n;
    private String representante_legal;
    private String tel_fono;
    private String tipo_de_empresa;
    private String ciudad_de_la_sede_principal_de_la_empresa;

    public String getCiudad_de_la_sede_principal_de_la_empresa() {
        return ciudad_de_la_sede_principal_de_la_empresa;
    }

    public String getDirecci_n() {
        return direcci_n;
    }

    public String getNombre_de_la_empresa() {
        return nombre_de_la_empresa;
    }

    public String getClase() {
        return clase;
    }

    public String getModalidad() {
        return modalidad;
    }

    public String getNit() {
        return nit;
    }

    public String getRadio_de_acci_n() {
        return radio_de_acci_n;
    }

    public String getRepresentante_legal() {
        return representante_legal;
    }

    public String getTel_fono() {
        return tel_fono;
    }

    public String getTipo_de_empresa() {
        return tipo_de_empresa;
    }
}
