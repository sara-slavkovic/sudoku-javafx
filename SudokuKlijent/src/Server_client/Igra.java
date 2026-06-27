
package Server_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for igra complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="igra"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://Server/}abstractDomainObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="vremeResavanja" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="brojGresaka" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nivoTezine" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="trenutnoStanje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="datumIgre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="korisnik" type="{http://Server/}korisnik" minOccurs="0"/&gt;
 *         &lt;element name="sudokuTabla" type="{http://Server/}sudokuTabla" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "igra", propOrder = {
    "id",
    "vremeResavanja",
    "brojGresaka",
    "nivoTezine",
    "status",
    "trenutnoStanje",
    "datumIgre",
    "korisnik",
    "sudokuTabla"
})
public class Igra
    extends AbstractDomainObject
{

    protected int id;
    protected int vremeResavanja;
    protected int brojGresaka;
    protected int nivoTezine;
    protected int status;
    protected String trenutnoStanje;
    protected String datumIgre;
    protected Korisnik korisnik;
    protected SudokuTabla sudokuTabla;

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
     * Gets the value of the vremeResavanja property.
     * 
     */
    public int getVremeResavanja() {
        return vremeResavanja;
    }

    /**
     * Sets the value of the vremeResavanja property.
     * 
     */
    public void setVremeResavanja(int value) {
        this.vremeResavanja = value;
    }

    /**
     * Gets the value of the brojGresaka property.
     * 
     */
    public int getBrojGresaka() {
        return brojGresaka;
    }

    /**
     * Sets the value of the brojGresaka property.
     * 
     */
    public void setBrojGresaka(int value) {
        this.brojGresaka = value;
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

    /**
     * Gets the value of the status property.
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the trenutnoStanje property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrenutnoStanje() {
        return trenutnoStanje;
    }

    /**
     * Sets the value of the trenutnoStanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrenutnoStanje(String value) {
        this.trenutnoStanje = value;
    }

    /**
     * Gets the value of the datumIgre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumIgre() {
        return datumIgre;
    }

    /**
     * Sets the value of the datumIgre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumIgre(String value) {
        this.datumIgre = value;
    }

    /**
     * Gets the value of the korisnik property.
     * 
     * @return
     *     possible object is
     *     {@link Korisnik }
     *     
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Sets the value of the korisnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Korisnik }
     *     
     */
    public void setKorisnik(Korisnik value) {
        this.korisnik = value;
    }

    /**
     * Gets the value of the sudokuTabla property.
     * 
     * @return
     *     possible object is
     *     {@link SudokuTabla }
     *     
     */
    public SudokuTabla getSudokuTabla() {
        return sudokuTabla;
    }

    /**
     * Sets the value of the sudokuTabla property.
     * 
     * @param value
     *     allowed object is
     *     {@link SudokuTabla }
     *     
     */
    public void setSudokuTabla(SudokuTabla value) {
        this.sudokuTabla = value;
    }

}
