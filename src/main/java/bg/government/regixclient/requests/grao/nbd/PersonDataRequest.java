//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.10 at 07:51:31 PM EET 
//


package bg.government.regixclient.requests.grao.nbd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * <p>Java class for PersonDataRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonDataRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EGN" type="{http://egov.bg/RegiX/GRAO/NBD}EGN" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PersonDataRequest", namespace = "http://egov.bg/RegiX/GRAO/NBD/PersonDataRequest")
public class PersonDataRequest {

    @XmlElement(name = "EGN")
    protected String egn;

    /**
     * Gets the value of the egn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEGN() {
        return egn;
    }

    /**
     * Sets the value of the egn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEGN(String value) {
        this.egn = value;
    }

}
