package com.deli.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminLoginFilter
 */
@WebFilter("/admin")
public class AdminLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        
        Object object = request.getSession().getAttribute("admin");  
        if (object != null) {  
            request.getRequestDispatcher("./list_orders.jsp").forward(request, response);  
            return;  
        }  
        
        // get current url
        String currentURL = request.getRequestURI();
        System.out.println("currentURL:"+currentURL);
        
        // create application address
        String ctxPath = request.getContextPath();
        System.out.println("ctxPath:"+ctxPath);

        // delete app address from current url
        String targetURL = currentURL.substring(ctxPath.length());
        System.out.println("targetURL:"+targetURL);
        
        // page for admin
        String loginPage = "/admin/list_orders.jsp";
        String loginServlet = "/admin/login";
        HttpSession session = request.getSession(false);
        if(loginServlet.equals(targetURL)){
            chain.doFilter(request, response);
            return;
        }else{
            if(session == null || session.getAttribute("adminId") == null ){
                response.sendRedirect(ctxPath+loginPage);
                System.out.println("redirect:"+ctxPath+loginPage);
                return;
            }else{
                chain.doFilter(request, response);
                return;
            }
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
