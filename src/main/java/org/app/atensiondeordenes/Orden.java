package org.app.atensiondeordenes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dervis on 09/11/16.
 */
public class Orden {
    private String ORDEACTI;      //     tabla => or_order_activity, campo => order_activity_id
    private String ORDEALTI;     //     Altitud Ubicación Geográfica
    private String ORDEANOR;      //  Anula otra Orden, Tabla=>or_orden, Campo=>is_countermand
    private String ORDEARCH;     //   Id de la tabla de log
    private String ORDEBARR;      //   Barrio, Campo=> b.name, Tabla=>ab_address y ge_neighborthood
    private String ORDECALE;     //    Causal de Legalización
    private String ORDECICL;      //     Ciclo
    private String ORDECOME;      // Comentario de la orden de trabajo
    private String ORDECONS;      //  Llave principal (pk) -> ID
    private String ORDECONT;      //  Contrato -> CONTRATO
    private String ORDECOUS;      //  Codigo del usuario
    private String ORDEDIRE;      //     Direccion, Tabla=> ab_address, Campo=> address -> DIRECCION
    private String ORDEEFEC;      //    (null)
    private String ORDEESES;      //     Consecutivo tabla ORD_ESTADO para consultar el ultimo estado de la orden.
    private String ORDEESLE;      //     Estado de Legalizacion
    private String ORDEESTA;      //    Estado de la orden por defecto 6->En ejecucion -> ESTADO
    private String ORDEESTR;      //    Estrato
    private String ORDEEVEN;      //   Codigo Evento que vincula en el sistema de mapas
    private String ORDEFEAS;       //   Fecha de Asignacion, Tabla=>or_order, campo=>assigned_date
    private String ORDEFECR;      //    Fecha de creacion
    private String ORDEFEFE;      //     Fecha Fin de Ejecucion, Tabla=> or_order, Campo=>execution_final_date
    private String ORDEFEFI;      //      Fecha-Hora Fin
    private String ORDEFEIE;      //      Fecha Inicio Ejecucion, Tabla=> or_order, campo=> exec_initial_date
    private String ORDEFEIN;      //     Fecha-Hora inicial
    private String ORDEFELE;      //    ; Fecha de Legalizacion, Tabla=>or_order, campo=>legalization_date
    private String ORDEFEML;      //   F;echa maxima de Legalizacion, Tabla=>or_order, campo=>max_date_to_legalize
    private String ORDEFERE;      //    ;Fecha de Registro, Tabla=>or_order_activity, campo=>register_date
    private String ORDELATI;      //     Latitud ubicacion geográfica
    private String ORDELEAC;      //    Lectura Actual
    private String ORDELONG;      //  Longitud Ubicación Geográfica
    private String ORDEMARI;      //   Descripción del material instalado
    private String ORDEMART;      //  Descripción del material retirado
    private String ORDEMEDI;      //   Medidor
    private String ORDEMOLE;      //  Guardar el motivo de la legalizacion so fue por OPEN, MERCURIO, PAGO, PREDIO DEMOLIDO
    private String ORDENATT;      //   Nombre Tipo de Trabajo
    private String ORDENAUO;      // Nombre Unidad Operativa
    private String ORDENUME;      // Numerador tabla => or_order, campo => ord.numerator_id
    private String ORDEOBSE;      //   Observación de la orden de trabajo
    private String ORDEORID;      //    Order ID campo de OPEN llave primari de la orden de trabajo tabla or_order
    private String ORDEPACK;      //   Número del Paquete => Tabla: or_order_activity, Campot: Packege_id
    private String ORDEPADR;      //   Numero de Orden padre u que la originó
    private String ORDEPEND;      //   Identificar las ordenes pendientes por (Dirección, Accesorios, Drásticas, Internos, Tiempo, Obstáculos) se deben reasignar
    private String ORDEPERI;      //Perido
    private String ORDEPERS;      //Personal, Tablas=> or_order_person - ge_person, Campos=>person_id - name_
    private String ORDEPRAC;      //Producto Acueducto
    private String ORDEPRAL;      //Producto Alcantarillado
    private String ORDEPRIO;      //Prioridad, Tabla=> or_orden, Campo=>priority
    private String ORDEREUS;      //Reporte Usuario
    private String ORDERULE;      //Ruta Lectura
    private String ORDERUTA;     //Ruta, Tabla=> rutasect, Campo=>ruseruta
    private String ORDESEQU;      //Sequencia, tabla=>or_order, campo=>sequence
    private String ORDESUSC;      //Subscriptor, Tabla=>PR_SUBSCRIPTION, Campo=> subscription_name - subs_last_name
    private String ORDETELE;      //Telefono
    private String ORDETERM;      //Id del dispositivo movil
    private String ORDETIAS;      //Tipo de Asignacion, Tabla=>or_order, Campo=>assigned_with
    private String ORDETISE;      //Tipo servicio 45. Acueducto y 46. Alcantarillado
    private String ORDETISO;      //Tipo de solicitud --> SOLICITUD
    private String ORDETITR;      //Codigo del Tipo de Trabajo (TT) --> TIPO TRABAJO
    private String ORDETRAR;      //Trabajo a realizar
    private String ORDEUNOP;      //Codigo de la Unidad Operativa
    private String ORDEUOPA;      //Unidad Operativa Padre
    private String ORDEUSCR;      //Usuario de creacion
    private String ORDEUSO ;      //Uso
    private String ORDEVAOR;      //Valor de la Orden, Tabla=>or_order, Campo=>order_value

