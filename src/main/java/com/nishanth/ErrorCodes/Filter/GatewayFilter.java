package com.nishanth.ErrorCodes.Filter;

import java.io.Console;
import java.io.IOException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class GatewayFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
//		String header =(request.getHeader("X-Gateway-Identifier") != "null" ) ? null : request.getHeader("X-Gateway-Identifier");
		
//		 Optional<String> header =Optional.of(request.getHeader("X-Gateway-Identifier"));
		 
//		 header.stream().filter(s-> s.equalsIgnoreCase("gateway-only"));
		 
			if (isInternalCall(request)) {
				filterChain.doFilter(request, response);
			}else {
				String header =request.getHeader("X-Gateway-Identifier");
				if (!(header.equalsIgnoreCase("gateway-only"))) {
					response.setStatus(HttpStatus.BAD_GATEWAY.value());
					response.getWriter().write("Bad gateway");
					return;
				}

				filterChain.doFilter(request, response);

			}
		}

	private boolean isInternalCall(HttpServletRequest request) {
		System.out.println(request.getRemoteAddr());
		if(! request.getRemoteAddr().startsWith("0:0") ) {
			System.out.println("not internall");
		    return false;
		}
		return true;
	}
	
	

}
