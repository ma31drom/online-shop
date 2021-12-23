package com.epam.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epam.shop.exception.UnauthorizedException;

@WebFilter("/*")
public class DefaultErrorFilter implements Filter {

	public static final Logger LOGGER = LoggerFactory.getLogger(DefaultErrorFilter.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
		} catch (UnauthorizedException e) {
			LOGGER.error("Operation cannot be performed for unauthorized user", e);
			((HttpServletResponse) response)
					.sendRedirect(((HttpServletRequest) request).getContextPath() + "/loginPage.jsp");
		} catch (Exception e) {
			LOGGER.error("something went wrong", e);
			((HttpServletResponse) response)
					.sendRedirect(((HttpServletRequest) request).getContextPath() + "/error.jsp");
		}

	}

}
