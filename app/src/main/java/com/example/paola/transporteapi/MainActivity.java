package com.example.paola.transporteapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.paola.transporteapi.api.EmpresaTransporte;
import com.example.paola.transporteapi.api.ListTransporteAdapter;
import com.example.paola.transporteapi.api.TransporteApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListTransporteAdapter listaTransporte;
    private boolean aptoParaCargar;
    final String TAG = "TRANSPORTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/").addConverterFactory(GsonConverterFactory.create()).build();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaTransporte = new ListTransporteAdapter(this);
        recyclerView.setAdapter(listaTransporte);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy >0){
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if(aptoParaCargar) {
                        if ((visibleItemCount +pastVisibleItems ) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final");
                            aptoParaCargar = false;

                            procesarDatos();
                        }
                    }
                }
            }
        });


        aptoParaCargar = true;
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
                    aptoParaCargar = true;
                    ArrayList<EmpresaTransporte>  empresas = response.body();


                        listaTransporte.adicionarEmpresa(empresas);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<EmpresaTransporte>> call, Throwable t) {
                //falla
                aptoParaCargar = true;
                Log.e(TAG," on Failure "+ t.getMessage());
            }
        });

    }
}

