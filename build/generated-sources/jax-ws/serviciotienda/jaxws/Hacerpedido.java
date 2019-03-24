
package serviciotienda.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "hacerpedido", namespace = "http://serviciotienda/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hacerpedido", namespace = "http://serviciotienda/", propOrder = {
    "producto",
    "cantidad"
})
public class Hacerpedido {

    @XmlElement(name = "producto", namespace = "")
    private String producto;
    @XmlElement(name = "cantidad", namespace = "")
    private String cantidad;

    /**
     * 
     * @return
     *     returns String
     */
    public String getProducto() {
        return this.producto;
    }

    /**
     * 
     * @param producto
     *     the value for the producto property
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCantidad() {
        return this.cantidad;
    }

    /**
     * 
     * @param cantidad
     *     the value for the cantidad property
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

}
