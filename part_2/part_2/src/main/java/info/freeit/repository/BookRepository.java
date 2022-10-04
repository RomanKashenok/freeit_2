package info.freeit.repository;

import info.freeit.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getAll();

    Book save(Book book);
    Book getById(int id);
    Book getByName(String title);
    boolean delete(int id);

}
