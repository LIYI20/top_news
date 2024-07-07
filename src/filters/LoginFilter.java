package filters;


import command.CodeEnum;
import command.Response;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.JwtHelper;
import util.WebUtil;

import java.io.IOException;

/**
 * ClassName: LoginFilter
 * Package: filters
 * Description:
 *
 * @Author wbl
 * @Create 2024/7/7 19:09
 * @Version 1.0
 */
@WebFilter("/headline/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        String token=request.getHeader("token");
        if(token!=null&&!JwtHelper.isExpiration(token)){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else{
            WebUtil.writeJson((HttpServletResponse) servletResponse, Response.build(CodeEnum.NOTLOGIN,null));
        }
    }
}
