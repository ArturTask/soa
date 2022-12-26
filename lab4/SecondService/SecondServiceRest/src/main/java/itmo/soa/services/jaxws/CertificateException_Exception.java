
package itmo.soa.services.jaxws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "CertificateException", targetNamespace = "http://ws.services.soa.itmo/")
public class CertificateException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private CertificateException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public CertificateException_Exception(String message, CertificateException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public CertificateException_Exception(String message, CertificateException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: itmo.soa.services.ws.CertificateException
     */
    public CertificateException getFaultInfo() {
        return faultInfo;
    }

}
