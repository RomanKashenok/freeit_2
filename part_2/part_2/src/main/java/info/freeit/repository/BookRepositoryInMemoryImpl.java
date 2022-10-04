package info.freeit.repository;

import info.freeit.model.Book;

import java.util.*;
import java.util.stream.Collectors;

public class BookRepositoryInMemoryImpl implements BookRepository {

    List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getAll() {
        return books;
    }
    @Override
    public Book save(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public Book getById(int id) {
        return null;
    }

    @Override
    public Book getByName(String title) {
        return books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst().orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
