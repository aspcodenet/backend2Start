package se.systementor.backend2start.demos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "catalog")
public class Catalog {
    @JacksonXmlProperty(localName = "book")
    public List<book> books;

}
