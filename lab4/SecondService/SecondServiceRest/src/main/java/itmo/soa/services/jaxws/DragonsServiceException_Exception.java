
package itmo.soa.services.jaxws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "DragonsServiceException", targetNamespace = "http://ws.services.soa.itmo/")
public class DragonsServiceException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private DragonsServiceException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public DragonsServiceException_Exception(String message, DragonsServiceException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public DragonsServiceException_Exception(String message, DragonsServiceException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: itmo.soa.services.ws.DragonsServiceException
     */
    public DragonsServiceException getFaultInfo() {
        return faultInfo;
    }

}
