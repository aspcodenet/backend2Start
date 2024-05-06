package se.systementor.backend2start;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import se.systementor.backend2start.demos.Catalog;
import se.systementor.backend2start.demos.book;

import java.net.URL;

@ComponentScan
public class FetchCustomers implements CommandLineRunner {

//    @Autowired
//    private se.systementor.backend2start.Utils.DataSeeder dataSeeder;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Kör fetcbcustomers");
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper xmlMapper = new XmlMapper(module);
        Catalog theBooks = xmlMapper.readValue(new URL("https://axmjqhyyjpat.objectstorage.eu-amsterdam-1.oci.customer-oci.com/n/axmjqhyyjpat/b/aspcodeprod/o/books.xml"),
                Catalog.class
        );

        for( book s : theBooks.books ){
            System.out.println(s.title);
            System.out.println(s.id);
        }


    }

}
