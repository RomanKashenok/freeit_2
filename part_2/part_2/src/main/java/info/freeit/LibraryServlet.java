package info.freeit;

import info.freeit.model.Book;
import info.freeit.repository.BookRepositoryInMemoryImpl;
import info.freeit.service.BookService;
import info.freeit.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LibraryServlet extends HttpServlet {

    private final BookService bs = new BookServiceImpl(new BookRepositoryInMemoryImpl());

    public LibraryServlet() {
        bs.getAll();
        bs.save(new Book(1, "test1", "Author1"));
        bs.save(new Book(2, "test2", "Author2"));
        bs.save(new Book(3, "test3", "Author3"));
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println(req);
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bs.getAll();
        PrintWriter writer = response.getWriter();
        for (Book b : books) {
            writer.write("<b><i>");
            writer.write(b.toString());
            writer.write("</i></b>");
            writer.write("</br>");
        }
        writer.write("total: " + books.size() + " books found.");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        Book book = new Book(id, title, author);
        bs.save(book);

        PrintWriter writer = response.getWriter();
        writer.write("book saved!");
        writer.flush();
    }
}
