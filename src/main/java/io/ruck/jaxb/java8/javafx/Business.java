package io.ruck.jaxb.java8.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ruckc
 */
@XmlRootElement(name="business")
public class Business implements Named {

    private final StringProperty nameProperty = new SimpleStringProperty();

    @Shim
    @Override
    public void setName(String name) {
        Named.super.setName(name);
    }

    @Shim
    @XmlAttribute(name="name")
    @Override
    public String getName() {
        return Named.super.getName();
    }

    @Override
    public StringProperty nameProperty() {
        return nameProperty;
    }

}
