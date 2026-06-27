
package Server_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sudokuTabla complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sudokuTabla"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://Server/}abstractDomainObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="pocetnaTabla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resenjeTabla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nivoTezine" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sudokuTabla", propOrder = {
    "id",
    "pocetnaTabla",
    "resenjeTabla",
    "nivoTezine"
})
public class SudokuTabla
    extends AbstractDomainObject
{

    protected int id;
    protected String pocetnaTabla;
    protected String resenjeTabla;
    protected int nivoTezine;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the pocetnaTabla property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPocetnaTabla() {
        return pocetnaTabla;
    }

    /**
     * Sets the value of the pocetnaTabla property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPocetnaTabla(String value) {
        this.pocetnaTabla = value;
    }

    /**
     * Gets the value of the resenjeTabla property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResenjeTabla() {
        return resenjeTabla;
    }

    /**
     * Sets the value of the resenjeTabla property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResenjeTabla(String value) {
        this.resenjeTabla = value;
    }

    /**
     * Gets the value of the nivoTezine property.
     * 
     */
    public int getNivoTezine() {
        return nivoTezine;
    }

    /**
     * Sets the value of the nivoTezine property.
     * 
     */
    public void setNivoTezine(int value) {
        this.nivoTezine = value;
    }

}
