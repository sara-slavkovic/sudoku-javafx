
package Server_client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Server_client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegistrujKorisnika_QNAME = new QName("http://Server/", "registrujKorisnika");
    private final static QName _RegistrujKorisnikaResponse_QNAME = new QName("http://Server/", "registrujKorisnikaResponse");
    private final static QName _VratiRangListu_QNAME = new QName("http://Server/", "vratiRangListu");
    private final static QName _VratiRangListuResponse_QNAME = new QName("http://Server/", "vratiRangListuResponse");
    private final static QName _Exception_QNAME = new QName("http://Server/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Server_client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistrujKorisnika }
     * 
     */
    public RegistrujKorisnika createRegistrujKorisnika() {
        return new RegistrujKorisnika();
    }

    /**
     * Create an instance of {@link RegistrujKorisnikaResponse }
     * 
     */
    public RegistrujKorisnikaResponse createRegistrujKorisnikaResponse() {
        return new RegistrujKorisnikaResponse();
    }

    /**
     * Create an instance of {@link VratiRangListu }
     * 
     */
    public VratiRangListu createVratiRangListu() {
        return new VratiRangListu();
    }

    /**
     * Create an instance of {@link VratiRangListuResponse }
     * 
     */
    public VratiRangListuResponse createVratiRangListuResponse() {
        return new VratiRangListuResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Korisnik }
     * 
     */
    public Korisnik createKorisnik() {
        return new Korisnik();
    }

    /**
     * Create an instance of {@link SudokuTabla }
     * 
     */
    public SudokuTabla createSudokuTabla() {
        return new SudokuTabla();
    }

    /**
     * Create an instance of {@link Igra }
     * 
     */
    public Igra createIgra() {
        return new Igra();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrujKorisnika }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistrujKorisnika }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "registrujKorisnika")
    public JAXBElement<RegistrujKorisnika> createRegistrujKorisnika(RegistrujKorisnika value) {
        return new JAXBElement<RegistrujKorisnika>(_RegistrujKorisnika_QNAME, RegistrujKorisnika.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrujKorisnikaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistrujKorisnikaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "registrujKorisnikaResponse")
    public JAXBElement<RegistrujKorisnikaResponse> createRegistrujKorisnikaResponse(RegistrujKorisnikaResponse value) {
        return new JAXBElement<RegistrujKorisnikaResponse>(_RegistrujKorisnikaResponse_QNAME, RegistrujKorisnikaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VratiRangListu }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VratiRangListu }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "vratiRangListu")
    public JAXBElement<VratiRangListu> createVratiRangListu(VratiRangListu value) {
        return new JAXBElement<VratiRangListu>(_VratiRangListu_QNAME, VratiRangListu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VratiRangListuResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VratiRangListuResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "vratiRangListuResponse")
    public JAXBElement<VratiRangListuResponse> createVratiRangListuResponse(VratiRangListuResponse value) {
        return new JAXBElement<VratiRangListuResponse>(_VratiRangListuResponse_QNAME, VratiRangListuResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
