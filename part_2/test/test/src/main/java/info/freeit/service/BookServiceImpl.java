package info.freeit.service;

import info.freeit.model.Book;
import info.freeit.repository.BookRepository;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book getByTitle(String title) {
        return bookRepository.getByName(title);
    }

    @Override
    public boolean delete(int id) {
        return bookRepository.delete(id);
    }
}
