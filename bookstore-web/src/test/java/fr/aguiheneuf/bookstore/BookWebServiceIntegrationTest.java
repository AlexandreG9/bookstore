package fr.aguiheneuf.bookstore;

import fr.aguiheneuf.bookstore.dto.BookDto;
import fr.aguiheneuf.bookstore.dto.SearchBookRequestDto;
import fr.aguiheneuf.bookstore.util.TestUtil;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Test class for {@link fr.aguiheneuf.bookstore.service.BookService}
 *
 * @author Alexandre Guiheneuf
 */
public class BookWebServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findBookSuccess() {
        SearchBookRequestDto searchBookRequestDto = new SearchBookRequestDto();
        searchBookRequestDto.setIsbnList(Arrays.asList("9782070368228"));

        final ResponseEntity<List<BookDto>> response = this.restTemplate.exchange("/book/find", HttpMethod.POST,
                TestUtil.generateHttpEntity(searchBookRequestDto), new ParameterizedTypeReference<List<BookDto>>() {
                });
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        final List<BookDto> dto = response.getBody();
        Assertions.assertThat(dto.size()).isEqualTo(1);

        final BookDto bookDto = dto.get(0);

        Assertions.assertThat(bookDto.getIsbn()).isEqualTo("9782070368228");
        Assertions.assertThat(bookDto.getTitle()).isEqualTo("1984");
        Assertions.assertThat(bookDto.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(9.2d));
    }

    @Test
    public void findBookError() {
        final ResponseEntity<String> response = this.restTemplate.exchange("/book/find", HttpMethod.POST,
                TestUtil.generateHttpEntity(new SearchBookRequestDto()), String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        Assertions.assertThat(response.getBody()).isNull();
    }

}
