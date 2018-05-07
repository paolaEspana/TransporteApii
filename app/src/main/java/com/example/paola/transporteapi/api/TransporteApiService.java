package com.example.paola.transporteapi.api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TransporteApiService
{
        @GET("f6bk-epfq.json")
        Call<ArrayList<EmpresaTransporte>> obtenerLista();
}
