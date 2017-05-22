package org.app.atensiondeordenes;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_IV extends Fragment {
    private List<Material> listaOrden=new ArrayList<Material>();
    private int orden;
    private EditText etNombre;
    private EditText etCantidad;
    private Button btnRegresar;
    private Button btnGuardar;
    private Button btnNuevo;
    private View rootView;
    private ScrollView formulario;
    private ScrollView lista;

    public Fragment_IV() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment__iv, container, false);
        etNombre=(EditText)rootView.findViewById(R.id.etNombreMaterial);
        etCantidad=(EditText)rootView.findViewById(R.id.etCantidadMaterial);
        btnRegresar=(Button)rootView.findViewById(R.id.btnRegresarMaterial);
        btnGuardar=(Button)rootView.findViewById(R.id.btnGuardarMaterial);
        btnNuevo=(Button)rootView.findViewById(R.id.btnNuevoMaterial);
        formulario=(ScrollView) rootView.findViewById(R.id.formularioMaterial);
        lista=(ScrollView) rootView.findViewById(R.id.listaMaterial);
        formulario.setVisibility(View.GONE);
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista.setVisibility(View.GONE);
                formulario.setVisibility(View.VISIBLE);
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre=etNombre.getText().toString();
                String cantidad=etCantidad.getText().toString();
                if(nombre.length()>0&&cantidad.length()>0){
                    try {
                        Material material=new Material(0,nombre,Integer.valueOf(cantidad),orden,"","Activo");
                        BDOrden bdOrden=new BDOrden(rootView.getContext());
                        bdOrden.abrir();
                        bdOrden.registrarMaterial(material);
                        bdOrden.cerrar();
                        showAlertDialog(rootView.getContext(), "Material", "Registro guardado",false);
                        buscarMaterial();
                        lista.setVisibility(View.VISIBLE);
                        formulario.setVisibility(View.GONE);
                        etNombre.setText("");
                        etCantidad.setText("");
                    }catch (Exception e){

                    }

                }else{
                    showAlertDialog(rootView.getContext(), "Error", "Debe especificar el nombre y cantidad",false);
                }
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lista.setVisibility(View.VISIBLE);
                formulario.setVisibility(View.GONE);
                etNombre.setText("");
                etCantidad.setText("");
            }
        });
        orden= getArguments().getInt("id");

        buscarMaterial();
        return rootView;
    }

    public void buscarMaterial(){
        try {
            BDOrden bda=new BDOrden(rootView.getContext());
            bda.abrir();
            listaOrden=bda.consultarMaterial(orden);
            bda.cerrar();
            if(listaOrden.size()>0){
                init();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            showAlertDialog(rootView.getContext(), "Error", e.toString(),false);

        }

    }

    public void init() {
        int width = rootView.getWidth();
        int desc=(width-32)*(25/100);
        int cara=(width-32)*(50/100);
        int cara1=(width-32)*(25/100);
        TableLayout stk = (TableLayout) rootView.findViewById(R.id.table_material);
        stk.removeAllViews();
        TableRow tbrow01 = new TableRow(rootView.getContext());

        TextView tv005 = new TextView(rootView.getContext());
        tv005.setHeight(4);
        tbrow01.addView(tv005);
        stk.addView(tbrow01);

        TableRow tbrow0 = new TableRow(rootView.getContext());

        TextView tv0 = new TextView(rootView.getContext());
        tv0.setText("ID");
        tv0.setTextColor(Color.BLACK);
        tv0.setGravity(Gravity.CENTER);
        tv0.setBackgroundResource(R.color.azul_3);
        tv0.setPadding(8, 8, 8, 8);
        tv0.setWidth(desc);
        tbrow0.addView(tv0);

        TextView tv01 = new TextView(rootView.getContext());
        tv01.setWidth(4);
        tbrow0.addView(tv01);

        TextView tv1 = new TextView(rootView.getContext());
        tv1.setText("NOMBRE");
        tv1.setTextColor(Color.BLACK);
        tv1.setGravity(Gravity.CENTER);
        tv1.setBackgroundResource(R.color.azul_3);
        tv1.setPadding(8, 8, 8, 8);
        tv1.setWidth(cara);
        tbrow0.addView(tv1);

        TextView tv0111 = new TextView(rootView.getContext());
        tv0111.setWidth(4);
        tbrow0.addView(tv0111);

        TextView tv11 = new TextView(rootView.getContext());
        tv11.setText("CANTIDAD");
        tv11.setTextColor(Color.BLACK);
        tv11.setGravity(Gravity.CENTER);
        tv11.setBackgroundResource(R.color.azul_3);
        tv11.setPadding(8, 8, 8, 8);
        tv11.setWidth(cara1);
        tbrow0.addView(tv11);
        stk.addView(tbrow0);

        TableRow tbrow02 = new TableRow(rootView.getContext());

        TextView tv011 = new TextView(rootView.getContext());
        tv011.setHeight(4);
        tbrow02.addView(tv011);
        stk.addView(tbrow02);

        for (int x=0;x<listaOrden.size();x++){

            TableRow tbrow=new TableRow(rootView.getContext());
            tbrow.setBackgroundResource(R.color.verde_2);

            TextView t1v = new TextView(rootView.getContext());
            t1v.setText(String.valueOf(listaOrden.get(x).getId()));
            t1v.setTextColor(Color.WHITE);
            t1v.setTop(4);
            t1v.setLeft(4);
            t1v.setRight(4);
            t1v.setBottom(4);
            t1v.setGravity(Gravity.CENTER_HORIZONTAL);
            t1v.setWidth(desc);
            tbrow.addView(t1v);

            TextView t11v = new TextView(rootView.getContext());
            t11v.setBackgroundResource(R.color.azul_4);
            t11v.setHeight(40);
            tbrow.addView(t11v);
            TextView t2v = new TextView(rootView.getContext());
            t2v.setText(listaOrden.get(x).getNombre());
            t2v.setTextColor(Color.WHITE);
            t2v.setWidth(cara);
            t2v.setTop(4);
            t2v.setLeft(4);
            t2v.setRight(4);
            t2v.setBottom(4);
            t2v.setGravity(Gravity.CENTER_HORIZONTAL);
            tbrow.addView(t2v);

            TextView t114v = new TextView(rootView.getContext());
            t114v.setBackgroundResource(R.color.azul_4);
            t114v.setHeight(40);
            tbrow.addView(t114v);
            TextView t24v = new TextView(rootView.getContext());
            t24v.setText(String.valueOf(listaOrden.get(x).getCantidad()));
            t24v.setTextColor(Color.WHITE);
            t24v.setWidth(cara1);
            t24v.setTop(4);
            t24v.setLeft(4);
            t24v.setRight(4);
            t24v.setBottom(4);
            t24v.setGravity(Gravity.CENTER_HORIZONTAL);
            tbrow.addView(t24v);

            stk.addView(tbrow);

            TableRow tbrow021 = new TableRow(rootView.getContext());

            TextView tv0112 = new TextView(rootView.getContext());
            tv0112.setHeight(4);
            tbrow021.addView(tv0112);
            stk.addView(tbrow021);
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
}