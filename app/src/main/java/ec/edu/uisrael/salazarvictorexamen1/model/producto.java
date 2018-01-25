package ec.edu.uisrael.salazarvictorexamen1.model;

import android.net.Uri;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

/**
 * Created by Victor on 4/12/2017.
 */

public class producto implements  KvmSerializable{

    private int idProducto;
    private String nombre;
    private String pvp;

    public producto() {
    }

    public producto(int idProducto, String nombre, String pvp) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.pvp = pvp;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPvp() {
        return pvp;
    }

    public void setPvp(String pvp) {
        this.pvp = pvp;
    }

    @Override
    public Object getProperty(int index) {
        switch(index)
        {
            case 0:
                return idProducto;
            case 1:
                return nombre;
            case 2:
                return pvp;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void setProperty(int index, Object value) {
        switch(index)
        {
            case 0:
                idProducto = (int) value;
                break;
            case 1:
                nombre = value.toString();
                break;
            case 2:
                pvp = value.toString();
                break;
            default:
                break;
        }
    }

    @Override
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        switch(index)
        {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "idProducto";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nombre";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "pvp";
                break;

            default:break;
        }
    }
    public producto (SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("idProducto"))
        {
            Object obj = soapObject.getProperty("idProducto");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) soapObject.getProperty("idProducto");
                idProducto = Integer.getInteger(j.toString());
            }
        }
        if (soapObject.hasProperty("nombre"))
        {
            Object obj = soapObject.getProperty("nombre");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) soapObject.getProperty("nombre");
                nombre = j.toString();
            }
        }
        if (soapObject.hasProperty("pvp"))
        {
            Object obj = soapObject.getProperty("pvp");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) soapObject.getProperty("pvp");
                pvp = j.toString();
            }
        }


    }
}

