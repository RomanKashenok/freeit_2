package info.freeit.service;

import info.freeit.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();
    Book save(Book book);
    Book getById(int id);
    Book getByTitle(String title);
    boolean delete(int id);

}
