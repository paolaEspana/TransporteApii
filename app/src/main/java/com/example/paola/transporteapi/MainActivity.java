package com.example.paola.transporteapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.paola.transporteapi.api.EmpresaTransporte;
import com.example.paola.transporteapi.api.TransporteApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/").addConverterFactory(GsonConverterFactory.create()).build();


        procesarDatos();
    }

    private void procesarDatos() {

        TransporteApiService service = retrofit.create(TransporteApiService.class);

        Call<ArrayList<EmpresaTransporte>> respesutaApi = service.obtenerLista();

        respesutaApi.enqueue(new Callback<ArrayList<EmpresaTransporte>>() {
            @Override
            public void onResponse(Call<ArrayList<EmpresaTransporte>> call, Response<ArrayList<EmpresaTransporte>> response)
            {
                if (response.isSuccessful())
                {
                    ArrayList<EmpresaTransporte>  empresas = response.body();

                    for(int i=0; i<empresas.size(); i++)
                    {
                        EmpresaTransporte empresa = empresas.get(i);

                        Log.i("Transporte", "nombre: " + empresa.getNombre_de_la_empresa()+ ", direccion: "+empresa.getDireccion());
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EmpresaTransporte>> call, Throwable t) {
                //falla
                Log.e("mi", " OnFailure: " + t.getMessage());
            }
        });

    }
}

