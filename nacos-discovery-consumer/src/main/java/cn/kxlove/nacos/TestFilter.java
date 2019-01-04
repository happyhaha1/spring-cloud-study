package cn.kxlove.nacos;

import javax.servlet.*;
import java.io.IOException;

/**
 * <p>TestFilter</p>
 *
 * @author zhengkaixin
 * @since 2019-01-04 11:10
 */
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("请求开始");
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long time = System.currentTimeMillis() - startTime;
        System.out.println("请求结束"+time);
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
