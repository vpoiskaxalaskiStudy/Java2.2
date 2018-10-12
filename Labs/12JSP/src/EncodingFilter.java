import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private FilterConfig filterConfig = null;
    public void init(FilterConfig config) throws ServletException{
        this.filterConfig = config;
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain next) throws IOException, ServletException {
        String encoding = req.getCharacterEncoding();
        if (!"UTF-8".equalsIgnoreCase(encoding))
            res.setCharacterEncoding("UTF-8");
        next.doFilter(req, res);
    }

    public void destroy() {

    }

}
