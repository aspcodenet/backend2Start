package se.systementor.backend2start.demos;


// VAD ÄR PROBLEMET?
// - vi har en textmassa i XML
// - vi är ju Javaprogrammerare - OBJEKT

// hämta en xml FIL från en "annan sajt"

// rename class
// autogenerate classes  https://json2csharp.com/code-converters/xml-to-java

//Hur vet Jackson att vi vill använda book classen vid mappningen? Jag kan inte se att den nämns i själva mappninskoden.


import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.net.URL;

//@SpringBootApplication
//public class XmlDemo implements CommandLineRunner {
//    @Autowired
//    private se.systementor.backend2start.Utils.DataSeeder dataSeeder;
//
//    @Override
//    public void run(String... args) throws Exception {
//        dataSeeder.Seed();
////        JacksonXmlModule module = new JacksonXmlModule();
////        module.setDefaultUseWrapper(false);
////        XmlMapper xmlMapper = new XmlMapper(module);
////        catalog theBooks = xmlMapper.readValue(new URL("https://axmjqhyyjpat.objectstorage.eu-amsterdam-1.oci.customer-oci.com/n/axmjqhyyjpat/b/aspcodeprod/o/books.xml"),
////                catalog.class
////        );
////
////        for( book s : theBooks.books ){
////            System.out.println(s.title);
////            System.out.println(s.id);
////        }
//
//
////
//        JacksonXmlModule module = new JacksonXmlModule();
//        module.setDefaultUseWrapper(false);
//        XmlMapper xmlMapper = new XmlMapper(module);
//        Catalog theBooks = xmlMapper.readValue(new URL("https://axmjqhyyjpat.objectstorage.eu-amsterdam-1.oci.customer-oci.com/n/axmjqhyyjpat/b/aspcodeprod/o/books2.xml"),
//                Catalog.class
//        );
//
//        for( book s : theBooks.books ){
//            System.out.println(s.title);
//            System.out.println(s.id);
//        }
//
//
//
//
////        JacksonXmlModule module = new JacksonXmlModule();
////        module.setDefaultUseWrapper(false);
////        XmlMapper xmlMapper = new XmlMapper(module);
////        students theStudents = xmlMapper.readValue(new URL("https://axmjqhyyjpat.objectstorage.eu-amsterdam-1.oci.customer-oci.com/n/axmjqhyyjpat/b/externalbucket/o/data-1vdvx7Um7UzezAhpKyNmQ.xml"),
////                students.class
////                );
////
////        for( student s : theStudents.student ){
////            System.out.println(s.name);
////            System.out.println(s.country);
////        }
//
//    }
//}
