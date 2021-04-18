package fr.aguiheneuf.bookstore.util;

import fr.aguiheneuf.bookstore.dto.SearchBookRequestDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * @author Alexandre Guiheneuf
 */
public final class TestUtil {

    private TestUtil() {
    }

    public static <T extends Object> HttpEntity<T> generateHttpEntity(T object) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<T>(object, headers);
    }
}
