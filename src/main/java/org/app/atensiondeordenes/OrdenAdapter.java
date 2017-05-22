package org.app.atensiondeordenes;

/**
 * Created by dervis on 09/11/16.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OrdenAdapter extends BaseAdapter {

    private Context context;
    private List<Orden> items;

    public OrdenAdapter(Context context, List<Orden> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.list_items, parent, false);
        }

        // Set data into the view
        TextView tvId = (TextView) rowView.findViewById(R.id.tvId);
        TextView tvSolicitud = (TextView) rowView.findViewById(R.id.tvSolicitud);
        TextView tvTipo = (TextView) rowView.findViewById(R.id.tvTipo);
        TextView tvContrato = (TextView) rowView.findViewById(R.id.tvContrato);
        TextView tvDireccion = (TextView) rowView.findViewById(R.id.tvDireccion);
        TextView tvEstado = (TextView) rowView.findViewById(R.id.tvEstado);

        Orden item = this.items.get(position);
        tvId.setText("Id: "+item.getORDECONS());
        tvSolicitud.setText("Tipo Solicitud: "+item.getORDETISO());
        tvTipo.setText("Tipo Trabajo: "+item.getORDETITR());
        tvContrato.setText("Contrato: "+item.getORDECONT());
        tvDireccion.setText("Direccion: "+item.getORDEDIRE());
        tvEstado.setText("Estado: "+item.getORDEESTA());

        return rowView;
    }

}
