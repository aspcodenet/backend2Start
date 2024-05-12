package se.systementor.backend2start.services.books;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.systementor.backend2start.demos.Catalog;
import se.systementor.backend2start.demos.book;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;


@Service
public class BookService {


    @Autowired
    BookService(XmlStreamProvider xmlStreamProvider){
        this.xmlStreamProvider = xmlStreamProvider;
    }


    XmlStreamProvider xmlStreamProvider;


    public List<book> GetBooks() throws IOException {
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper xmlMapper = new XmlMapper(module);
        InputStream stream =  xmlStreamProvider.getDataStream();
        Catalog theBooks = xmlMapper.readValue(stream,
                Catalog.class
        );

        return theBooks.books;
    }

}
