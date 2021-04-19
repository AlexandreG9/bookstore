package fr.aguiheneuf.bookstore.mapper;

import fr.aguiheneuf.bookstore.dto.OrderDto;
import fr.aguiheneuf.bookstore.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper interface of {@link Order}
 *
 * @author Alexandre Guiheneuf
 */
@Mapper
public interface OrderMapper {

    /**
     * Transform {@link Order} to {@link OrderDto}
     * @param order the entity
     * @return the dto
     */
    @Mapping(target = "orderNumber", source = "id")
    OrderDto getOrderDtoFromEntity(Order order);

}
