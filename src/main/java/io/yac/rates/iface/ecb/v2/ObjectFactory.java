//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.02.17 à 09:03:02 PM CET 
//


package io.yac.rates.iface.ecb.v2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.yac.rates.iface.ecb.v2 package. 
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

    private final static QName _Cube_QNAME = new QName("http://www.ecb.int/vocabulary/2002-08-01/eurofxref", "Cube");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.yac.rates.iface.ecb.v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ECBRate }
     * 
     */
    public ECBRate createCubeType() {
        return new ECBRate();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ECBRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref", name = "Cube")
    public JAXBElement<ECBRate> createCube(ECBRate value) {
        return new JAXBElement<ECBRate>(_Cube_QNAME, ECBRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ECBRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref", name = "Cube", scope = ECBRate.class)
    public JAXBElement<ECBRate> createCubeTypeCube(ECBRate value) {
        return new JAXBElement<ECBRate>(_Cube_QNAME, ECBRate.class, ECBRate.class, value);
    }

}
