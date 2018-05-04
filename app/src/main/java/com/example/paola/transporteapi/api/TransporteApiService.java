package com.example.paola.transporteapi.api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TransporteApiService
{
        @GET("4p32-twbt.json")
        Call<ArrayList<EmpresaTransporte>> obtenerLista();
}