    public Orden() {
        this.ORDEACTI = "";
        this.ORDEALTI = "";
        this.ORDEANOR = "";
        this.ORDEARCH = "";
        this.ORDEBARR = "";
        this.ORDECALE = "";
        this.ORDECICL = "";
        this.ORDECOME = "";
        this.ORDECONS = "";
        this.ORDECONT = "";
        this.ORDECOUS = "";
        this.ORDEDIRE = "";
        this.ORDEEFEC = "";
        this.ORDEESES = "";
        this.ORDEESLE = "";
        this.ORDEESTA = "";
        this.ORDEESTR = "";
        this.ORDEEVEN = "";
        this.ORDEFEAS = "";
        this.ORDEFECR = "";
        this.ORDEFEFE = "";
        this.ORDEFEFI = "";
        this.ORDEFEIE = "";
        this.ORDEFEIN = "";
        this.ORDEFELE = "";
        this.ORDEFEML = "";
        this.ORDEFERE = "";
        this.ORDELATI = "";
        this.ORDELEAC = "";
        this.ORDELONG = "";
        this.ORDEMARI = "";
        this.ORDEMART = "";
        this.ORDEMEDI = "";
        this.ORDEMOLE = "";
        this.ORDENATT = "";
        this.ORDENAUO = "";
        this.ORDENUME = "";
        this.ORDEOBSE = "";
        this.ORDEORID = "";
        this.ORDEPACK = "";
        this.ORDEPADR = "";
        this.ORDEPEND = "";
        this.ORDEPERI = "";
        this.ORDEPERS = "";
        this.ORDEPRAC = "";
        this.ORDEPRAL = "";
        this.ORDEPRIO = "";
        this.ORDEREUS = "";
        this.ORDERULE = "";
        this.ORDERUTA = "";
        this.ORDESEQU = "";
        this.ORDESUSC = "";
        this.ORDETELE = "";
        this.ORDETERM = "";
        this.ORDETIAS = "";
        this.ORDETISE = "";
        this.ORDETISO = "";
        this.ORDETITR = "";
        this.ORDETRAR = "";
        this.ORDEUNOP = "";
        this.ORDEUOPA = "";
        this.ORDEUSCR = "";
        this.ORDEUSO = "";
        this.ORDEVAOR = "";
    }

    public Orden(String a, String b, String c,String d, String e, String f){
        this.ORDECONS=a;
        this.ORDECONT=b;
        this.ORDEDIRE=c;
        this.ORDEESTA=d;
        this.ORDETISO=e;
        this.ORDETITR=f;
    }

