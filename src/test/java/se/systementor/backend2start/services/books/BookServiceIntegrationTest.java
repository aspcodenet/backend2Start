package se.systementor.backend2start.services.books;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import se.systementor.backend2start.demos.book;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@Profile("IntegrationTest")
class BookServiceIntegrationTest {
    @Autowired
    BookService sut;

    @Test
    void getBooksWillFetch() throws IOException {
        Scanner s = new Scanner(sut.xmlStreamProvider.getDataStream()).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";

        assertTrue(  result.contains("<catalog>") );
        assertTrue(  result.contains("</catalog>") );
        assertTrue(  result.contains("<author>") );
        assertTrue(  result.contains("<author>") );
        assertTrue(  result.contains("</author>") );
        assertTrue(  result.contains("<title>") );
        assertTrue(  result.contains("</title>") );
        assertTrue(  result.contains("<genre>") );
        assertTrue(  result.contains("</genre>") );
        assertTrue(  result.contains("<price>") );
        assertTrue(  result.contains("</price>") );
        assertTrue(  result.contains("<publish_date>") );
        assertTrue(  result.contains("</publish_date>") );
        assertTrue(  result.contains("<description>") );
        assertTrue(  result.contains("</description>") );


    }

}