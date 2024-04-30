package se.systementor.backend2start.demos;


import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URL;

@Component
public class XmlDemo implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        XmlMapper xmlMapper = new XmlMapper(module);
        students theStudents = xmlMapper.readValue(new URL("https://axmjqhyyjpat.objectstorage.eu-amsterdam-1.oci.customer-oci.com/n/axmjqhyyjpat/b/externalbucket/o/data-1vdvx7Um7UzezAhpKyNmQ.xml"),
                students.class
                );

        for( student s : theStudents.student ){
            System.out.println(s.name);
            System.out.println(s.country);
        }

    }
}
