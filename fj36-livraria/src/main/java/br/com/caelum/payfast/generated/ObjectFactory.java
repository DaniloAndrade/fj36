//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2016.03.06 às 05:19:19 PM BRT 
//


package br.com.caelum.payfast.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.caelum.payfast.generated package. 
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

    private final static QName _Pagamento_QNAME = new QName("", "pagamento");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.caelum.payfast.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pagamento }
     * 
     */
    public Pagamento createPagamento() {
        return new Pagamento();
    }

    /**
     * Create an instance of {@link Link }
     * 
     */
    public Link createLink() {
        return new Link();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pagamento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pagamento")
    public JAXBElement<Pagamento> createPagamento(Pagamento value) {
        return new JAXBElement<Pagamento>(_Pagamento_QNAME, Pagamento.class, null, value);
    }

}
