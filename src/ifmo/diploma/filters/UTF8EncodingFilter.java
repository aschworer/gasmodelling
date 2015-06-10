/*
 * Zainullina.A. Diploma. IFMO. 2008.
 */
package ifmo.diploma.filters;

import org.apache.commons.logging.Log; import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created: 27.10.2007 || 17:01:05
 *
 *
 */
public class UTF8EncodingFilter implements Filter {
    private static Log logger = LogFactory.getLog(UTF8EncodingFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String ip = servletRequest.getRemoteAddr();
        if (!"127.0.0.1".equals(ip) && !"localhost".equals(ip) && !"81.201.16.209".equals(ip)) {
            if ("85.249.73.170".equals(ip)) {
                logger.info("request ip: |...MASHA.......| request URI: |" + ((HttpServletRequest) servletRequest).getRequestURI());
            } else {
                logger.info("request ip: |" + ip + "| request URI: |" + ((HttpServletRequest) servletRequest).getRequestURI());
            }

        }
        servletRequest.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }
}
