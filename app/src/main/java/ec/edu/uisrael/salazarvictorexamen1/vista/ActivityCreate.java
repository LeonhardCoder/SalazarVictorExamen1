package ec.edu.uisrael.salazarvictorexamen1.vista;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import ec.edu.uisrael.salazarvictorexamen1.R;
import ec.edu.uisrael.salazarvictorexamen1.controlador.ControllerLogin;
import ec.edu.uisrael.salazarvictorexamen1.controlador.ControllerViews;
import ec.edu.uisrael.salazarvictorexamen1.model.RequestProducto;
import ec.edu.uisrael.salazarvictorexamen1.model.Usuario;
import ec.edu.uisrael.salazarvictorexamen1.model.producto;

public class ActivityCreate extends AppCompatActivity {
    private static String NAMESPACE = "http://ws.docente.uisrael.edu.ec/";
    private static String URL = "http://www.cuscungosoft.com:8080/docente-ws/ProductoServices";
    private TextView textproducto;
    private TextView textprecio;
    private String respuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        textproducto  =  (TextView) findViewById(R.id.txtproducto);
        textprecio  =  (TextView) findViewById(R.id.txtprecio);
    }

    public void onclickSave (View v) {
        AsyncCallWS task = new AsyncCallWS();
        task.execute();
    }
    public void onclickCancel (View v) {
        Intent intlistProduct =  new Intent ( ActivityCreate.this, productList.class);
        startActivity(intlistProduct);

    }

    private class AsyncCallWS extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            String producto = textproducto.getText().toString();
            String p = textprecio.getText().toString();
            //Double precio = Double.valueOf(p).doubleValue();
            insertProductWS(producto, p);

            return null;
        }

        protected void onPostExecute(Void result) {
            if (respuesta.equals("OK")){
                Toast.makeText(ActivityCreate.this, "Guardado correctamente", Toast.LENGTH_SHORT).show();
                Intent intlistProduct =  new Intent ( ActivityCreate.this, productList.class);
                startActivity(intlistProduct);
            }else{
                Toast.makeText(ActivityCreate.this, "Error al guardar", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void insertProductWS(String usr, String pwd) {
        String METHOD_NAME = "crearProducto";
        String SOAP_ACTION = "crearProductoAction";
        producto productIn =  new producto(1,usr,pwd);
        RequestProducto rstProduc   =  new RequestProducto(productIn);
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("producto",rstProduc.getProperty(0));
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.dotNet = false;
        soapEnvelope.implicitTypes = true;
        soapEnvelope.setOutputSoapObject(request);
        HttpTransportSE transporte = new HttpTransportSE(URL);
        try {
            transporte.call(SOAP_ACTION, soapEnvelope);
            //Se procesa el resultado devuelto
            //SoapObject   response = (SoapObject ) soapEnvelope.bodyIn;
            SoapPrimitive  response = (SoapPrimitive) soapEnvelope.getResponse();
            respuesta = "OK";
        } catch (Exception e) {
            e.printStackTrace();
            respuesta = "ERROR";
        }
    }

}
