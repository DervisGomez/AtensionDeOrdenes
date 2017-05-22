package org.app.atensiondeordenes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dervis on 09/11/16.
 */
public class BDOrden extends SQLiteOpenHelper {

    Context ctx;
    BDOrden bdOrden;
    SQLiteDatabase bd;

    public BDOrden(Context context) {
        super(context, "orden", null, 3);
        ctx=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ordorden(" +
                "ORDEACTI TEXT," +
                "ORDEALTI TEXT," +
                "ORDEANOR TEXT," +
                "ORDEARCH TEXT," +
                "ORDEBARR TEXT," +
                "ORDECALE TEXT," +
                "ORDECICL TEXT," +
                "ORDECOME TEXT," +
                "ORDECONS INTEGER PRIMARY KEY," +
                "ORDECONT TEXT," +
                "ORDECOUS TEXT," +
                "ORDEDIRE TEXT," +
                "ORDEEFEC TEXT," +
                "ORDEESES TEXT," +
                "ORDEESLE TEXT," +
                "ORDEESTA TEXT," +
                "ORDEESTR TEXT," +
                "ORDEEVEN TEXT," +
                "ORDEFEAS TEXT," +
                "ORDEFECR TEXT," +
                "ORDEFEFE TEXT," +
                "ORDEFEFI TEXT," +
                "ORDEFEIE TEXT," +
                "ORDEFEIN TEXT," +
                "ORDEFELE TEXT," +
                "ORDEFEML TEXT," +
                "ORDEFERE TEXT," +
                "ORDELATI TEXT," +
                "ORDELEAC TEXT," +
                "ORDELONG TEXT," +
                "ORDEMARI TEXT," +
                "ORDEMART TEXT," +
                "ORDEMEDI TEXT," +
                "ORDEMOLE TEXT," +
                "ORDENATT TEXT," +
                "ORDENAUO TEXT," +
                "ORDENUME TEXT," +
                "ORDEOBSE TEXT," +
                "ORDEORID TEXT," +
                "ORDEPACK TEXT," +
                "ORDEPADR TEXT," +
                "ORDEPEND TEXT," +
                "ORDEPERI TEXT," +
                "ORDEPERS TEXT," +
                "ORDEPRAC TEXT," +
                "ORDEPRAL TEXT," +
                "ORDEPRIO TEXT," +
                "ORDEREUS TEXT," +
                "ORDERULE TEXT," +
                "ORDERUTA TEXT," +
                "ORDESEQU TEXT," +
                "ORDESUSC TEXT," +
                "ORDETELE TEXT," +
                "ORDETERM TEXT," +
                "ORDETIAS TEXT," +
                "ORDETISE TEXT," +
                "ORDETISO TEXT," +
                "ORDETITR TEXT," +
                "ORDETRAR TEXT," +
                "ORDEUNOP TEXT," +
                "ORDEUOPA TEXT," +
                "ORDEUSCR TEXT," +
                "ORDEUSO TEXT," +
                "ORDEVAOR TEXT)");
        db.execSQL("CREATE TABLE persona(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, orden integer, fecha TEXT, estado TEXT)");
        db.execSQL("CREATE TABLE material(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT,cantidad INTEGER, orden integer, fecha TEXT, estado TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS ordorden");
        db.execSQL("DROP TABLE IF EXISTS persona");
        db.execSQL("DROP TABLE IF EXISTS material");
        onCreate(db);
    }
    public void abrir(){
        bdOrden=new BDOrden(ctx);
        bd=bdOrden.getWritableDatabase();
    }

    public void cerrar(){
        bd.close();
    }

    public long registrarMaterial(Material material){
        ContentValues valores=new ContentValues();
        valores.put("nombre",material.getNombre());
        valores.put("orden",material.getOrden());
        valores.put("fecha",material.getFecha());
        valores.put("cantidad",material.getCantidad());
        valores.put("estado",material.getEstado());
        return bd.insert("material", null, valores);
    }

