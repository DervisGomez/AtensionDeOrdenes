package org.app.atensiondeordenes;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity {
    private ListView listView;
    private ProgressDialog pd = null;
    List<Orden> listaOrden=new ArrayList<Orden>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        this.listView = (ListView) findViewById(R.id.listView);

        buscarOrdenes();

        // Register a callback to be invoked when an item in this AdapterView
        // has been clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long arg) {
                // Loads the given URL
                Orden item = (Orden) listView.getAdapter().getItem(position);
                llamarActivity(item);
            }
        });
    }

    public void llamarActivity(Orden item){
        Intent i=new Intent(this, DatosOrden.class);
        i.putExtra("id",item.getORDECONS());
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.main1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int i = item.getItemId();
        if (i == R.id.descargar_orden) {
            this.pd = ProgressDialog.show(this, "Procesando", "Espere unos segundos...", true, false);
            new MiTarea("https://appexp.akc.co/api/servlet/datamap/GEN_ORD_001/","{}").execute();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void buscarOrdenes(){
        try {
            BDOrden bda=new BDOrden(this);
            bda.abrir();
            listaOrden=bda.consultarOrdenView();
            bda.cerrar();

            if(listaOrden.size()>0){
                this.listView.setAdapter(new OrdenAdapter(this, listaOrden));
            }else{
                showAlertDialog(this, "Orden", "No hay datos para mostrar",false);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block

        }
    }

    public void cargarDatos(String datos){

        List<Orden> listaOrden=new ArrayList<Orden>();
        Orden orden= new Orden();
        listaOrden = orden.getListaOrdenJson(datos);
        try {
            BDOrden bda=new BDOrden(this);
            bda.abrir();
            int guardar=0;
            for (int x=0;x<listaOrden.size();x++){
                if(bda.consultarGuardar(listaOrden.get(x).getORDECONS())){
                    bda.registrarOrden(listaOrden.get(x));
                    guardar++;
                }
            }
            if (guardar>0){
                showAlertDialog(this, "Orden", " Ser han guardado "+String.valueOf(guardar)+" registros",false);
            }else{
                showAlertDialog(this, "Orden", "No es necesirio guardar nuevos registro su base de datos esta actualizada ",false);
            }
            bda.cerrar();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            showAlertDialog(this, "Registrar", " error: "+e.toString(),false);
        }
        this.listView.setAdapter(null);
        buscarOrdenes();
        if (this.pd != null) {
            this.pd.dismiss();
        }
    }

    public void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
//		alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);
        alertDialog.setButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        alertDialog.show();
    }
    private class MiTarea extends AsyncTask<String, Float, String> {
        private String ur;

        public MiTarea(String url,String x){
            this.ur=url+x;

        }
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... urls) {
            String responce = "";
            BufferedReader rd = null;
            try {
                URL url = new URL(ur);
                rd = new BufferedReader(new InputStreamReader(url.openStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    responce += line;
                }

            } catch (Exception e) {
            } finally {
                if (rd != null) {
                    try {
                        rd.close();
                    } catch (IOException ex) {
                    }
                }
            }
            return responce;
        }

        @Override
        protected void onProgressUpdate (Float... valores) {

        }

        @Override
        protected void onPostExecute(String tiraJson) {
            cargarDatos(tiraJson);
        }
    }
}
