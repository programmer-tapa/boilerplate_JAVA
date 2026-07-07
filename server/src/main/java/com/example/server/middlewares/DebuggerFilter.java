package com.example.server.middlewares;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DebuggerFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(DebuggerFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        if (request instanceof HttpServletRequest) {
            logger.info("MIDDLEWARE : debugger");
        }
        
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            logger.warn("MIDDLEWARE : debugger - " + e.getMessage(), e);
            throw e;
        }
    }
}
