package io.ruck.jaxb.java8.javafx;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author ruckc
 */
public class Main {

    private static final JAXBContext JAXB;

    static {
        try {
            JAXB = JAXBContext.newInstance(Business.class);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    static String marshal(Business b) throws JAXBException {
        Marshaller m = JAXB.createMarshaller();
        StringWriter sw = new StringWriter();
        m.marshal(b, sw);
        return sw.toString();
    }

    static Business unmarshall(String s) throws JAXBException {
        Unmarshaller u = JAXB.createUnmarshaller();
        return (Business) u.unmarshal(new StringReader(s));
    }

    public static void main(String... args) throws JAXBException {
        Business sevenEleven = new Business();
        sevenEleven.setName("7-11");
        System.out.println(marshal(sevenEleven));
        String mcdonalds = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<business name=\"McDonalds\"/>";
        System.out.println("Name: " + unmarshall(mcdonalds).getName());
    }
}
