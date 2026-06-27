
package Server_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for korisnik complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="korisnik"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://Server/}abstractDomainObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="korisnickoIme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lozinka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "korisnik", propOrder = {
    "id",
    "korisnickoIme",
    "lozinka"
})
public class Korisnik
    extends AbstractDomainObject
{

    protected int id;
    protected String korisnickoIme;
    protected String lozinka;

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
     * Gets the value of the korisnickoIme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * Sets the value of the korisnickoIme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKorisnickoIme(String value) {
        this.korisnickoIme = value;
    }

    /**
     * Gets the value of the lozinka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * Sets the value of the lozinka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLozinka(String value) {
        this.lozinka = value;
    }

}