    public Orden(String ORDEACTI, String ORDEALTI, String ORDEANOR, String ORDEARCH, String ORDEBARR, String ORDECALE, String ORDECICL, String ORDECOME, String ORDECONS, String ORDECONT, String ORDECOUS, String ORDEDIRE, String ORDEEFEC, String ORDEESES, String ORDEESLE, String ORDEESTA, String ORDEESTR, String ORDEEVEN, String ORDEFEAS, String ORDEFECR, String ORDEFEFE, String ORDEFEFI, String ORDEFEIE, String ORDEFEIN, String ORDEFELE, String ORDEFEML, String ORDEFERE, String ORDELATI, String ORDELEAC, String ORDELONG, String ORDEMARI, String ORDEMART, String ORDEMEDI, String ORDEMOLE, String ORDENATT, String ORDENAUO, String ORDENUME, String ORDEOBSE, String ORDEORID, String ORDEPACK, String ORDEPADR, String ORDEPEND, String ORDEPERI, String ORDEPERS, String ORDEPRAC, String ORDEPRAL, String ORDEPRIO, String ORDEREUS, String ORDERULE, String ORDERUTA, String ORDESEQU, String ORDESUSC, String ORDETELE, String ORDETERM, String ORDETIAS, String ORDETISE, String ORDETISO, String ORDETITR, String ORDETRAR, String ORDEUNOP, String ORDEUOPA, String ORDEUSCR, String ORDEUSO, String ORDEVAOR) {
        this.ORDEACTI = ORDEACTI;
        this.ORDEALTI = ORDEALTI;
        this.ORDEANOR = ORDEANOR;
        this.ORDEARCH = ORDEARCH;
        this.ORDEBARR = ORDEBARR;
        this.ORDECALE = ORDECALE;
        this.ORDECICL = ORDECICL;
        this.ORDECOME = ORDECOME;
        this.ORDECONS = ORDECONS;
        this.ORDECONT = ORDECONT;
        this.ORDECOUS = ORDECOUS;
        this.ORDEDIRE = ORDEDIRE;
        this.ORDEEFEC = ORDEEFEC;
        this.ORDEESES = ORDEESES;
        this.ORDEESLE = ORDEESLE;
        this.ORDEESTA = ORDEESTA;
        this.ORDEESTR = ORDEESTR;
        this.ORDEEVEN = ORDEEVEN;
        this.ORDEFEAS = ORDEFEAS;
        this.ORDEFECR = ORDEFECR;
        this.ORDEFEFE = ORDEFEFE;
        this.ORDEFEFI = ORDEFEFI;
        this.ORDEFEIE = ORDEFEIE;
        this.ORDEFEIN = ORDEFEIN;
        this.ORDEFELE = ORDEFELE;
        this.ORDEFEML = ORDEFEML;
        this.ORDEFERE = ORDEFERE;
        this.ORDELATI = ORDELATI;
        this.ORDELEAC = ORDELEAC;
        this.ORDELONG = ORDELONG;
        this.ORDEMARI = ORDEMARI;
        this.ORDEMART = ORDEMART;
        this.ORDEMEDI = ORDEMEDI;
        this.ORDEMOLE = ORDEMOLE;
        this.ORDENATT = ORDENATT;
        this.ORDENAUO = ORDENAUO;
        this.ORDENUME = ORDENUME;
        this.ORDEOBSE = ORDEOBSE;
        this.ORDEORID = ORDEORID;
        this.ORDEPACK = ORDEPACK;
        this.ORDEPADR = ORDEPADR;
        this.ORDEPEND = ORDEPEND;
        this.ORDEPERI = ORDEPERI;
        this.ORDEPERS = ORDEPERS;
        this.ORDEPRAC = ORDEPRAC;
        this.ORDEPRAL = ORDEPRAL;
        this.ORDEPRIO = ORDEPRIO;
        this.ORDEREUS = ORDEREUS;
        this.ORDERULE = ORDERULE;
        this.ORDERUTA = ORDERUTA;
        this.ORDESEQU = ORDESEQU;
        this.ORDESUSC = ORDESUSC;
        this.ORDETELE = ORDETELE;
        this.ORDETERM = ORDETERM;
        this.ORDETIAS = ORDETIAS;
        this.ORDETISE = ORDETISE;
        this.ORDETISO = ORDETISO;
        this.ORDETITR = ORDETITR;
        this.ORDETRAR = ORDETRAR;
        this.ORDEUNOP = ORDEUNOP;
        this.ORDEUOPA = ORDEUOPA;
        this.ORDEUSCR = ORDEUSCR;
        this.ORDEUSO = ORDEUSO;
        this.ORDEVAOR = ORDEVAOR;
    }

    public String getORDEACTI() {
        return ORDEACTI;
    }

    public void setORDEACTI(String ORDEACTI) {
        this.ORDEACTI = ORDEACTI;
    }

    public String getORDEALTI() {
        return ORDEALTI;
    }

