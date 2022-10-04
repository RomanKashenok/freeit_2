package info.freeit;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/health")
public class TestFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter " + this.getClass().getName() + " initialization");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
