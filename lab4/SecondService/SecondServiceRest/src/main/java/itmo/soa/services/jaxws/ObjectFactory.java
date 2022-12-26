
package itmo.soa.services.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the itmo.soa.services.ws package. 
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

    private final static QName _MoveToCave_QNAME = new QName("http://ws.services.soa.itmo/", "moveToCave");
    private final static QName _KillDragonResponse_QNAME = new QName("http://ws.services.soa.itmo/", "killDragonResponse");
    private final static QName _UnrecoverableKeyException_QNAME = new QName("http://ws.services.soa.itmo/", "UnrecoverableKeyException");
    private final static QName _KillDragon_QNAME = new QName("http://ws.services.soa.itmo/", "killDragon");
    private final static QName _KeyManagementException_QNAME = new QName("http://ws.services.soa.itmo/", "KeyManagementException");
    private final static QName _IOException_QNAME = new QName("http://ws.services.soa.itmo/", "IOException");
    private final static QName _KeyStoreException_QNAME = new QName("http://ws.services.soa.itmo/", "KeyStoreException");
    private final static QName _NoSuchAlgorithmException_QNAME = new QName("http://ws.services.soa.itmo/", "NoSuchAlgorithmException");
    private final static QName _CertificateException_QNAME = new QName("http://ws.services.soa.itmo/", "CertificateException");
    private final static QName _GetCaveId_QNAME = new QName("http://ws.services.soa.itmo/", "getCaveId");
    private final static QName _MoveToCaveResponse_QNAME = new QName("http://ws.services.soa.itmo/", "moveToCaveResponse");
    private final static QName _DragonsServiceException_QNAME = new QName("http://ws.services.soa.itmo/", "DragonsServiceException");
    private final static QName _GetCaveIdResponse_QNAME = new QName("http://ws.services.soa.itmo/", "getCaveIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: itmo.soa.services.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DragonsServiceException }
     * 
     */
    public DragonsServiceException createDragonsServiceException() {
        return new DragonsServiceException();
    }

    /**
     * Create an instance of {@link GetCaveIdResponse }
     * 
     */
    public GetCaveIdResponse createGetCaveIdResponse() {
        return new GetCaveIdResponse();
    }

    /**
     * Create an instance of {@link MoveToCaveResponse }
     * 
     */
    public MoveToCaveResponse createMoveToCaveResponse() {
        return new MoveToCaveResponse();
    }

    /**
     * Create an instance of {@link CertificateException }
     * 
     */
    public CertificateException createCertificateException() {
        return new CertificateException();
    }

    /**
     * Create an instance of {@link GetCaveId }
     * 
     */
    public GetCaveId createGetCaveId() {
        return new GetCaveId();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link KeyStoreException }
     * 
     */
    public KeyStoreException createKeyStoreException() {
        return new KeyStoreException();
    }

    /**
     * Create an instance of {@link NoSuchAlgorithmException }
     * 
     */
    public NoSuchAlgorithmException createNoSuchAlgorithmException() {
        return new NoSuchAlgorithmException();
    }

    /**
     * Create an instance of {@link KeyManagementException }
     * 
     */
    public KeyManagementException createKeyManagementException() {
        return new KeyManagementException();
    }

    /**
     * Create an instance of {@link KillDragon }
     * 
     */
    public KillDragon createKillDragon() {
        return new KillDragon();
    }

    /**
     * Create an instance of {@link UnrecoverableKeyException }
     * 
     */
    public UnrecoverableKeyException createUnrecoverableKeyException() {
        return new UnrecoverableKeyException();
    }

    /**
     * Create an instance of {@link KillDragonResponse }
     * 
     */
    public KillDragonResponse createKillDragonResponse() {
        return new KillDragonResponse();
    }

    /**
     * Create an instance of {@link MoveToCave }
     * 
     */
    public MoveToCave createMoveToCave() {
        return new MoveToCave();
    }

    /**
     * Create an instance of {@link DefaultDto }
     * 
     */
    public DefaultDto createDefaultDto() {
        return new DefaultDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoveToCave }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "moveToCave")
    public JAXBElement<MoveToCave> createMoveToCave(MoveToCave value) {
        return new JAXBElement<MoveToCave>(_MoveToCave_QNAME, MoveToCave.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KillDragonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "killDragonResponse")
    public JAXBElement<KillDragonResponse> createKillDragonResponse(KillDragonResponse value) {
        return new JAXBElement<KillDragonResponse>(_KillDragonResponse_QNAME, KillDragonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnrecoverableKeyException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "UnrecoverableKeyException")
    public JAXBElement<UnrecoverableKeyException> createUnrecoverableKeyException(UnrecoverableKeyException value) {
        return new JAXBElement<UnrecoverableKeyException>(_UnrecoverableKeyException_QNAME, UnrecoverableKeyException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KillDragon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "killDragon")
    public JAXBElement<KillDragon> createKillDragon(KillDragon value) {
        return new JAXBElement<KillDragon>(_KillDragon_QNAME, KillDragon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyManagementException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "KeyManagementException")
    public JAXBElement<KeyManagementException> createKeyManagementException(KeyManagementException value) {
        return new JAXBElement<KeyManagementException>(_KeyManagementException_QNAME, KeyManagementException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KeyStoreException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "KeyStoreException")
    public JAXBElement<KeyStoreException> createKeyStoreException(KeyStoreException value) {
        return new JAXBElement<KeyStoreException>(_KeyStoreException_QNAME, KeyStoreException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoSuchAlgorithmException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "NoSuchAlgorithmException")
    public JAXBElement<NoSuchAlgorithmException> createNoSuchAlgorithmException(NoSuchAlgorithmException value) {
        return new JAXBElement<NoSuchAlgorithmException>(_NoSuchAlgorithmException_QNAME, NoSuchAlgorithmException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CertificateException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "CertificateException")
    public JAXBElement<CertificateException> createCertificateException(CertificateException value) {
        return new JAXBElement<CertificateException>(_CertificateException_QNAME, CertificateException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCaveId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "getCaveId")
    public JAXBElement<GetCaveId> createGetCaveId(GetCaveId value) {
        return new JAXBElement<GetCaveId>(_GetCaveId_QNAME, GetCaveId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MoveToCaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "moveToCaveResponse")
    public JAXBElement<MoveToCaveResponse> createMoveToCaveResponse(MoveToCaveResponse value) {
        return new JAXBElement<MoveToCaveResponse>(_MoveToCaveResponse_QNAME, MoveToCaveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DragonsServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "DragonsServiceException")
    public JAXBElement<DragonsServiceException> createDragonsServiceException(DragonsServiceException value) {
        return new JAXBElement<DragonsServiceException>(_DragonsServiceException_QNAME, DragonsServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCaveIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.services.soa.itmo/", name = "getCaveIdResponse")
    public JAXBElement<GetCaveIdResponse> createGetCaveIdResponse(GetCaveIdResponse value) {
        return new JAXBElement<GetCaveIdResponse>(_GetCaveIdResponse_QNAME, GetCaveIdResponse.class, null, value);
    }

}
