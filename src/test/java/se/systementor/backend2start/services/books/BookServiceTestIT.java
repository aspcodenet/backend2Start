package se.systementor.backend2start.services.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BookServiceTestIT {
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