    public void setORDEALTI(String ORDEALTI) {
        this.ORDEALTI = ORDEALTI;
    }

    public String getORDEANOR() {
        return ORDEANOR;
    }

    public void setORDEANOR(String ORDEANOR) {
        this.ORDEANOR = ORDEANOR;
    }

    public String getORDEARCH() {
        return ORDEARCH;
    }

    public void setORDEARCH(String ORDEARCH) {
        this.ORDEARCH = ORDEARCH;
    }

    public String getORDEBARR() {
        return ORDEBARR;
    }

    public void setORDEBARR(String ORDEBARR) {
        this.ORDEBARR = ORDEBARR;
    }

    public String getORDECALE() {
        return ORDECALE;
    }

    public void setORDECALE(String ORDECALE) {
        this.ORDECALE = ORDECALE;
    }

    public String getORDECICL() {
        return ORDECICL;
    }

    public void setORDECICL(String ORDECICL) {
        this.ORDECICL = ORDECICL;
    }

    public String getORDECOME() {
        return ORDECOME;
    }

    public void setORDECOME(String ORDECOME) {
        this.ORDECOME = ORDECOME;
    }

    public String getORDECONS() {
        return ORDECONS;
    }

    public void setORDECONS(String ORDECONS) {
        this.ORDECONS = ORDECONS;
    }

    public String getORDECONT() {
        return ORDECONT;
    }

    public void setORDECONT(String ORDECONT) {
        this.ORDECONT = ORDECONT;
    }

    public String getORDECOUS() {
        return ORDECOUS;
    }

    public void setORDECOUS(String ORDECOUS) {
        this.ORDECOUS = ORDECOUS;
    }

    public String getORDEDIRE() {
        return ORDEDIRE;
    }

    public void setORDEDIRE(String ORDEDIRE) {
        this.ORDEDIRE = ORDEDIRE;
    }

    public String getORDEEFEC() {
        return ORDEEFEC;
    }

    public void setORDEEFEC(String ORDEEFEC) {
        this.ORDEEFEC = ORDEEFEC;
    }

    public String getORDEESES() {
        return ORDEESES;
    }

    public void setORDEESES(String ORDEESES) {
        this.ORDEESES = ORDEESES;
    }

    public String getORDEESLE() {
        return ORDEESLE;
    }

    public void setORDEESLE(String ORDEESLE) {
        this.ORDEESLE = ORDEESLE;
    }

    public String getORDEESTA() {
        return ORDEESTA;
    }

    public void setORDEESTA(String ORDEESTA) {
        this.ORDEESTA = ORDEESTA;
    }

    public String getORDEESTR() {
        return ORDEESTR;
    }

    public void setORDEESTR(String ORDEESTR) {
        this.ORDEESTR = ORDEESTR;
    }

    public String getORDEEVEN() {
        return ORDEEVEN;
    }

    public void setORDEEVEN(String ORDEEVEN) {
        this.ORDEEVEN = ORDEEVEN;
    }

    public String getORDEFEAS() {
        return ORDEFEAS;
    }

    public void setORDEFEAS(String ORDEFEAS) {
        this.ORDEFEAS = ORDEFEAS;
    }

    public String getORDEFECR() {
        return ORDEFECR;
    }

    public void setORDEFECR(String ORDEFECR) {
        this.ORDEFECR = ORDEFECR;
    }

    public String getORDEFEFE() {
        return ORDEFEFE;
    }

    public void setORDEFEFE(String ORDEFEFE) {
        this.ORDEFEFE = ORDEFEFE;
    }

    public String getORDEFEFI() {
        return ORDEFEFI;
    }

    public void setORDEFEFI(String ORDEFEFI) {
        this.ORDEFEFI = ORDEFEFI;
    }

    public String getORDEFEIE() {
        return ORDEFEIE;
    }

    public void setORDEFEIE(String ORDEFEIE) {
        this.ORDEFEIE = ORDEFEIE;
    }

    public String getORDEFEIN() {
        return ORDEFEIN;
    }

    public void setORDEFEIN(String ORDEFEIN) {
        this.ORDEFEIN = ORDEFEIN;
    }

    public String getORDEFELE() {
        return ORDEFELE;
    }

    public void setORDEFELE(String ORDEFELE) {
        this.ORDEFELE = ORDEFELE;
    }

