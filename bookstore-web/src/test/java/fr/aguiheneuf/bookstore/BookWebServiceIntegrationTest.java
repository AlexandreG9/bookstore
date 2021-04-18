package fr.aguiheneuf.bookstore;

import fr.aguiheneuf.bookstore.dto.BookDto;
import fr.aguiheneuf.bookstore.dto.SearchBookRequestDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test class for {@link fr.aguiheneuf.bookstore.service.BookService}
 *
 * @author Alexandre Guiheneuf
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookWebServiceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findBookSuccess() {
        final ResponseEntity<List<BookDto>> response = this.restTemplate.exchange("/book/find", HttpMethod.POST,
                generateHttpEntity(Arrays.asList("9782070368228")), new ParameterizedTypeReference<List<BookDto>>() {
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
                generateHttpEntity(new ArrayList<>()), String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        Assertions.assertThat(response.getBody()).isNull();
    }

    private HttpEntity<SearchBookRequestDto> generateHttpEntity(final List<String> isbnList) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final SearchBookRequestDto searchBookRequestDto = new SearchBookRequestDto();
        searchBookRequestDto.setIsbnList(isbnList);

        return new HttpEntity<>(searchBookRequestDto, headers);
    }

}
