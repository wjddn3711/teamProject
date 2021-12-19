package controller;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter({"*.do","*.jsp"}) // 모든 do,jsp 파일에 대해서 처리
public class EncFilter implements Filter {
    private String encoding;
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getServletContext().getInitParameter("encoding");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);

        chain.doFilter(request,response);
    }
}