    public String getORDEFEML() {
        return ORDEFEML;
    }

    public void setORDEFEML(String ORDEFEML) {
        this.ORDEFEML = ORDEFEML;
    }

    public String getORDEFERE() {
        return ORDEFERE;
    }

    public void setORDEFERE(String ORDEFERE) {
        this.ORDEFERE = ORDEFERE;
    }

    public String getORDELATI() {
        return ORDELATI;
    }

    public void setORDELATI(String ORDELATI) {
        this.ORDELATI = ORDELATI;
    }

    public String getORDELEAC() {
        return ORDELEAC;
    }

    public void setORDELEAC(String ORDELEAC) {
        this.ORDELEAC = ORDELEAC;
    }

    public String getORDELONG() {
        return ORDELONG;
    }

    public void setORDELONG(String ORDELONG) {
        this.ORDELONG = ORDELONG;
    }

    public String getORDEMARI() {
        return ORDEMARI;
    }

    public void setORDEMARI(String ORDEMARI) {
        this.ORDEMARI = ORDEMARI;
    }

    public String getORDEMART() {
        return ORDEMART;
    }

    public void setORDEMART(String ORDEMART) {
        this.ORDEMART = ORDEMART;
    }

    public String getORDEMEDI() {
        return ORDEMEDI;
    }

    public void setORDEMEDI(String ORDEMEDI) {
        this.ORDEMEDI = ORDEMEDI;
    }

    public String getORDEMOLE() {
        return ORDEMOLE;
    }

    public void setORDEMOLE(String ORDEMOLE) {
        this.ORDEMOLE = ORDEMOLE;
    }

    public String getORDENATT() {
        return ORDENATT;
    }

    public void setORDENATT(String ORDENATT) {
        this.ORDENATT = ORDENATT;
    }

    public String getORDENAUO() {
        return ORDENAUO;
    }

    public void setORDENAUO(String ORDENAUO) {
        this.ORDENAUO = ORDENAUO;
    }

    public String getORDENUME() {
        return ORDENUME;
    }

    public void setORDENUME(String ORDENUME) {
        this.ORDENUME = ORDENUME;
    }

    public String getORDEOBSE() {
        return ORDEOBSE;
    }

    public void setORDEOBSE(String ORDEOBSE) {
        this.ORDEOBSE = ORDEOBSE;
    }

    public String getORDEORID() {
        return ORDEORID;
    }

    public void setORDEORID(String ORDEORID) {
        this.ORDEORID = ORDEORID;
    }

    public String getORDEPACK() {
        return ORDEPACK;
    }

    public void setORDEPACK(String ORDEPACK) {
        this.ORDEPACK = ORDEPACK;
    }

    public String getORDEPADR() {
        return ORDEPADR;
    }

    public void setORDEPADR(String ORDEPADR) {
        this.ORDEPADR = ORDEPADR;
    }

    public String getORDEPEND() {
        return ORDEPEND;
    }

    public void setORDEPEND(String ORDEPEND) {
        this.ORDEPEND = ORDEPEND;
    }

    public String getORDEPERI() {
        return ORDEPERI;
    }

    public void setORDEPERI(String ORDEPERI) {
        this.ORDEPERI = ORDEPERI;
    }

    public String getORDEPERS() {
        return ORDEPERS;
    }

    public void setORDEPERS(String ORDEPERS) {
        this.ORDEPERS = ORDEPERS;
    }

    public String getORDEPRAC() {
        return ORDEPRAC;
    }

    public void setORDEPRAC(String ORDEPRAC) {
        this.ORDEPRAC = ORDEPRAC;
    }

    public String getORDEPRAL() {
        return ORDEPRAL;
    }

    public void setORDEPRAL(String ORDEPRAL) {
        this.ORDEPRAL = ORDEPRAL;
    }

    public String getORDEPRIO() {
        return ORDEPRIO;
    }

    public void setORDEPRIO(String ORDEPRIO) {
        this.ORDEPRIO = ORDEPRIO;
    }

    public String getORDEREUS() {
        return ORDEREUS;
    }

    public void setORDEREUS(String ORDEREUS) {
        this.ORDEREUS = ORDEREUS;
    }

    public String getORDERULE() {
        return ORDERULE;
    }

    public void setORDERULE(String ORDERULE) {
        this.ORDERULE = ORDERULE;
    }

