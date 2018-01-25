package ec.edu.uisrael.salazarvictorexamen1.model;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

/**
 * Created by Victor on 4/12/2017.
 */

public class RequestProducto implements  KvmSerializable{

    public producto WSProducto;

    public RequestProducto() {
        super();
    }
    public RequestProducto(producto WSProducto) {
        super();
        this.WSProducto = WSProducto;
    }

    @Override
    public Object getProperty(int index) {
        switch (index) {
            case 0:
                return WSProducto;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void setProperty(int index, Object value) {

    }

    @Override
    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = producto.class;
                info.name = "producto";
                break;

        }
    }

    public RequestProducto(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("producto")) {
            Object obj = soapObject.getProperty("producto");
            WSProducto   =  new  producto((SoapObject)obj);
        }
    }
}

