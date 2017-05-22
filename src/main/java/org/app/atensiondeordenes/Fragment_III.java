package org.app.atensiondeordenes;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_III extends Fragment implements OnClickListener {
    private List<Persona> listaOrden=new ArrayList<Persona>();
    private int orden;
    private EditText etNombreApellido;
    private Button btnRegresar;
    private Button btnGuardar;
    private Button btnNuevaPersona;
    private View rootView;
    private ScrollView formulario;
    private ScrollView lista;

    public Fragment_III() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment__iii, container, false);
        etNombreApellido=(EditText)rootView.findViewById(R.id.etNombreApellido);
        btnRegresar=(Button)rootView.findViewById(R.id.btnRegresarPersona);
        btnGuardar=(Button)rootView.findViewById(R.id.btnGuardarPersona);
        btnNuevaPersona=(Button)rootView.findViewById(R.id.btnNuevaPersona2);
        formulario=(ScrollView) rootView.findViewById(R.id.formularioPersona);
        lista=(ScrollView) rootView.findViewById(R.id.listaPersona);
        formulario.setVisibility(View.GONE);
        btnNuevaPersona.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                lista.setVisibility(View.GONE);
                formulario.setVisibility(View.VISIBLE);
            }
        });
        btnGuardar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre=etNombreApellido.getText().toString();
                if(nombre.length()>0){
                    try {
                        Persona persona=new Persona(0,nombre,orden,"","Activo");
                        BDOrden bdOrden=new BDOrden(rootView.getContext());
                        bdOrden.abrir();
                        bdOrden.registrarPersona(persona);
                        bdOrden.cerrar();
                        showAlertDialog(rootView.getContext(), "Persona", "Registro guardado",false);
                        buscarPersonas();
                        lista.setVisibility(View.VISIBLE);
                        formulario.setVisibility(View.GONE);
                        etNombreApellido.setText("");
                    }catch (Exception e){

                    }

                }else{
                    showAlertDialog(rootView.getContext(), "Error", "Debe especificar el nombre",false);
                }
            }
        });
        btnRegresar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                lista.setVisibility(View.VISIBLE);
                formulario.setVisibility(View.GONE);
                etNombreApellido.setText("");
            }
        });
        orden= getArguments().getInt("id");

        buscarPersonas();

        // Register a callback to be invoked when an item in this AdapterView
        // has been clicked

        return rootView;
    }

    public void buscarPersonas(){
        try {
            BDOrden bda=new BDOrden(rootView.getContext());
            bda.abrir();
            listaOrden=bda.consultarPersona(orden);
            bda.cerrar();


        } catch (Exception e) {
            // TODO Auto-generated catch block
            showAlertDialog(rootView.getContext(), "Error", e.toString()+String.valueOf(orden),false);

        }
        if(listaOrden.size()>0){
            init();
        }
    }

    public void init() {
        int width = rootView.getWidth();
        int desc=(width-24)*(25/100);
        int cara=(width-24)*(75/100);
        TableLayout stk = (TableLayout) rootView.findViewById(R.id.table_persona);
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

                stk.addView(tbrow);
                TableRow tbrow021 = new TableRow(rootView.getContext());

                TextView tv0111 = new TextView(rootView.getContext());
                tv0111.setHeight(4);
                tbrow021.addView(tv0111);
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

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btnNuevaPersona2) {
            lista.setVisibility(View.GONE);
            formulario.setVisibility(View.VISIBLE);
        }else  if(i==R.id.btnRegresarPersona){
            lista.setVisibility(View.VISIBLE);
            formulario.setVisibility(View.GONE);
        }else if (i==R.id.btnGuardarPersona){
            String nombre=etNombreApellido.getText().toString();
            if(nombre.length()>0){
                try {
                    Persona persona=new Persona(0,nombre,orden,"","Activo");
                    BDOrden bdOrden=new BDOrden(rootView.getContext());
                    bdOrden.abrir();
                    bdOrden.registrarPersona(persona);
                    bdOrden.cerrar();
                    buscarPersonas();
                }catch (Exception e){

                }

            }else{
                showAlertDialog(rootView.getContext(), "Error", "Debe especificar el nombre",false);
            }
        }

    }
}