    public List<Material> consultarMaterial(int id) throws Exception {
        List<Material> datosCombos = new ArrayList<Material>();
        String[] columns = new String[]{"id", "nombre","cantidad", "orden", "fecha", "estado"};
        String[] where = new String[]{String.valueOf(id)};
        Cursor c = bd.query(true, "material", columns, "orden=?", where, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                int codigo = c.getInt(0);
                String nombre = c.getString(1);
                int cantidad =c.getInt(2);
                int orden = c.getInt(3);
                String fecha = c.getString(4);
                String estado = c.getString(5);
                Material datosCombo = new Material(codigo, nombre,cantidad, orden, fecha, estado);
                datosCombos.add(datosCombo);
            } while (c.moveToNext());
        }
        return datosCombos;
    }

    public long registrarPersona(Persona persona){
        ContentValues valores=new ContentValues();
        valores.put("nombre",persona.getNombre());
        valores.put("orden",persona.getOrden());
        valores.put("fecha",persona.getFecha());
        valores.put("estado",persona.getEstado());
        return bd.insert("persona", null, valores);
    }

    public List<Persona> consultarPersona(int id) throws Exception {
        List<Persona> datosCombos = new ArrayList<Persona>();
        String[] columns = new String[]{"id", "nombre", "orden", "fecha", "estado"};
        String[] where = new String[]{String.valueOf(id)};
        Cursor c = bd.query(true, "persona", columns, "orden=?", where, null, null, null, null);
        if (c.moveToFirst()) {
            do {
                int codigo = c.getInt(0);
                String nombre = c.getString(1);
                int orden = c.getInt(2);
                String fecha = c.getString(3);
                String estado = c.getString(4);
                Persona datosCombo = new Persona(codigo, nombre, orden, fecha, estado);
                datosCombos.add(datosCombo);
            } while (c.moveToNext());
        }
    return datosCombos;
    }


    public long registrarOrden(Orden orden){
        ContentValues valores=new ContentValues();
        valores.put("ORDEACTI",orden.getORDEACTI());
        valores.put("ORDEALTI",orden.getORDEALTI());
        valores.put("ORDEANOR",orden.getORDEANOR());
        valores.put("ORDEARCH",orden.getORDEARCH());
        valores.put("ORDEBARR",orden.getORDEBARR());
        valores.put("ORDECALE",orden.getORDECALE());
        valores.put("ORDECICL",orden.getORDECICL());
        valores.put("ORDECOME",orden.getORDECOME());
        valores.put("ORDECONS",Integer.valueOf(orden.getORDECONS()));
        valores.put("ORDECONT",orden.getORDECONT());
        valores.put("ORDECOUS",orden.getORDECOUS());
        valores.put("ORDEDIRE",orden.getORDEDIRE());
        valores.put("ORDEEFEC",orden.getORDEEFEC());
        valores.put("ORDEESES",orden.getORDEESES());
        valores.put("ORDEESLE",orden.getORDEESLE());
        valores.put("ORDEESTA",orden.getORDEESTA());
        valores.put("ORDEESTR",orden.getORDEESTR());
        valores.put("ORDEEVEN",orden.getORDEEVEN());
        valores.put("ORDEFEAS",orden.getORDEFEAS());
        valores.put("ORDEFECR",orden.getORDEFECR());
        valores.put("ORDEFEFE ",orden.getORDEFEFE());
        valores.put("ORDEFEFI",orden.getORDEFEFI());
        valores.put("ORDEFEIE",orden.getORDEFEIE());
        valores.put("ORDEFEIN",orden.getORDEFEIN());
        valores.put("ORDEFELE",orden.getORDEFELE());
        valores.put("ORDEFEML",orden.getORDEFEML());
        valores.put("ORDEFERE",orden.getORDEFERE());
        valores.put("ORDELATI",orden.getORDELATI());
        valores.put("ORDELEAC",orden.getORDELEAC());
        valores.put("ORDELONG",orden.getORDELONG());
        valores.put("ORDEMARI",orden.getORDEMARI());
        valores.put("ORDEMART",orden.getORDEMART());
        valores.put("ORDEMEDI",orden.getORDEMEDI());
        valores.put("ORDEMOLE",orden.getORDEMOLE());
        valores.put("ORDENATT",orden.getORDENATT());
        valores.put("ORDENAUO",orden.getORDENAUO());
        valores.put("ORDENUME",orden.getORDENUME());
        valores.put("ORDEOBSE",orden.getORDEOBSE());
        valores.put("ORDEORID",orden.getORDEORID());
        valores.put("ORDEPACK",orden.getORDEPACK());
        valores.put("ORDEPADR",orden.getORDEPADR());
        valores.put("ORDEPEND",orden.getORDEPEND());
        valores.put("ORDEPERI",orden.getORDEPERI());
        valores.put("ORDEPERS",orden.getORDEPERS());
        valores.put("ORDEPRAC",orden.getORDEPRAC());
        valores.put("ORDEPRAL",orden.getORDEPRAL());
        valores.put("ORDEPRIO",orden.getORDEPRIO());
        valores.put("ORDEREUS",orden.getORDEREUS());
        valores.put("ORDERULE",orden.getORDERULE());
        valores.put("ORDERUTA",orden.getORDERUTA());
        valores.put("ORDESEQU",orden.getORDESEQU());
        valores.put("ORDESUSC",orden.getORDESUSC());
        valores.put("ORDETELE",orden.getORDETELE());
        valores.put("ORDETERM",orden.getORDETERM());
        valores.put("ORDETIAS",orden.getORDETIAS());
        valores.put("ORDETISE",orden.getORDETISE());
        valores.put("ORDETISO",orden.getORDETISO());
        valores.put("ORDETITR",orden.getORDETITR());
        valores.put("ORDETRAR",orden.getORDETRAR());
        valores.put("ORDEUNOP",orden.getORDEUNOP());
        valores.put("ORDEUOPA",orden.getORDEUOPA());
        valores.put("ORDEUSCR",orden.getORDEUSCR());
        valores.put("ORDEUSO",orden.getORDEUSO());
        valores.put("ORDEVAOR",orden.getORDEVAOR());
        return bd.insert("ordorden", null, valores);
    }

    public List<Orden> consultarOrdenView() throws Exception{
        List<Orden> datosCombos=new ArrayList<Orden>();
        String[] columns=new String[]{"ORDECONS","ORDECONT","ORDEDIRE","ORDEESTA","ORDETISO","ORDETITR"};
        Cursor c=bd.query(true, "ordorden", columns,null, null,null, null, null, null);
        if(c.moveToFirst()){
            do{
                int codigo=c.getInt(0);
                String cont=c.getString(1);
                String dire=c.getString(2);
                String esta=c.getString(3);
                String tipo=c.getString(4);
                String titr=c.getString(5);
                Orden datosCombo=new Orden(String.valueOf(codigo),cont,dire,esta,tipo,titr);
                datosCombos.add(datosCombo);
            }while(c.moveToNext());
        }
        return datosCombos;
    }

    public List<Orden> consultarOrden() throws Exception{
        List<Orden> datosCombos=new ArrayList<Orden>();
        String[] columns=new String[]{
                "ORDEACTI",
                        "ORDEALTI",
                        "ORDEANOR",
                        "ORDEARCH",
                        "ORDEBARR",
                        "ORDECALE",
                        "ORDECICL",
                        "ORDECOME",
                        "ORDECONS",
                        "ORDECONT",
                        "ORDECOUS",
                        "ORDEDIRE",
                        "ORDEEFEC",
                        "ORDEESES",
                        "ORDEESLE",
                        "ORDEESTA",
                        "ORDEESTR",
                        "ORDEEVEN",
                        "ORDEFEAS",
                        "ORDEFECR",
                        "ORDEFEFE",
                        "ORDEFEFI",
                        "ORDEFEIE",
                        "ORDEFEIN",
                        "ORDEFELE",
                        "ORDEFEML",
                        "ORDEFERE",
                        "ORDELATI",
                        "ORDELEAC",
                        "ORDELONG",
                        "ORDEMARI",
                        "ORDEMART",
                        "ORDEMEDI",
                        "ORDEMOLE",
                        "ORDENATT",
                        "ORDENAUO",
                        "ORDENUME",
                        "ORDEOBSE",
                        "ORDEORID",
                        "ORDEPACK",
                        "ORDEPADR",
                        "ORDEPEND",
                        "ORDEPERI",
                        "ORDEPERS",
                        "ORDEPRAC",
                        "ORDEPRAL",
                        "ORDEPRIO",
                        "ORDEREUS",
                        "ORDERULE",
                        "ORDERUTA",
                        "ORDESEQU",
                        "ORDESUSC",
                        "ORDETELE",
                        "ORDETERM",
                        "ORDETIAS",
                        "ORDETISE",
                        "ORDETISO",
                        "ORDETITR",
                        "ORDETRAR",
                        "ORDEUNOP",
                        "ORDEUOPA",
                        "ORDEUSCR",
                        "ORDEUSO",
                        "ORDEVAOR"
        };
        Cursor c=bd.query(true, "ordorden", columns,null, null,null, null, null, null);
        if(c.moveToFirst()){
            do{
                String ORDEACTI=c.getString(0);
                String ORDEALTI=c.getString(1);
                String ORDEANOR=c.getString(2);
                String ORDEARCH=c.getString(3);
                String ORDEBARR=c.getString(4);
                String ORDECALE=c.getString(5);
                String ORDECICL=c.getString(6);
                String ORDECOME=c.getString(7);
                int ORDECONS=c.getInt(8);
                String ORDECONT=c.getString(9);
                String ORDECOUS=c.getString(10);
                String ORDEDIRE=c.getString(11);
                String ORDEEFEC=c.getString(12);
                String ORDEESES=c.getString(13);
                String ORDEESLE=c.getString(14);
                String ORDEESTA=c.getString(15);
                String ORDEESTR=c.getString(16);
                String ORDEEVEN=c.getString(17);
                String ORDEFEAS=c.getString(18);
                String ORDEFECR=c.getString(19);
                String ORDEFEFE=c.getString(20);
                String ORDEFEFI=c.getString(21);
                String ORDEFEIE=c.getString(22);
                String ORDEFEIN=c.getString(23);
                String ORDEFELE=c.getString(24);
                String ORDEFEML=c.getString(25);
                String ORDEFERE=c.getString(27);
                String ORDELATI=c.getString(28);
                String ORDELEAC=c.getString(29);
                String ORDELONG=c.getString(30);
                String ORDEMARI=c.getString(31);
                String ORDEMART=c.getString(32);
                String ORDEMEDI=c.getString(33);
                String ORDEMOLE=c.getString(34);
                String ORDENATT=c.getString(35);
                String ORDENAUO=c.getString(36);
                String ORDENUME=c.getString(37);
                String ORDEOBSE=c.getString(38);
                String ORDEORID=c.getString(39);
                String ORDEPACK=c.getString(40);
                String ORDEPADR=c.getString(41);
                String ORDEPEND=c.getString(42);
                String ORDEPERI=c.getString(43);
                String ORDEPERS=c.getString(44);
                String ORDEPRAC=c.getString(45);
                String ORDEPRAL=c.getString(46);
                String ORDEPRIO=c.getString(47);
                String ORDEREUS=c.getString(48);
                String ORDERULE=c.getString(49);
                String ORDERUTA=c.getString(50);
                String ORDESEQU=c.getString(51);
                String ORDESUSC=c.getString(52);
                String ORDETELE=c.getString(53);
                String ORDETERM=c.getString(53);
                String ORDETIAS=c.getString(54);
                String ORDETISE=c.getString(55);
                String ORDETISO=c.getString(56);
                String ORDETITR=c.getString(57);
                String ORDETRAR=c.getString(58);
                String ORDEUNOP=c.getString(59);
                String ORDEUOPA=c.getString(60);
                String ORDEUSCR=c.getString(61);
                String ORDEUSO=c.getString(62);
                String ORDEVAOR=c.getString(63);
                Orden datosCombo=new Orden(
                        ORDEACTI,
                        ORDEALTI,
                        ORDEANOR,
                        ORDEARCH,
                        ORDEBARR,
                        ORDECALE,
                        ORDECICL,
                        ORDECOME,
                        String.valueOf(ORDECONS),
                        ORDECONT,
                        ORDECOUS,
                        ORDEDIRE,
                        ORDEEFEC,
                        ORDEESES,
                        ORDEESLE,
                        ORDEESTA,
                        ORDEESTR,
                        ORDEEVEN,
                        ORDEFEAS,
                        ORDEFECR,
                        ORDEFEFE,
                        ORDEFEFI,
                        ORDEFEIE,
                        ORDEFEIN,
                        ORDEFELE,
                        ORDEFEML,
                        ORDEFERE,
                        ORDELATI,
                        ORDELEAC,
                        ORDELONG,
                        ORDEMARI,
                        ORDEMART,
                        ORDEMEDI,
                        ORDEMOLE,
                        ORDENATT,
                        ORDENAUO,
                        ORDENUME,
                        ORDEOBSE,
                        ORDEORID,
                        ORDEPACK,
                        ORDEPADR,
                        ORDEPEND,
                        ORDEPERI,
                        ORDEPERS,
                        ORDEPRAC,
                        ORDEPRAL,
                        ORDEPRIO,
                        ORDEREUS,
                        ORDERULE,
                        ORDERUTA,
                        ORDESEQU,
                        ORDESUSC,
                        ORDETELE,
                        ORDETERM,
                        ORDETIAS,
                        ORDETISE,
                        ORDETISO,
                        ORDETITR,
                        ORDETRAR,
                        ORDEUNOP,
                        ORDEUOPA,
                        ORDEUSCR,
                        ORDEUSO,
                        ORDEVAOR
                );
                datosCombos.add(datosCombo);
            }while(c.moveToNext());
        }
        return datosCombos;
    }
    public boolean consultarGuardar(String codigo) throws Exception{
        boolean guardar=true;
        String[] columns=new String[]{"ORDECONS"};
        String[] where=new String[]{codigo};
        Cursor c=bd.query(true, "ordorden", columns,"ORDECONS=?", where,null, null, null, null);
        if(c.moveToFirst()){
            do{
                guardar=false;
            }while(c.moveToNext());
        }
        return guardar;
    }
}
