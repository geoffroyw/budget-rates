//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2016.02.17 à 09:03:02 PM CET 
//


package io.yac.rates.iface.ecb.v2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Classe Java pour ECBRate complex type.
 * <p/>
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p/>
 * <pre>
 * &lt;complexType name="ECBRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cube" type="{http://www.ecb.int/vocabulary/2002-08-01/eurofxref}ECBRate" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="rate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="time" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ECBRate", namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref", propOrder = {
        "content"
})
public class ECBRate {

    @XmlElementRef(name = "Cube", namespace = "http://www.ecb.int/vocabulary/2002-08-01/eurofxref",
                   type = JAXBElement.class, required = false)
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute(name = "currency")
    protected String currency;
    @XmlAttribute(name = "rate")
    protected String rate;
    @XmlAttribute(name = "time")
    protected String time;

    /**
     * Gets the value of the content property.
     * <p/>
     * <p/>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * <p/>
     * <p/>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * <p/>
     * <p/>
     * <p/>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ECBRate }{@code >}
     * {@link String }
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

    /**
     * Obtient la valeur de la propriété currency.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Définit la valeur de la propriété currency.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Obtient la valeur de la propriété rate.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRate() {
        return rate;
    }

    /**
     * Définit la valeur de la propriété rate.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRate(String value) {
        this.rate = value;
    }

    /**
     * Obtient la valeur de la propriété time.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTime() {
        return time;
    }

    /**
     * Définit la valeur de la propriété time.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTime(String value) {
        this.time = value;
    }

    @Override
    public String toString() {
        return "ECBRate{" +
                "content=" + content +
                ", currency='" + currency + '\'' +
                ", rate='" + rate + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