    public String getORDERUTA() {
        return ORDERUTA;
    }

    public void setORDERUTA(String ORDERUTA) {
        this.ORDERUTA = ORDERUTA;
    }

    public String getORDESEQU() {
        return ORDESEQU;
    }

    public void setORDESEQU(String ORDESEQU) {
        this.ORDESEQU = ORDESEQU;
    }

    public String getORDESUSC() {
        return ORDESUSC;
    }

    public void setORDESUSC(String ORDESUSC) {
        this.ORDESUSC = ORDESUSC;
    }

    public String getORDETELE() {
        return ORDETELE;
    }

    public void setORDETELE(String ORDETELE) {
        this.ORDETELE = ORDETELE;
    }

    public String getORDETERM() {
        return ORDETERM;
    }

    public void setORDETERM(String ORDETERM) {
        this.ORDETERM = ORDETERM;
    }

    public String getORDETIAS() {
        return ORDETIAS;
    }

    public void setORDETIAS(String ORDETIAS) {
        this.ORDETIAS = ORDETIAS;
    }

    public String getORDETISE() {
        return ORDETISE;
    }

    public void setORDETISE(String ORDETISE) {
        this.ORDETISE = ORDETISE;
    }

    public String getORDETISO() {
        return ORDETISO;
    }

    public void setORDETISO(String ORDETISO) {
        this.ORDETISO = ORDETISO;
    }

    public String getORDETITR() {
        return ORDETITR;
    }

    public void setORDETITR(String ORDETITR) {
        this.ORDETITR = ORDETITR;
    }

    public String getORDEUNOP() {
        return ORDEUNOP;
    }

    public void setORDEUNOP(String ORDEUNOP) {
        this.ORDEUNOP = ORDEUNOP;
    }

    public String getORDETRAR() {
        return ORDETRAR;
    }

    public void setORDETRAR(String ORDETRAR) {
        this.ORDETRAR = ORDETRAR;
    }

    public String getORDEUOPA() {
        return ORDEUOPA;
    }

    public void setORDEUOPA(String ORDEUOPA) {
        this.ORDEUOPA = ORDEUOPA;
    }

    public String getORDEUSCR() {
        return ORDEUSCR;
    }

    public void setORDEUSCR(String ORDEUSCR) {
        this.ORDEUSCR = ORDEUSCR;
    }

    public String getORDEUSO() {
        return ORDEUSO;
    }

    public void setORDEUSO(String ORDEUSO) {
        this.ORDEUSO = ORDEUSO;
    }

    public String getORDEVAOR() {
        return ORDEVAOR;
    }

    public void setORDEVAOR(String ORDEVAOR) {
        this.ORDEVAOR = ORDEVAOR;
    }

