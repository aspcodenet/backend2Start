package se.systementor.backend2start.demos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class price{
    @JacksonXmlProperty(isAttribute = true)
    public String currency;

    @JacksonXmlText
    public float amount;

}
