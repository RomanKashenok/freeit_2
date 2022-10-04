package info.freeit;

import info.freeit.model.Book;
import info.freeit.repository.BookRepositoryInMemoryImpl;
import info.freeit.service.BookService;
import info.freeit.service.BookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/books/*", "/library/books/*"}, name = "Feofan")
public class LibraryServlet extends HttpServlet {

//    @Override
//    public void init() throws ServletException {
//        super.init();
//    }
//
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
//    }
//
//    @Override
//    public void destroy() {
//        super.destroy();
//    }

    public static final BookService bs = new BookServiceImpl(new BookRepositoryInMemoryImpl());

    public LibraryServlet() {
        bs.getAll();
        bs.save(new Book(1, "test1", "Author1"));
        bs.save(new Book(2, "test2", "Author2"));
        bs.save(new Book(3, "test3", "Author3"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bs.getAll();
        request.setAttribute("books", books);
        RequestDispatcher rd = request.getRequestDispatcher("/books.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean filled = request.getAttribute("filled") != null && (boolean) request.getAttribute("filled");
        if(filled) {
            PrintWriter writer = response.getWriter();
            writer.write("<html>\n" +
                    "<head>\n" +
                    "    <title>Books</title>\n" +
                    "</head>\n" +
                    "<body>\n");
            writer.write("Done!");
            writer.write("Go to books list: ");
            writer.write("<a href=\"http://localhost:8080/test_war_exploded/books/\">Go to books</a>");
            writer.write( "</body>\n" +
                    "</html>");
        } else {
            String title = request.getParameter("title_p");
            String author = request.getParameter("author_p");
            Book b = new Book(0, title, author);
            bs.save(b);

            fulfillRequestWithBooks(request);
            request.setAttribute("filled", true);
            RequestDispatcher rd = request.getRequestDispatcher("books.jsp");
            rd.include(request, response);
        }
    }

    private static void fulfillRequestWithBooks(HttpServletRequest request) {
        List<Book> books = bs.getAll();
        request.setAttribute("books", books);
    }
}