    public List<Orden> getListaOrdenJson(String datos){
        JsonParser parser = new JsonParser();
        Object obje = parser.parse(datos);
        JsonArray array=(JsonArray)obje;
        List<Orden> listaOrden=new ArrayList<Orden>();
        if(!array.isJsonNull()){
            for (int x=0;x<array.size();x++){
                Orden orden=new Orden();
                JsonObject objO=array.get(x).getAsJsonObject();
                if (!(objO.get("ORDEACTI").isJsonNull())) {
                    orden.setORDEACTI(objO.get("ORDEACTI").getAsString());
                }if (!(objO.get("ORDEALTI").isJsonNull())) {
                    orden.setORDEALTI(objO.get("ORDEALTI").getAsString());
                }if (!(objO.get("ORDEANOR").isJsonNull())) {
                    orden.setORDEANOR(objO.get("ORDEANOR").getAsString());
                }if (!(objO.get("ORDEARCH").isJsonNull())) {
                    orden.setORDEARCH(objO.get("ORDEARCH").getAsString());
                }if (!(objO.get("ORDEBARR").isJsonNull())) {
                    orden.setORDEBARR(objO.get("ORDEBARR").getAsString());
                }if (!(objO.get("ORDECALE").isJsonNull())) {
                    orden.setORDECALE(objO.get("ORDECALE").getAsString());
                }if (!(objO.get("ORDECICL").isJsonNull())) {
                    orden.setORDECICL(objO.get("ORDECICL").getAsString());
                }if (!(objO.get("ORDECOME").isJsonNull())) {
                    orden.setORDECOME(objO.get("ORDECOME").getAsString());
                }if (!(objO.get("ORDECONS").isJsonNull())) {
                    orden.setORDECONS(objO.get("ORDECONS").getAsString());
                }if (!(objO.get("ORDECONT").isJsonNull())) {
                    orden.setORDECONT(objO.get("ORDECONT").getAsString());
                }if (!(objO.get("ORDECOUS").isJsonNull())) {
                    orden.setORDECOUS(objO.get("ORDECOUS").getAsString());
                }if (!(objO.get("ORDEDIRE").isJsonNull())) {
                    orden.setORDEDIRE(objO.get("ORDEDIRE").getAsString());
                }if (!(objO.get("ORDEEFEC").isJsonNull())) {
                    orden.setORDEEFEC(objO.get("ORDEEFEC").getAsString());
                }if (!(objO.get("ORDEESES").isJsonNull())) {
                    orden.setORDEESES(objO.get("ORDEESES").getAsString());
                }if (!(objO.get("ORDEESLE").isJsonNull())) {
                    orden.setORDEESLE(objO.get("ORDEESLE").getAsString());
                }if (!(objO.get("ORDEESTA").isJsonNull())) {
                    orden.setORDEESTA(objO.get("ORDEESTA").getAsString());
                }if (!(objO.get("ORDEESTR").isJsonNull())) {
                    orden.setORDEESTR(objO.get("ORDEESTR").getAsString());
                }if (!(objO.get("ORDEEVEN").isJsonNull())) {
                    orden.setORDEEVEN(objO.get("ORDEEVEN").getAsString());
                }if (!(objO.get("ORDEFEAS").isJsonNull())) {
                    orden.setORDEFEAS(objO.get("ORDEFEAS").getAsString());
                }if (!(objO.get("ORDEFECR").isJsonNull())) {
                    orden.setORDEFECR(objO.get("ORDEFECR").getAsString());
                }if (!(objO.get("ORDEFEFE").isJsonNull())) {
                    orden.setORDEFEFE(objO.get("ORDEFEFE").getAsString());
                }if (!(objO.get("ORDEFEFI").isJsonNull())) {
                    orden.setORDEFEFI(objO.get("ORDEFEFI").getAsString());
                }if (!(objO.get("ORDEFEIE").isJsonNull())) {
                    orden.setORDEFEIE(objO.get("ORDEFEIE").getAsString());
                }if (!(objO.get("ORDEFEIN").isJsonNull())) {
                    orden.setORDEFEIN(objO.get("ORDEFEIN").getAsString());
                }if (!(objO.get("ORDEFELE").isJsonNull())) {
                    orden.setORDEFELE(objO.get("ORDEFELE").getAsString());
                }if (!(objO.get("ORDEFEML").isJsonNull())) {
                    orden.setORDEFEML(objO.get("ORDEFEML").getAsString());
                }if (!(objO.get("ORDEFERE").isJsonNull())) {
                    orden.setORDEFERE(objO.get("ORDEFERE").getAsString());
                }if (!(objO.get("ORDELATI").isJsonNull())) {
                    orden.setORDELATI(objO.get("ORDELATI").getAsString());
                }if (!(objO.get("ORDELEAC").isJsonNull())) {
                    orden.setORDELEAC(objO.get("ORDELEAC").getAsString());
                }if (!(objO.get("ORDELONG").isJsonNull())) {
                    orden.setORDELONG(objO.get("ORDELONG").getAsString());
                }if (!(objO.get("ORDEMARI").isJsonNull())) {
                    orden.setORDEMARI(objO.get("ORDEMARI").getAsString());
                }if (!(objO.get("ORDEMART").isJsonNull())) {
                    orden.setORDEMART(objO.get("ORDEMART").getAsString());
                }if (!(objO.get("ORDEMEDI").isJsonNull())) {
                    orden.setORDEMEDI(objO.get("ORDEMEDI").getAsString());
                }if (!(objO.get("ORDEMOLE").isJsonNull())) {
                    orden.setORDEMOLE(objO.get("ORDEMOLE").getAsString());
                }if (!(objO.get("ORDENATT").isJsonNull())) {
                    orden.setORDENATT(objO.get("ORDENATT").getAsString());
                }if (!(objO.get("ORDENAUO").isJsonNull())) {
                    orden.setORDENAUO(objO.get("ORDENAUO").getAsString());
                }if (!(objO.get("ORDENUME").isJsonNull())) {
                    orden.setORDENUME(objO.get("ORDENUME").getAsString());
                }if (!(objO.get("ORDEOBSE").isJsonNull())) {
                    orden.setORDEOBSE(objO.get("ORDEOBSE").getAsString());
                }if (!(objO.get("ORDEORID").isJsonNull())) {
                    orden.setORDEORID(objO.get("ORDEORID").getAsString());
                }if (!(objO.get("ORDEPACK").isJsonNull())) {
                    orden.setORDEPACK(objO.get("ORDEPACK").getAsString());
                }if (!(objO.get("ORDEPADR").isJsonNull())) {
                    orden.setORDEPADR(objO.get("ORDEPADR").getAsString());
                }if (!(objO.get("ORDEPEND").isJsonNull())) {
                    orden.setORDEPEND(objO.get("ORDEPEND").getAsString());
                }if (!(objO.get("ORDEPERI").isJsonNull())) {
                    orden.setORDEPERI(objO.get("ORDEPERI").getAsString());
                }if (!(objO.get("ORDEPERS").isJsonNull())) {
                    orden.setORDEPERS(objO.get("ORDEPERS").getAsString());
                }if (!(objO.get("ORDEPRAC").isJsonNull())) {
                    orden.setORDEPRAC(objO.get("ORDEPRAC").getAsString());
                }if (!(objO.get("ORDEPRAL").isJsonNull())) {
                    orden.setORDEPRAL(objO.get("ORDEPRAL").getAsString());
                }if (!(objO.get("ORDEPRIO").isJsonNull())) {
                    orden.setORDEPRIO(objO.get("ORDEPRIO").getAsString());
                }if (!(objO.get("ORDEREUS").isJsonNull())) {
                    orden.setORDEREUS(objO.get("ORDEREUS").getAsString());
                }if (!(objO.get("ORDERULE").isJsonNull())) {
                    orden.setORDERULE(objO.get("ORDERULE").getAsString());
                }if (!(objO.get("ORDERUTA").isJsonNull())) {
                    orden.setORDERUTA(objO.get("ORDERUTA").getAsString());
                }if (!(objO.get("ORDESEQU").isJsonNull())) {
                    orden.setORDESEQU(objO.get("ORDESEQU").getAsString());
                }if (!(objO.get("ORDESUSC").isJsonNull())) {
                    orden.setORDESUSC(objO.get("ORDESUSC").getAsString());
                }if (!(objO.get("ORDETELE").isJsonNull())) {
                    orden.setORDETELE(objO.get("ORDETELE").getAsString());
                }if (!(objO.get("ORDETERM").isJsonNull())) {
                    orden.setORDETERM(objO.get("ORDETERM").getAsString());
                }if (!(objO.get("ORDETIAS").isJsonNull())) {
                    orden.setORDETIAS(objO.get("ORDETIAS").getAsString());
                }if (!(objO.get("ORDETISE").isJsonNull())) {
                    orden.setORDETISE(objO.get("ORDETISE").getAsString());
                }if (!(objO.get("ORDETISO").isJsonNull())) {
                    orden.setORDETISO(objO.get("ORDETISO").getAsString());
                }if (!(objO.get("ORDETITR").isJsonNull())) {
                    orden.setORDETITR(objO.get("ORDETITR").getAsString());
                }if (!(objO.get("ORDETRAR").isJsonNull())) {
                    orden.setORDETRAR(objO.get("ORDETRAR").getAsString());
                }if (!(objO.get("ORDEUNOP").isJsonNull())) {
                    orden.setORDEUNOP(objO.get("ORDEUNOP").getAsString());
                }if (!(objO.get("ORDEUOPA").isJsonNull())) {
                    orden.setORDEUOPA(objO.get("ORDEUOPA").getAsString());
                }if (!(objO.get("ORDEUSCR").isJsonNull())) {
                    orden.setORDEUSCR(objO.get("ORDEUSCR").getAsString());
                }if (!(objO.get("ORDEUSO").isJsonNull())) {
                    orden.setORDEUSO(objO.get("ORDEUSO").getAsString());
                }if (!(objO.get("ORDEVAOR").isJsonNull())) {
                    orden.setORDEVAOR(objO.get("ORDEVAOR").getAsString());
                }
                listaOrden.add(orden);
            }
        }
        return listaOrden;
    }
}
