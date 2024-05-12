package se.systementor.backend2start.services.books;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import se.systementor.backend2start.demos.book;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookServiceTest {
    private XmlStreamProvider xmlStreamProvider = mock(XmlStreamProvider.class);
    BookService sut;

    @BeforeEach()
    void setUp() {
        sut = new BookService(xmlStreamProvider);

    }

    @Test
    void getBooksShouldMapCorrectly() throws IOException {
        when(xmlStreamProvider.getDataStream()).thenReturn(getClass().getClassLoader().getResourceAsStream("books.xml"));

        List<book> result = sut.GetBooks();
        assertEquals(3, result.size() );
        assertEquals("Stefan 1", result.get(0).author );
        assertEquals("XML Developer's Guide", result.get(0).title );
        assertEquals("Computer", result.get(0).category );

    }

}