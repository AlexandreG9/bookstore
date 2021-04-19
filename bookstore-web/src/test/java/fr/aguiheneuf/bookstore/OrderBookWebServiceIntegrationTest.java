package fr.aguiheneuf.bookstore;

import fr.aguiheneuf.bookstore.dto.*;
import fr.aguiheneuf.bookstore.util.TestUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Alexandre Guiheneuf
 */
public class OrderBookWebServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createOrderOk() {
        final OrderBooksRequestDto orderBooksRequestDto = new OrderBooksRequestDto();
        final BookRequestDto bookRequestDto1 = BookRequestDto.builder()
                .isbn("9782070360284")
                .quantity(2)
                .build();

        final BookRequestDto bookRequestDto2 = BookRequestDto.builder()
                .isbn("9782070754922")
                .quantity(1)
                .build();

        orderBooksRequestDto.setBookRequestDtos(Set.of(bookRequestDto1, bookRequestDto2));

        final ResponseEntity<OrderDto> response = this.restTemplate.exchange("/order/create", HttpMethod.POST,
                TestUtil.generateHttpEntity(orderBooksRequestDto), OrderDto.class);


        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        final OrderDto dto = response.getBody();
        Assertions.assertThat(dto).isNotNull();
        Assertions.assertThat(dto.getPrice()).isEqualByComparingTo(BigDecimal.valueOf(55.6d));
        Assertions.assertThat(dto.getOrderDetails()).containsAll(getExpectedOrderDetailDtoData());
    }

    @Test
    public void createOrderOutOfOrder() {
        final OrderBooksRequestDto orderBooksRequestDto = new OrderBooksRequestDto();
        final BookRequestDto bookRequestDto = BookRequestDto.builder()
                .isbn("9782370490001")
                .quantity(2)
                .build();

        orderBooksRequestDto.setBookRequestDtos(Set.of(bookRequestDto));

        final ResponseEntity<String> response = this.restTemplate.exchange("/order/create", HttpMethod.POST,
                TestUtil.generateHttpEntity(orderBooksRequestDto), String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isEqualTo("At least one of these books are unavailable. Order is impossible.");
    }

    @Test
    public void createOrderNoBookError() {
        final ResponseEntity<String> response = this.restTemplate.exchange("/order/create", HttpMethod.POST,
                TestUtil.generateHttpEntity(new OrderBooksRequestDto()), String.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        Assertions.assertThat(response.getBody()).isEqualTo("Technical error, cannot order books");
    }

    @Test
    public void findOrderExists() {
        final ResponseEntity<OrderDto> response = this.restTemplate.getForEntity("/order/2", OrderDto.class);

        // Build expected Order
        final OrderDto expectedOrderDto = OrderDto.builder()
                .orderNumber(2)
                .price(BigDecimal.valueOf(55.6d).setScale(2))
                .dateTime(LocalDateTime.of(2021, Month.APRIL, 17, 8, 5, 41)) // 2021-04-17 08:05:41
                .orderDetails(getExpectedOrderDetailDtoData())
                .build();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isInstanceOfSatisfying(OrderDto.class, orderDto -> {
            Assertions.assertThat(orderDto.getOrderDetails()).containsAll(expectedOrderDto.getOrderDetails());
            Assertions.assertThat(orderDto.getOrderNumber()).isEqualTo(expectedOrderDto.getOrderNumber());
            Assertions.assertThat(orderDto.getPrice()).isEqualTo(expectedOrderDto.getPrice());
            Assertions.assertThat(orderDto.getDateTime()).isEqualTo(expectedOrderDto.getDateTime());
        });
    }


    /**
     * Generate expected data for {@link #createOrderOk()} and {@link #findOrderExists()}
     *
     * @return a list that contains expected {@link OrderDto}
     */
    private List<OrderDetailDto> getExpectedOrderDetailDtoData() {
        final OrderDetailDto orderDetailDto1 = OrderDetailDto.builder()
                .book(BookDto.builder()
                        .isbn("9782070360284")
                        .title("Voyage au bout de la nuit")
                        .price(BigDecimal.valueOf(10.3d).setScale(2))
                        .build())
                .quantity(2)
                .build();

        final OrderDetailDto orderDetailDto2 = OrderDetailDto.builder()
                .book(BookDto.builder()
                        .isbn("9782070754922")
                        .title("A la recherche du temps perdu")
                        .price(BigDecimal.valueOf(35).setScale(2))
                        .build())
                .quantity(1)
                .build();

        return Arrays.asList(orderDetailDto1, orderDetailDto2);
    }
}
