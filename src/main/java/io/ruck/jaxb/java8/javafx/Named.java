package io.ruck.jaxb.java8.javafx;

import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author ruckc
 */
public interface Named {
    @XmlAttribute(name="name")
    default String getName() {
        return nameProperty().get();
    }
    
    default void setName(String name) {
        nameProperty().set(name);
    }
    
    StringProperty nameProperty();
}
