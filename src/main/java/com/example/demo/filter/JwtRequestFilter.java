package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.services.UserDetailsServiceImpl;
import com.example.demo.util.JwtUtil;


@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	@Autowired
	private UserDetailsServiceImpl userDetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String username = null;
		String jwt = null;
		final String authorizationHeader = request.getHeader("Authorization");
		if(authorizationHeader == null) { //if authHeader = null means that the uri does not require authentication, so 
			filterChain.doFilter(request, response); //you just have to keep going on the filter chain
            return;
		}
		boolean contain = authorizationHeader.startsWith("Bearer ");
		
		if (authorizationHeader != null && contain) {
			jwt = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(jwt);
		}
		
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailService.loadUserByUsername(username);
			if (jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
