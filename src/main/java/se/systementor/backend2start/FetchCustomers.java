package se.systementor.backend2start;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import se.systementor.backend2start.demos.Catalog;
import se.systementor.backend2start.demos.CsvUser;
import se.systementor.backend2start.demos.Post;
import se.systementor.backend2start.demos.book;

import java.net.URL;
import java.util.List;

@ComponentScan
public class FetchCustomers implements CommandLineRunner {

//    @Autowired
//    private se.systementor.backend2start.Utils.DataSeeder dataSeeder;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Kör fetcbcustomers");

//        //https://jsonplaceholder.typicode.com/posts
//        JsonMapper jsonMapper = new JsonMapper();
//        Post []thePosts =jsonMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"),
//                Post[].class
//        );
//
//        for(Post p : thePosts){
//            System.out.println(p.title);
//        }
//
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(CsvUser.class).
                withSkipFirstDataRow(true)
                .withColumnSeparator('.').withoutQuoteChar();

        MappingIterator<CsvUser> allUsers = mapper
                .readerFor(CsvUser.class)
                .with(schema).readValues(new URL("https://gist.githubusercontent.com/RobVanGroenewoud/ba89ad7684df8cefe5c183adb498cc65/raw/f2eec6d2cb89f5d779e16b28ed0dab89d738ba96/sample.csv"));
        List<CsvUser> users = allUsers.readAll();
        for(CsvUser user : users) {
            System.out.println(user.email);
        }



//        JacksonXmlModule module = new JacksonXmlModule();
//        module.setDefaultUseWrapper(false);
//        XmlMapper xmlMapper = new XmlMapper(module);
//        Catalog theBooks = xmlMapper.readValue(new URL("https://axmjqhyyjpat.objectstorage.eu-amsterdam-1.oci.customer-oci.com/n/axmjqhyyjpat/b/aspcodeprod/o/books.xml"),
//                Catalog.class
//        );
//
//        for( book s : theBooks.books ){
//            System.out.println(s.title);
//            System.out.println(s.id);
//        }


    }

}
