package fr.aguiheneuf.bookstore.service.impl;

import fr.aguiheneuf.bookstore.dto.BookDto;
import fr.aguiheneuf.bookstore.dto.SearchBookRequestDto;
import fr.aguiheneuf.bookstore.mapper.BookMapper;
import fr.aguiheneuf.bookstore.model.Book;
import fr.aguiheneuf.bookstore.repository.BookRepository;
import fr.aguiheneuf.bookstore.service.BookService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Alexandre Guiheneuf
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    /**
     * Constructor
     *
     * @param bookRepository instance of {@link BookRepository}
     * @param bookMapper instance of {@link BookMapper}
     */
    @Autowired
    public BookServiceImpl(final BookRepository bookRepository, final BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> findBook(@NonNull final SearchBookRequestDto searchBookRequestDto) {
        Iterable<Book> books = bookRepository.findAllById(searchBookRequestDto.getIsbnList());

        return StreamSupport.stream(books.spliterator(), false)
                .map(bookMapper::getDtoFromEntity)
                .collect(Collectors.toList());
    }
}
